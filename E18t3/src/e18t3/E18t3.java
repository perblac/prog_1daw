package e18t3;

/** Enunciado: Usa la Consola DAW y las clases de Java Time para realizar un programa que muestre en el centro de la pantalla la hora, minutos y segundos actuales. Durante medio minuto, a cada segundo la pantalla se borrará y se volverá a imprimir la hora actual, dando la apariencia de un reloj.
 *
 * @author rperblac
 */
import bpc.daw.consola.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;

public class E18t3 {

    public static void main(String[] args) {
        // Elementos de ConsolaDAW
        Consola cons = new Consola();
        CapaTexto capat = cons.getCapaTexto();
        Teclado tecl = cons.getTeclado();
        
        boolean salir = false; // ¿Salimos del programa?
        
        // Formateado de hora
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("hh:mm:ss a");
        LocalTime lahora = LocalTime.now();
        String horaforma = lahora.format(formato);
        
        // Posición central
        int ancho = capat.getNumeroColumnas(), x = (ancho/2)-(horaforma.length()/2);
        int alto = capat.getNumeroFilas(), y = (alto/2);
        
        // Variables para medir los 30 segundos
        LocalTime duracion, ahora;
        Duration lapso;
        int fintiempo = 30000; // En ms.
        
        // Momento inicial
        ahora = LocalTime.now();       
        
        // Bucle principal
        do
        {
            if (tecl.hayTeclaPulsada()) salir = true; // Salida en cualquier momento pulsando una tecla
            
            // Tomamos la hora y le aplicamos formato
            lahora = LocalTime.now();
            horaforma = lahora.format(formato);
            
            // Limpiamos pantalla e imprimimos            
            capat.cls();
            capat.print(y,x, horaforma);
            
            // Pausa de un segundo
            try
            {
                Thread.sleep(1000);
            } catch (InterruptedException e)
            {
                capat.println("Pausa interrumpida. " + e.getLocalizedMessage());
            }
            
            // Comprobamos si el lapso entre este momento y el inicial sobrepasa
            // la cantidad para finalizar el programa
            duracion = LocalTime.now();
            lapso = Duration.between(ahora, duracion);
            if (lapso.getSeconds()>fintiempo) salir = true;
            
        } while (!salir);
    }
    
}
