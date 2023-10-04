/** Voltea una cadena de texto
 *
 * @author rperblac
 */
import java.util.Scanner;

public class t1_giratexto {
	
    public static void main(String args[]) {
        char a;
        String b = "", c;
        int contador;
        System.out.println("Introduzca cadena a voltear: ");
        c = new Scanner(System.in).nextLine();

        for (contador = (c.length() - 1); (contador >= 0); --contador) {
            b = c.substring(0, contador);
            System.out.println(b);
        }

        for (contador = (c.length() - 1); (contador >= 0); --contador) {
            a = c.charAt(contador);
            b += a;
            System.out.println(b);

        }
    }
}
