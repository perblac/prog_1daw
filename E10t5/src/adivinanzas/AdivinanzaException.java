
package adivinanzas;

/**
 * Excepción especial para la clase Adivinanza.
 * @author rperblac
 */
public class AdivinanzaException extends Exception{
    /**
     * Crea una AdivinanzaException con un mensaje de error
     * @param mensaje mensaje de la excepción
     */
    public AdivinanzaException(String mensaje) {
        super(mensaje);
    }
}
