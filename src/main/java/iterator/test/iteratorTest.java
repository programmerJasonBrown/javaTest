package iterator.test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: test1
 * @description:
 * @author: Chao Qian
 * @create: 2018-09-11 09:28
 **/
public class iteratorTest {
    public static void main(String[] args) {
        List<Integer> array = new LinkedList<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        array.add(6);

        List<Integer> array2 = new LinkedList<>();
        array2.add(1);
        array2.add(2);
        array2.add(3);
        array2.add(4);
        array2.add(5);
        array2.add(6);


        Iterator<Integer> iterator = array.iterator();
        Iterator<Integer> iterator1 = array2.iterator();
    }
}
