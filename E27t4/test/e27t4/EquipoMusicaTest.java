
package e27t4;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rperblac
 */
public class EquipoMusicaTest {

    public EquipoMusicaTest() {
    }
    
    @Test
    public void testEquipoMusica_int() {
        EquipoMusica e = new EquipoMusica(0);
        assertEquals("e27t4.EquipoMusica", e.getClass().getName());
    }

    @Test
    public void testGetAltavoz() {
        EquipoMusica e = new EquipoMusica(1);
        Altavoz a = e.getAltavoz(0);
        assertEquals(a, e.getAltavoz(0));
    }

    @Test
    public void testSetVolumen() {
        int vol = 125;
        EquipoMusica e = new EquipoMusica(1);
        e.setVolumen(0, vol);
        assertEquals(vol, e.getAltavoz(0).getVolumen());
    }

}