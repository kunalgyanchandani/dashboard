package person.kg.business.transit;

import org.jsoup.Jsoup;

import java.io.IOException;

/**
 * Created by gyanc on 7/28/2018.
 */
public class StationArgyle {
    public static String data() {
        try {
            return Jsoup.connect("https://www.transitchicago.com/traintracker/arrivaltimes/?sid=41200")
                    .get()
                    .getElementsByClass("ea-line-time-big")
                    .text();

        } catch (IOException e) {
            e.printStackTrace();
            return "0";
        }

    }
}
