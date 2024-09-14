package pl.dicedev.pethotel.controllers.dot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorDto {

    private String message;
    private String userMessage;
    private UUID id;

}
