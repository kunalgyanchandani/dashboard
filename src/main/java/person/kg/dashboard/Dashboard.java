package person.kg.dashboard;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Dashboard {
    public static void main(String... args)
    {
        new SpringApplicationBuilder(Dashboard.class).run(args);
    }

}
