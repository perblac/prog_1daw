package e8t3;

/** Enunciado: Usa la clase StringTokenizer para hacer un programa que pregunte al usuario "Escriba una frase" y nos muestre en una línea diferente cada palabra de la frase y además, el número total de palabras encontradas.
 *
 * @author rperblac
 */
import java.util.Scanner;
import java.util.StringTokenizer;

public class E8t3 {

    public static void main(String[] args) {
        System.out.println("Escriba una frase");
        String frase = new Scanner(System.in).nextLine();
        StringTokenizer separador = new StringTokenizer(frase);
        int i = 0;
        while (separador.hasMoreTokens())
        {
            i++;
            System.out.println(i + ".- " + separador.nextToken());
        }
        System.out.println("En total hay " + i + " palabras");
        
    }
    
}
