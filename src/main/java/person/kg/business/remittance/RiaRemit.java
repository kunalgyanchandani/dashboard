package person.kg.business.remittance;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;

/**
 * Created by gyanc on 7/28/2018.
 */
public class RiaRemit {
    public static String data() {

        Connection.Response response = null;
        try {
            response = Jsoup.connect("https://www.riamoneytransfer.com/").method(Connection.Method.GET).execute();
        String data = response.cookies()
                .get("__RequestVerificationToken");
        return Jsoup.connect("https://www.riamoneytransfer.com/send-money-online/countrychange")
                .method(Connection.Method.POST)
                .cookies(response.cookies())
                .headers(response.headers())
                .followRedirects(true)
                .data("countryTo", "IN")
                .data("SkipPaymentMethods", "false")
                //.data("currencyTo","INR")
                //.data("DeliveryMethod","")
                //.data("PaymentMethod","")
                .data("__RequestVerificationToken", data)
                .get()
                .html()
                .toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
