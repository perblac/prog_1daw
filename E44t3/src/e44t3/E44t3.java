package e44t3;


/** Enunciado: Con el bloc de notas haz un archivo llamado palabras.txt y rellénalo con las 10
palabras que tú quieras. A continuación, haz un programa que abra ese archivo y lea todas las
palabras del archivo, guardándolas en un List<String>. Por último, recorre ese List<String>
usando un for mejorado y muestra cada palabra en pantalla.
 *
 * @author rperblac
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E44t3 {

    public static void main(String[] args) {
        // Abrir archivo
        File palabras = new File("palabras.txt");
        
        // Leer palabras
        List<String> lista = new ArrayList(10);
        Scanner leer = null;
        try
        {
            leer = new Scanner(palabras);            
        } catch (FileNotFoundException fnfe)
        {
            System.out.println("No se encuentra el archivo");
        }
                while (leer.hasNext())
        {
            lista.add(leer.next());
        }
        
        // Mostrar palabras
        for (String siguiente : lista)
        {
            System.out.println(siguiente + " ");
        }
    }
    
}
