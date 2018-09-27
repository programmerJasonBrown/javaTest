import java.util.LinkedList;
import java.util.List;

/**
 * @program: test1
 * @description:
 * @author: Chao Qian
 * @create: 2018-08-13 11:45
 **/
public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.addLast(3);
        list.addFirst(4);
        list.push(5);
        System.out.println(list.poll());
//        try {
//            //list.wait();
//            System.out.println(list.poll());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println();
    }
}
