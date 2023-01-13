package daw.persona;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rperblac
 */
public class DNITest {
    
    public DNITest() {
    }

    @Test
    public void testDNI_int_char() {
        DNI dni = new DNI(12345678,'A');
        assertEquals(12345678,dni.numero);
        assertEquals('A',dni.letra);
        assertNotNull(dni);
    }

    @Test
    public void testDNI_String() {
        DNI dni = new DNI("12345678A");
        assertEquals(12345678,dni.numero);
        assertEquals('A',dni.letra);
        assertNotNull(dni);
    }
    
}
