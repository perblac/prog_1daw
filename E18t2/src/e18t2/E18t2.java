package e18t2;

/**Enunciado: Haz un programa que pregunte al usuario por su dirección de correo y la descomponga en su nombre de usuario y su dominio.
 *
 * @author rperblac
 */
import java.util.Scanner;

public class E18t2 {

    public static void main(String[] args) {
        System.out.println("¿Cuál es tu correo electrónico?");
        String correo = new Scanner(System.in).next();
        if (!(correo.contains("@")))
        {
            System.out.println("La dirección de correo no contiene el caracter @");
        }
        else
        {
            String nombre = correo.substring(0, correo.indexOf("@"));
            String dominio = correo.substring((correo.indexOf("@") + 1), correo.length());
            System.out.println("- Tu nombre de usuario es: " + nombre);
            System.out.println("- Tu dominio es: " + dominio);
        }
    }

}
