package synchronizedQueueTest;

import java.util.concurrent.RunnableFuture;
import java.util.concurrent.SynchronousQueue;

/**
 * @program: test1
 * @description: https://www.cnblogs.com/duanxz/p/3252267.html
 * @author: Chao Qian
 * @create: 2018-08-31 15:05
 **/
public class SynchronizedQueueTest {
    public static void main(String[] args) {
        final SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue<>(true);

        new Thread(() -> {
            try {
                /*put() 往queue放进去一个element以后就一直wait直到有其他thread进来把这个element取走。
                 * offer() 往queue里放一个element后立即返回，如果碰巧这个element被另一个thread取走了，offer方法返回true，
                 * 认为offer成功；否则返回false。 offer(2000, TimeUnit.SECONDS) 往queue里放一个element但是等待指定
                 * 的时间后才返回，返回的逻辑和offer()方法一样。*/
                synchronousQueue.put(10);
                synchronousQueue.put(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(2000);

                /*take() 取出并且remove掉queue里的element（认为是在queue里的。。。），取不到东西他会一直等。
                 * poll() 取出并且remove掉queue里的element（认为是在queue里的。。。），只有到碰巧另外一个线程
                 * 正在往queue里offer数据或者put数据的时候，该方法才会取到东西。否则立即返回null。poll(2000, TimeUnit.SECONDS)
                 * 等待指定的时间然后取出并且remove掉queue里的element,其实就是再等其他的thread来往里塞。*/
                Integer take = synchronousQueue.take();
                System.out.println(take);
                System.out.println(synchronousQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

//        while (Thread.activeCount() > 2) {
//
//        }
    }
}
