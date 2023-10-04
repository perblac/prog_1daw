
package e3t4;

import java.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rperblac
 */
public class MarcadorBaloncestoTest {

    public MarcadorBaloncestoTest() {
    }

    @Test
    public void testMarcadorBaloncesto_String_String() {
        MarcadorBaloncesto a = new MarcadorBaloncesto("Estudiantes", "CB Granada");
        assertEquals("Estudiantes", a.nombreLocal);
        assertEquals("CB Granada", a.nombreVisitante);
        assertEquals(0, a.puntosLocal);
        assertEquals(0,a.puntosVisitante);
        assertEquals(LocalDate.now(), a.fecha);               
    }

    @Test
    public void testMarcadorBaloncesto_3args() {
        LocalDate fecha = LocalDate.of(2000, 1, 1);
        MarcadorBaloncesto b = new MarcadorBaloncesto("Estudiantes", "CB Granada", fecha);
        assertEquals("Estudiantes", b.nombreLocal);
        assertEquals("CB Granada", b.nombreVisitante);
        assertEquals(0, b.puntosLocal);
        assertEquals(0,b.puntosVisitante);
        assertEquals(fecha, b.fecha);    
    }

}