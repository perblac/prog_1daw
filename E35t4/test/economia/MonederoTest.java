

package economia;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rperblac
 */
public class MonederoTest {

    public MonederoTest() {
    }
    
    @Test
    public void testMonedero() {
        Monedero m = new Monedero();
        assertEquals("economia.Monedero", m.getClass().getName());
    }

    @Test
    public void testGetDineroTotal() {
        double cant = 500;
        Monedero m = new Monedero();
        m.añadirDinero((int) cant);
        assertEquals(cant, m.getDineroTotal(), 0);
    }

    @Test
    public void testAñadirDinero() {
        double cant = 500;
        Monedero m = new Monedero();
        assertTrue(m.añadirDinero((int) cant));
        cant = 1000;
        assertTrue(!(m.añadirDinero((int) cant)));
    }

    @Test
    public void testRetirarDinero() {
        double cant = 500;
        Monedero m = new Monedero();
        assertEquals(false, m.retirarDinero((int) cant));
        m.añadirDinero((int) cant);
        assertTrue(m.retirarDinero((int) cant));
    }

}