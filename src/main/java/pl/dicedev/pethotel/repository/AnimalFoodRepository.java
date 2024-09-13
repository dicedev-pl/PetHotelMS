package pl.dicedev.pethotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dicedev.pethotel.repository.entity.AnimalFoodEntity;

import java.util.UUID;

@Repository
public interface AnimalFoodRepository extends JpaRepository<AnimalFoodEntity, UUID> {
}
