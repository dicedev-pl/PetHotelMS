package pl.dicedev.pethotel.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Set;

@Data
@ConfigurationProperties(prefix = "dicedev")
public class RoomsTypeProperty {

    private Set<String> rooms;

}
