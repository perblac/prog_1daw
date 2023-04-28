
package figurasgeometricas;

import java.awt.Point;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test de la interfaz Centrable
 * @author rperblac
 */
public class CentrableTest {
    CentrableImpl ci = new CentrableImpl();

    public CentrableTest() {
    }

    @Test
    public void testGetCentro() {
        assertEquals(ci.centro, ci.getCentro());
    }

    public class CentrableImpl implements Centrable {
        Point centro = new Point(100,100);
        public Point getCentro() {
            return this.centro;
        }
    }

}