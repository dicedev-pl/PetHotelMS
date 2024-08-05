package pl.dicedev.pethotel.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.dicedev.pethotel.config.AuthConfigService;


@Service
public class AddReservationService {

    private final String URI = "/v2/token/valid";
    private final AuthConfigService authConfigService;
    private final RestTemplate restTemplate;

    public AddReservationService(AuthConfigService authConfigService, RestTemplate restTemplate) {
        this.authConfigService = authConfigService;
        this.restTemplate = restTemplate;
    }

    public String getScopeFromToken(String token, String right) {
        String url = "http://" + getAuthServiceName() + ":8081" + URI + "?right=" + right;

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("token", token);

        HttpEntity<String> httpEntity = new HttpEntity<>(null, httpHeaders);

        return restTemplate.postForObject(url, httpEntity, String.class);
    }

    private String getAuthServiceName() {
        return authConfigService.getAuthservice();
    }
}
