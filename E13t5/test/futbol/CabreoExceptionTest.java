
package futbol;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test de la clase CabreoException
 * @author rperblac
 */
public class CabreoExceptionTest {

    public CabreoExceptionTest() {
    }

    @Test(expected = futbol.CabreoException.class)
    public void testCabreoException_String() throws CabreoException {
        throw new CabreoException("No se cobró suficiente!");
    }

}