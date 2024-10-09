package pl.dicedev.pethotel.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.dicedev.pethotel.controllers.dot.AnimalFoodDto;
import pl.dicedev.pethotel.exceptions.AnimalFoodException;
import pl.dicedev.pethotel.i18n.I18nUtil;
import pl.dicedev.pethotel.repository.AnimalFoodRepository;
import pl.dicedev.pethotel.repository.SupplierRepository;
import pl.dicedev.pethotel.repository.entity.AnimalFoodEntity;
import pl.dicedev.pethotel.repository.entity.SupplierEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AnimalFoodService {

    private final AnimalFoodServiceDependencies animalFoodServiceDependencies;

    public List<AnimalFoodDto> getAllAnimalFood(String token) {
        String messageForUser = animalFoodServiceDependencies
                .getI18nMessage("user.no.permission");
        if (!userCanOrderFood(token)) {
            throw new AnimalFoodException(
                    "User do not have permission to order food",
                    messageForUser,
                    UUID.fromString("850f4ee9-3268-4573-877a-6bd15da91e0b")
            );
        }

        return animalFoodServiceDependencies.getAllAnimalFood().stream()
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
        SupplierEntity supplierEntity = animalFoodServiceDependencies
                .getSupplierEntityById(dto.getId());

        AnimalFoodEntity entity = AnimalFoodEntity.builder()
                .brand(dto.getBrand())
                .animalType(dto.getAnimalType())
                .foodName(dto.getFoodName())
                .caretakerID(dto.getCaretakerID())
                .quantityInStock(dto.getQuantityInStock())
                .supplier(supplierEntity)
                .build();

        AnimalFoodEntity savedEntity = animalFoodServiceDependencies.saveFoodEntity(entity);

        return savedEntity.getId();
    }

    private boolean userCanOrderFood(String token) {
        return animalFoodServiceDependencies.userCanOrderFood(token);
    }
}

@Component
class AnimalFoodServiceDependencies {
    @Autowired
    private AnimalFoodRepository animalFoodRepository;
    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private I18nUtil i18n;
    @Autowired
    private AuthTokenCheckService authTokenCheckServiceImpl;

    List<AnimalFoodEntity> getAllAnimalFood() {
        return animalFoodRepository.findAll();
    }

    public String getI18nMessage(String messageKey) {
        return i18n.getMessage(messageKey);
    }

    public SupplierEntity getSupplierEntityById(UUID id) {
        Optional<SupplierEntity> supplierEntity = supplierRepository.findById(id);
        return supplierEntity.orElse(null);
    }

    public AnimalFoodEntity saveFoodEntity(AnimalFoodEntity entity) {
        return animalFoodRepository.save(entity);
    }

    public boolean userCanOrderFood(String token) {
        return authTokenCheckServiceImpl.hasTokenWithAddReservationsRights(token);
    }
}














