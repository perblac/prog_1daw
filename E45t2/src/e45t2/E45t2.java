package e45t2;

/** Enunciado: Consulta el pdf de la librería “java time” y busca las clases LocalDate y DayOfWeek. Haz un programa que muestre por pantalla el nombre del día de la semana que será el 28 de febrero de 2100.
 *
 * @author rperblac
 */
import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;

public class E45t2 {

    public static void main(String[] args) {
        LocalDate fecha = LocalDate.of(2100, 2, 28);
        System.out.print("El 28 de febrero de 2100 será ");
        System.out.println(DayOfWeek.from(fecha).getDisplayName(TextStyle.FULL, Locale.getDefault()));
    }
    
}
