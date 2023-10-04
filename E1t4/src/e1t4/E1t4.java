
package e1t4;

/**
 *
 * @author rperblac
 */
import daw.persona.DNI;

public class E1t4 {

    public static void main(String[] args) {
        DNI dni = new DNI(98765432,'Z');
        DNI dni2 = new DNI("11335577M");
        System.out.println("Dni 1: " + dni.numero + ", letra " + dni.letra);
        System.out.println("Dni 2: " + dni2.numero + ", letra " + dni2.letra);
    }

}
