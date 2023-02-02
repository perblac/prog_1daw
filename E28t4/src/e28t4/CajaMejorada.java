
package e28t4;

import java.util.Optional;

/**
 * Caja que usa Optional&lt;String&gt; para guardar su mensaje.
 * @author rperblac
 */
public class CajaMejorada {
    private String mensaje;
    private boolean abierta;
    /**
     * Crea una caja cerrada con un mensaje dentro. Si el mensaje que se pasa como parámetro es null se lanzará una IllegalArgumentExcepcion.
     * @param m mensaje de la caja
     * @throws IllegalArgumentException cuando el parametro es null
     */
    public CajaMejorada(String m) throws IllegalArgumentException {
        if (m == null) throw new IllegalArgumentException("El mensaje es nulo");
        abierta = false;
        mensaje = m;
    }
    
    /**
     * Abre la caja
     * @return true si estaba cerrada
     */
    public boolean abrir() {
        boolean ret = (!this.abierta);
        this.abierta = true;
        return ret;
    }
    
    /**
     * Cierra la caja
     * @return true si estaba abierta
     */
    public boolean cerrar() {
        boolean ret = (this.abierta);
        this.abierta = false;
        return ret;
    }
    
    /**
     * Devuelve el mensaje de la caja
     * @return si la caja está abierta, devuelve un Optional&lt;String&gt; rellenado con el mensaje que hay en la caja. Si la caja está cerrada, devuelve un Optional&lt;String&gt; vacío
     */
    public Optional<String> getMensaje() {
        Optional<String> o;
        o = (this.abierta)?Optional.of(this.mensaje):Optional.empty();
        return o;
    }
}
