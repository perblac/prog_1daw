
package daw.zoo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests de la clase ContenedorAnimales
 * @author rperblac
 */
public class ContenedorAnimalesTest {
    int max = 2;
    ContenedorAnimalesImpl cai = new ContenedorAnimalesImpl(max);
    String nombreL = "Leo";
    int pesoL = 100;
    Leon l = new Leon(nombreL, pesoL);
    String nombreT = "Tony";
    int pesoT = 90;
    Tigre t = new Tigre(nombreT, pesoT);
    
    public ContenedorAnimalesTest() {
    }

    @Test
    public void testAñadir() {
        boolean sepuede;
        sepuede = cai.añadir(l);
        assertTrue(sepuede);
        sepuede = cai.añadir(t);
        assertTrue(sepuede);
        sepuede = cai.añadir(l);
        assertFalse(sepuede);
    }

    @Test
    public void testRetirar() {
        boolean sepuede;
        cai.añadir(l);
        sepuede = cai.retirar(t);
        assertFalse(sepuede);
        sepuede = cai.retirar(l);
        assertTrue(sepuede);
    }

    @Test
    public void testGetPesoActual() {
        int pesoTotal = pesoL + pesoT;
        cai.añadir(l);
        cai.añadir(t);
        assertEquals(pesoTotal, cai.getPesoActual());
    }

    @Test
    public void testGetNumeroAnimales() {
        int animales = 2;
        cai.añadir(l);
        cai.añadir(t);
        assertEquals(animales, cai.getNumeroAnimales());
    }

    @Test
    public void testComprobarDisponibilidad() {
        cai.añadir(l);
        assertTrue(cai.comprobarDisponibilidadPlaza());
        cai.añadir(t);
        assertFalse(cai.comprobarDisponibilidadPlaza());
    }

    public class ContenedorAnimalesImpl extends ContenedorAnimales {
        int maxanimales;
        public ContenedorAnimalesImpl(int m) {
            super();
            this.maxanimales = m;
        }
        public boolean comprobarDisponibilidadPlaza() {
            boolean r = (this.getNumeroAnimales() < this.maxanimales);
            return r;
        }
    }

}