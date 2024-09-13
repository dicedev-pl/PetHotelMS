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
public class ToysDto {

    private UUID id;
    private UUID wearOut;
    private UUID caretakerID;
    private UUID supplierID;
    private String toyName;
    private String toyType;
    private String cleaning;
    private String brand;
    private int quantityInStock;

}
