package pl.dicedev.pethotel.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.dicedev.pethotel.controllers.dot.AnimalFoodDto;
import pl.dicedev.pethotel.services.AnimalFoodService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/vi/food")
@AllArgsConstructor
public class AnimalFoodController {

    private final AnimalFoodService service;

    @GetMapping
    public List<AnimalFoodDto> getAnimalFoodDtoList() {
        return service.getAllAnimalFood("token");
    }

    @PostMapping
    public UUID saveAnimalFoodDto(@RequestBody AnimalFoodDto dto) {
        return service.saveAnimalFood(dto);
    }

}
