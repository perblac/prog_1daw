
package adivinanzas;

/**
 * Excepción que se lanza cuando se supera el tiempo para la adivinanza.
 * @author rperblac
 */
public class TiempoSuperadoException extends AdivinanzaException{
    /**
     * Crea una TiempoSuperadoException
     */
    public TiempoSuperadoException() {
        super("Se superaron los 30 segundos");
    }
}
