/**Enunciado: : Realiza un programa que pregunte al usuario su nota final del examen. El programa mostrará si está aprobado y también si está suspenso.
 *
 * @author rperblac
 */
import java.util.Scanner;

public class E26t1 {

    public static void main(String[] args) {
        System.out.println("Introduzca su nota: ");
        float nota = new Scanner(System.in).nextFloat();
        System.out.print("Aprobado: ");
        boolean aprobado = nota >= 5;
        if (aprobado) {
            System.out.println("Si");
        } else {
            System.out.println("No");
        }
        System.out.print("Suspenso: ");
        if (!aprobado) {
            System.out.println("Si");
        } else {
            System.out.println("No");
        }
        
    }
}