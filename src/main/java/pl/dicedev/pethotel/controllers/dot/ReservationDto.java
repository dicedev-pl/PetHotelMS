package pl.dicedev.pethotel.controllers.dot;

import pl.dicedev.pethotel.enums.Pet;

import java.time.Instant;
import java.util.UUID;

public class ReservationDto {

    private UUID uuid;
    private String customerName;
    private Instant startDate;
    private Instant endDate;
    private Pet petTyle;

}
