package pl.dicedev.pethotel.services;

import com.example.petshotel.repository.AnimalFoodRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dicedev.pethotel.controllers.dot.AnimalFoodDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AnimalFoodService {

    private final AnimalFoodRepository animalFoodRepository;

    public List<AnimalFoodDto> getAllAnimalFood() {
        return animalFoodRepository.findAll().stream()
                .map(it -> AnimalFoodDto.builder()
                        .id(it.getId())
                        .brand(it.getBrand())
                        .animalType(it.getAnimalType())
                        .foodName(it.getFoodName())
                        .caretakerID(it.getCaretakerID())
                        .quantityInStock(it.getQuantityInStock())
                        .supplierID(it.getSupplier().getId())
                        .build())
                .collect(Collectors.toList());
    }
}
