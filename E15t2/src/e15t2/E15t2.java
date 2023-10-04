package e15t2;

/**Enunciado: Haz un programa en el que haya una variable String llamada “clave” con el texto que tú quieras. A continuación, el programa pedirá que introduzcas una contraseña por teclado. El ordenador mostrará si la variable “clave” coincide con la contraseña introducida.
 *
 * @author rperblac
 */
import java.util.Scanner;
public class E15t2 {

    public static void main(String[] args) {
        String clave = "ABCD";
        System.out.println("Introduzca clave:");
        String entrada = new Scanner(System.in).next();
        if (entrada.equals(clave))
        {
            System.out.println("Clave correcta");
        } else
        {
            System.out.println("Clave incorrecta");            
        }
    }
    
}
