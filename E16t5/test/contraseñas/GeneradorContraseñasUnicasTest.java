
package contraseñas;

import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests de la clase GeneradorContraseñasUnicas
 * @author rperblac
 */
public class GeneradorContraseñasUnicasTest {

    public GeneradorContraseñasUnicasTest() {
    }

    @Test
    public void testGeneradorContraseñasUnicas() {
        GeneradorContraseñasUnicas gcu = new GeneradorContraseñasUnicas();
        assertEquals("contraseñas.GeneradorContraseñasUnicas", gcu.getClass().getName());
    }
    
    @Test
    public void testGeneradorContraseñasUnicas_Random() {
        Random r = new Random(0);
        Random q = new Random(0);
        int longitud = 8;
        GeneradorContraseñasUnicas gcu = new GeneradorContraseñasUnicas(q);
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < longitud; i++){
            int tipo = r.nextInt(3);
            switch (tipo){
                case 0:
                    s.append((char) (r.nextInt(10)+48));
                    break;
                case 1:
                    s.append((char) (r.nextInt(26)+65));
                    break;
                case 2:
                    s.append((char) (r.nextInt(26)+97));
                    break;
            }            
        }
        assertEquals("contraseñas.GeneradorContraseñasUnicas", gcu.getClass().getName());
        assertEquals(s.toString(), gcu.generarContraseña(longitud));
    }    

    @Test
    public void testGenerarContraseña_int() {
       int longitud = 15;
       GeneradorContraseñasUnicas gcu = new GeneradorContraseñasUnicas();
       String c = gcu.generarContraseña(longitud);
       System.out.println(c);
       assertEquals(longitud, c.length());
    }

    @Test
    public void testGenerarContraseña() {
       int longitud = 12;
       GeneradorContraseñasUnicas gcu = new GeneradorContraseñasUnicas();
       String c = gcu.generarContraseña();
       System.out.println(c);
       assertEquals(longitud, c.length());
    }

}