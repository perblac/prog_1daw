/**Enunciado: Caso de ejemplo de pasar argumentos por línea de comandos (el array args por defecto). 
    Ejemplo de uso: java check_nullpointer_args.java 1 2 3 

    -Declarar un array de longitud variable de elementos de tipo String. Inicializar a null en la declaración
    -Tratamos de escribir algo en una posición del array.
    -Manejar la excepción producida con: con try { }  catch { }
    -Copia los valores introducidos en la llamada de programa, en el array de argumentos de entrada, a otra cadena de String interna del programa.
    -Hacer eco de los valores de cadena introducidos en la llamada del programa.
    -Escribir a null alguno de los elementos de la cadena copiada de argumentos.
    -Mostrar lo que ocurre si el usuario hubiera llamado al programa sin introducir argumentos.
    -Trata de gestionar la excepción producida anterior para finalizar el programa de forma ordenada.
 *
 * @author rperc
 */
import java.util.ArrayList; // Importar la clase ArrayList

public class check_nullpointer_args {

    public static void main(String args[]) {
// -Declarar un array de longitud variable de elementos de tipo String. Inicializar a null en la declaración
        if (args.length<1)
        {

            System.out.println("No se introdujeron argumentos");
            System.exit(0);
        }

        ArrayList<String> lista;
//        lista = new ArrayList<String>(null); // Produce error IndexOutOfBoundsException
        lista = new ArrayList<String>();

// -Tratamos de escribir algo en una posición del array.
// -Manejar la excepción producida con: con try { }  catch { }

        try
        {
            lista.add(0,"cadena");
        } catch (IndexOutOfBoundsException error)
        {
            System.out.println("No se pudo introducir \"cadena\" en la posición 0\n" + error);
        }
        
// -Copia los valores introducidos en la llamada de programa, en el array de
// argumentos de entrada, a otra cadena de String interna del programa.
        int posicion;
        for (posicion = 0; posicion < 3; ++posicion)        {
            try
            {
                lista.add(posicion, args[posicion]);
            } catch (IndexOutOfBoundsException error)
            {
                System.out.println("No se pudo introducir un valor en la posición " + posicion + "\n" + error);
                if (posicion == 1)
                {
                    System.out.println("Introduzca 3 argumentos. Sólo se encontró uno (" + args[0] + ")");
                    System.exit(1);
                }
                if (posicion == 2)
                {
                    System.out.println("Introduzca 3 argumentos. Sólo se encontraron dos (" + args[0] + " y " + args[1] + ")");
                    System.exit(1);
                }
            }
        }
        
// -Hacer eco de los valores de cadena introducidos en la llamada del programa.
        try
        {
            System.out.println("Argumento 1: " + lista.get(0) + "\nArgumento 2: " + lista.get(1) + "\nArgumento 3: " + lista.get(2));
        } catch (IndexOutOfBoundsException error)
        {
            System.out.println("No se pudo imprimir algún valor del array \"lista\"\n" + error);
        }
        
// -Escribir a null alguno de los elementos de la cadena copiada de argumentos.
        try
        {
            lista.add(1,null);
        } catch (IndexOutOfBoundsException error)
        {
            System.out.println("Error al escribir null en la posición 2 del array \"lista\"\n" + error);
        }

// -Mostrar lo que ocurre si el usuario hubiera llamado al programa sin introducir argumentos.
/* Respuesta:
java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0
No se pudo introducir un valor en la posición 1
java.lang.ArrayIndexOutOfBoundsException: Index 1 out of bounds for length 0
No se pudo introducir un valor en la posición 2
java.lang.ArrayIndexOutOfBoundsException: Index 2 out of bounds for length 0
No se pudo imprimir algún valor del array "lista"
java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length 1
*/

// -Trata de gestionar la excepción producida anterior para finalizar el programa de forma ordenada.

    }
}
