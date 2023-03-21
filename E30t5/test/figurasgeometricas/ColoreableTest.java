
package figurasgeometricas;

import java.awt.Color;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test de la interfaz Coloreable
 * @author rperblac
 */
public class ColoreableTest {

    public ColoreableTest() {
    }

    @Test
    public void testGetColor() {
        Color c = Color.black;
        ColoreableImpl ci = new ColoreableImpl();
        assertEquals(c, ci.getColor());
    }

    public class ColoreableImpl implements Coloreable {
        private Color c = Color.black;
        public Color getColor() {
            return this.c;
        }
    }

}