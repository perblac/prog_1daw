
package geometria;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests de la clase Rectángulo
 * @author rperblac
 */
public class RectanguloTest {

    public RectanguloTest() {
    }
    
    @Test
    public void testRectangulo_int_int() {
        int base1 = 2;
        int altura1 = 3;
        int area1 = 6;
        int base2 = -3;
        int area2 = 9;
        int altura2 = 0;
        Rectangulo c1 = null;
        try {
            c1 = new Rectangulo(base1, altura1);
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
            fail("Se lanzó una excepción inesperada");
        }
        assertEquals("geometria.Rectangulo", c1.getClass().getName());
        assertEquals(area1, c1.getArea());
        Rectangulo c2 = null;
        try {
            c2 = new Rectangulo(base2, altura1);
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
            fail("Se lanzó una excepción inesperada");
        }
        assertEquals(area2, c2.getArea());
        try {
            Rectangulo c3 = new Rectangulo(base2, altura2);
            fail("No se lanzó la excepción esperada con altura = 0");
        } catch (Exception ex) {
            System.out.print("Excepción lanzada con éxito: " + ex.getMessage());
        }
        
    }

    @Test
    public void testSetBase() {
        int base1 = 2;
        int altura1 = 3;
        int area1 = 6;
        int base2 = -3;
        int area2 = 9;
        int base3 = 0;
        Rectangulo c1 = null;
        try {
            c1 = new Rectangulo(base1, altura1);
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
            fail("Se lanzó una excepción inesperada");
        }
        assertEquals(base1, c1.getBase());
        try {
            c1.setBase(base2);
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
            fail("Se lanzó una excepción inesperada");
        }
        assertEquals(Math.abs(base2), c1.getBase());
        assertEquals(area2, c1.getArea());
        try {
            c1.setBase(base3);
            fail("No se lanzó la excepción esperada con base = 0");
        } catch (Exception ex) {
            System.out.print("Excepción lanzada con éxito: " + ex.getMessage());
        }        
    }

    @Test
    public void testSetAltura() {
        int base1 = 2;
        int altura1 = 3;
        int area1 = 6;
        int altura2 = -2;
        int area2 = 4;
        int altura3 = 0;
        Rectangulo c1 = null;
        try {
            c1 = new Rectangulo(base1, altura1);
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
            fail("Se lanzó una excepción inesperada");
        }
        assertEquals(altura1, c1.getAltura());
        try {        
            c1.setAltura(altura2);
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
            fail("Se lanzó una excepción inesperada");
        }
        assertEquals(Math.abs(altura2), c1.getAltura());
        try {
            c1.setAltura(altura3);
            fail("No se lanzó la excepción esperada con altura = 0");
        } catch (Exception ex) {
            System.out.print("Excepción lanzada con éxito: " + ex.getMessage());
        }        
    }

    @Test
    public void testGetArea() {
        int base1 = 2;
        int altura1 = 3;
        int area1 = 6;
        Rectangulo c1 = null;
        try {
            c1 = new Rectangulo(base1, altura1);
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
            fail("Se lanzó una excepción inesperada");
        }
        assertEquals(area1, c1.getArea());
    }

    @Test
    public void testGetBase() {
        int base1 = 2;
        int altura1 = 3;
        Rectangulo c1 = null;
        try {
            c1 = new Rectangulo(base1, altura1);
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
            fail("Se lanzó una excepción inesperada");
        }
        assertEquals(base1, c1.getBase());
    }

    @Test
    public void testGetAltura() {
        int base1 = 2;
        int altura1 = 3;
        Rectangulo c1 = null;
        try {
            c1 = new Rectangulo(base1, altura1);
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
            fail("Se lanzó una excepción inesperada");
        }
        assertEquals(altura1, c1.getAltura());
    }

}