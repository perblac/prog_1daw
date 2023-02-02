
package e28t4;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rperblac
 */
public class CajaMejoradaTest {

    public CajaMejoradaTest() {
    }
    
    @Test
    public void testCajaMejorada_String() {
        String m = "mensaje";
        CajaMejorada c = new CajaMejorada(m);
        assertEquals("e28t4.CajaMejorada", c.getClass().getName());
    }
    
    @Test(expected=java.lang.IllegalArgumentException.class)
    public void testCajaMejorada_String_Exception() throws IllegalArgumentException{
        String m = null;
        CajaMejorada c = new CajaMejorada(m);
        fail("No se lanzó la excepción esperada");
    }

    @Test
    public void testAbrir() {
        String m = "mensaje";
        CajaMejorada c = new CajaMejorada(m);
        assertTrue(c.abrir());
    }

    @Test
    public void testCerrar() {
        String m = "mensaje";
        CajaMejorada c = new CajaMejorada(m);
        assertFalse(c.cerrar());
    }

    @Test
    public void testGetMensaje() {
        String m = "mensaje";
        CajaMejorada c = new CajaMejorada(m);
        assertEquals("Optional.empty",c.getMensaje().toString());
        c.abrir();
        assertEquals(m, c.getMensaje().get());
    }

}