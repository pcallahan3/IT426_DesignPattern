package singleton_pattern;

import java.time.LocalDateTime;

public class TestSingleton {

    public static void main(String[] args) {


       // AppStats stats = new AppStats();
        AppStats stats = AppStats.instance();

        stats.setStartTime((LocalDateTime.now()));
        System.out.println(stats.getStartTime());


    }
}
