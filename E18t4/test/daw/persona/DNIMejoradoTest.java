
package daw.persona;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rperc
 */
public class DNIMejoradoTest {

    public DNIMejoradoTest() {
    }
    
    @Test
    public void testDNUMejorado_int() {        
        int numero = 12345678;
        char letra = 'Z';
        DNIMejorado dni = new DNIMejorado(numero);
        assertEquals(numero, dni.getNumero());
        assertEquals(letra, dni.getLetra());
    }

    @Test
    public void testGetNumero() {
        int numero = 12345678;
        DNIMejorado dni = new DNIMejorado(numero);
        assertEquals(numero, dni.getNumero());
    }

    @Test
    public void testGetLetra() {
        int numero = 12345678;
        char letra = 'Z';
        DNIMejorado dni = new DNIMejorado(numero);
        assertEquals(letra, dni.getLetra());
    }

}