package center.jhub.utils;

import java.time.Duration;

public class ThreadUtils {


    public static void sleep(Duration duration) {
        sleep(duration.toMillis());
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
