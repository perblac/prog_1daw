/**Enunciado: Hacer un programa en el que haya una variable entera llamada dinero e inicializarla a cualquier valor. El programa nos expresará esa cantidad en billetes de 500, 100, 50, 20 y 10 € y monedas de 2 y 1 €. Se ignoran los céntimos.
 *
 * @author rperc
 */
import java.util.Scanner;

public class E50t1 {

    public static void main(String args[]) {
        int dinero = 0;
        System.out.println("Introduzca cantidad: ");
        dinero = new Scanner(System.in).nextInt();
        int[] cambio = {0, 0, 0, 0, 0, 0, 0};//quinientos,cien,cincuenta,veinte,diez,dos,uno
        cambio[0] = dinero / 500;
        dinero = dinero - (cambio[0] * 500);
        cambio[1] = dinero / 100;
        dinero = dinero - (cambio[1] * 100);
        cambio[2] = dinero / 50;
        dinero = dinero - (cambio[2] * 50);
        cambio[3] = dinero / 20;
        dinero = dinero - (cambio[3] * 20);
        cambio[4] = dinero / 10;
        dinero = dinero - (cambio[4] * 10);
        cambio[5] = dinero / 2;
        dinero = dinero - (cambio[5] * 2);
        cambio[6] = dinero / 1;
        dinero = dinero - (cambio[6] * 1);
        System.out.println("Billetes\n--------\n500: " + cambio[0] + "\n100: " + cambio[1] + "\n50: " + cambio[2] + "\n20: " + cambio[3] + "\n10: " + cambio[4] + "\nMonedas\n-------\n2: " + cambio[5] + "\n1: " + cambio[6]);
    }
}
