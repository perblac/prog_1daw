package e22t3;

/**
 * Enunciado: Realiza un programa que muestre el nombre de cada alumno y su nota
 * media Alumno/a Programación Base de datos Sistemas Nota FOL Pepe 9 5 4 3 Ana
 * 4 8 6 5 Juan 2 5 10 2 Guillermo 0 0 5 0 Roberta 10 10 10 9
 *
 * @author rperblac
 */
import static java.lang.System.out;

public class E22t3 {

    static float media(float[] a) {
        float notamedia = (a[0] + a[1] + a[2] + a[3]) / 4;
        return notamedia;
    }

    public static void main(String[] args) {
        float[] P = {9, 5, 4, 3}, A = {4, 8, 6, 5}, J = {2, 5, 10, 2}, G = {0, 0, 5, 0}, R = {10, 10, 10, 9};
        out.println("NOTAS MEDIAS\n"
                + "------------");
        out.print("Pepe: \t\t");
        out.printf("%.2f\n", media(P));
        out.print("Ana: \t\t");
        out.printf("%.2f\n", media(A));
        out.print("Juan: \t\t");
        out.printf("%.2f\n", media(J));
        out.print("Guillermo:\t");
        out.printf("%.2f\n", media(G));
        out.print("Roberta:\t");
        out.printf("%.2f\n", media(R));

    }

}
