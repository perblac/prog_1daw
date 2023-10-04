package e46t2;

/** Enunciado: Consulta la “Librería estándar de Java” y busca las clases Thread y Random. Haz
un programa que haga una pausa de una cantidad aleatoria de segundos entre 0 y 10.
Consulta ahora el pdf de la librería “java time” y busca las clases Instant y Duration. Obtén un
objeto Instant antes de que empiece la pausa y luego otro objeto Instant cuando la pausa
termine. A partir de dichos dos objetos, obtén un objeto Duration y úsalo para mostrar
cuántos segundos ha durado la pausa.
 *
 * @author rperblac
 */
import java.lang.Thread;
import java.util.Random;
import java.time.Instant;
import java.time.Duration;

public class E46t2 {

    public static void main(String[] args) {
        Random generador = new Random();
        long espera = (long) generador.nextInt(0,10000);
        Instant ahora = Instant.now();
        System.out.println("INICIO PAUSA");
        try
        {
        Thread.sleep(espera);
        } catch (IllegalArgumentException iae)
        {
            System.out.println("Espera negativa\n" + iae);
        } catch (InterruptedException ie)
        {
            System.out.println("La pausa se detuvo\n" + ie);
        }
        Instant luego = Instant.now();
        System.out.println("FIN PAUSA");
        System.out.println("La duración de la pausa fue de " + (Duration.between(ahora, luego).toMillis())/1000.0 + " segundos");
    }
    
}
