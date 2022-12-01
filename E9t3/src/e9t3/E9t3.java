package e9t3;

/** Enunciado: Realiza un programa que calcule de forma aproximada la raíz cuadrada de un número positivo N introducido desde el teclado usando el Método de Newton-Raphson, que consiste en lo siguiente:
    - Creamos dos variables de tipo double llamadas S y A, y les damos valor inicial uno.
    - Actualizamos S con la siguiente fórmula:
        𝑆 = 1/2 (𝐴 + 𝑁/A)
    - Si el valor absoluto de la diferencia entre S y A es menor de 0.000001 entonces ya hemos terminado y la raíz cuadrada aproximada es S. En caso contrario, le damos a A el valor de S y repetimos el proceso a partir del punto anterior.
 *
 * @author rperblac
 */
import java.util.Scanner;
import java.lang.Math;

public class E9t3 {

    public static void main(String[] args) {
        System.out.print("Introduzca un número positivo N: ");
        int entrada = 0;
        boolean ok = false;
        do
        {
            try
            {
                entrada = new Scanner(System.in).nextInt();
                if (entrada < 0) System.out.println("El número ha de ser positivo");
                else ok = true;
            } catch (Exception error)
            {
                System.out.println("¡Valor no válido!");
            }
        } while (!ok);
        double S = 1, A = 1;
        double resta;
        do
        {
            S = (A + (entrada/A))/2;
            resta = S - A;
            System.out.println(resta + " " + S);
            A = S;
        } while (Math.abs(resta) > 0.000001);
        System.out.println("La raiz es " + S);
    }
    
}
