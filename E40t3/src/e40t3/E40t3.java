package e40t3;

/** Enunciado: En este ejercicio vas a hacer un programa que pida por teclado al usuario el nombre de un día y muestre tu horario de clases de ese día. Sigue estos pasos:
    a) Crea una lista para guardar los nombres de los días de la semana
    b) Crea una lista de String para guardar las horas (por ejemplo “16:00 – 16:55”)
    c) Crea una tabla 5 x 6 con las asignaturas que tienes cada día (cada columna es un día).
    d) Pide por teclado al usuario el nombre de un día
    e) Obtén la posición que tiene el día introducido dentro de la lista del apartado a)
    f) Recorre la columna correspondiente a ese día y muestra las asignaturas, poniendo
    también la hora correspondiente a cada una.
 *
 * @author rperblac
 */
import java.util.Scanner;
public class E40t3 {

    public static void main(String[] args) {
        String[] semana = {"lunes", "martes", "miercoles", "jueves", "viernes"};
        String[] horario = {"16:00 - 16:55", "16:55 - 17:50", "17:50 - 18:45", "19:00 - 19:55", "19:55 - 20:40", "20:40 - 21:45"};
        String[][] asignaturas = {
            {"S.I.", "S.I.", "S.I.", "Bases Datos", "Bases Datos", "Bases Datos"},
            {"FOL", "FOL", "Programación", "Inglés", "Inglés", "ED"},
            {"FOL", "SI", "SI", "ED", "LMSGI", "LMSGI"},
            {"Bases Datos", "Bases Datos", "Bases Datos", "Programación", "Programación", "Programación"},
            {"Programación", "Programación", "Programación", "LMSGI", "LMSGI", "ED"}
        };
        
        String entrada;
        boolean salir = false; // ¿Salimos del programa?
        boolean encontrado; // ¿Aparece la entrada en la lista de dias semana[]?
        do
        {
            encontrado = false; // Reiniciamos 'encontrado' a false siempre que empezamos el bucle
            
            System.out.println("Introduzca dia (lunes, martes, miercoles, jueves o viernes) o s para salir:");
            entrada = new Scanner(System.in).next();
            
            if ((entrada.equals("s"))||(entrada.equals("S")))
            {
                salir = true; // Sólo salimos si se introdujo s o S
            }
            else              // En otro caso comparamos la entrada con los dias de la semana.                              
            {
                for (int dia = 0; dia < semana.length; dia++)
                {
                    if (semana[dia].equals(entrada)) // Si aparece, imprimimos el horario y lo marcamos como encontrado,
                    {
                        for (int hora = 0; hora < horario.length; hora++)
                        {
                            System.out.println(horario[hora]+" -> "+asignaturas[dia][hora]);
                        }
                        encontrado = true;
                    }
                }
                // Si no aparece 'entrada' en 'semana', 'encontrado' sigue siendo false e informamos 
                if (encontrado == false) System.out.println("No se ha encontrado el dia introducido");
            }
        } while (!salir);
    }
    
}
