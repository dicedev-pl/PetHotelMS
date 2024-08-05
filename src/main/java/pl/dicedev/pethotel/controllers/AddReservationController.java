package pl.dicedev.pethotel.controllers;

import org.springframework.web.bind.annotation.*;
import pl.dicedev.pethotel.services.AddReservationService;

@RestController
@RequestMapping("vi/auth")
class AddReservationController {

    private final AddReservationService addReservationService;

    public AddReservationController(AddReservationService addReservationService) {
        this.addReservationService = addReservationService;
    }

    @PostMapping
    public String getAuthenticationToken(
            @RequestHeader("token") String token
    ) {
        return addReservationService.getScopeFromToken(token, "ADD_RESERVATIONS");
    }

}
