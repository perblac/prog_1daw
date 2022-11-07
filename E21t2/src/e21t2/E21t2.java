package e21t2;

/**Enunciado: Realiza un programa que pida por teclado la ruta de un directorio. En caso de que la ruta introducida no sea un directorio, el programa mostrará un mensaje de error. En caso contrario, el programa mostrará el número total de archivos y carpetas que contiene.
 *
 * @author rperblac
 */
import java.io.File;
import java.util.Scanner;

public class E21t2 {

    public static void main(String[] args) {
        System.out.println("Introduzca directorio: ");
        String ruta = new Scanner(System.in).next();
        File archivo = new File(ruta);

        if (!(archivo.isDirectory()))
        {
            System.out.println("La ruta introducida no corresponde a un directorio");
        }
        else if (archivo.isDirectory())
        {
            String[] lista = archivo.list();
            System.out.println("Número total de archivos y carpetas: "+lista.length);
            for (int i = 0; i <lista.length;i++)
            {
                System.out.println(lista[i]);
            }
        }        
    }
    
}
