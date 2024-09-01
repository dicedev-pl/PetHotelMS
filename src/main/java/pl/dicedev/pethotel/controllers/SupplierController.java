package pl.dicedev.pethotel.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dicedev.pethotel.controllers.dot.AnimalFoodDto;
import pl.dicedev.pethotel.services.SupplierService;

import java.util.List;

@RestController
@RequestMapping("/vi/supplier")
@AllArgsConstructor
public class SupplierController {

    private final SupplierService service;

    @GetMapping
    public List<AnimalFoodDto> getAnimalSuupplierDtoList() {
        return service.getAllSupplier();
    }

}
