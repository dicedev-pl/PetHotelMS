package pl.dicedev.pethotel.services;

import org.junit.jupiter.api.Test;
import pl.dicedev.pethotel.exceptions.AnimalFoodException;
import pl.dicedev.pethotel.repository.entity.AnimalFoodEntity;
import pl.dicedev.pethotel.repository.entity.SupplierEntity;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AnimalFoodServiceTest {

    @Test
    void shouldThrowAnExceptionIfUserDoNotHavePermissionToOrderFood() {
        // given
        AnimalFoodService service = new AnimalFoodService(
                new AnimalFoodServiceDependenciesMock()
        );

        // when
        AnimalFoodException exception = assertThrows(
                AnimalFoodException.class,
                () -> service.getAllAnimalFood("token")
        );

        // then
        assertEquals("User do not have permission to order food", exception.getMessage());
        assertEquals(
                UUID.fromString(
                        "850f4ee9-3268-4573-877a-6bd15da91e0b"),
                exception.getId()
        );


    }
}

class AnimalFoodServiceDependenciesMock extends AnimalFoodServiceDependencies {
    @Override
    List<AnimalFoodEntity> getAllAnimalFood() {
        return List.of(AnimalFoodEntity.builder()
                .animalType("DOG")
                .foodName("Doggot")
                .brand("Doggi")
                .caretakerID(UUID.randomUUID())
                .quantityInStock(1)
                .build());
    }

    @Override
    public String getI18nMessage(String messageKey) {
        return "Message: " + messageKey;
    }

    @Override
    public SupplierEntity getSupplierEntityById(UUID id) {
        return SupplierEntity.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public AnimalFoodEntity saveFoodEntity(AnimalFoodEntity entity) {
        entity.setId(UUID.randomUUID());
        return entity;
    }

    @Override
    public boolean userCanOrderFood(String token) {
        return false;
    }
}