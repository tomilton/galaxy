package co.trycore.galaxy.core.common.util;

import co.trycore.galaxy.core.common.constants.Constants;
import org.apache.commons.validator.GenericValidator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UtilityDate {
    private UtilityDate() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * @param fecha
     * @param numero
     * @return
     */
    public static Integer getYearFromDate(String fecha, int numero) {
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
            LocalDate localDate = LocalDate.parse(fecha, dateTimeFormatter);
            switch (numero) {
                case 1:
                    return localDate.getYear();
                case 2:
                    return localDate.getMonthValue();
                case 3:
                    return localDate.getDayOfMonth();
                default:
                    return 0;
            }
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @param fecha
     * @return
     */
    public static boolean isDate(String fecha) {
        return GenericValidator.isDate(fecha, Constants.FORMAT_DATE, false);
    }

}
