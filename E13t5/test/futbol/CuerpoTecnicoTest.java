
package futbol;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests de la clase CuerpoTecnico
 * @author rperblac
 */
public class CuerpoTecnicoTest {
    String n = "Pepe";
    double s = 1400;
    String puesto = "Entrenador";
    CuerpoTecnico ct = new CuerpoTecnico (n, s, puesto);

    public CuerpoTecnicoTest() {
    }
    
    @Test
    public void testCuerpoTecnico_String_double_String() {
        assertEquals("futbol.CuerpoTecnico", ct.getClass().getName());
    }
    
    @Test
    public void testGetPuesto() {
        assertEquals(puesto, ct.getPuesto());
    }

}