package pl.dicedev.pethotel.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.dicedev.pethotel.enums.Pet;

import java.time.Instant;
import java.util.UUID;

@Entity(name="reservation")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "start_date")
    private Instant startDate;
    @Column(name = "end_date")
    private Instant endDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "pet_type")
    private Pet petType;

}
