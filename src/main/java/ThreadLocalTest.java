/**
 * @program: test1
 * @description: https://www.jianshu.com/p/ee8c9dccc953
 * https://blog.csdn.net/xrt95050/article/details/7324229
 * http://www.importnew.com/22039.html  分析内存泄漏
 *纵向隔离 —— 线程（Thread）与线程（Thread）之间的数据访问隔离。
 * 这一点由线程（Thread）的数据结构保证。因为每个线程（Thread）在进行对象访问时，
 * 访问的都是各自线程自己的ThreadLocalMap。
 *
 * 横向隔离 —— 同一个线程中，不同的ThreadLocal实例操作的对象之间的相互隔离。
 * 这一点由ThreadLocalMap在存储时，采用当前ThreadLocal的实例作为key来保证。
 * @author: Chao Qian
 * @create: 2018-08-08 09:48
 **/
public class ThreadLocalTest {
    private static final ThreadLocal<A> threadLocal = ThreadLocal.withInitial(A::new);

    public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(() -> {
                threadLocal.get().setNumber(threadLocal.get().getNumber() + 5);
                System.out.println(Thread.currentThread().getName() + ":"
                        + threadLocal.get().getNumber());
            }, "Thread-" + i);
        }

        for (Thread t : threads) {
            t.start();
        }
    }

    static class A {
        private int number = 0;

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }
    }
}
