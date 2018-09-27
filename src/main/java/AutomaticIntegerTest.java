import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: test1
 * @description:
 * @author: Chao Qian
 * @create: 2018-08-13 14:21
 **/
public class AutomaticIntegerTest {
    public AtomicInteger inc = new AtomicInteger();

    public void increase() {
        inc.getAndIncrement();
    }

    public static void main(String[] args) {
        final AutomaticIntegerTest test = new AutomaticIntegerTest();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    test.increase();
                    System.out.println(test.inc);
                }
            }).start();
        }

        if (Thread.activeCount() > 2) // idea至少存在2个线程
            Thread.yield();
        System.out.println(test.inc);
    }
}
