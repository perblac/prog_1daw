
import java.awt.Toolkit;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rperblac
 */
public class PuntoTest {

    public PuntoTest() {
    }

    @Test
    public void testPunto() {
        Punto p1 = new Punto();
        assertEquals(0, p1.x);
        assertEquals(0, p1.y);
    }
    
    @Test
    public void testPunto_int_int() {
        Punto p2a = new Punto(100, 200);
        Punto p2b = new Punto(100, 2000);
        assertEquals(100, p2a.x);
        assertEquals(200, p2a.y);
        assertEquals(Toolkit.getDefaultToolkit().getScreenSize().width, p2b.x);
        assertEquals(Toolkit.getDefaultToolkit().getScreenSize().height, p2b.y);
    }
    
    @Test
    public void testPunto_Punto() {
        Punto p2a = new Punto(100, 200);
        Punto p3 = new Punto(p2a);
        assertEquals(50, p3.x);
        assertEquals(100, p3.y);
    }
    
    @Test
    public void testPunto_double_double() {
        double angulo = 30;
        double distancia = 100;
        Punto p4 = new Punto(angulo, distancia);
        assertEquals(87, p4.x);
        assertEquals(50, p4.y);
    }
    

}