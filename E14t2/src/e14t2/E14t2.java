package e14t2;

/**Enunciado: Consulta la documentación de la clase String para hacer un programa que pregunte una frase al usuario y se muestre la letra que hay justo en la mitad de la frase.
 *
 * @author rperblac
 */
import java.util.Scanner;
public class E14t2 {

    public static void main(String[] args) {
        System.out.println("Introduzca frase:");
        String frase = new Scanner(System.in).nextLine();
        char letra = frase.charAt((frase.length()/2));
        System.out.println("La letra central es ->"+letra+"<-");
    }
    
}
