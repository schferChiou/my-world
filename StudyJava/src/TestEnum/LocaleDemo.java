package TestEnum;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 国际化操作
 *
 * Created by schfer on 2018/7/23.
 */
public class LocaleDemo {
    public static void main(String[] args) {

        Locale loc = new Locale("zh","CN");
        Locale loc1 = Locale.getDefault();
        System.out.println(loc1);
        ResourceBundle rb = ResourceBundle.getBundle("Message",loc);
        System.out.println(rb.getString("hello"));
    }
}
