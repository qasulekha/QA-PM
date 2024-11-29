package biz.promanage.driverManager;


import biz.promanage.constants.DriverType;

public class DriverFactory {

    public static DriverManager getDriverManager(DriverType driverType){
        switch (driverType){
            case CHROME -> {
                return new ChromeDriverManager();
            }
            case FIREFOX -> {
                return new FirefoxDriverManager();
            }
            default -> throw new IllegalStateException("Unexpected value: " + driverType);
        }
    }
}
