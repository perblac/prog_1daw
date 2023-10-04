package e34t3;

/** Enunciado: Haz un programa que pregunte un número al usuario y nos muestre la lista de todos sus divisores.
 *
 * @author rperblac
 */
import java.util.Scanner;
public class E34t3 {

    public static void main(String[] args) {
        boolean ok = false;
        int num = 0;
        
        System.out.print("Introduce un número: ");

        do
        {
            try
            {
                num = new Scanner(System.in).nextInt();
                ok = true;
            } catch (Exception e)
            {
                System.out.println("Entrada incorrecta");
                ok = false;
            }
        } while (!ok);
        
        System.out.println("Los divisores de " + num + " son:");
        for (int i = 1; i <= Math.abs(num); i++)
        {
            if (num%i==0) System.out.println(i);
        }
    }
    
}
