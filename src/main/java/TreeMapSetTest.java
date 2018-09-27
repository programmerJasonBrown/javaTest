import java.util.TreeMap;

/**
 * @program: test1
 * @description:
 * @author: Chao Qian
 * @create: 2018-08-20 13:55
 **/
public class TreeMapSetTest {
    public static void main(String[] args) {
        //可以自己写比较函数
        TreeMap<Integer, String> tm = new TreeMap<>((o1, o2) -> o2 - o1);
        tm.put(1, "jason");
        tm.put(2, "brown");
        tm.put(3, "tom");
        tm.put(4, "jerry");
        tm.put(5, "success");

        tm.forEach((key, value) -> {
            System.out.println(key + " " + value);
        });

    }
}
