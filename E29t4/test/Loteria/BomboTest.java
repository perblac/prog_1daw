
package Loteria;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rperblac
 */
public class BomboTest {

    public BomboTest() {
    }
    
    @Test
    public void testBombo_int() {
        int numbolas = 10;
        Bombo b = new Bombo(numbolas);
        assertEquals("Loteria.Bombo", b.getClass().getName());
        assertTrue(!(b.sacarBola().isEmpty()));
    }

    @Test
    public void testGetNumeroBolas() {
        int numbolas = 10;
        Bombo b = new Bombo(numbolas);
        assertEquals(numbolas, b.getNumeroBolas());
    }

    @Test
    public void testSacarBola() {
        int numbolas = 1;
        Bombo b = new Bombo(numbolas);
        assertTrue(!(b.sacarBola().isEmpty()));        
        assertTrue(b.sacarBola().isEmpty());
    }

}