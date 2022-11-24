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

public class check_nullpointer_args {

    public static void main(String args[]) {

        int numparametros = args.length;
        
        // Declarar un array de longitud variable de elementos de tipo String.
        // Inicializar a null en la declaración
        String[] cadenaargs = null;
        int elemento = 0;
        
        // Tratamos de escribir algo en una posición del array.
        // Manejar la excepción producida con: con try { }  catch { }
        try
        {
            System.out.println("Accediendo al valor declarado del nobre del array de cadena: " + cadenaargs[elemento]);
        } catch (NullPointerException npe)
        {
            System.out.println("NullPointerException: array nulo");
        }
        
        // Copia los valores introducidos en la llamada de programa, en el array
        // de argumentos de entrada, a otra cadena de String interna del programa.
        String[] otracadena = new String[numparametros];
        
        for (int i = 0;i < numparametros;++i)
        {
            otracadena[i] = args[i];
        }
        
        // Hacer eco de los valores de cadena introducidos en la llamada del programa.
        for (int i = 0; i < numparametros;++i)
        {
            System.out.print(otracadena[i]+" ");
        }
        
        // Escribir a null alguno de los elementos de la cadena copiada de argumentos.
        // Mostrar lo que ocurre si el usuario hubiera llamado al programa sin introducir argumentos.
        // ->     Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0
        // Trata de gestionar la excepción producida anterior para finalizar el programa de forma ordenada.
        try
        {
            otracadena[0] = null;
        } catch (ArrayIndexOutOfBoundsException ioob)
        {
            System.out.println("ArrayIndexOutOfBoundsException: posición vacía");
        }
    }
}
