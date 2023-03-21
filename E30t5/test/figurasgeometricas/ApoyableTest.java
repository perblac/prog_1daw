
package figurasgeometricas;

import java.awt.Color;
import java.awt.Graphics;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests de la interfaz Apoyable
 * @author rperblac
 */
public class ApoyableTest {
    ApoyableImpl ai = new ApoyableImpl();

    public ApoyableTest() {
    }

    @Test
    public void testGetLongitudBase() {
        assertEquals(ai.base, ai.getLongitudBase());
    }

    @Test
    public void testGetLongitudAltura() {
        assertEquals(ai.altura, ai.getLongitudAltura());
    }

    @Test
    public void testEsHorizontal() {
        assertTrue(ai.esHorizontal());
    }

    @Test
    public void testEsVertical() {
        assertFalse(ai.esVertical());
    }

    public class ApoyableImpl implements Apoyable {
        int base = 10;
        int altura = 5;

        public int getLongitudBase() {
            return this.base;
        }

        public int getLongitudAltura() {
            return this.altura;
        }

        @Override
        public double getArea() {
            return (double) this.base * this.altura;
        }

        @Override
        public int getPerimetro() {
            return this.base * 2 + this.altura * 2;
        }

        @Override
        public void dibujar(Graphics g) {
            
        }

        @Override
        public Color getColor() {
            return Color.black;
        }
    }

}