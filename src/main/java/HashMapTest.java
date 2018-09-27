import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: test1
 * @description:
 * @author: Chao Qian
 * @create: 2018-08-20 11:19
 **/
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, String> hs = new HashMap<>();
        hs.put("1", "hello");
        hs.put("2", "world");

        hs.forEach((key, value) -> {
            System.out.println(key + value);
        });

        List<Integer> array = new LinkedList<>();
        Collections.synchronizedList(array);


    }
}
