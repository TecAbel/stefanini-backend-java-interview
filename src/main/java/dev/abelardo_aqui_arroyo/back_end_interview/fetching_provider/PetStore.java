package dev.abelardo_aqui_arroyo.back_end_interview.fetching_provider;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PetStore {

  private final String baseUrl = "https://petstore.swagger.io/v2/";
  private final RestTemplate restTemplate = new RestTemplate();

  public <T> ResponseEntity<T> get(String route, Class<T> responseType) {
    return restTemplate.getForEntity(this.baseUrl + route, responseType);
  }

  public <T, B> ResponseEntity<T> post(String route, B body, Class<T> responseType) {
    HttpEntity<B> entity = new HttpEntity<>(body);
    return restTemplate.exchange(this.baseUrl + route, HttpMethod.POST, entity, responseType);
  }

}
