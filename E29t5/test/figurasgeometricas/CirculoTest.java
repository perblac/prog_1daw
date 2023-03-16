
package figurasgeometricas;

import java.awt.Color;
import java.awt.Point;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests de la clase Circulo
 * @author rperblac
 */
public class CirculoTest {
    Point centro = new Point(0,0);
    int radio = 10;
    Color color = Color.gray;
    double area = Math.PI * (Math.pow(radio, 2));
    int perimetro = (int) Math.round(2 * Math.PI * this.radio);
    Circulo c = new Circulo(centro, radio, color);

    public CirculoTest() {
    }

    @Test
    public void testGetArea() {
        assertEquals(area, c.getArea(), 0);
    }

    @Test
    public void testGetPerimetro() {
        assertEquals(perimetro, c.getPerimetro());
    }

    @Test
    public void testDibujar() {
    }

    @Test
    public void testCrearCuadradoIgualArea() {
        double lado = Math.sqrt(area);
        Point esquina = new Point(0,0);
        Cuadrado cuad = new Cuadrado(esquina, (int) Math.round(lado), color);
        assertEquals(cuad.getLongitudAltura(), c.crearCuadradoIgualArea(esquina).getLongitudAltura());
        assertEquals(cuad.getLongitudBase() , c.crearCuadradoIgualArea(esquina).getLongitudBase());
        assertEquals(cuad.getPerimetro() , c.crearCuadradoIgualArea(esquina).getPerimetro());
        assertEquals(cuad.getArea() , c.crearCuadradoIgualArea(esquina).getArea(), 0);
    }

    @Test
    public void testGetCentro() {
        assertEquals(centro, c.getCentro());
    }

    @Test
    public void testGetColor() {
        assertEquals(color, c.getColor());
    }

}