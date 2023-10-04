/**Enunciado: Realiza un programa que pregunte por teclado al usuario las tres notas de sus exámenes y nos muestre por pantalla si su media le sale aprobado.
 *
 * @author rperblac
 */
import java.util.Scanner;

public class E23t1 {

    public static void main(String[] args) {
        float nota1, nota2, nota3, media;
        System.out.println("Introduzca notas: ");
        System.out.println("a: ");
        nota1 = new Scanner(System.in).nextFloat();
        System.out.println("b: ");
        nota2 = new Scanner(System.in).nextFloat();
        System.out.println("c: ");
        nota3 = new Scanner(System.in).nextFloat();
        media = (float) (nota1 + nota2 + nota3) / 3;
        boolean aprueba = media >= 5;
        System.out.println("¿Aprueba? " + aprueba);
    }

}
