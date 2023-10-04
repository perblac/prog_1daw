/**Enunciado: En los ciclos de Formación Profesional, un alumno que falte más de un 20% de las horas de clase pierde el derecho a la evaluación continua.
		Lenguajes de marcas 128 horas
		Redes 				192 horas
		Hardware 			 96 horas
	a) Realiza un programa que muestre por pantalla la cantidad máxima de faltas permitidas para cada una de estas asignaturas
	b) Haz que el programa pregunte al usuario por el número de faltas de un alumno en redes y nos muestre si el alumno ha superado o no la cantidad de faltas indicada.
 *
 * @author rperblac
 */
import java.util.Scanner;

public class E31t1 {

    public static void main(String[] args) {
        System.out.println("Máximo de faltas permitidas por asignatura (20% del total)");
        System.out.println("Lenguajes de marcas 128 horas: " + ((128 * 20) / 100));
        System.out.println("Redes               192 horas: " + ((192 * 20) / 100));
        System.out.println("Hardware             96 horas: " + ((96 * 20) / 100));

        System.out.println("Nº de faltas del alumno en Redes: ");
        byte faltas = new Scanner(System.in).nextByte();
        if (faltas > ((192 * 20) / 100)) {
            System.out.println("El alumno ha superado la cantidad de faltas indicadas (" + ((192 * 20) / 100) + ")");
        } else {
            System.out.println("El alumno no ha superado la cantidad de faltas indicadas (" + ((192 * 20) / 100) + ")");
        }
    }

}
