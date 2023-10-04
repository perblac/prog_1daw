package e44t2;

/** Enunciado: Consulta el pdf de la librería “java time” y busca las clases LocalDate y DateTimeFormatter. Haz un programa que muestre por pantalla la fecha actual en formato día/mes/año y después en formato día-mes-año.
 *
 * @author rperblac
 */
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class E44t2 {

    public static void main(String[] args) {
        LocalDate fecha = LocalDate.now();
        DateTimeFormatter formatobarra = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechabarra = fecha.format(formatobarra);
        String fechaguion = fecha.format(DateTimeFormatter.ofPattern("dd-MM-yyy"));
        System.out.println(fechabarra + "\n" + fechaguion);
    }
    
}
