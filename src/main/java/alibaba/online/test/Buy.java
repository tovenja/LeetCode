package alibaba.online.test;

import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by blank on 2015-08-23 上午11:00.
 */
public class Buy implements Runnable {
    private final AtomicInteger residue;
    private Map<String, Integer> names;


    public Buy(AtomicInteger residue, Map<String, Integer> names) {
        this.residue = residue;
        this.names = names;
    }

    @Override
    public void run() {

        if (residue.get() > 0) {
            synchronized (residue) {
                if (residue.get() > 0) {
                    String userId = UUID.randomUUID().toString();
                    int buy = new Random().nextInt(21);
                    buy = Math.min(buy, residue.get());
                    residue.set(residue.get() - buy);
                    names.put(userId, buy * 1000);
                }
            }
        }
    }
}
