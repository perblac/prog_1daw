package e26t2;

/**Enunciado: Consulta el pdf de la “Librería Estándar de Java” y busca la clase Thread. Realiza un programa que pregunte al usuario “¿cuántos segundos quiere esperar?”. El usuario escribirá un número entero y el programa hará una pausa de dicha cantidad de segundos. Pasado ese tiempo se mostrará el mensaje “Programa finalizado”.
 *
 * @author rperblac
 */
import java.lang.Thread;
import java.util.Scanner;

public class E26t2 {
    public static void main(String[] args) {
        System.out.println("¿Cuántos segundos quiere esperar?");
        int segundos = new Scanner(System.in).nextInt();
        int i;
        long espera = segundos * 1000;
        try
        {
            for (i=0;i<segundos;++i)
            {
                Thread.sleep(espera/segundos);
                System.out.print((i+1)+" ");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
}
