/** Hace una lista de dos números y su suma, y la multiplica por un valor introducido
 *
 * @author rperblac
 */
import java.util.Scanner;

public class t1_listaplus {

    public static void main(String args[]) {
        
        Scanner leer = new Scanner(System.in);
        
        int[] suma = {0, 0, 0};
        int[] producto = {0, 0, 0};
        int mult = 0;
        String repetir="s";
        
        while (!(repetir.equals("n")))
        {
        System.out.println("A: ");
        suma[0] = leer.nextInt();
        System.out.println("B: ");
        suma[1] = leer.nextInt();
        suma[2] = suma[0] + suma[1];
        
        System.out.println("Multiplicador: ");
        mult = leer.nextInt();
        producto[0] = (suma[0] * mult);
        producto[1] = (suma[1] * mult);
        producto[2] = (suma[2] * mult);
        
        System.out.println("variable suma: [" + suma[0] + "," + suma[1] + "," + suma[2]+"]");
        System.out.println("variable producto: [" + producto[0] + "," + producto[1] + "," + producto[2]+"]");
        
        System.out.println("Continuar (s/n)");
        repetir = leer.next();
        }
    }
}
