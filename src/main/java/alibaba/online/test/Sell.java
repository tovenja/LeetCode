package alibaba.online.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.SimpleTimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by blank on 2015-08-23 上午11:00.
 */
public class Sell {

    private static AtomicInteger MAX = new AtomicInteger(2000);
    private static Map<String, Integer> NAMES = new HashMap<>();
    private static ExecutorService es = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        for (int i = 0; i < 300; i++) {
            Buy buy = new Buy(MAX, NAMES);
            Thread thread = new Thread(buy);
            es.submit(thread);
        }
        es.shutdown();
        while (!es.isTerminated())
            ;
        NAMES.entrySet().forEach(System.out::println);
        int sum = 0;
        for (Map.Entry<String, Integer> en : NAMES.entrySet()) {
            sum += en.getValue();
        }
        System.out.println(sum);
    }
}
