/**Enunciado:: Realiza un programa que pregunte al usuario por teclado un número de “euros” y el programa mostrará por pantalla el cambio de dicha cantidad a las siguientes monedas:
    Dolares 1 € = 1.42 $
    Libras 100 € = 87.13£
    Yens 1 € = 113.86 ¥
    Pesetas 1 € = 166.386 pts
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
