package e16t2;

/**Enunciado: Haz un programa que pregunte al usuario por teclado dos frases. El programa deberá mostrar por pantalla si la segunda frase está incluida dentro de la primera frase.
 *
 * @author rperblac
 */
import java.util.Scanner;

public class E16t2 {
    public static void main(String[] args) {
        System.out.println("Introduzca texto 1:");
        String texto1 = new Scanner(System.in).nextLine();
        System.out.println("Introduzca texto 2:");
        String texto2 = new Scanner(System.in).nextLine();
        System.out.print("¿El texto 2 esta incluido en el texto 1? "+texto1.contains(texto2));
    }
    
}
