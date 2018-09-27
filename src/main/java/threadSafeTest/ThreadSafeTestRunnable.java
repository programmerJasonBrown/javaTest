package threadSafeTest;

/**
 * @program: test1
 * @description:
 * @author: Chao Qian
 * @create: 2018-08-15 17:04
 **/
public class ThreadSafeTestRunnable implements Runnable {
    private int count;
    private static ThreadSafeTestRunnable threadSafeTestRunnable = new ThreadSafeTestRunnable();

    public int getCount() {
        return count;
    }

    private ThreadSafeTestRunnable(){
        count = 0;
    }
    public static ThreadSafeTestRunnable getThreadSafeTestRunnable(){
        return threadSafeTestRunnable;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread() + "count = " + String.valueOf(count));
            try {
                Thread.sleep(500);
                count += 1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
