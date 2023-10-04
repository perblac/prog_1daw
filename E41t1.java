/**Enunciado: Realiza un programa que pregunte un número comprendido entre 10 y 56 por teclado al usuario. Si el número está en dicho rango, el programa mostrará un mensaje de que es correcto, y en caso contrario, se indicará que no lo es
 *
 * @author rperblac
 */
import java.util.Scanner;

public class E41t1 {

    public static void main(String[] args) {
        System.out.println("Introduzca un nº comprendido entre 10 y 56");
        byte dato = new Scanner(System.in).nextByte();
        if ((dato < 10) || (dato > 56)) {
            System.out.println("El nº no está en el rango");
        } else {
            System.out.println("Correcto");
        }
    }

}
