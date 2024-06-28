package pl.dicedev.pethotel.controllers;

import org.springframework.web.bind.annotation.*;
import pl.dicedev.pethotel.services.AuthService;

@RestController
@RequestMapping("vi/auth")
class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/{requestedData}")
    public String getAuthenticationData(@PathVariable String requestedData) {
        return authService.getToken(requestedData);
    }

    @PostMapping("/{requestedData}")
    public String getAuthenticationToken(@PathVariable String requestedData) {
        return authService.getScopeFromToken(requestedData);
    }

}
