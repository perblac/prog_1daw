
package adivinanzas;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test de la clase AdivinanzaException
 * @author rperc
 */
public class AdivinanzaExceptionTest {

    public AdivinanzaExceptionTest() {
    }

    @Test
    public void testAdivinanzaException() throws AdivinanzaException{
        String mensaje = "Error de adivinanza";
        String retorno = "";
        try
        {
            throw new AdivinanzaException(mensaje);
        } catch (AdivinanzaException ae)
        {
            retorno = ae.getMessage();
        }
        finally
        {
            System.out.println(retorno);
            assertEquals(mensaje, retorno);
        }
    }

}