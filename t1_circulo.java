/** Calcula el área de un circulo de radio dado
 *
 * @author rperblac
 */
import java.util.Scanner;

public class t1_circulo {

    public static void main(String args[]) {
        float radio, area;
        float pi = 3.14159F;
        System.out.println("Introduzca radio: ");
        radio = new Scanner(System.in).nextFloat();
        area = pi * (radio * radio);
        System.out.println("El área es " + area);
    }
}
