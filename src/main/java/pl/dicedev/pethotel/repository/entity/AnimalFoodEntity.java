package pl.dicedev.pethotel.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "animal_food")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AnimalFoodEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "food_name", nullable = false)
    private String foodName;

    @Column(name = "animal_type", nullable = false)
    private String animalType;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "quantity_in_stock", nullable = false)
    private int quantityInStock;

    @Column(name = "caretaker_id", nullable = false)
    private UUID caretakerID;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private SupplierEntity supplier;

}
