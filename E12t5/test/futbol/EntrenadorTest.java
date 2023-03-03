
package futbol;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test de la clase Entrenador
 * @author rperblac
 */
public class EntrenadorTest {
    
    String n = "Andres";
    double s = 1400;
    Entrenador e = new Entrenador(n, s);

    public EntrenadorTest() {
    }

    @Test
    public void testEntrenador_String_double() {
        assertEquals("futbol.Entrenador", e.getClass().getName());
    }

}