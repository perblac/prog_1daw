
package contraseñas;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;
import java.util.Scanner;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests de la clase GeneradorContraseñasUnicasArchivo
 * @author rperblac
 */
public class GeneradorContraseñasUnicasArchivoTest {

    public GeneradorContraseñasUnicasArchivoTest() {
    }
    
    @Test
    public void testGeneradorContraseñasUnicasArchivo_String() {
        String f = "temp.txt";
        GeneradorContraseñasUnicasArchivo gcua = new GeneradorContraseñasUnicasArchivo(f);
        assertEquals("contraseñas.GeneradorContraseñasUnicasArchivo", gcua.getClass().getName());
    }
    
    @Test
    public void testGeneradorContraseñasUnicasArchivo_String_Random() {
        String f = "temp.txt";
        Random r = new Random(0);
        Random q = new Random(0);
        int longitud = 8;
        GeneradorContraseñasUnicasArchivo gcua = new GeneradorContraseñasUnicasArchivo(f, q);
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
        String i = s.toString();
        String generada = gcua.generarContraseña(longitud);
        System.out.println(i + " : " + generada);
        try {
            Files.deleteIfExists(Path.of(f));
        } catch (IOException ex) {
            System.out.println("Error en archivo :" + ex.getMessage());
        }
        assertEquals("contraseñas.GeneradorContraseñasUnicasArchivo", gcua.getClass().getName());
        assertEquals(i, generada);
    }    

    @Test
    public void testGenerarContraseña_int() {
        String archivo = "temp.txt";
        GeneradorContraseñasUnicasArchivo gcua = new GeneradorContraseñasUnicasArchivo(archivo);
        String contraseña = gcua.generarContraseña(8);
        System.out.print(contraseña + " (Se grabó: ");
        String leida = "";
        try {
            // Abrir archivo para lectura
            FileReader fr = new FileReader(archivo);
            Scanner s = new Scanner(fr);
            // Recorrer hasta la ultima linea
            while (s.hasNext()) {
                leida = s.nextLine();
            }
            System.out.println(leida + ")");
            // Comprobar que la contraseña grabada es la misma que la producida por el método GenerarContraseña()
            assertEquals(contraseña, leida);
            // Cerrar archivo
            s.close();
            fr.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error de lectura de archivo :" + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error al cerrar el archivo :" + ex.getMessage());
        }
        try {
            Files.deleteIfExists(Path.of(archivo));
        } catch (IOException ex) {
            System.out.println("Error en archivo :" + ex.getMessage());
        }
    }

}