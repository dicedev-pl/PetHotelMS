package pl.dicedev.pethotel.services;

public interface CustomersService {

    String getCustomerByName(String name);
    String getCustomerById(String id);
    String getCustomerByLogin(String login);

}
