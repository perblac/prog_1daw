package e47t2;

/** Enunciado: Consulta el pdf de la “Librería Estándar de Java” y busca la clase Desktop. Haz un programa que pregunte al usuario la ruta de un archivo. El programa abrirá dicho archivo usando para ello el programa que esté configurado en el sistema operativo.
 *
 * @author rperblac
 */
import java.util.Scanner;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class E47t2 {
    
    public static void main(String[] args) {
        System.out.println("Introduzca ruta: ");
        String ruta = new Scanner(System.in).next();
        File archivo = new File(ruta);
        try
        {
        Desktop.getDesktop().open(archivo);
        } catch(IOException ioe)
        {
            System.out.println("Error, no se pudo abrir el archivo");
        } catch(IllegalArgumentException iae)
        {
            System.out.println("Error, no existe el archivo");
        } catch(NullPointerException npe)
        {
            System.out.println("Error, ruta vacía");
        } catch(UnsupportedOperationException uoe)
        {
            System.out.println("Error, el sistema no permite la apertura del archivo");
        }
    }
    
}
