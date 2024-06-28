package pl.dicedev.pethotel.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("vi/auth")
class AuthController {

    private final RestTemplate restTemplate;

    public AuthController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/{requestedData}")
    public String getAuthenticationData(@PathVariable String requestedData) {
        String url = "http://localhost:8081/v1/authentication/" + requestedData;
        return restTemplate.getForObject(url, String.class);
    }

}
