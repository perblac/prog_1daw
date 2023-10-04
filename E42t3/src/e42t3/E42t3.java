package e42t3;

/**
 * Enunciado: Haz un programa que pregunte al usuario el número total de filas y el número total de columnas, y cree una tabla de números, en la que cada número es la suma de su número de fila y número de columna.
 *
 * @author rperblac
 */
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class E42t3 {

    public static void main(String[] args) {
        boolean bien;
        int filas = 1, columnas = 1;
        DecimalFormat formato = new DecimalFormat("###");
        
        System.out.println("Número de filas");
        do {
            bien = false;
            try {
                filas = new Scanner(System.in).nextInt();
                if (filas < 1) {
                    System.out.println("Por favor introduzca un número mayor que 0");
                } else {
                    bien = true;
                }
            } catch (InputMismatchException ime) {
                System.out.println("Por favor introduzca un número entero");
                bien = false;
            }
        } while (!bien);

        System.out.println("Número de columnas");
        do {
            bien = false;
            try {
                columnas = new Scanner(System.in).nextInt();
                if (columnas < 1) {
                    System.out.println("Por favor introduzca un número mayor que 0");
                } else {
                    bien = true;
                }
            } catch (InputMismatchException ime) {
                System.out.println("Por favor introduzca un número entero");
                bien = false;
            }
        } while (!bien);
        
        for (int i = 0; i < filas ; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.printf("%3s", formato.format(i + j));
                System.out.print(" ");
            }
            System.out.println();
        }
    }

}
