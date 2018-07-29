package person.kg.business.news;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by gyanc on 7/28/2018.
 */
public class GoogleNews {
    public static String data() {
        try {

            StringBuilder str = new StringBuilder();
            String START = "<H1>\"";
            String STOP = "\"</H1>";

            List<String> data = new LinkedList<>();

            Jsoup.connect("https://news.google.com")
                    .method(Connection.Method.GET)
                    .get()
                    .getElementsByTag("article")
                    .forEach(action -> {
                        String record = action.getElementsByTag("span").get(0).text();
                        data.add(record.replace("\"","").replace("'",""));
                    });


            final String[] key = {""};
            data.stream()
                    .map(record -> Arrays.asList(record.toString().split(" "))
                            .stream())
                    .flatMap(mapper -> mapper)
                    .sorted()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet().stream()
                    .filter(predicate-> !Arrays.asList(new String[]{"of", "the","in","to","and","have","for","its","a","is","at","on"
                            ,"after"
                            ,"new",
                            "as"
                            ,"|","-"
                            ,"0","1","2","3","4","5","6","7","8","9"

                    }).contains(predicate.getKey().toLowerCase()))
                    .map(record -> {
                        record.setValue(record.getValue()*-1);
                        return record;
                    })
                    .sorted(Map.Entry.comparingByValue())
                    .findFirst().ifPresent(record-> {
                    System.out.println(record.getValue());
                    key[0] =record.getKey();});

            System.out.println(key[0]);

                    data.stream().filter(predicate->predicate.contains(key[0])).forEach(
                            record->str.append(START).append(record).append(STOP)
                    );


            return str.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "NoNews!";
    }
}
