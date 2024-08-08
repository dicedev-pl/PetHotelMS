package pl.dicedev.pethotel.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.dicedev.pethotel.repository.entity.ReservationEntity;

import java.util.UUID;

@Repository
public interface ReservationRepository extends CrudRepository<ReservationEntity, UUID> {
}
