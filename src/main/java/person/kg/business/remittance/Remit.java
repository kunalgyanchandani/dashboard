package person.kg.business.remittance;

import org.jsoup.Jsoup;

import java.io.IOException;

/**
 * Created by gyanc on 7/28/2018.
 */
public class Remit {
    public static String data() {
        try {
            return Jsoup.connect("https://www.google.com/search?q=usd+to+inr")
                    .get()
                    .getElementById("knowledge-currency__tgt-amount").text();
        } catch (IOException e) {
            e.printStackTrace();
            return "0";
        }
    }
}
