
package futbol;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests de la clase Empleado
 * @author rperblac
 */
public class EmpleadoTest {
    String n = "Paco";
    double s = 1400;
    Empleado e = new Empleado(n, s);

    public EmpleadoTest() {
    }
    
    @Test
    public void testEmpleado_String_double() {
        assertEquals("futbol.Empleado", e.getClass().getName());
    }

    @Test
    public void testGetSueldo() {
        assertEquals(s, e.getSueldo(), 0);
    }

    @Test
    public void testGetDinero() {
        assertEquals(0, e.getDinero(), 0);
    }

    @Test
    public void testCobrar() throws Exception {
        double cobrar = 1000;
        try {
            e.cobrar(cobrar);
            fail("No se lanzó la excepción esperada");
        } catch (CabreoException ex) {
            System.out.println("Se lanzó la excepción esperada: " + ex.getMessage());
            assertEquals(cobrar, e.getDinero(), 0);
        }
    }

}