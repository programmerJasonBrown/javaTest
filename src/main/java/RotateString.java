/**
 * @program: test1
 * @description:
 * @author: Chao Qian
 * @create: 2018-08-16 15:32
 **/
public class RotateString {
    public static void main(String[] args) {
        String str = "Hello World!";
        str = new StringBuilder(str).reverse().toString();
        System.out.println(str);
        Integer integer = new Integer(122);
    }
}
