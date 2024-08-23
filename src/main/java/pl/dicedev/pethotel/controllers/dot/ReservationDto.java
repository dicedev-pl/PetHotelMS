package pl.dicedev.pethotel.controllers.dot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.dicedev.pethotel.enums.Pet;

import java.time.Instant;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservationDto {

    private UUID id;
    private String customerName;
    private Instant startDate;
    private Instant endDate;
    private Pet petType;
    private String roomType;

}
