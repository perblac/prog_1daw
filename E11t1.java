/**Enunciado:  Haz un programa que pregunte al usuario su nombre, su primer apellido y su segundo apellido (cada uno será una pregunta independiente). El ordenador mostrará el nombre y apellidos del usuario en formato apellido1 apellido2, nombre
 *
 * @author rperblac
 */

import java.util.Scanner;

public class E11t1 {
    public static void main(String[] args) {
        System.out.println("Nombre? ");
        String nombre = new Scanner(System.in).nextLine();
        System.out.println("Primer apellido? ");
        String apellido1 = new Scanner(System.in).nextLine();
        System.out.println("Segundo apellido? ");
        String apellido2 = new Scanner(System.in).nextLine();
        System.out.println(apellido1+" "+apellido2+", "+nombre);
    }
}
