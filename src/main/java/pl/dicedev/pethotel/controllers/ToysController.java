package pl.dicedev.pethotel.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dicedev.pethotel.controllers.dot.AnimalFoodDto;
import pl.dicedev.pethotel.controllers.dot.ToysDto;
import pl.dicedev.pethotel.services.AnimalFoodService;
import pl.dicedev.pethotel.services.ToysService;

import java.util.List;

@RestController
@RequestMapping("/vi/toys")
@AllArgsConstructor
public class ToysController {

    private final ToysService service;

    @GetMapping
    public List<ToysDto> getAnimalFoodDtoList() {
        return service.getAllToys();
    }

}
