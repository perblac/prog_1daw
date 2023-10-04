package e21t3;

/** Enunciado: Realiza un programa que cree la lista de números del ejercicio anterior. A
continuación, el programa preguntará al usuario: “Escribe un número” y nos mostrará en
pantalla cuántas veces aparece el número en la lista y si el número está o no en la lista.
 *
 * @author rperblac
 */
import java.util.Scanner;
import java.util.InputMismatchException;

public class E21t3 {

    public static void main(String[] args) {
        int[] numeros = {2,9,4,5,6,1,2,3,45,2,1,2,65,3,2,6,1,2,3,5,2,2,6,67,11,67,3,2,1,7,8,5,3,27,8,93,1,6};

        int entrada = 0;
        boolean bien=false;
        do
        {
            try
            {
                System.out.println("Escriba un numero");
                entrada = new Scanner(System.in).nextInt();
                bien = true;
            }
            catch(InputMismatchException ime)
            {
                System.out.println("Introduzca un numero entero");
            }
        } while (!bien);
        int veces = 0;
        for (int i = 0;i<numeros.length;i++)
        {
            if (numeros[i] == entrada) veces = veces +1;            
        }
        switch (veces) {
            case 0:
                System.out.println("El numero " +  entrada + " no aparece en la lista");
                break;
            case 1:
                System.out.println("El numero "+entrada+" aparece en la lista " + veces + " vez");
                break;
            default:
                System.out.println("El numero "+entrada+" aparece en la lista " + veces + " veces");
                break;
        }
    }
    
}
