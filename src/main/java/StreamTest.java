import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.sun.tools.doclint.Entity.gt;

/**
 * @program: test1
 * @description:
 * @author: Chao Qian
 * @create: 2018-08-01 14:48
 **/
public class StreamTest {
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        //List<Integer> ints = Lists.newArrayList(1,2,3,4,5,6,7,8,9,10);
        System.out.println("ints sum is:" + ints.stream().reduce(0,(sum, item) -> sum + item));

        List list = Arrays.asList("C","P");
        System.out.println("list"+list.get(0));
    }
}
