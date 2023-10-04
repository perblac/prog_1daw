
package Loteria;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rperblac
 */
public class BolaTest {

    public BolaTest() {
    }
    
    @Test
    public void testBola_int() {
        int num = 1;
        Bola a = new Bola(num);
        assertEquals("Loteria.Bola", a.getClass().getName());
    }

    @Test
    public void testGetNumero() {
        int num = 1;
        Bola a = new Bola(num);
        assertEquals(num, a.getNumero());
    }

}