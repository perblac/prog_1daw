
package altavoz;

/**
 * Representa un altavoz
 * @author rperblac
 */

public class Altavoz {
    /**
     * Indica el valor máximo que puede tener cualquier altavoz.
     */
    public static final int VOL_MAX = 255;
    
    /**
     * Indica el valor mínimo que puede tener cualquier altavoz.
     */
    public static final int VOL_MIN = 0;
    
    /**
     * Indica el volumen del altavoz.
     */
    private int volumen;
    
    /**
     * Crea un altavoz apagado (su volumen es 0).
     */
    public Altavoz() {
        volumen = 0;
    }
    
    /**
     * Pone el altavoz al máximo de su volumen.
     */
    public void ponerVolumenMaximo() {
        this.volumen = VOL_MAX;        
    }
    
    /**
     * Pone el altavoz al nivel pasado como parámetro.
     * @param v nuevo volumen del altavoz
     */
    public void setVolumen(int v) {
        if (v < 0) {
            this.volumen = 0;
        } else {
            this.volumen = v;
        }
        if (v > VOL_MAX)
            this.volumen = VOL_MAX;
    }
    
    /**
     * Devuelve el volumen del altavoz.
     * @return volumen del altavoz
     */
    public int getVolumen() {
        return this.volumen;
    }
    
    /**
     * Devuelve un String con este formato: entre corchetes se ve el volumen, y luego se ve una barra formada por un total de 10 asteriscos y guiones que indican de forma gráfica el tanto por ciento del volumen del altavoz sobre su máximo.
     * @return una cadena representando el volumen
     */
    public String toString() {
        String v = "[" + this.volumen + "]";
        int asteriscos = Math.round((float) (this.volumen * 10.0) / VOL_MAX);
        return new StringBuilder(v).append("**********", 0, asteriscos).append("----------", 0, (10-asteriscos)).toString();
    }
}
