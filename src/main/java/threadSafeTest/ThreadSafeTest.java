package threadSafeTest;


/**
 * @program: test1
 * @description:
 * @author: Chao Qian
 * @create: 2018-08-15 17:07
 **/
public class ThreadSafeTest {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(ThreadSafeTestRunnable.getThreadSafeTestRunnable()).start();
        }
        while (Thread.activeCount() > 2) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Main:" + ThreadSafeTestRunnable.getThreadSafeTestRunnable().getCount());
        }

    }
}
