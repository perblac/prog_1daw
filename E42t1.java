/**Enunciado: Realiza un programa que pregunte al usuario su nota numérica, y el ordenador muestre por pantalla la calificación obtenida según esta tabla:
	Nota 			Menor de 5 	Entre 5 y 6 	Entre 6 y 7 	Entre 7 y 9 	Entre 9 y 10 10
	Calificación 	Suspenso 	Suficiente 		Bien Notable 	Sobresaliente 	Matrícula
 *
 * @author rperblac
 */
import java.util.Scanner;

public class E42t1 {

    public static void main(String[] args) {
        System.out.println("Introduzca su nota: ");
        float nota = new Scanner(System.in).nextFloat();
        if ((nota < 0) || (nota > 10)) {
            System.out.println("El rango de nota es entre 0 y 10");
        } else {
            if (nota < 5) {
                System.out.println("Suspenso");
            } else if (nota <= 6) {
                System.out.println("Suficiente");
            } else if (nota <= 7) {
                System.out.println("Bien");
            } else if (nota <= 9) {
                System.out.println("Notable");
            } else if (nota <= 10) {
                System.out.print("Sobresaliente");
            }
            if (nota == 10) {
                System.out.println(" Matrícula");
            }
        }
    }

}
