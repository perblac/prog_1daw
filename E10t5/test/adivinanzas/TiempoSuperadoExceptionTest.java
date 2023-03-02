
package adivinanzas;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test de la clase TiempoSuperadoException
 * @author rperblac
 */
public class TiempoSuperadoExceptionTest {

    public TiempoSuperadoExceptionTest() {
    }

    @Test
    public void testTiempoSuperadoException() throws TiempoSuperadoException{
        String mensaje = "Se superaron los 30 segundos";
        String retorno = "";
        try
        {
            throw new TiempoSuperadoException();
        } catch (TiempoSuperadoException tse)
        {
            retorno = tse.getMessage();
        }
        finally
        {
            System.out.println(retorno);
            assertEquals(mensaje, retorno);
        }
    }
}