package futureTaskTest;

import java.util.concurrent.*;

/**
 * @program: test1
 * @description: https://www.jianshu.com/p/49541d720d5b
 * @author: Chao Qian
 * @create: 2018-08-30 09:25
 **/
public class FutureTaskTest {
    static class Task implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            System.out.println("子线程正在计算");
            Thread.sleep(5000);
            int sum = 0;
            for (int i = 0; i < 100; i++) {
                sum += i;
            }
            System.out.println(sum);
            return sum;
        }
    }

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();


        FutureTask<Integer> lambdaTask = new FutureTask<>(() -> {
            int sum = 0;
            Thread.sleep(5000);
            for (int i = 0; i < 10; i++) {
                sum += i;
            }
            System.out.println(sum);
            return sum;
        });



        threadPool.submit(lambdaTask);

        System.out.println(Thread.activeCount());
        try {
            System.out.println(lambdaTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.activeCount());

        threadPool.shutdown();
        System.out.println(Thread.activeCount());


        while(Thread.activeCount()!=2){

        }
        System.out.println(Thread.activeCount());
    }


}
