
package contraseñas;

import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests de la clase GeneradorContraseñasRaras
 * @author rperblac
 */
public class GeneradorContraseñasRarasTest {

    public GeneradorContraseñasRarasTest() {
    }

    @Test
    public void testGeneradorContraseñasRaras() {
        GeneradorContraseñasRaras gcr = new GeneradorContraseñasRaras();
        assertEquals("contraseñas.GeneradorContraseñasRaras", gcr.getClass().getName());
    }
    
    @Test
    public void testGeneradorContraseñasRaras_Random() {
        Random r = new Random(0);
        Random q = new Random(0);
        int longitud = 8;
        GeneradorContraseñasRaras gcr = new GeneradorContraseñasRaras(q);
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
        String i = "";
        for (char c:s.toString().toCharArray()) {
            c += 122;
            i += c;
        }
        String generada = gcr.generarContraseña(longitud);
        System.out.println(generada + " : " + s.toString() + " -> " + i);
        assertEquals("contraseñas.GeneradorContraseñasRaras", gcr.getClass().getName());
        assertEquals(i, generada);
    }    

    @Test
    public void testGenerarContraseña_int() {
       int longitud = 15;
       GeneradorContraseñasRaras gcr = new GeneradorContraseñasRaras();
       String c = gcr.generarContraseña(longitud);
       System.out.println(c);
       assertEquals(longitud, c.length());
    }

}