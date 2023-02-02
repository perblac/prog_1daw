
package notas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.OptionalDouble;

/**
 * Un objeto que sirve para registrar las notas que se van sacando en los exámenes y poder hacer algunas estadísticas.
 * @author rperblac
 */
public class Notas {
    /**
     * Lista con las notas.
     */
    private List<Double> notas;
    /**
     * Crea un objeto Notas. Inicializa la propiedad “notas” con un ArrayList&lt;Double&gt;
     */
    public Notas() {
        this.notas = new ArrayList<>();
    }
    /**
     * Añade a la lista de notas la nota que se pasa como parámetro.
     * @param n nueva nota para la lista
     */
    public void añadirNota(double n) {
        this.notas.add(n);
    }
    /**
     * Devuelve la cantidad de notas en el objeto Notas que se pasa como parámetro.
     * @return cantidad de notas en el objeto
     */
    public int getTotalNotas() {
        return this.notas.size();
    }
    /**
     * Devuelve un OptionalDouble rellenado con la nota media de todas las notas que hay en la lista, o un OptionalDouble vacío si no hay notas en la lista.
     * @return media de todas las notas en la lista, vacío si no hay ninguna
     */
    public OptionalDouble calcularNotaMedia() {
        OptionalDouble o;
        Double suma = 0.0;
        for (Double i:notas)
        {
            suma += i;
        }
        o = (suma==0.0)?OptionalDouble.empty():OptionalDouble.of(suma/notas.size());
        return o;
    }
    /**
     * Devuelve un OptionalDouble rellenado con la nota máxima de todas las notas que hay en la lista, o un OptionalDouble vacío si no hay notas en la lista.
     * @return nota máxima en la lista, vacío si no hay ninguna
     */
    public OptionalDouble calcularNotaMaxima() {
        OptionalDouble o = (this.notas.isEmpty())?OptionalDouble.empty():OptionalDouble.of(Collections.max(this.notas));
        return o;
    }
}
