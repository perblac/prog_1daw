package e6t2;

/**Enunciado: Crea un programa que pida por teclado dos coordenadas y cree un muñeco de Mario en ellas.
 *
 * @author rperblac
 */
import bpc.daw.mario.*;
import java.util.Scanner;

public class E6t2 {

    public static void main(String[] args) {
        System.out.print("Introduzca x (entre 0 y 1500): ");
        int x = new Scanner(System.in).nextInt();
        System.out.print("Introduzca x (entre 0 y 800): ");
        int y = new Scanner(System.in).nextInt();
        Mario m = new Mario(x,y);
    }
    
}
