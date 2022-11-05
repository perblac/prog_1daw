/**
 *
 * @author rperblac
 */
import java.util.Scanner;

public class E14t1 {

    public static void main(String args[]) {
        System.out.print("¿Cantidad en euros? ");
        float euros = new Scanner(System.in).nextFloat();
        System.out.println("Dólares:\t" + (euros * 1.42) + " $");
        System.out.println("Libras:\t\t" + (euros * 0.8713) + " £");
        System.out.println("Yenes:\t\t" + (euros * 113.86) + " ¥");
        System.out.println("Pesetas:\t" + (euros * 166.386) + " pts");
    }
}
