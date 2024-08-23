package pl.dicedev.pethotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import pl.dicedev.pethotel.config.RoomsTypeProperty;

@SpringBootApplication
@EnableConfigurationProperties(RoomsTypeProperty.class)
@Configuration
public class PethotelApplication {

    public static void main(String[] args) {
        SpringApplication.run(PethotelApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
