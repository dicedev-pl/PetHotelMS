package pl.dicedev.pethotel.exceptions;

import lombok.Getter;

import java.util.UUID;

@Getter
public class AnimalFoodException extends RuntimeException {

    private UUID id;
    private String userMessage;

    public AnimalFoodException(String message, String userMessage, UUID id) {
        super(message);
        this.id = id;
        this.userMessage = userMessage;
    }
}
