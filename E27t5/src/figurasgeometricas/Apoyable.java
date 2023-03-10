
package figurasgeometricas;

/**
 * Una figura geométrica que tiene una base y una altura.
 * @author rperblac
 */

public interface Apoyable implements FiguraGeometrica {
    /**
     * Devuelve la longitud de la basa
     * @return longitud de la basa
     */
    public int getLongitudBase();
    
    /**
     * Devuelve la altura
     * @return altura
     */
    public int getLongitudAltura();
    
    /**
     * Devuelve true si la base es mayor que la altura.
     * @return true si es horizontal
     */
    public default boolean esHorizontal() {
        return this.getLongitudBase() > this.getLongitudAltura();
    }
    
    /**
     * Devuelve true si la altura es mayor que la base.
     * @return true si es vertical
     */
    public default boolean esVertical() {
        return this.getLongitudBase() < this.getLongitudAltura();
    }
}
