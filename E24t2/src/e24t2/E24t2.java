package e24t2;

/**Enunciado: Consulta el pdf de la librería “java io” y busca la clase PrintWriter. Realiza un programa que pregunte por teclado al usuario dos frases. El ordenador creará un archivo llamado “d:/frases.txt” (asegúrate de tener permisos de escritura, si no, pon otra carpeta) y escribirá las dos frases en él.
 *
 * @author rperblac
 */
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;

public class E24t2 {
    public static void main(String[] args) {
        System.out.println("Frase 1: ");
        String frase1 = new Scanner(System.in).nextLine();
        System.out.println("Frase 2: ");
        String frase2 = new Scanner(System.in).nextLine();
        
        File archivo = new File("../frases.txt");
        
        try
        {
            PrintWriter escribir = new PrintWriter(archivo);
            escribir.println(frase1);
            escribir.println(frase2);
            escribir.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        
        
    }
    
}
