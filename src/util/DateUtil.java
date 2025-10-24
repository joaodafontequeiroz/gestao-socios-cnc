package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Classe utilitária para manipulação de datas
 */
public class DateUtil {
    
    public static String getDataAtualFormatada() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    
    public static String getDataAtualISO() {
        return LocalDate.now().toString();
    }
}