package pl.dicedev.pethotel.services;

public interface AuthTokenCheckService {

    Boolean hasTokenWithAddReservationsRights(String token);

}
