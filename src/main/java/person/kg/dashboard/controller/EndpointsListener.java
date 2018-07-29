package person.kg.dashboard.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * Created by gyanc on 7/29/2018.
 */
public class EndpointsListener{

}
/*
public class EndpointsListener implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ContextRefreshedEvent) {
            ApplicationContext applicationContext = ((ContextRefreshedEvent) event).getApplicationContext();
            applicationContext.getBean(RequestMappingHandlerMapping.class).getHandlerMethods().forEach(
                    {(record,data)->
                            System.out.println(record);
            System.out.println(data);
                            }
            );
        }
    }
}
*/