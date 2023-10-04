package e25t2;

/**Enunciado: Consulta el pdf de la “Librería Estándar de Java” y busca la clase Scanner. Realiza un programa que abra el archivo “d:/frase.txt” que has creado en el ejercicio anterior y nos muestre por pantalla las dos frases que hay guardadas en él.
 *
 * @author rperblac
 */
import java.io.File;
import java.util.Scanner;

public class E25t2 {

    public static void main(String[] args) {
        File archivo = new File("../frases.txt");
        try
        {
            Scanner leer = new Scanner(archivo);
            int i = 1;
            while (leer.hasNextLine())
            {
                String frase = leer.nextLine();
                System.out.println("Frase " + i + ": " + frase);
                ++i;
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}
