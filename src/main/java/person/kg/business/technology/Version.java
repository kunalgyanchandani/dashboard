package person.kg.business.technology;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;

/**
 * Created by gyanc on 7/28/2018.
 */
public class Version {
    public static String data() {
        try {
            return Jsoup.connect("https://developer.android.com/studio/releases/sdk-tools")
                    .method(Connection.Method.GET)
                    .get()
                    .getElementsByTag("p")
                    .get(2)
                    .text()
                    .toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "0";
        }
    }
}
