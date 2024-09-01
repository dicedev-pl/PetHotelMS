package pl.dicedev.pethotel.controllers.dot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnimalFoodDto {

    private UUID id;
    private String foodName;
    private String animalType;
    private String brand;
    private int quantityInStock;
    private UUID caretakerID;
    private UUID supplierID;

}
