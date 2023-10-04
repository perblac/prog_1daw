package examt23.pkg;

/** Enunciado: 2) Programa que simule por consola un Cajero automático, añadido al proyecto del
    examen, crear un fichero Autocajero.java para que a partir de la Clase
    TarjetaCredito de la librería ObjetosSencillos. Se creará al inicio un objeto de la
    clase TarjetaCredito con una contraseña de valor: 91222 y saldo inicial de 100. A
    continuación se muestran repetidamente las opciones del menú interactivo.
        A. Deberá gestionar las siguientes operaciones en menú, mientras no se pulsa ‘T’:
            a. ‘I’: Ingresar dinero que se indique por consola.
            b. ‘R’: Retirar dinero que se indique a continuación.
            c. ‘S’: obtener el saldo actual de la tarjeta.
            d. ‘T’: terminar el programa solo al pulsar dicha opción.
        B. Deberá implementarse la gestión de excepciones y de programa siguientes:
            - si contraseña incorrecta, permite hasta 3 intentos y si no, termina.
            - si la opción de menú es incorrecta, se informa y vuelve a mostrarse el menú.
            - si dinero insuficiente en la tarjeta, se informa por pantalla y se repite menú.
            - si se indica ingresar una cantidad negativa, se informará al usuario.
 * 
 *  Automarcador.java
 *  v1.0
 *
 * @author rperblac
 */

// Importado de librerías
import bpc.daw.objetos.MarcadorBaloncesto;
import java.util.Scanner;
import static java.lang.System.out;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class Automarcador {
 
    public static void main(String[] args) {
        // Declaración de variables
            // Nombre de los equipos
            String equipolocal = "Estudiantes", equipovisitante = "CB Granada";        
            // Creación del objeto Marcador
            MarcadorBaloncesto marcador = new MarcadorBaloncesto(equipolocal, equipovisitante);        
            // Char para entrada de menu. Lo inicializamos con 0, porque en realidad es un valor numérico correspondiente al valor ascci o unicode del caracter
            char opcion = 0;        
            // Boolean para salir del programa. Si salir = true -> salimos
            boolean salir = false;        
            // Variables para comprobar los puntos introducidos
            boolean canastavalida; // ¿Se introdujo un valor entero 1, 2 o 3?
            int puntos;        
        
        // Instrucciones iniciales        
        out.println("Marcador automático entre equipos, local: " + marcador.getNombreLocal() + "; visitante: " + marcador.getNombreVisitante());
        out.println("Pulse la tecla 'P' para visualizar el marcador actual.\n"
                  + "Pulse la tecla 'S' para visualizar el marcador final y terminar el partido.\n"
                  + "Marque la canasta de la forma:\n"
                  + "1) indique equipo anotador: pulse letra L (local) o V (visitante) + INTRO\n"
                  + "2) Marque la puntuación anotada por dicho equipo: (entero 1, 2 o 3) + INTRO");
        
        // Bucle principal
        do 
        {            
            // Menú
            out.print("a) indique equipo anotador (L|V), S (salir), P (puntos actuales): ");
            
            // Entrada de opción
            try
            {
                opcion = new Scanner(System.in).next().charAt(0);
            }
            catch (NoSuchElementException nsee) // Esta excepción no debería darse, ya que cada vez creamos un nuevo objeto Scanner
            {
                out.println("Error: " + nsee + "\n" + nsee.getLocalizedMessage());
            }
            catch (IllegalStateException ise) // Esta excepción tampoco debería darse, porque el objeto Scanner está abierto
            {
                out.println("Error: " + ise + "\n" + ise.getLocalizedMessage());
            }
            
            // Selección según opción
            switch(opcion)
            {
                // Si se introdujo L o V (anotar local o visitante)
                case 'l':
                case 'L':
                case 'v':
                case 'V':
                    do
                    {
                        out.print("b) Indique la puntuación de la canasta: ");
                        try
                        {
                            puntos = new Scanner(System.in).nextInt();
                            // Si puntos está fuera del rango 1-3, no tenemos puntuación válida así que repetimos
                            if ((puntos < 1) || (puntos > 3))
                            {
                                out.println("Por favor introduzca un valor de 1,2 o 3");
                                canastavalida = false;
                            }
                            else canastavalida = true; // En caso contrario, ya tenemos una puntuación válida

                        }

                        // Gestión de errores del método nextInt()
                        catch (InputMismatchException ime) // El valor introducido no es un entero o está fuera de rango
                        {
                            out.println("Por favor introduzca un valor entero válido (1,2 o 3)");
                            canastavalida = false;
                            puntos = 0;
                        }

                        catch (NoSuchElementException | IllegalStateException e) // Estas excepciones no deberían darse
                        {
                            out.println("Error: " + e + "\n" + e.getLocalizedMessage());
                            canastavalida = false;
                            puntos = 0;
                        }
                    } while (!canastavalida);

                    // Marcamos la puntuación                    
                    out.print("Marca ");
                    if ((opcion == 'l') || (opcion == 'L'))
                    {
                        out.print("local con ");
                        marcador.anotarCanasta('L', puntos);
                    }
                    else
                    {
                        out.print("visitante con ");
                        marcador.anotarCanasta('V', puntos);
                    }
                    
                    // Información sobre los puntos marcados
                    switch(puntos)
                    {
                        case 1:
                            out.println("canasta de 1 punto. (Tiro libre)");
                            break;
                        case 2:
                            out.println("canasta de 2 puntos. (Tiro normal)");
                            break;
                        case 3:
                            out.println("canasta de 3 puntos. (Triple)");
                            break;    
                    }
                    break; // Fin case L-V
                    
                // Si se introdujo P (mostrar puntos actuales)
                case 'p':
                case 'P':
                    out.println("En estos momentos:");
                    out.println(marcador.toString());
                    out.print("Va ganando: " + marcador.getNombreEquipoGanador() + " con ");
                    if (marcador.getNombreEquipoGanador().equals(equipolocal)) out.println(marcador.getPuntosLocal() + " puntos");
                    else out.println(marcador.getPuntosVisitante() + " puntos");
                    break;
                    
                // Si se introdujo S (salir)
                case 's':
                case 'S':
                    salir = true;
                    break;
                    
                // En caso de otra opción fuera del menu
                default:
                    out.println("Opción inválida");              
                    
            }
        } while (!salir);
        
        // Mensajes de salida
        out.println("Ha pulsado salir del marcador.\nFin de partido, marcador final:");
        out.println(marcador.toString());
        out.print("Ganador: " + marcador.getNombreEquipoGanador() + " con ");
        if (marcador.getNombreEquipoGanador().equals(equipolocal)) out.println(marcador.getPuntosLocal() + " puntos");
        else out.println(marcador.getPuntosVisitante() + " puntos");
    }
    
}