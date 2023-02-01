
package e26t4;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rperblac
 */
public class AltavozTest {

    public AltavozTest() {
    }
    
    @Test
    public void testAltavoz() {
        Altavoz a = new Altavoz();
        assertEquals("e26t4.Altavoz",a.getClass().getName());
    }

    @Test
    public void testPonerVolumenMaximo() {
        Altavoz a = new Altavoz();
        a.ponerVolumenMaximo();
        assertEquals(255,a.getVolumen());
    }

    @Test
    public void testSetVolumen() {
        Altavoz a = new Altavoz();
        int v = 125;
        a.setVolumen(v);
        assertEquals(v, a.getVolumen());
    }

    @Test
    public void testGetVolumen() {
        Altavoz a = new Altavoz();
        assertEquals(0,a.getVolumen());
    }

    @Test
    public void testToString() {
        Altavoz a = new Altavoz();
        int v = 125;
        a.setVolumen(v);
        String cadena = "[125]****------";
        assertEquals(cadena,a.toString());
    }

}