import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: test1
 * @description:
 * @author: Chao Qian
 * @create: 2018-08-13 13:32
 **/
public class LockTest {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
//        System.out.println(Thread.activeCount());
        System.out.println(Thread.interrupted());

    }

}
