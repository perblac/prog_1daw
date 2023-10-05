
package figurasgeometricas;

import java.awt.Color;
import java.awt.Point;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests de la clase Rectangulo
 * @author rperblac
 */
public class RectanguloTest {

    Point esi = new Point(100,10);
    Point eid = new Point(160, 30);
    Color color = Color.CYAN;
    Rectangulo r = new Rectangulo(esi, eid, color);
    Point centro = new Point(130,20);
    int base = 60;
    int altura = 20;
    double area = base * altura;
    int perimetro = 2 * base + 2 * altura;
    
    public RectanguloTest() {
    }

    @Test
    public void testGetCentro() {
        assertEquals(centro, r.getCentro());
    }

    @Test
    public void testGetLongitudBase() {
        assertEquals(base, r.getLongitudBase());
    }

    @Test
    public void testGetLongitudAltura() {
        assertEquals(altura, r.getLongitudAltura());
    }

    @Test
    public void testGetArea() {
        assertEquals(area, r.getArea(), 0);
    }

    @Test
    public void testGetPerimetro() {
        assertEquals(perimetro, r.getPerimetro());
    }

    @Test
    public void testGetColor() {
        assertEquals(color,r.getColor());
    }

    @Test
    public void testDibujar() {
    }

}