/**Enunciado: Crea un programa que pregunte al usuario un número entero llamado gradosCentígrados. El programa deberá convertir dicha cantidad a grados Farenheit y mostrarla por pantalla. La fórmula para realizar la conversión es:
	F= 9/5*C+32
 *
 * @author rperblac
 */
import java.util.Scanner;

public class E15t1 {
    public static void main(String[] args) {
        int gradosCentigrados;
        System.out.println("Introduzca grados: ");
        gradosCentigrados = new Scanner(System.in).nextInt();
        double far = (gradosCentigrados * 9)/5 + 32;
        System.out.println("Grados Farenheit: " + far +"º F");
    }
}
