package biz.promanage.driverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v132.network.Network;
import org.openqa.selenium.devtools.v132.page.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class DevToolsHelper {

    private final DevTools devTools;
    private static final Logger logger = LoggerFactory.getLogger(DevToolsHelper.class);

    private final long timeoutInSeconds;

    public DevToolsHelper(WebDriver driver) {
        this(driver, 30);
    }

    public DevToolsHelper(WebDriver driver, long timeoutSeconds) {
        this.devTools = ((ChromeDriver) driver).getDevTools();
        this.devTools.createSession();
        this.devTools.send(Page.enable());
        this.devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        this.timeoutInSeconds = timeoutSeconds;
    }
      public void waitForPageLoadAndAsyncCompletion() {
        CountDownLatch latch = new CountDownLatch(2);
        AtomicBoolean pageLoaded = new AtomicBoolean(false);
        AtomicBoolean networkIdle = new AtomicBoolean(false);

        logger.info("Waiting for page load and network idle...");

        devTools.addListener(Page.loadEventFired(), event -> {
            if (!pageLoaded.get()) {
                logger.info("Page has fully loaded.");
                pageLoaded.set(true);
                latch.countDown();
            }
        });

        devTools.addListener(Page.lifecycleEvent(), lifecycleEvent -> {
            if ("networkIdle".equals(lifecycleEvent.getName()) && !networkIdle.get()) {
                logger.info("All async operations (network idle) are complete.");
                networkIdle.set(true);
                latch.countDown();
            }
        });

        try {
            if (!latch.await(timeoutInSeconds, TimeUnit.SECONDS)) {
                logger.warn("Timed out waiting for page load or network idle after {} seconds.", timeoutInSeconds);
            }
        } catch (InterruptedException e) {
            logger.error("Interrupted while waiting for page load or network idle.", e);
            Thread.currentThread().interrupt();
        }
    }
}
