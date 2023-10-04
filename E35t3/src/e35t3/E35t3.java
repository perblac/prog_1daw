package e35t3;

/** Enunciado: Haz un programa que pregunte un número al usuario y nos muestre por pantalla
si es primo o no. De las dos formas que hay de hacer el ejercicio, elige la que más fácil te sea:
    1. Se generan todos los números desde 2 hasta el que hay antes del número. Si alguno de
    los números generados es un divisor, entonces ya sabemos que el número no es
    primo. En ese caso, se interrumpe la generación de números y hemos terminado. Si
    por el contrario no hay divisores, entonces el número es primo.
    2. Se generan todos los números desde 2 hasta el que hay antes del número y se cuenta
    en una variable auxiliar el número de divisores que se van encontrando. Si al finalizar
    el recorrido dicha variable es 0 el número es primo.
 *
 * @author rperblac
 */
import java.util.Scanner;
public class E35t3 {
    public static void main(String[] args) {
        boolean ok = false, primo = true;
        int num = 0, divisores = 0;
        
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
        
        // 1.
        for (int i = 2; i < Math.abs(num); i++)
        {
            if (num % i == 0){
                System.out.println(i + " es divisor de " + num + ", por lo tanto no es primo");
                primo = false;
                break;
            }
        }
        
        if (primo) System.out.println("El número " + num + " es primo");
        
        // 2.
        for (int i = 2; i < Math.abs(num); i++)
        {
            if (num % i == 0){
                divisores++;
                System.out.print("[" + i + "] ");
            }
        }
        
        if (divisores == 0) System.out.println("El número " + num + " es primo");
        else System.out.println("El número " + num + " no es primo");
    }
    
}
