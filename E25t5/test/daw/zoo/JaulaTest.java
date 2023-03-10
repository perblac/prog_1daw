
package daw.zoo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests de la clase Jaula
 * @author rperblac
 */
public class JaulaTest {
    int cm = 2;
    int pm =190;
    Jaula j = new Jaula(cm, pm);
    String nombreL = "Leo";
    int pesoL = 100;
    Leon l = new Leon(nombreL, pesoL);
    String nombreT = "Tony";
    int pesoT = 90;
    Tigre t = new Tigre(nombreT, pesoT);

    public JaulaTest() {
    }

    @Test
    public void testGetCapacidadMaxima() {
        assertEquals(cm, j.getCapacidadMaxima());
    }

    @Test
    public void testGetPesoMaximo() {
        assertEquals(pm, j.getPesoMaximo());
    }

    @Test
    public void testComprobarDisponibilidadPlaza() {
        assertTrue(j.comprobarDisponibilidadPlaza(l));
        j.añadir(l);
        assertTrue(j.comprobarDisponibilidadPlaza(t));
        j.añadir(t);
        assertFalse(j.comprobarDisponibilidadPlaza(l));        
    }

    @Test
    public void testAñadir() {
        assertTrue(j.añadir(l));
        assertFalse(j.añadir(l));
        assertEquals(1, j.getNumeroAnimales());
    }

}