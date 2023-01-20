
package daw.persona;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rperblac
 */
public class CuentaCorrienteTest {

    public CuentaCorrienteTest() {
    }
    
    @Test
    public void testCuentaCorriente() {
        CuentaCorriente c = new CuentaCorriente();
        assertEquals(0, c.saldo);
    }
    @Test
    public void testCuentaCorriente_int() {
        CuentaCorriente c = new CuentaCorriente(1234);
        assertEquals(0, c.saldo);
        assertEquals(1234, c.número);
    }
    @Test
    public void testCuentaCorriente_int_double() {
        CuentaCorriente c = new CuentaCorriente(1234,1000);
        assertEquals(1000, c.saldo);
        assertEquals(1234, c.número);
    }
    
    @Test
    public void testAñadirDinero() {
        CuentaCorriente c = new CuentaCorriente(1234,1000);
        c.añadirDinero(100);
        assertEquals(1100, c.saldo);
        c.añadirDinero(-100);
        assertEquals(1200, c.saldo);
    }

    @Test
    public void testRetirarDinero() {
        CuentaCorriente c = new CuentaCorriente(1234,1000);
        c.retirarDinero(100);
        assertEquals(900, c.saldo);
        c.retirarDinero(900);
        assertEquals(0,c.saldo);
        c.retirarDinero(100);
        assertEquals(0,c.saldo);
        c.añadirDinero(100);
        c.retirarDinero(200);
        assertEquals(0,c.saldo);
        
    }

}