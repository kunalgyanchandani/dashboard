package person.kg.dashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import person.kg.business.Social;
import person.kg.business.news.GoogleNews;
import person.kg.business.remittance.Remit;
import person.kg.business.remittance.RiaRemit;
import person.kg.business.technology.Version;
import person.kg.business.transit.BusStopMarine;

import java.sql.SQLException;
import java.util.stream.Collectors;

/**
 * Created by gyanc on 7/28/2018.
 */
@RestController
public class IndexController {

    @Autowired
    public RequestMappingHandlerMapping requestMappingHandlerMapping;

    @RequestMapping("/")
    public @ResponseBody
    String showEndpointsAction() throws SQLException {
        return requestMappingHandlerMapping.getHandlerMethods().keySet().stream()
                .map(record -> record.getPatternsCondition().getPatterns().toArray()[0].toString())
                .sorted()
                .map(record -> {
                            String text = "http://localhost:8080" + record;
                            return "<a href=\"" + text + "\">" + text + "</a><BR>";
                        }
                ).collect(Collectors.joining());
    }

    @RequestMapping("/remit")
    public String remit() {
        return Remit.data();
    }

    @RequestMapping("/version")
    public String version() {
        return Version.data();
    }

    @RequestMapping("/bus147")
    public String bus147() {
        return BusStopMarine.data();
    }


    @RequestMapping("/riaremit")
    public String riaremit() {
        return RiaRemit.data();
    }

    @RequestMapping("/social")
    public String social() {
        return Social.data();
    }

    @RequestMapping("/news")
    public String news() {
        return GoogleNews.data();
    }
}
