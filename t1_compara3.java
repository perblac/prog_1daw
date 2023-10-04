/** Compara tres numeros y los ordena de mayor a menor
 *
 * @author rperblac
 */
import java.util.Scanner;

public class t1_compara3 {

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
            if ((num1 > num2) && (num1 > num3)) {
                if (num2 > num3) {
                    System.out.println(num1 + ">" + num2 + ">" + num3);
                } else {
                    if (num2 == num3) {
                        System.out.println(num1 + ">" + num2 + "=" + num3);

                    } else {
                        System.out.println(num1 + ">" + num3 + ">" + num2);
                    }
                }
            } else if ((num2 > num1) && (num2 > num3)) {
                if (num1 > num3) {
                    System.out.println(num2 + ">" + num1 + ">" + num3);
                } else {
                    if (num1 == num3) {
                        System.out.println(num2 + ">" + num1 + "=" + num3);
                    } else {
                        System.out.println(num2 + ">" + num3 + ">" + num1);
                    }
                }
            } else if ((num3 > num1) && (num3 > num2)) {
                if (num1 > num2) {
                    System.out.println(num3 + ">" + num1 + ">" + num2);
                } else {
                    if (num1 == num2) {
                        System.out.println(num3 + ">" + num1 + "=" + num2);
                    } else {
                        System.out.println(num3 + ">" + num2 + ">" + num1);

                    }
                }
            } else {

                if ((num1 == num2) && (num1 > num3)) {
                    System.out.println(num1 + "=" + num2 + ">" + num3);
                }
                if ((num2 == num3) && (num2 > num1)) {
                    System.out.println(num2 + "=" + num3 + ">" + num1);
                }
                if ((num1 == num3) && (num1 > num2)) {
                    System.out.println(num1 + "=" + num3 + ">" + num2);
                }
            }

        }

    }
}
