package e24t3;

/** Enunciado: Haz un programa que pregunte por teclado el número de un mes (entre 1 y 12) y haga lo siguiente:
    · Si el número no está entre 1 y 12, se mostrará un mensaje de error y finalizará.
    · El programa creará un List<LocalDate> y lo rellenará con objetos LocalDate para todos los días del mes cuyo número se ha pasado como parámetro.
    · Se mostrará por pantalla cada elemento de la lista y también el tamaño de la lista.
 *
 * @author rperblac
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class E24t3 {

    public static void main(String[] args) {
        int mes, año = 2022;
        System.out.println("Introduzca nº del mes (1-12)");
        boolean bien; // ¿Se introdujo un número entero?
        do
        {
            try
            {
                mes = new Scanner(System.in).nextInt();
                bien = true;
            } catch (InputMismatchException ime)
            {
                System.out.println("Por favor introduzca un nº entero entre 1 y 12");
                bien = false;
                mes = 0;
            }
        } while (!bien);
        if ((mes<1)||(mes>12)) System.out.println("Error. Valor fuera de rango");
        else
        {
            ArrayList<LocalDate> dias = new ArrayList();
            LocalDate fecha = LocalDate.of(año,mes,1);
            int numerodias = fecha.lengthOfMonth();
            for (int i = 1; i <= numerodias; i++)
            {
                dias.add(fecha);
                fecha = fecha.plusDays(1);
            }
            System.out.print(dias + "\nTamaño de la lista: " + dias.size() + "\n");
        }
    }
    
}
