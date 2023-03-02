
package adivinanzas;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test de la clase AdivinanzaIncorrectaException
 * @author rperblac
 */
public class AdivinanzaIncorrectaExceptionTest {

    public AdivinanzaIncorrectaExceptionTest() {
    }

    @Test
    public void testAdivinanzaIncorrectaException() throws AdivinanzaIncorrectaException{
        String mensaje = "La respuesta a la adivinanza es incorrecta";
        String retorno = "";
        try
        {
            throw new AdivinanzaIncorrectaException();
        } catch (AdivinanzaIncorrectaException aie)
        {
            retorno = aie.getMessage();
        }
        finally
        {
            System.out.println(retorno);
            assertEquals(mensaje, retorno);
        }
    }
}