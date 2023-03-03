
package futbol;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests de la clase EmpleadoPrimable
 * @author rperblac
 */
public class EmpleadoPrimableTest {
    
    String n = "Luis";
    double s = 1400;
    EmpleadoPrimable ep = new EmpleadoPrimable(n, s);

    public EmpleadoPrimableTest() {
    }
    
    @Test
    public void testEmpleadoPrimable_String_double() {
        assertEquals("futbol.EmpleadoPrimable", ep.getClass().getName());
    }

    @Test
    public void testPrimar() {
        assertFalse(ep.esPrimado());
        ep.primar();
        assertTrue(ep.esPrimado());
    }

    @Test
    public void testEsPrimado() {
        String n2 = "Juan";
        double s2 = 1400;
        EmpleadoPrimable ep2 = new EmpleadoPrimable(n2, s2);
        assertFalse(ep2.esPrimado());
        ep2.primar();
        assertTrue(ep2.esPrimado());
    }

}