package e31t3;

/** Enunciado: Realiza un programa que pida un número entero al usuario y muestre por pantalla la tabla de multiplicar de dicho número.
 *
 * @author rperblac
 */
import java.util.Scanner;

public class E31t3 {

    public static void main(String[] args) {
        int num = 0;
        boolean correcto= false;
        while (!correcto)        
        {            
            try
            {
                System.out.print("Introduce un número: ");
                num = new Scanner(System.in).nextInt();
                correcto = true;
            } catch (Exception e)
            {
                System.out.println("Introduzca un nº entero");
                correcto = false;
            }
        }
        for (int i = 0; i <= 10; i++)
        {
            System.out.println(num + " x " + i + " = " + (num*i));
        }
    }
    
}
