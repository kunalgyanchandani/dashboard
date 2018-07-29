package person.kg.business;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;

/**
 * Created by gyanc on 7/28/2018.
 */
public class Social {
    public static String data() {
        try {
            return Jsoup.connect("https://www.youtube.com/feed/trending")
                    .method(Connection.Method.GET)
                    .get()
                    .getElementById("video-title")
                    .text()
                   ;
        } catch (IOException e) {
            e.printStackTrace();
            return "0";
        }
    }
}
