package e43t3;

/** Enunciado: Haz un programa que cree una tabla de 4 filas y 3 columnas rellenada con booleanos aleatorios. El programa mostrará la tabla en pantalla y después la recorrerá y nos dirá cuántos true y cuántos false hay en la tabla.
 *
 * @author rperblac
 */
import java.util.Random;

public class E43t3 {
    public static void main(String[] args) {
        boolean[][] tabla = new boolean[4][3];
        Random g = new Random();
        int i, j, t = 0, f = 0;
        for (i = 0; i < 4; i++)
        {
            for (j = 0; j < 3; j++)
            {
                tabla[i][j] = g.nextBoolean();
                System.out.printf("%5s", tabla[i][j]);
                System.out.print(" ");
                if (tabla[i][j]) t = t + 1;
                else f = f + 1;
            }
            System.out.println();
        }
        System.out.println("Trues: " + t + "\nFalses: " + f);
    }
    
}
