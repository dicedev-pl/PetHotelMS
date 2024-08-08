package pl.dicedev.pethotel.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.dicedev.pethotel.controllers.dot.ReservationDto;
import pl.dicedev.pethotel.services.ReservationService;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("vi/reservations")
class AddReservationController {

    private final ReservationService reservationService;

    @PostMapping
    public UUID saveReservation(
            @RequestBody ReservationDto reservationDto,
            @RequestHeader("token") String token
    ) {
        return reservationService.saveReservation(reservationDto, token);
    }

}
