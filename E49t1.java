/**Enunciado: : La siguiente gráfica (tabla) nos muestra el número de asignaturas suspensas de unos alumnos. Se supone que un alumno pasa de curso si no tiene asignaturas suspensas. Realiza un programa que pregunte al usuario por un número de lista entre 0 y 4 y nos muestre por pantalla el nombre del alumno seleccionado, su número de suspensos y si pasa de curso o no.
 *
 * @author rperblac
 */
import java.util.Scanner;

public class E49t1 {

    public static void main(String args[]) {
        String[] alumnos = {"Antonio", "Jaime", "Pedro", "Manuel", "Maite"};
        byte[] suspensos = {3, 8, 2, 0, 0};
        System.out.print("Introduzca numero de lista (0 a 4): ");
        byte numero = new Scanner(System.in).nextByte();
        System.out.print("\nAlumno: " + alumnos[numero] + "\nNº de suspensos: " + suspensos[numero] + "\nPasa de curso: ");
        if (suspensos[numero] > 0) {
            System.out.println("NO");
        } else {
            System.out.println("SI");
        }
    }
}
