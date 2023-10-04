/** Adivina un número entre 0 y 10, en tres intentos
 *
 * @author rperblac
 */
import java.util.Scanner;
import static java.lang.System.out;

public class t1_adivinanumero2 {

    public static void main(String args[]) {
        int adivina, intentos = 0, numero = (int) (Math.random() * 10);

        out.println("ACIERTE UN NÚMERO DEL 0 AL 10");
        out.println("-----------------------------");
        out.println("Recuerde que tiene 3 intentos\n");

        do {
            out.println("Introduzca numero:");
            do {
                adivina = new Scanner(System.in).nextInt();
                if ((adivina < 0) || (adivina > 10))
                {
                    out.println("Debe ser un numero entre 0 y 10, vuelva a introducir número:");
                }
            } while ((adivina < 0) || (adivina > 10));

            if (adivina > numero)
            {
                out.println("Menor");
            }
            if (adivina < numero)
            {
                out.println("Mayor");
            }
            intentos++;
        } while ((intentos < 3) && (adivina != numero));
        
        if (adivina == numero)
        {
            out.println("Acertó!");
        } 
        else if (intentos >= 3) 
        {
            out.println("Se le acabaron los intentos. El número era " + numero);
        }
    }
}
