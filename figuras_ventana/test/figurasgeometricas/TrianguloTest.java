
package figurasgeometricas;

import java.awt.Color;
import java.awt.Point;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests de la clase Triangulo
 * @author rperblac
 */
public class TrianguloTest {

    Point a = new Point (10,10);
    Point b = new Point (50,10);
    Point c = new Point (10,40);
    Triangulo t = new Triangulo(a, b, c);
    Color color = Color.BLUE;
    int base = 50;
    int altura = 24;
    double area = 600;
    int perimetro = 120;
        
    public TrianguloTest() {
    }

    @Test
    public void testGetLongitudBase() {
        assertEquals(base, t.getLongitudBase());
    }

    @Test
    public void testGetLongitudAltura() {
        assertEquals(altura, t.getLongitudAltura());
    }

    @Test
    public void testGetArea() {
        assertEquals(area, t.getArea(), 0);
    }

    @Test
    public void testGetPerimetro() {
        assertEquals(perimetro, t.getPerimetro());
    }

    @Test
    public void testGetColor() {
        assertEquals(color,t.getColor());
    }
    
    @Test
    public void testDibujar() {
    }

}