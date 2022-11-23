package e40t2;

/** Enunciado: Consulta el pdf de la “Librería Estándar de Java” y busca la clase Runtime. Haz un programa que muestre por pantalla el número de procesadores de tu ordenador y la cantidad de memoria total asociada al proceso de Java por el sistema operativo.
 *
 * @author rperblac
 */
import java.lang.Runtime;
import static java.lang.System.out;

public class E40t2 {

    public static void main(String[] args) {
        out.print("Nº de procesadores: ");
        int procesadores = Runtime.getRuntime().availableProcessors();
        out.println(procesadores);
        
        out.print("Memoria utilizada por el proceso: ");
        long memoria;
        memoria = Runtime.getRuntime().totalMemory(); //da la memoria en bytes
        float memoriakb = memoria / 1024;
        float memoriamb = memoriakb / 1024;
        out.println(memoriamb + " MB");
    }
    
}
