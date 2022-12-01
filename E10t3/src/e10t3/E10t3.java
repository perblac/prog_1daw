package e10t3;

/** Enunciado: Utiliza las clases y métodos de la librería de entrada y salida que se indican a continuación para hacer un programa que pregunte por teclado la ruta de un archivo de texto (.txt) y a continuación, use un BufferedReader para leer una por una todas sus líneas y mostrarlas por pantalla a la vez.
 *
 * @author rperblac
 */
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;

public class E10t3 {

    public static void main(String[] args) {
        boolean ok = false; // ¿Archivo cargado con éxito?
        String ruta, extension;

        /*
        FileInputStream(String name)
                throws FileNotFoundException
        */
        FileInputStream streamArchivo = null;

        do
        {
            System.out.println("Introduzca ruta a un archivo de texto (.txt): ");
            ruta = new Scanner(System.in).next();
            extension = ruta.substring(ruta.length()-3); // La extensión son los últimos tres caracteres
            if (extension.equals("txt")||extension.equals("TXT"))
            {
                try
                {
                    streamArchivo = new FileInputStream(ruta);                
                    ok = true;
                }
                catch (FileNotFoundException fnfe)
                {
                    System.out.println ("Archivo no encontrado");
                }
            }
            else System.out.println("La extensión del archivo debe ser .txt");
        } while (!ok);
        
        /*
        InputStreamReader(InputStream in)
        */
        InputStreamReader lector = new InputStreamReader(streamArchivo);
        
        /*
        BufferedReader(Reader in)
        */
        BufferedReader buferLectura = new BufferedReader(lector);        
             
        String linea = null; // Linea leida actual
        boolean sigue = true; // ¿Continua leyendo lineas?
        int i = 1; // Número de linea
        
        while (sigue)
        {
            /*
            boolean ready()
              throws IOException
            */
            try
            {
                sigue = buferLectura.ready(); // false si no puede leer más líneas
            }
            catch (IOException ioe)
            {
                System.out.println("Error de lectura");
                sigue = false;
            }
            
            /*
            String readLine()
                    throws IOException
            */
            try
            {
                linea = buferLectura.readLine(); // lee la siguiente linea
            }
            catch (IOException ioe)
            {
                System.out.println("No se pudo leer la linea");
                sigue = false;
            }
            
            if (sigue) // Cuando vaya a salir del bucle, ya no imprime más lineas
            {
                System.out.println("Linea " + i + ": " + linea);
                i++;
            }
        }
        
        // Cerrar recursos:
        try
        {
            streamArchivo.close();
            lector.close();
            buferLectura.close();
        }
        catch (IOException | NullPointerException error)
        {
            System.out.println(error);
        }
    }
    
}
