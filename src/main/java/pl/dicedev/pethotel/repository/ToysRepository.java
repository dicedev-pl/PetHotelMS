package pl.dicedev.pethotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dicedev.pethotel.repository.entity.ToysEntity;

import java.util.UUID;

@Repository
public interface ToysRepository extends JpaRepository<ToysEntity, UUID> {
}
