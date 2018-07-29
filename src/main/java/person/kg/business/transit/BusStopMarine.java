package person.kg.business.transit;

import org.jsoup.Jsoup;

import java.io.IOException;

/**
 * Created by gyanc on 7/28/2018.
 */
public class BusStopMarine {
    public static String data() {
        try {
            return Jsoup.connect("http://www.ctabustracker.com/bustime/eta/eta.jsp?id=4846&showAllBusses=on&findstop=on")
                    .get()
                    .getElementsByClass("prediction_time")
                    .toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "0";
        }

    }
}
