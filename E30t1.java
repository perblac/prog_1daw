/**Enunciado: Un alumno ha sacado un 6.5, un 4.2, un 5.75, un 3.5 y un 8 en sus exámenes, y además, tiene 10 faltas. Realiza un programa que nos diga si el alumno ha aprobado, teniendo en cuenta que para aprobar se siguen estos criterios:
	- Si el número de faltas es superior a 10, la nota media de los exámenes debe ser mayor que 5
	- Si el número de faltas está entre 15 y 20, la nota media de los exámenes debe ser más de 7
	- Si el número de faltas es superior a 20, está suspenso
 *
 * @author rperblac
 */
import java.util.Scanner;

public class E30t1 {

    public static void main(String[] args) {
        float nota1, nota2, nota3, nota4, nota5, media;
        byte faltas;
        boolean aprobado = true;
        System.out.println("Introduzca notas\nNota 1: ");
        nota1 = new Scanner(System.in).nextFloat();
        System.out.println("Nota 2: ");
        nota2 = new Scanner(System.in).nextFloat();
        System.out.println("Nota 3: ");
        nota3 = new Scanner(System.in).nextFloat();
        System.out.println("Nota 4: ");
        nota4 = new Scanner(System.in).nextFloat();
        System.out.println("Nota 5: ");
        nota5 = new Scanner(System.in).nextFloat();
        media = (nota1 + nota2 + nota3 + nota4 + nota5) / 5;
        System.out.println("Media ->" + media);
        System.out.println("Introduzca número de faltas: ");
        faltas = new Scanner(System.in).nextByte();

        if (media < 5) {
            aprobado = false;
        }

        if ((faltas > 10) && (faltas < 14)) {
            if (media > 5) {
                aprobado = true;
            } else {
                aprobado = false;
            }
        } else if ((faltas > 14) && (faltas < 21) && (media > 7)) {
            aprobado = true;
        } else if (faltas > 20) {
            aprobado = false;
        }

        if (aprobado) {
            System.out.println("APROBADO");
        } else {
            System.out.println("SUSPENSO");
        }
    }
}
