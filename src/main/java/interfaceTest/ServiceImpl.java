package interfaceTest;

/**
 * @program: test1
 * @description:
 * @author: Chao Qian
 * @create: 2018-08-20 15:17
 **/
public class ServiceImpl implements Service {
    @Override
    public void publicPrint() {
        System.out.println("hello publicPrint");
        Service.servicePrint();
    }
}
