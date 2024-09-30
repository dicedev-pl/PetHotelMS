package pl.dicedev.pethotel.i18n;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Locale;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LocaleHolder {
    private Locale currentLocale;
}