/**Enunciado:  Haz un programa que pregunte al usuario tres números enteros y guárdalos en variables llamadas horas, minutos y segundos. El programa mostrará el número total de segundos que hay juntando las cantidades de tiempo expresadas en las tres variables.
 *
 * @author rperblac
 */
import java.util.Scanner;

public class E13t1 {

    public static void main(String args[]) {
        int horas, minutos, segundos;
        System.out.print("Horas? ");
        horas = new Scanner(System.in).nextInt();
        System.out.print("Minutos? ");
        minutos = new Scanner(System.in).nextInt();
        System.out.print("Segundos? ");
        segundos = new Scanner(System.in).nextInt();
        System.out.println("\n" + horas + " horas, " + minutos + " minutos y " + segundos + " segundos son un total de " + ((horas * 3600) + (minutos * 60) + segundos) + " segundos");
    }
}
