package pl.dicedev.pethotel.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "web.filter.cors")
class CorsFilterProperties {

    private int order = 100;
    private List<String> urlPatterns;
    private List<String> allowedOrigins;
    private List<String> allowedMethods;
    private List<String> allowedHeaders;
    private Long maxAge;

}