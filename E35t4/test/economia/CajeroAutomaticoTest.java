
package economia;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rperblac
 */
public class CajeroAutomaticoTest {

    public CajeroAutomaticoTest() {
    }
    
    @Test
    public void testCajeroAutomatico() {
        CajeroAutomatico c = new CajeroAutomatico();
        assertEquals("economia.CajeroAutomatico",c.getClass().getName());
    }

    @Test
    public void testGetDineroTotal() {        
        CajeroAutomatico c = new CajeroAutomatico();
        int dinero = 86;
        assertEquals(0, c.getDineroTotal(),0);
        c.añadirDinero(dinero);
        assertEquals(dinero,c.getDineroTotal(),0);
    }

    @Test
    public void testAñadirDinero() {
        CajeroAutomatico c = new CajeroAutomatico();
        int dinero = 86;
        int dinero2 = -86;
        assertEquals(true, c.añadirDinero(dinero));
        assertEquals(false,c.añadirDinero(dinero2));
    }

    @Test
    public void testRetirarDinero() {
        CajeroAutomatico c = new CajeroAutomatico();
        int dinero = 86;
        int dinero2 = 173;
        c.añadirDinero(dinero);
        assertEquals(true, c.retirarDinero(dinero));
        c.añadirDinero(dinero);
        c.añadirDinero(dinero);
        assertEquals(false, c.retirarDinero(dinero2));
        assertEquals(true, c.retirarDinero(dinero));        
    }

    @Test
    public void testGetTotal50() {
        CajeroAutomatico c = new CajeroAutomatico();
        assertEquals(0, c.getTotal50());
        int dinero = 188;
        c.añadirDinero(dinero);
        assertEquals(3, c.getTotal50());
    }

    @Test
    public void testGetTotal20() {
        
        CajeroAutomatico c = new CajeroAutomatico();
        assertEquals(0, c.getTotal20());
        int dinero = 188;
        c.añadirDinero(dinero);
        assertEquals(1, c.getTotal20());
    }

    @Test
    public void testGetTotal10() {        
        CajeroAutomatico c = new CajeroAutomatico();
        assertEquals(0, c.getTotal10());
        int dinero = 188;
        c.añadirDinero(dinero);
        assertEquals(1, c.getTotal10());
    }

    @Test
    public void testGetTotal5() {
        CajeroAutomatico c = new CajeroAutomatico();
        assertEquals(0, c.getTotal5());
        int dinero = 188;
        c.añadirDinero(dinero);
        assertEquals(1, c.getTotal5());
    }

    @Test
    public void testGetTotal1() {
        CajeroAutomatico c = new CajeroAutomatico();
        assertEquals(0, c.getTotal1());
        int dinero = 188;
        c.añadirDinero(dinero);
        assertEquals(3, c.getTotal1());
    }

}