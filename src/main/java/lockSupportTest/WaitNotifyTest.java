package lockSupportTest;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @program: test1
 * @description: wait和notify/notifyAll方法只能在同步代码块里用
 * https://www.cnblogs.com/qingquanzi/p/8228422.html
 * @author: Chao Qian
 * @create: 2018-08-31 17:16
 **/
public class WaitNotifyTest {
    static class MyThread {
        private String name;

        public MyThread(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        ThreadFactory nameThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();

        ExecutorService pool = new ThreadPoolExecutor(8, 8, 200L
                , TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(8), nameThreadFactory
                , new ThreadPoolExecutor.AbortPolicy());

        MyThread jason = new MyThread("jason");
        pool.execute(() -> {
            int sum = 0;
            for (int i = 0; i < 100; i++) {
                sum += i;
            }
            try {
                synchronized (jason) {
                    jason.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(sum);
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (jason) {
            jason.notify();
        }

        pool.shutdown();

    }

}

/**
 * 测试线程池拒绝策略之由调用线程调用
 * ExecutorService threadPool = Executors.newCachedThreadPool();
 * ThreadFactory nameThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
 * <p>
 * ExecutorService pool = new ThreadPoolExecutor(1, 1, 200L
 * , TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1), nameThreadFactory
 * , new ThreadPoolExecutor.CallerRunsPolicy());
 * <p>
 * System.out.println("主线程" + Thread.currentThread());
 * Runnable r = () -> {
 * System.out.println(Thread.currentThread() + "开始执行");
 * try {
 * Thread.sleep(5000);
 * } catch (InterruptedException e) {
 * e.printStackTrace();
 * }
 * System.out.println(Thread.currentThread() + "结束执行");
 * };
 * pool.execute(r);
 * pool.execute(r);
 * pool.execute(r);
 * pool.shutdown();
 **/
