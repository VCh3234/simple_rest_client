package vlad;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vlad.config.SpringConfig;
import vlad.entity.TransportType;

import java.util.List;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        RestClient restClient = context.getBean("restClient", RestClient.class);
        //List<TransportType> allTransportTypes = restClient.getAll();
        TransportType transportType = restClient.getById(1);
        System.out.println(transportType);

    }
}
