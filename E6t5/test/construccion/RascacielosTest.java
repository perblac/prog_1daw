
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
            if (iae.getMessage().contains("La altura debe ser positiva")) {
                System.out.println("Se lanzó la excepción con éxito: " + iae.getMessage());                
            } else {
                fail("La excepción lanzada no era la esperada");
            }
        }      
    }
    
    @Test
    public void testRascacielos_String_int() {
        String dir = "calle a nº 1";
        int np = 10;
        Rascacielos r = new Rascacielos(dir, np);
        assertEquals("construccion.Rascacielos", r.getClass().getName());
    }

    @Test
    public void testGetAltura() {
        String dir = "calle a nº 1";
        int np = 10;
        int a = 100;
        Rascacielos r = new Rascacielos(dir, np, a);
        assertEquals(a, r.getAltura());
    }
    
    @Test
    public void testGetAltura2() {
        String dir = "calle a nº 1";
        int np = 10;
        Rascacielos r = new Rascacielos(dir, np);
        assertEquals(10 + (np * 3), r.getAltura());
    }

}