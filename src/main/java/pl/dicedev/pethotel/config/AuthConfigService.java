package pl.dicedev.pethotel.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AuthConfigService {

    @Value("${AUTH_SERVICE}")
    private String authservice;

    public String getAuthservice() {
        return authservice;
    }
}
