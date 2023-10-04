package examt23.pkg;

/** Enunciado: Realice un programa interactivo, a partir de un fichero Automarcador.java que
    usa la clase Marcador, importando la librería ObjetosSencillos. Implementa un
    marcador automático de partidos de baloncesto entre un equipo local (L) y otro
    visitante (V), creados en la declaración inicial del programa. El funcionamiento del
    programa consiste en mostrar un menú de opciones iterativo, donde el usuario va
    marcando el equipo anotador (L o V) y a continuación, los puntos de la canasta
    anotada por dicho equipo, conforme avanza el partido.
        A. El programa muestra repetidamente el menú, por mensaje de consola al usuario,
        que le informa de las posibles opciones en el programa. Las opciones son:
            - guardar anotación: a) marcar equipo anotador, b) marcar puntos de canasta.
            - ver marcador de puntos guardado en el momento actual del partido (P),
            indicando qué equipo va ganando.
            - finalizar el partido (S) y mostrar marcador final con el nombre de los equipos.
        Nota: para recoger un solo carácter de teclado: Scanner.next().charAt(0)
        B. Gestionar excepciones del programa: introducción de datos erróneos (teclas fuera
        de opciones del menú) o canasta no se registra correctamente (valor entero de
        canasta introducido es distinto de 1,2 o 3).
 * 
 *  Autocajero.java
 *  v1.0
 * 
 * @author rperblac
 */
// Importado de librerías
import bpc.daw.objetos.TarjetaCredito;
import java.util.Scanner;
import static java.lang.System.out;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class Autocajero {

    public static void main(String args[]) {
       // Boolean para gestionar errores de entrada
       boolean error;
       
       // Boolean para comprobar si el pin es correcto
       boolean pincorrecto = false;
       
       // Variable para contar los intentos de introduccion del pin
       int intentos = 0;
       
        // Boolean para salir del programa. Si salir = true -> salimos
        boolean salir = false;
        
        // Char para entrada de menu
        char opcion = 0;
        
        // Variables para comprobación del pin
        String contraseña = "91222";
        String pin = null;
        
        // Variables para ingreso y retirada de dinero
        int ingreso;
        int retirada; 
        
        // Boolean para estado de la retirada de efectivo
        boolean retiradacorrecta;
        
        // Comprobación del PIN
        do // Bucle principal
        {
            if (intentos > 2) // Comprobamos que quedan intentos
            {
                out.println("Agotó sus intentos. Saliendo.");
                System.exit(0);
            }

            // Bucle de entrada de contraseña
            do
            {
                error = false;
                out.println("Introduzca la contraseña: ");
                try
                {
                    pin = new Scanner(System.in).next();
                    if (pin.length()!=5)
                    {
                        throw new Exception(); // Lanzamos un error para volver al bucle si no se introdujo una clave de 5 caracteres
                    }
                }
                catch (Exception e)
                {
                    error = true;
                    out.println("introduzca una clave de 5 caracteres");
                }            
            } while (error);
            // Fin del bucle de entrada de contraseña
            
            out.println("Has marcado la contraseña: " + pin);
            intentos = intentos + 1;
           
            // Comprobamos el PIN
            if (!(pin.equals(contraseña)))
            {
                out.println("Contraseña incorrecta");
                out.println(intentos + " intentos de 3");
            }
            else pincorrecto = true;
            
        } while (!pincorrecto);
        
        // Se ha introducido el pin correcto. Inicializamos la tarjeta
        out.println("Contraseña aceptada con saldo inicial: 100");
        
        int clave = Integer.parseInt(pin); // Usaremos clave para los accesos a la tarjeta
        
        // Creamos la tarjeta
        TarjetaCredito tarjeta = new TarjetaCredito(100,clave);        
        
        // Bucle principal
        do 
        {            
            // Menú
            out.print("Indique la operación a realizar: Ingresar(I), Retirar(R), T(terminar), S (saldo actual): ");
            
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
                // Opcion ingresar
                case 'i':
                case 'I':
                    out.println("Indique el importe con el que quiere operar: ");
                    
                    // Comprobamos que el importe es numérico y positivo
                    do
                    {
                        error = true;
                        try
                        {
                            ingreso = new Scanner(System.in).nextInt();
                            if (ingreso < 1) out.println("Por favor introduzca un valor positivo");
                            else error = false;
                        } catch (InputMismatchException ime)
                        {
                            out.println("Por favor introduzca un valor numérico entero");
                            ingreso = 0;
                        }                        
                    } while (error);

                    // Realizamos el ingreso
                    tarjeta.ingresarDinero(ingreso);
                    out.println("Se ha ingresado una cantidad de " + ingreso + " euros.");
                    break;
                    
                // Opcion retirar
                case 'r':
                case 'R':
                    out.println("Indique el importe con el que quiere operar: ");
                    
                    // Comprobamos que el importe es numérico y positivo
                    do
                    {
                        error = true;
                        try
                        {
                            retirada = new Scanner(System.in).nextInt();
                            if (retirada < 1) out.println("Por favor introduzca un valor positivo");
                            else error = false;
                        } catch (InputMismatchException ime)
                        {
                            out.println("Por favor introduzca un valor numérico entero");
                            retirada = 0;
                        }
                        
                    } while (error);
                    
                    // Intentamos la retirada. Si devuelve false, es que no hay saldo suficiente
                    try
                    {
                        retiradacorrecta = tarjeta.sacarDinero(retirada, clave);
                    } catch (Exception e)
                    {
                        out.println("Contraseña incorrecta");
                        retiradacorrecta = false;
                    }
                    
                    // Informamos del resultado de la operación
                    if (retiradacorrecta) out.println("Se ha retirado una cantidad de " + retirada + " euros.");
                    else out.println("No hay saldo suficiente para realizar la operación");
                    break;
                    
                // Opcion saldo
                case 's':
                case 'S':
                    out.println("En estos momentos el saldo de la tarjeta es:");
                    try
                    {
                        out.println("Saldo actual: " + tarjeta.getSaldo(clave) + " euros.");
                    }
                    catch (Exception e)
                    {
                        out.println("Contraseña incorrecta");
                    }
                    break;
                    
                // Opcion terminar
                case 't':
                case 'T':
                    out.println("Ha pulsado terminar de operar en Cajero.\nGracias por usar el cajero. Recoja su tarjeta.");
                    salir = true; // Ponemos a true el booleano para salir del bulce principal
                    break;
                    
                // Entrada no válida
                default:
                    out.println("Opción incorrecta");
            }
                
        } while (!salir);
        // Fin del bucle principal y del programa
    }
}
