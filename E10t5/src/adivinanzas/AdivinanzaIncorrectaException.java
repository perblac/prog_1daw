
package adivinanzas;

/**
 * Excepción que se lanza cuando la respuesta a la adivinanza es incorrecta.
 * @author rperblac
 */
public class AdivinanzaIncorrectaException extends AdivinanzaException{
    /**
     * Crea una AdivinanzaIncorrectaException
     */
    public AdivinanzaIncorrectaException() {
        super("La respuesta a la adivinanza es incorrecta");        
    }
}
