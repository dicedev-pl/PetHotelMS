package pl.dicedev.pethotel.services;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class CustomersServiceImpl implements CustomersService {

    @Override
    public String getCustomerByName(String name) {
        if (!"ALAALACKA".equals(name.toUpperCase().replaceAll(" ", ""))) return "";

        log.info("getCustomerByName {}", name);
        return getCustomerUUID();
    }

    @Override
    public String getCustomerById(String id) {
        if (!"999888777".equals(id)) return "";

        log.info("getCustomerById {}", id);
        return getCustomerUUID();
    }

    @Override
    public String getCustomerByLogin(String login) {
        if (!"ala123".equals(login)) return "";

        log.info("getCustomerByLogin {}", login);
        return getCustomerUUID();
    }

    private String getCustomerUUID() {
        return "5c4ff4d6-6f27-44c3-a0bb-14f11ff16fe7";
    }
}
