package e27t3;

/** Enunciado: Un profesor hace diez exámenes y calcula la nota de la asignatura haciendo la
nota media, pero si alguna de las notas es suspenso, entonces la calificación de la asignatura es
suspenso. Realiza un programa que pida una por una las notas y muestre al final la nota de la
asignatura. El programa deberá detenerse si alguno de los exámenes está suspenso.
 *
 * @author rperblac
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class E27t3 {

    public static void main(String[] args) {
        float[] notas = new float[10];
        boolean bien, salir, hacermedia = true;
        float numero = -1, media;
        System.out.println("Introduzca notas: ");
        int i = 1;
        do
        {
            salir = false;
            do
            {
                bien = false;
                try
                {
                    System.out.print(i+": ");
                    numero = new Scanner(System.in).nextFloat();
                    if ((numero<0)||(numero>10))
                    {
                        System.out.println("El rango de nota es (0-10)");
                        bien=false;
                    }
                    else bien = true;
                } catch (InputMismatchException ime)
                {
                    System.out.println("Por favor, introduzca valores numéricos");
                    bien = false;
                }

            } while (!bien);
            notas[i - 1] = numero;
            if (i==10) salir = true;
            else
                if (numero==0)
                {
                    System.out.println("Una nota es igual a 0. El alumno está suspenso");
                    salir = true;
                    hacermedia = false;                 
                }
                else i++;
        } while (!salir);
        if (hacermedia)
        {
            media = (notas[0]+notas[1]+notas[2]+notas[3]+notas[4]+notas[5]+notas[6]+notas[7]+notas[8]+notas[9])/10;
            System.out.printf("\nMedia: %.2f", media);
            System.out.println();
        }
    }
    
}
