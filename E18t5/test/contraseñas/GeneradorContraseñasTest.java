
package contraseñas;

import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests de la clase GeneradorContraseñas
 * @author rperblac
 */
public class GeneradorContraseñasTest {

    public GeneradorContraseñasTest() {
    }
    
    @Test
    public void testGeneradorContraseñas() {
        GeneradorContraseñas gc = new GeneradorContraseñas();
        assertEquals("contraseñas.GeneradorContraseñas", gc.getClass().getName());
    }
    
    @Test
    public void testGeneradorContraseñas_Random() {
        Random r = new Random(0);
        Random q = new Random(0);
        int longitud = 8;
        GeneradorContraseñas gc = new GeneradorContraseñas(q);
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
        assertEquals("contraseñas.GeneradorContraseñas", gc.getClass().getName());
        assertEquals(s.toString(), gc.generarContraseña(longitud));
    }    

    @Test
    public void testGenerarContraseña_int() {
       int longitud = 15;
       GeneradorContraseñas gc = new GeneradorContraseñas();
       String c = gc.generarContraseña(longitud);
       System.out.println(c);
       assertEquals(longitud, c.length());
    }

    @Test
    public void testGenerarContraseña() {
       int longitud = 8;
       GeneradorContraseñas gc = new GeneradorContraseñas();
       String c = gc.generarContraseña();
       System.out.println(c);
       assertEquals(longitud, c.length());
    }

}