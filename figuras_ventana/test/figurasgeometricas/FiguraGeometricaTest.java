
package figurasgeometricas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests de la interfaz FiguraGeometrica
 * @author rperblac
 */
public class FiguraGeometricaTest {
    FiguraGeometricaImpl fgi = new FiguraGeometricaImpl();
    
    public FiguraGeometricaTest() {
    }

    @Test
    public void testGetArea() {
        assertEquals(fgi.area, fgi.getArea(), 0);
    }

    @Test
    public void testGetPerimetro() {
        assertEquals(fgi.perimetro, fgi.getPerimetro());
    }

    @Test
    public void testDibujar() {
    }

    @Test
    public void testCrearCuadradoIgualArea() {
        double lado = Math.sqrt(fgi.getArea());
        Point esquina = new Point(0,0);
        Cuadrado a = new Cuadrado(esquina, (int) Math.round(lado), Color.black);
        Cuadrado b = fgi.crearCuadradoIgualArea(esquina);
        assertEquals(a.getPerimetro(),b.getPerimetro());
    }

    public class FiguraGeometricaImpl implements FiguraGeometrica {
        public double area = 3;
        public int perimetro = 5;
        
        public double getArea() {
            return this.area;
        }

        public int getPerimetro() {
            return this.perimetro;
        }

        public void dibujar(Graphics g) {
        }

        @Override
        public Color getColor() {
            return null;
        }
    }

}