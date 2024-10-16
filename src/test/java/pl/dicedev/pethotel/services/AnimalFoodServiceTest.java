package pl.dicedev.pethotel.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.dicedev.pethotel.exceptions.AnimalFoodException;
import pl.dicedev.pethotel.i18n.I18nUtil;
import pl.dicedev.pethotel.repository.AnimalFoodRepository;
import pl.dicedev.pethotel.repository.SupplierRepository;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AnimalFoodServiceTest {

    @Mock
    private AnimalFoodRepository animalFoodRepository;
    @Mock
    private SupplierRepository supplierRepository;
    @Mock
    private I18nUtil i18n;
    @Mock
    private AuthTokenCheckService authTokenCheckServiceImpl;

    @Test
    void shouldThrowAnExceptionIfUserDoNotHavePermissionToOrderFood() {
        // given
        String token = "token";
        when(authTokenCheckServiceImpl.hasTokenWithAddReservationsRights(token))
                .thenReturn(false);

        AnimalFoodService service = new AnimalFoodService(
                animalFoodRepository,
                supplierRepository,
                i18n,
                authTokenCheckServiceImpl
        );

        // when
        AnimalFoodException exception = assertThrows(
                AnimalFoodException.class,
                () -> service.getAllAnimalFood(token)
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
