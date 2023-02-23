
package construccion;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests de la clase Rascacielos
 * @author rperblac
 */
public class RascacielosTest {

    public RascacielosTest() {
    }
    
    @Test
    public void testRascacielos_String_int_int() {
        String dir = "calle a nº 1";
        int np = 10;
        int a = 100;
        Rascacielos r = new Rascacielos(dir, np, a);
        assertEquals("construccion.Rascacielos", r.getClass().getName());
        int a0 = 0;
        try
        {
            Rascacielos r0 = new Rascacielos(dir, np, a0);
            fail("No se lanzó la excepción esperada");
        } catch (IllegalArgumentException iae)
        {
            System.out.println("Se lanzó la excepción con éxito: " + iae.getMessage());
        }      
    }

    @Test
    public void testGetAltura() {
        String dir = "calle a nº 1";
        int np = 10;
        int a = 100;
        Rascacielos r = new Rascacielos(dir, np, a);
        assertEquals(a, r.getAltura());
    }

}