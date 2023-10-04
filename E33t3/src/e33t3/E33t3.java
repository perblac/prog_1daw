package e33t3;

/** Enunciado: Realiza un programa que pregunte una frase al usuario. El programa mostrará cada letra de la frase en un renglón diferente.
 *
 * @author rperblac
 */
import java.util.Scanner;
public class E33t3 {

    public static void main(String[] args) {
        String frase;
        System.out.print("Introduce frase: ");
        frase = new Scanner(System.in).next();
        for (int i = 0; i < frase.length(); i ++){
            System.out.println(frase.charAt(i));
        }
    }
    
}
