/**Enunciado: : Repite el ejercicio 8, pero haciendo que el usuario introduzca por teclado los datos que aparecen subrayados.
 *
 * @author rperblac
 */
import java.util.Scanner;

public class E10t1 {
    public static void main(String[] args) {
        String nombreDia, mes, curso, centro, ciudad, hora;
        int dia,nivel;
        System.out.println("INTRODUCCIÓN DE DATOS\n----------------------\n");
        System.out.println("Nombre del día? ");
        nombreDia = new Scanner(System.in).nextLine();
        System.out.println("Número del día? ");
        dia = new Scanner(System.in).nextInt();
        System.out.println("Nombre del mes? ");
        mes = new Scanner(System.in).nextLine();
        System.out.println("Nivel del curso? ");
        nivel = new Scanner(System.in).nextInt();
        System.out.println("Nombre del curso? ");
        curso = new Scanner(System.in).nextLine();
        System.out.println("Nombre del centro? ");
        centro = new Scanner(System.in).nextLine();
        System.out.println("Ciudad? ");
        ciudad = new Scanner(System.in).nextLine();
        System.out.println("Hora de publicación? ");
        hora = new Scanner(System.in).nextLine();
        System.out.println("El "+nombreDia+" día "+dia+" de "+mes+" tendrá lugar la reunión de evaluación del "+nivel+"º curso de "+curso+" en el "+centro+" de "+ciudad+". Los profesores calificarán al alumnado y se prevé que a las "+hora+" horas las notas estén publicadas en el tablón de anuncios del centro.");
    }
}
