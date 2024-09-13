package pl.dicedev.pethotel.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dicedev.pethotel.controllers.dot.AnimalFoodDto;
import pl.dicedev.pethotel.repository.AnimalFoodRepository;
import pl.dicedev.pethotel.repository.SupplierRepository;
import pl.dicedev.pethotel.repository.entity.AnimalFoodEntity;
import pl.dicedev.pethotel.repository.entity.SupplierEntity;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AnimalFoodService {

    private final AnimalFoodRepository animalFoodRepository;
    private final SupplierRepository supplierRepository;

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

    public UUID saveAnimalFood(AnimalFoodDto dto) {
        SupplierEntity supplierEntity = supplierRepository.findById(
                dto.getSupplierID()
        ).get();

        AnimalFoodEntity entity = AnimalFoodEntity.builder()
                .brand(dto.getBrand())
                .animalType(dto.getAnimalType())
                .foodName(dto.getFoodName())
                .caretakerID(dto.getCaretakerID())
                .quantityInStock(dto.getQuantityInStock())
                .supplier(supplierEntity)
                .build();

        AnimalFoodEntity savedEntity = animalFoodRepository.save(entity);

        return savedEntity.getId();
    }
}
