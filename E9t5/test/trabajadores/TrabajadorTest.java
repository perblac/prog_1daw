
package trabajadores;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests de la clase Trabajador
 * @author rperblac
 */
public class TrabajadorTest {
    
    String nombre = "Paco";
    int sueldo = 1000;
    int numDNI = 12345678;
    char letraDNI = 'Z';
    Trabajador t = new Trabajador(nombre, sueldo, numDNI, letraDNI);

    public TrabajadorTest() {
    }
    
    @Test
    public void testTrabajador_String_int_int_char() {
        assertEquals("trabajadores.Trabajador", t.getClass().getName());
    }

    @Test
    public void testGetSueldo() {
        assertEquals(sueldo, t.getSueldo());
    }

    @Test
    public void testGetNombre() {
        assertEquals(nombre, t.getNombre());
    }

    @Test
    public void testGetDNI() {
        String dni = "" + numDNI + letraDNI;
        assertEquals(dni, t.getDNI());
    }

}