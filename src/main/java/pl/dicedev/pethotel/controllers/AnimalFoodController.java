package pl.dicedev.pethotel.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dicedev.pethotel.controllers.dot.AnimalFoodDto;
import pl.dicedev.pethotel.services.AnimalFoodService;

import java.util.List;

@RestController
@RequestMapping("/vi/food")
@AllArgsConstructor
public class AnimalFoodController {

    private final AnimalFoodService service;

    @GetMapping
    public List<AnimalFoodDto> getAnimalFoodDtoList() {
        return service.getAllAnimalFood();
    }

}
