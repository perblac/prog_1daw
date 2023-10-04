package e26t3;

/** Enunciado: Haz un programa que pida 6 palabras al usuario y las guarde en un array. El programa deberá recorrer el array y mostrar por pantalla cuántas palabras contienen la letra “a”.
 *
 * @author rperblac
 */
import java.util.Scanner;

public class E26t3 {

    public static void main(String[] args) {
        String[] palabras = new String[6];
        String entrada;
        System.out.println("Introduzca seis palabras:");
        for (int i = 0; i < 6; i++)
        {
            System.out.print((i+1)+": ");
            entrada = new Scanner(System.in).next();
            palabras[i] = entrada;
        }
        int contador = 0;
        for (int i = 0; i < 6; i++)
        {
            if (palabras[i].lastIndexOf("a") > -1)
                    {
                        contador = contador + 1;
                        System.out.println(palabras[i]);
                    }           
        }
        System.out.println("Hay " + contador + " palabras que contienen la letra a");
    }
    
}
