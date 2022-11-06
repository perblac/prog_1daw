/**Enunciado: Realiza un programa que pregunte al usuario tres números enteros y el programa nos muestre el mayor de ellos
 *
 * @author rperblac
 */
import java.util.Scanner;

public class E40t1 {

    public static void main(String[] args) {
        int num1, num2, num3;

        System.out.println("Nº 1:");
        num1 = new Scanner(System.in).nextInt();
        System.out.println("Nº 2:");
        num2 = new Scanner(System.in).nextInt();
        System.out.println("Nº 3:");
        num3 = new Scanner(System.in).nextInt();

        if ((num1 == num2) && (num2 == num3)) {
            System.out.println("Todos son iguales");
        } else {
            System.out.print("El mayor es ");

            if (num1 >= num2) {
                if (num1 > num3) {
                    System.out.println(num1);
                } else {
                    System.out.println(num3);
                }
            } else {
                if (num2 > num1) {
                    if (num2 > num3) {
                        System.out.println(num2);
                    } else {
                        System.out.println(num3);
                    }
                }
            }

        }

    }
}
