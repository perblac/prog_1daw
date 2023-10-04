/**Enunciado: : En un colegio por motivos de seguridad los niños no pueden salir solos. La puerta de entrada está programada para abrirse cuando llega un adulto, o cuando llega un niño acompañado por un familiar. Haz un programa que pregunte por teclado si la persona que llega es adulta o no, y si va a compañada o no. Tras recoger estos datos, el programa mostrará por pantalla si la puerta deberá o no abrirse.
 *
 * @author rperblac
 */
import java.util.Scanner;

public class E28t1 {

    public static void main(String[] args) {
        boolean adulto = false, acompañado = false;
        System.out.println("¿Es usted adulto? ");
        String edad = new Scanner(System.in).next();
        if ((edad.equals("si")) || (edad.equals("Si")) || (edad.equals("SI")) || (edad.equals("sí")) || (edad.equals("Sí")) || (edad.equals("SÍ")) || (edad.equals("1"))) {
            adulto = true;
        }
        System.out.println("¿Viene usted acompañado?");
        String comp = new Scanner(System.in).nextLine();
        if ((comp.equals("si")) || (comp.equals("Si")) || (comp.equals("SI")) || (comp.equals("sí")) || (comp.equals("Sí")) || (comp.equals("SÍ")) || (comp.equals("1"))) {
            acompañado = true;
        }
        if (adulto || acompañado) {
            System.out.println("La puerta se abre");
        } else {
            System.out.println("La puerta permanece cerrada");
        }

    }
}
