/**Enunciado: Realiza un programa que pregunte al usuario dos números enteros y nos diga si el primero es mayor o igual que el segundo
 *
 * @author rperblac
 */
import java.util.Scanner;

public class E39t1 {

    public static void main(String[] args) {
        int num1, num2;

        System.out.println("Nº 1:");
        num1 = new Scanner(System.in).nextInt();
        System.out.println("Nº 2:");
        num2 = new Scanner(System.in).nextInt();

        if (num1 > num2) {
            System.out.println(num1 + " es mayor que " + num2);
        } else {
            if (num1 == num2) {
                System.out.println("Ambos números son iguales");
            }
        }

    }
}
