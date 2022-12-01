package e11t3;

/** Enunciado: Utiliza las clases PrintWriter y BufferedReader de la librería de entrada y salida para realizar un programa que muestre al usuario este menú de opciones que se repite continuamente hasta que se pulsa la opción de salir:
    1. Añadir nuevo alumno
    2. Ver los datos de un alumno
    3. Salir
Al pulsar cada opción, sucede esto:
    - Opción 1: El programa preguntará el dni, nombre, dirección y teléfono de un alumno y guardará estos tres últimos datos en líneas diferentes en un archivo de texto llamado (poner el dni).txt
    - Opción 2: El programa pregunta un dni y recupera del archivo (poner el dni).txt el nombre, dirección y teléfono del alumno, mostrándolos por pantalla.
    - Opción 3: El programa finalizará.
 *
 * @author rperblac
 */
import static java.lang.System.out;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
/*
public PrintWriter(String fileName)
            throws FileNotFoundException
FileNotFoundException - If the given string does not denote an existing, writable regular file and a new regular file of that name cannot be created, or if some other error occurs while opening or creating the file
SecurityException - If a security manager is present and checkWrite(fileName) denies write access to the file
*/
import java.io.BufferedReader;
import java.io.IOException;
/*
public BufferedReader(Reader in)
*/
import java.io.InputStreamReader;
/*
public InputStreamReader(InputStream in)
*/
import java.io.FileInputStream;
/*
public FileInputStream(String name)
                throws FileNotFoundException
FileNotFoundException - if the file does not exist, is a directory rather than a regular file, or for some other reason cannot be opened for reading.
SecurityException - if a security manager exists and its checkRead method denies read access to the file.
*/

public class E11t3 {
    
private static void imprimeMenu() {
    out.println("1. Añadir nuevo alumno\n" +
                "2. Ver los datos de un alumno\n" +
                "3. Salir");
}

private static String leerDni()
{
    boolean dnicorrecto = false; // ¿Se introdujo un dni con el formato correcto?
    String dni = null;
    while (!dnicorrecto)
    {
        out.print("dni: ");
        dni = new Scanner(System.in).nextLine();
        if (dni.length()==9) // Debe tener 9 caracteres
        {
            String numeros = dni.substring(0,7); // Los 8 primeros a "numeros"
            String letra = dni.substring(8,9); // El noveno a "letra"
            if (numeros.chars().allMatch(Character::isDigit)) // "numeros" deben ser dígitos
            {
                if (Character.isLetter(letra.charAt(0))) // "letra" debe ser un carácter
                {
                    char letradni = Character.toUpperCase(letra.charAt(0)); // Pasa la letra a mayúscula
                    dni = numeros + letradni;
                    out.println("DNI -> " + dni);
                    dnicorrecto = true;
                } else
                {
                    out.println("El noveno caracter debe ser una letra");
                }
            } else
            {
                out.println("El dni debe comenzar con 8 números");
            }
        } else
        {
            out.println("El formato de dni son 8 números y una letra (00000000A)");
        }
    }
    return dni;
}

private static boolean nuevaEntrada(String dni, String nombre, String direccion, String telefono)
{
    PrintWriter escribir;
    try
    {
        escribir = new PrintWriter(dni + ".txt");
        /*
        public void println(String x)
        */
        escribir.println(nombre);
        escribir.println(direccion);
        escribir.println(telefono);
        escribir.close();
        return true;
    } catch (FileNotFoundException | SecurityException error)
    {
        out.println(error.getLocalizedMessage());
        return false;
    }
}

private static boolean leerEntrada(String dni)
{
    FileInputStream archivo;
    InputStreamReader stream;
    BufferedReader bufer;
    try
    {
        // Apertura de archivo
        archivo = new FileInputStream(dni + ".txt");
        stream = new InputStreamReader(archivo);
        bufer = new BufferedReader(stream);
        
        // Lectura de lineas
        out.println("Nombre: " + bufer.readLine());
        out.println("Direccion: " + bufer.readLine());
        out.println("Teléfono: " + bufer.readLine());
        
        // Cerrado de archivo
        bufer.close();
        stream.close();
        archivo.close();        
    }
    catch (FileNotFoundException fnfe)
    {
        out.println("No existe la entrada del dni " + dni);
        return false;
    }
    catch (SecurityException se)
    {
        out.println("Error de apertura del archivo");
        return false;
    }
    catch (IOException ioe)
    {
        out.println("Error de lectura de linea, archivo corrupto");
    }    
    
    // Si todo fue bien, devuelve true
    return true;        

}
    public static void main(String[] args) {
        int opcion = 0; // Opción del menu, entre 1 y 3
        boolean salir = false; // ¿Vamos a salir del programa?
        boolean valoropcion = false; // ¿Se introdujo un valor válido en el menú?
        String dni = null, nombre, direccion, telefono; // Variables para los datos

// Bucle principal        
        while (!salir)
        {
            imprimeMenu();
            
        // Bucle de entrada de opcion
            do
            {
                try
                {
                    opcion = new Scanner(System.in).nextInt();
                    if (opcion>0&&opcion<4) valoropcion=true; // Comprueba que el valor esté entre 1 y 3
                    else out.println ("Introduzca un numero entre 1 y 3");
                }
                catch (Exception error)
                {
                    out.println ("Introduzca un numero entre 1 y 3");
                }
            } while (!valoropcion);
            
        // Ejecución de la opción elegida
            switch (opcion)
            {
                // Añadir nuevo alumno
                case 1:
                    dni = leerDni();
                    out.print("nombre: ");
                    nombre = new Scanner(System.in).nextLine();
                    out.print("direccion: ");
                    direccion = new Scanner(System.in).nextLine();
                    out.print("telefono: ");
                    telefono = new Scanner(System.in).nextLine();
                    if (nuevaEntrada(dni,nombre,direccion,telefono)) out.println("Entrada escrita correctamente");
                    else out.println("No se ha escrito la entrada");
                    break;
                    
                // Ver los datos de un alumno
                case 2:                    
                    dni = leerDni();
                    if (leerEntrada(dni)) out.println("---");
                    else out.println("No se pudo leer la entrada");                    
                    break;
                    
                // Salir    
                case 3:
                    salir = true;
            }
        }
    }
    
}