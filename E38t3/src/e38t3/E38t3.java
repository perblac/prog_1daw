package e38t3;

/** Enunciado: Realiza un programa que pida diez notas por teclado y al final muestre su nota
media. Si alguna nota introducida es incorrecta (negativa o superior a 10) el programa la
preguntará nuevamente.
 *
 * @author rperblac
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class E38t3 {
    
    public static void main(String[] args) {
        float[] notas = new float[10];
        boolean bien;
        float numero = -1, media;
        System.out.println("Introduzca notas: ");
        for (int i = 1; i <= 10; i++)
        {
            do
            {                
                try
                {
                    System.out.print(i+": ");
                    numero = new Scanner(System.in).nextFloat();
                    if ((numero<0)||(numero>10))
                    {
                        System.out.println("El rango de nota es valores entre 0 y 10");
                        bien=false;
                    }
                    else bien = true;
                } catch (InputMismatchException ime)
                {
                    System.out.println("Por favor, introduzca valores numéricos");
                    bien = false;
                }
            } while (!bien);
            notas[i-1] = numero;
        }
        media = (notas[0]+notas[1]+notas[2]+notas[3]+notas[4]+notas[5]+notas[6]+notas[7]+notas[8]+notas[9])/10;
        System.out.printf("\nMedia: %.2f", media);
        System.out.println();
        
    }
    
}
