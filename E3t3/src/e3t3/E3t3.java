package e3t3;

/** Enunciado: Realiza un programa que genere números enteros aleatorios entre 0 y 10 y los muestre por pantalla. El programa terminará cuando el número generado sea el 10
 *
 * @author rperblac
 */
import java.util.Random;
public class E3t3 {

    public static void main(String[] args) {
        Random aleatorio = new Random();
        int valor;
        do
        {
            valor = aleatorio.nextInt(11);
            System.out.print(valor + " ");
        } while (valor<10);
    }
    
}
