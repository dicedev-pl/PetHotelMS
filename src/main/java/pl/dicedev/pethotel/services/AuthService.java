package pl.dicedev.pethotel.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.dicedev.pethotel.config.AuthConfigService;

@Service
public class AuthService {

    private final AuthConfigService authConfigService;
    private final RestTemplate restTemplate;

    public AuthService(AuthConfigService authConfigService, RestTemplate restTemplate) {
        this.authConfigService = authConfigService;
        this.restTemplate = restTemplate;
    }

    public String getToken(String userData) {
        String url = "http://" + getAuthServiceName() + ":8081/v1/authentication/" + userData;
        return restTemplate.getForObject(url, String.class);
    }

    public String getScopeFromToken(String token) {
        String url = "http://" + getAuthServiceName() + ":8081/v1/authentication/scope/" + token;
        return restTemplate.getForObject(url, String.class);
    }

    private String getAuthServiceName() {
        return authConfigService.getAuthservice();
    }
}
