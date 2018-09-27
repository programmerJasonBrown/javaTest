import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @program: test1
 * @description:
 * @author: Chao Qian
 * @create: 2018-08-01 09:58
 **/
public class DateTest {
    public static void main(String[] args) {

        //Date date = new Date(System.currentTimeMillis());
        Date date = new Date();
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(dateFormater.format(new Date()));
        Calendar c = Calendar.getInstance();

        c.setTime(new Date());
        c.add(Calendar.DATE, -8);

        System.out.println(c.getTime());
        System.out.println(new Date());
    }
}
