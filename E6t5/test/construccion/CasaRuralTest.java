
package construccion;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test de la clase CasaRural
 * @author rperblac
 */
public class CasaRuralTest {

    public CasaRuralTest() {
    }

    @Test
    public void testCasaRural_String() {
        String dir = "calle a nº 1";
        CasaRural cr = new CasaRural(dir);
        assertEquals("construccion.CasaRural", cr.getClass().getName());
    }

}