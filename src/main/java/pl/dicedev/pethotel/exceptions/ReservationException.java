package pl.dicedev.pethotel.exceptions;

import lombok.Getter;

import java.util.UUID;

@Getter
public class ReservationException extends RuntimeException {

    private final UUID id;
    private final String userMessage;

    public ReservationException(String message, String userMessage, UUID id) {
        super(message);
        this.id = id;
        this.userMessage = userMessage;
    }
}
