package pl.dicedev.pethotel.i18n;

import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class I18nUtil {

    private MessageSource messageSource;

    @Resource(name = "localeHolder")
    LocaleHolder localeHolder;

    public String getMessage(String code, String... args) {
        return messageSource.getMessage(code, args, localeHolder.getCurrentLocale());
    }

}
