package e23t3;

/** Enunciado: Consulta la documentación del “Java Collection Framework” y busca la interfaz
List<T>, que representa una lista dinámica (es decir, la lista empieza vacía y se le pueden
añadir y quitar objetos). Una vez que la tengas y la hayas leído, haz el siguiente programa:
a) El programa comenzará creando un objeto List<String> y lo rellenará con un objeto de
la clase que más se usa en la práctica para implementar List<T>.
b) El programa mostrará este menú de opciones, que se repetirá hasta que el usuario
pulse la opción de salir.
    1. Añadir mensaje a la lista
    2. Consultar el número de mensajes de la lista
    3. Consultar mensaje
    4. Comprobar mensaje
    5. Consultar todos los mensajes
    6. Borrar toda la lista
    7. Salir
c) Lo que hay que hacer en cada opción es:
    1. Pide al usuario que introduzca una frase y la añadirá al List<String>
    2. Muestra en pantalla el número de elementos que hay en el List<String>
    3. Cuando se selecciona, pueden pasar dos cosas
        1. Si la lista está vacía, se mostrará “No hay mensajes” y volverá al menú.
        2. Si la lista no está vacía, el programa preguntará el número del mensaje
        que se desea consultar y el usuario deberá introducir un número entre
        0 y la última posición válida de la lista. Si se introduce un número fuera
        de ese rango, el programa avisará de ello. En caso contrario, se
        mostrará el mensaje indicado.
    4. Pedirá al usuario que escriba un mensaje y el programa mostrará si el mensaje
    está o no en la lista. En caso de que si esté, se mostrará también su número de
    posición.
    5. Mostrará todos los mensajes de la lista, cada uno en una línea con el formato
    “El mensaje de la posición … es …”
    6. Borra todos los mensajes de la lista
 *
 * @author rperblac
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E23t3 {

    static int menu()
    {
        int salida = 7;
        boolean opcionvalida = false; // ¿Tenemos ya una opcion válida?
        do
        {
            System.out.println("\n1. Añadir mensaje a la lista\n2. Consultar el nº de mensajes de la lista\n3. Consultar mensaje\n4. Comprobar mensaje\n5. Consultar todos los mensajes\n6. Borrar toda la lista\n7. Salir");
            try
            {
                salida = new Scanner(System.in).nextInt();
                if ((salida < 1) || (salida > 7)) System.out.println("Por favor introduzca un numero entre 1 y 7");
                else opcionvalida = true;                        
            } catch (Exception e)
            {
                System.out.println("Por favor introduzca un numero entre 1 y 7");
                opcionvalida = false;
            }
        } while (!opcionvalida);

        return salida;
    }
    
    static boolean añadir(List<String> lista)
    {
        String entrada;
        boolean entradavalida = false; // ¿Tenemos ya una entrada válida?
        do
        {
            System.out.println( "Introduzca el mensaje a añadir");
            entrada = new Scanner(System.in).nextLine();
            try
            {
                lista.add(entrada);
                entradavalida = true;                        
            } catch (Exception e)
            {
                System.out.println(e.getLocalizedMessage());
                entradavalida = false;
            }
        } while (!entradavalida);
        return entradavalida;
    }
    
    static int numeroElementos(List<String> lista)
    {
        int elems = lista.size();
        return elems;
    }
    
    static void consulta(List<String> lista)
    {
        if (lista.isEmpty()) System.out.println("No hay mensajes");
        else
        {
            int opcion = 0;
            boolean opcionvalida = false; // ¿Tenemos ya una opcion válida?
            do
            {
                System.out.println("¿Nº de mensaje a consultar (0-" + (lista.size() - 1) + ")?");
                try
                {
                    opcion = new Scanner(System.in).nextInt();
                    if ((opcion < 0) || (opcion > (lista.size() - 1))) System.out.println("Por favor introduzca un nº entre 0 y " + (lista.size() - 1));
                    else opcionvalida = true;                        
                } catch (Exception e)
                {
                    System.out.println("Por favor introduzca un valor numérico entero");
                    opcionvalida = false;
                }
            } while (!opcionvalida);
            
            System.out.println(opcion + " -> " + lista.get(opcion));
        }
    }
    
    static void busca(List<String> lista)
    {
        System.out.println("Escriba el mensaje a buscar: ");
        String entrada = new Scanner(System.in).nextLine();
        
        if (lista.contains(entrada)) System.out.println("El mensaje está almacenado en la posición "+ lista.indexOf(entrada));
        else System.out.println("El mensaje no está almacenado")            ;        
    }
    
    static void mostrar(List<String> lista)
    {
        if (!(lista.isEmpty()))
        for (int i = 0; i <= (lista.size()-1);i++)
        {
            System.out.println("El mensaje de la posición " + i + " es " + lista.get(i));
        }
        else System.out.println("No hay mensajes");
    }
    
    static void borrar(List<String> lista)
    {
        System.out.println("¡Advertencia! Todos los mensajes se borrarán");
        System.out.println("Para proceder introduzca S");
        String adelante = new Scanner(System.in).next();
        
        if (adelante.equals("S"))
        {
            lista.clear();
            System.out.println("Todos los mensajes han sido borrados");
        }
        else System.out.println("Operación cancelada");
    }
    
    public static void main(String[] args) {
        List<String> mensajes = new ArrayList();
        mensajes.add("Mensaje inicial");
        int opcion;
        boolean salir = false; // ¿Salimos del menu?
        do
        {
            opcion = menu();
            switch(opcion){
                case 1 -> {
                    boolean correcto = añadir(mensajes);
                    if (correcto) System.out.println("Mensaje añadido correctamente");
                    else System.out.println("El mensaje no se pudo añadir");
                }
                case 2 -> {
                    int num = numeroElementos(mensajes);
                    System.out.println("Hay almacenados " + num + " mensajes");
                }
                case 3 -> consulta(mensajes);
                case 4 -> busca(mensajes);
                case 5 -> mostrar(mensajes);
                case 6 -> borrar(mensajes);
                case 7 -> salir = true;
            }
        } while (!salir);
        
    }
    
}
