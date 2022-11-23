package e42t2;

/** Enunciado: Realiza un programa que genere un número aleatorio comprendido entre 29 y 65 y lo muestre por pantalla. Nota: Hay dos formas posibles de hacerlo: con la clase Math y con la clase Random de la “Librería Estándar de Java”. Mira las dos y elige la que te resulte más fácil.
 *
 * @author rperblac
 */
import java.lang.Math;
import java.util.Random;

public class E42t2 {

    public static void main(String[] args) {
        int minimo = 29, maximo = 65;
        int numero1 = ((int) (Math.random() * (maximo - minimo + 1))) + minimo;
        Random aleatorio = new Random();
        int numero2 = aleatorio.nextInt((maximo - minimo + 1)) + minimo;
        System.out.println("Aleatorio entre " + minimo + " y " + maximo + "\nCon Math: " + numero1 + "\nCon Random: " + numero2);
    }
    
}
