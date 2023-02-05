package vlad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import vlad.entity.TransportType;

import java.util.List;

@Component
public class RestClient {
    private RestTemplate restTemplate;
    private final String URL;

    public RestClient(@Autowired RestTemplate restTemplate, @Value("${my.rest.url}") String url) {
        this.restTemplate = restTemplate;
        URL = url;
    }

    public List<TransportType> getAll() {
        ResponseEntity<List<TransportType>> response =
                restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<TransportType>>() {
                });
        List<TransportType> result = response.getBody();
        return result;
    }

    public TransportType getById(long id) {
        ResponseEntity<TransportType> response =
                restTemplate.exchange((URL + "/" + id), HttpMethod.GET, null, new ParameterizedTypeReference<TransportType>() {
                });
        return response.getBody();
    }

    public void deleteById(long id) {
        ResponseEntity<String> response =
                restTemplate.exchange((URL + "/" + id), HttpMethod.DELETE, null, new ParameterizedTypeReference<String>() {
                });
        System.out.println(response.getBody() + " " + id);
    }

    public void save(TransportType transportType) {
        ResponseEntity<String> response =
                restTemplate.exchange((URL), HttpMethod.POST, new HttpEntity<>(transportType), new ParameterizedTypeReference<String>() {
                });
        System.out.println(response.getBody());
    }


}
