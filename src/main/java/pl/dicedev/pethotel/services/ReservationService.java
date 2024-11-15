package pl.dicedev.pethotel.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dicedev.pethotel.controllers.dot.ReservationDto;
import pl.dicedev.pethotel.exceptions.ReservationException;
import pl.dicedev.pethotel.repository.ReservationRepository;
import pl.dicedev.pethotel.repository.entity.ReservationEntity;

import java.util.UUID;

@AllArgsConstructor
@Service
public class ReservationService {

    private final AuthTokenCheckService authTokenCheckService;
    private final ReservationRepository reservationRepository;
    private final CustomersService customersService;

    public UUID saveReservation(ReservationDto dto, String token) {
        if (dto == null) return null;

//        if (!authTokenCheckService.hasTokenWithAddReservationsRights(token)) {
//            throw new ReservationException(
//                    "Invalid token",
//                    "Invalid token",
//                    UUID.fromString("850f4ee9-3268-4573-877a-6bd15da91e0b")
//            );
//        }

        var a = customersService.getCustomerByLogin(dto.getCustomerName());
        var b = customersService.getCustomerById(dto.getCustomerName());
        var c = customersService.getCustomerByName(dto.getCustomerName());

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        ReservationEntity entity = new ReservationEntity();
        entity.setCustomerName(dto.getCustomerName());
        entity.setGuestType(dto.getGuestType());
        entity.setStartDate(dto.getStartDate());
        entity.setEndDate(dto.getEndDate());

//        ReservationEntity savedEntity = reservationRepository.save(entity);
//        return savedEntity.getId();
        return null; // Placeholder for actual saving logic to repository
    }

}
