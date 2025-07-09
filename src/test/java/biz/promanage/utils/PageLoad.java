package biz.promanage.utils;

public class PageLoad {
    public static void waitForPageLoad() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }

    public static void pauseThreeSecs() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }

    public static void pause() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }

    public static void pauseTenSeconds() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }

    public static void pauseFifteenSeconds() {
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }


    public static void pauseOneSec() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }
}
