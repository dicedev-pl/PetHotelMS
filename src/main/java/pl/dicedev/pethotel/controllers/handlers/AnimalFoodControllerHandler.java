package pl.dicedev.pethotel.controllers.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.dicedev.pethotel.controllers.dot.ErrorDto;
import pl.dicedev.pethotel.exceptions.AnimalFoodException;

@RestControllerAdvice
public class AnimalFoodControllerHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public ErrorDto handlerAnimalFoodException(AnimalFoodException exception) {
        return new ErrorDto(
                exception.getMessage(),
                exception.getUserMessage(),
                exception.getId()
        );
    }

}
