package pl.dicedev.pethotel.services;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.dicedev.pethotel.config.AuthConfigService;


@Service
@AllArgsConstructor
public class AuthTokenCheckService {

    private final AuthConfigService authConfigService;
    private final RestTemplate restTemplate;

    public Boolean hasTokenWithAddReservationsRights(String token) {
        String RIGHT = "ADD_RESERVATIONS";
        return checkRightForToken(token, RIGHT);
    }

    private Boolean checkRightForToken(String token, String right) {
        String URI = "/v2/token/valid";
        String checkRightUrl = "http://" + getAuthServiceName() + ":8081" + URI + "?right=" + right;

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("token", token);

        HttpEntity<String> httpEntity = new HttpEntity<>(null, httpHeaders);

        return restTemplate.postForObject(checkRightUrl, httpEntity, Boolean.class);
    }

    private String getAuthServiceName() {
        return authConfigService.getAuthservice();
    }
}
