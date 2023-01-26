
package e22t4;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rperblac
 */
public class FraccionTest {

    public FraccionTest() {
    }
    
    @Test
    public void testFraccion_int_int() {
        int n = 3, d = 7;
        Fraccion a = new Fraccion(n, d);
        assertEquals(n, a.getNumerador());        
        assertEquals(d, a.getDenominador());
    }

    @Test
    public void testGetNumerador() {
        int n = 3, d = 7;
        Fraccion a = new Fraccion(n, d);
        assertEquals(n, a.getNumerador());
    }

    @Test
    public void testGetDenominador() {
        int n = 3, d = 7;
        Fraccion a = new Fraccion(n, d);
        assertEquals(d, a.getDenominador());
    }

    @Test
    public void testGetValorReal() {
        int n = 3, d = 7;
        Fraccion a = new Fraccion(n, d);
        assertEquals((double) n/d, a.getValorReal(), 0);
    }

    @Test
    public void testGetInversa() {
        int n = 3, d = 7;
        Fraccion a = new Fraccion(n, d);
        assertEquals(n, a.getInversa().getDenominador());
        assertEquals(d,a.getInversa().getNumerador());
    }

    @Test
    public void testSumar() {
        int n1 = 3, d1 = 7, n2 = 5, d2 = 2, ns = 41, ds = 14;
        Fraccion a = new Fraccion(n1, d1);
        Fraccion b = new Fraccion(n2, d2);        
        assertEquals(ns, Fraccion.sumar(a, b).getNumerador());
        assertEquals(ds, Fraccion.sumar(a, b).getDenominador());
    }

    @Test
    public void testMultiplicar() {
        int n1 = 3, d1 = 7, n2 = 5, d2 = 2, nm = 15, dm = 14;
        Fraccion a = new Fraccion(n1, d1);
        Fraccion b = new Fraccion(n2, d2);        
        assertEquals(nm, Fraccion.multiplicar(a, b).getNumerador());
        assertEquals(dm, Fraccion.multiplicar(a, b).getDenominador());
    }

    @Test
    public void testDividir() {
        int n1 = 3, d1 = 7, n2 = 5, d2 = 2, nd = 6, dd = 35;
        Fraccion a = new Fraccion(n1, d1);
        Fraccion b = new Fraccion(n2, d2);        
        assertEquals(nd, Fraccion.dividir(a, b).getNumerador());
        assertEquals(dd, Fraccion.dividir(a, b).getDenominador());
    }

}