package util.general_util.poller;



/**
 * Created by asih on 16/08/2015.
 */
public interface Pollable {

    boolean until() throws Exception;

    default void waitUntil(long timeOutInMilisec, long interval, String timeoutMessage) throws Exception {
        while (!this.until()) {
            try {
                Thread.sleep(interval);
                timeOutInMilisec -= interval;
                if (timeOutInMilisec <= 0) {
                    throw new RuntimeException(timeoutMessage, new Exception(timeoutMessage));
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    default boolean waitUntilWithoutReport(long timeOutInMilisec, long interval) {

        try {
            while (!this.until()){
                try {
                    Thread.sleep(interval);
                    timeOutInMilisec -= interval;
                    if (timeOutInMilisec <= 0) {
                        return false;
                    }
                } catch (InterruptedException e) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }

    }


}
