package e39t2;

/** Enunciado: Consulta el pdf de la “Librería Estándar de Java” y busca la clase System. Haz un programa que muestre por pantalla información sobre tu ordenador, de la forma que indica la imagen. (Nota: La carpeta de archivos temporales es la variable de entorno TMP).
 *
 * @author rperblac
 */
import static java.lang.System.out;

public class E39t2 {

    public static void main(String[] args) {
        out.println("Información sobre el ordenador:");
        out.println("- Sistema operativo: " + System.getProperty("os.name"));
        out.println("- Versión del sistema operativo: " + System.getProperty("os.version"));
        out.println("- Arquitectura del sistema operativo: " + System.getProperty("os.arch"));
        out.println("- Usuario actual: " + System.getProperty("user.name"));
        out.println("- Carpeta de archivos temporales: " + System.getenv("TMP"));
    }
    
}