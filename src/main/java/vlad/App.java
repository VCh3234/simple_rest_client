package vlad;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vlad.config.SpringConfig;
import vlad.entity.TransportType;

import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        RestClient restClient = context.getBean("restClient", RestClient.class);
//        List<TransportType> allTransportTypes = restClient.getAll();
//        TransportType transportType = restClient.getById(1);
//        System.out.println(transportType);
//        restClient.deleteById(1);
        TransportType transportType = new TransportType();
        transportType.setBrandName("SOME BRAND");
        transportType.setStartOfProduce(LocalDate.now());
        transportType.setEndOfProduce(null);
        transportType.setModelName("Cool car 999");
        transportType.setModificationName("1");
        restClient.save(transportType);
    }
}
