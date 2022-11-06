/**Enunciado: Realiza un programa que pregunte al usuario la edad de dos personas. El programa mostrará si ambas son mayores de edad, y también si la primera persona es mayor que la segunda.
 *
 * @author rperblac
 */
import java.util.Scanner;

public class E24t1 {

    public static void main(String[] args) {
        System.out.print("Edad persona 1: ");
        byte edad1 = new Scanner(System.in).nextByte();
        System.out.print(" Edad persona 2: ");
        byte edad2 = new Scanner(System.in).nextByte();

        System.out.println("\n¿Son mayores de edad?: ");
        boolean mayor1 = edad1 >= 18;
        boolean mayor2 = edad2 >= 18;

        System.out.print("Persona1: ");
        if (mayor1) {
            System.out.println("Si");
        } else {
            System.out.println("No");
        }

        System.out.print("Persona2: ");
        if (mayor2) {
            System.out.println("Si");
        } else {
            System.out.println("No");
        }

        boolean relacion = edad1 > edad2;
        System.out.println("¿Es mayor la primera que la segunda?");
        if (relacion) {
            System.out.println("Si");
        } else {
            System.out.println("No");
        }
    }

}
