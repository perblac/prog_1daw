
package economia;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rperblac
 */
public class BancoTest {

    public BancoTest() {
    }
    
    @Test
    public void testBanco() {
        Banco b = new Banco();
        assertEquals("economia.Banco", b.getClass().getName());
    }

    @Test
    public void testGetDineroTotal() {
        double cant = 500;
        Banco b = new Banco();
        b.añadirDinero((int) cant);
        assertEquals(cant, b.getDineroTotal(), 0);
    }

    @Test
    public void testAñadirDinero() {
        double cant = 500;
        Banco b = new Banco();
        assertTrue(b.añadirDinero((int) cant));
        cant = -100;
        assertTrue(!(b.añadirDinero((int) cant)));
    }

    @Test
    public void testRetirarDinero() {
        double cant = 500;
        Banco b = new Banco();
        assertEquals(false, b.retirarDinero((int) cant));
        b.añadirDinero((int) cant);
        assertTrue(b.retirarDinero((int) cant));
    }

}