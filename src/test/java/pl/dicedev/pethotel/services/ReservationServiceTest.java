package pl.dicedev.pethotel.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.dicedev.pethotel.controllers.dot.ReservationDto;
import pl.dicedev.pethotel.exceptions.ReservationException;
import pl.dicedev.pethotel.repository.ReservationRepository;
import pl.dicedev.pethotel.repository.entity.ReservationEntity;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ReservationServiceTest {

    @Mock
    private AuthTokenCheckService authTokenCheckService;
    @Mock
    private ReservationRepository reservationRepository;

    @Test
    void shouldThrowExceptionWhenTokenIsInvalid() {
        // given
        ReservationService service = new ReservationService(
                new MockServiceFalseClass(),
                null);

        // when
        ReservationException exception = assertThrows(
                ReservationException.class,
                () -> service.saveReservation(new ReservationDto(), null)
        );

        // then
        assertEquals("Invalid token", exception.getMessage());
        assertEquals(
                UUID.fromString(
                        "850f4ee9-3268-4573-877a-6bd15da91e0b"),
                exception.getId()
        );

    }

    @Test
    void shouldThrowExceptionWhenTokenIsInvalid2() {
        // given
        ReservationService service = new ReservationService(
                new MockServiceTrueClass(),
                new MockRepository());

        // when
        UUID result = service.saveReservation(new ReservationDto(), null);

        // then
        assertNotNull(result);

    }

    @Test
    void shouldThrowExceptionWhenTokenIsInvalid3() {
        // given
        ReservationService service = new ReservationService(
                new MockServiceFalseClass(),
                null);

        // when
        ReservationException exception = assertThrows(
                ReservationException.class,
                () -> service.saveReservation(null, null)
        );

        // then
        assertEquals("Invalid token", exception.getMessage());
        assertEquals(
                UUID.fromString(
                        "850f4ee9-3268-4573-877a-6bd15da91e0b"),
                exception.getId()
        );

    }

    private class MockServiceTrueClass implements AuthTokenCheckService {
        @Override
        public Boolean hasTokenWithAddReservationsRights(String token) {
            return true;
        }
    }

    private class MockServiceFalseClass implements AuthTokenCheckService {
        @Override
        public Boolean hasTokenWithAddReservationsRights(String token) {
            return false;
        }
    }

    private class MockServiceNullClass implements AuthTokenCheckService {
        @Override
        public Boolean hasTokenWithAddReservationsRights(String token) {
            return null;
        }
    }

    private class MockRepository implements ReservationRepository {
        @Override
        public ReservationEntity save(ReservationEntity entity) {
            return ReservationEntity.builder()
                    .id(UUID.randomUUID())
                    .build();
        }

        @Override
        public <S extends ReservationEntity> Iterable<S> saveAll(Iterable<S> entities) {
            return null;
        }

        @Override
        public Optional<ReservationEntity> findById(UUID uuid) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(UUID uuid) {
            return false;
        }

        @Override
        public Iterable<ReservationEntity> findAll() {
            return null;
        }

        @Override
        public Iterable<ReservationEntity> findAllById(Iterable<UUID> uuids) {
            return null;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(UUID uuid) {

        }

        @Override
        public void delete(ReservationEntity entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends UUID> uuids) {

        }

        @Override
        public void deleteAll(Iterable<? extends ReservationEntity> entities) {

        }

        @Override
        public void deleteAll() {

        }
    }
}