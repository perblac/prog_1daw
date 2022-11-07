package e20t2;

/**Enunciado: Realiza un programa que pregunte al usuario por la ruta de un archivo del disco duro. Si dicho archivo existe y es directorio, el programa dirá "La ruta introducida corresponde a un directorio" y terminará sin hacer nada más. En caso de que sea un archivo, el programa mostrará "La ruta introducida es un archivo de tamaño ... bytes. ¿Desea borrarlo (si/no)?". Si el usuario introduce la palabra "si", el archivo se borrará y el ordenador mostrará si se ha borrado correctamente o se ha producido un error al borrar. En caso de que el usuario escriba cualquier otra cosa el programa responderá "Borrado cancelado" y finalizará.
 *
 * @author rperblac
 */
import java.util.Scanner;
import java.io.*;

public class E20t2 {
    public static void main(String[] args) {
        System.out.println("Introduzca ruta de archivo: ");
        String ruta = new Scanner(System.in).next();
        File archivo = new File(ruta);

        if (archivo.isDirectory())
        {
            System.out.println("La ruta introducida corresponde a un directorio");
        }
        else if (archivo.isFile())
        {
            System.out.println("La ruta introducida es un archivo de tamaño "+ archivo.length()+" bytes. ¿Desea borrarlo (si/no)?");
            String respuesta = new Scanner(System.in).next();
            if (respuesta.equals("si"))
            {
                if (archivo.canWrite())
                {
                    archivo.delete();
                    System.out.println("Fichero borrado correctamente.");
                }
                else
                {
                    System.out.println("El archivo no se puede borrar.");
                }
            }
        }
    }
    
}
