
package futbol;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test de la clase Futbolista
 * @author rperblac
 */
public class FutbolistaTest {
    String n = "Raul";
    double s = 1400;
    int dorsal = 10;
    Futbolista f = new Futbolista(n, s, dorsal);

    public FutbolistaTest() {
    }

    @Test
    public void testFutbolista_String_double_int() {
        assertEquals("futbol.Futbolista", f.getClass().getName());
    }

}