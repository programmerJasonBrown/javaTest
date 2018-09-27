package interfaceTest;

/**
 * @program: test1
 * @description:
 * @author: Chao Qian
 * @create: 2018-08-20 15:18
 **/
public class MainTest {
    public static void main(String[] args) {
        Service service = new ServiceImpl();
        service.publicPrint();
        Service.servicePrint();
    }
}
