package e19t3;

/** Enunciado: Usa la Consola DAW para hacer un programa que pregunte al usuario un número
de segundos. El programa finalizará cuando pase la cantidad de segundos introducida y
durante ese tiempo se dibujará y actualizar en la pantalla una barra de progreso como esta:
 *
 * @author rperblac
 */
import bpc.daw.consola.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;

public class E19t3 {

    public static void main(String[] args) {
        // Objetos de la consola
        Consola cons = new Consola();
        CapaTexto capat = cons.getCapaTexto();
        Teclado tecl = cons.getTeclado();
        CapaCanvas capaGr = cons.getCapaCanvas();
        Graphics2D graficos = (Graphics2D) capaGr.getGraphics();

        // Tamaño de pantalla: Ancho/Alto del texto por nº Columnas/Filas
        int columnas = capat.getNumeroColumnas(), filas = capat.getNumeroFilas();
        int ancho = (int) capat.getAnchoTexto() * columnas;
        int alto = (int) capat.getAltoTexto() * filas;
        
        // Rectángulo
        Rectangle rect;
        
        // Variables para tamaño, posición y componentes de color
        int tamx, tamy, posx, posy, rojo, verde, azul;
        float proporcion, anchoactual;
        Color color;        
        
        // Fondo barra
        int altobarra = 60, anchobarra = 1024;
        posx = (ancho / 2) - (anchobarra / 2);
        posy = (alto / 2) - (altobarra / 2);
        tamx = anchobarra;
        tamy = altobarra;
        rojo = 124;
        verde = 124;
        azul = 124;
        color = new Color(rojo, verde, azul);                
        graficos.setPaint(color);
        rect = new Rectangle(posx, posy, tamx, tamy);
        graficos.draw(rect);
        
        // Variables para medir tiempo
        LocalTime estemomento, inicial;
        Duration lapso;
        String porcentaje;
        int porcenx, porceny;
        porceny = (filas / 2) + 2;
        
        int segundos = 1, duracion;
        
        // Inicializacion de la barra de progreso        
        anchobarra = anchobarra - 4;
        altobarra = altobarra - 4;
        posx = (ancho / 2) - (anchobarra / 2);
        posy = (alto / 2) - (altobarra / 2);
        tamy = altobarra;
        rojo = 33;
        verde = 33;
        azul = 200;
        color = new Color(rojo, verde, azul);                
        graficos.setPaint(color);        
        
        // Entrada de tiempo
        boolean lotenemos; // ¿Tenemos un tiempo en segundos válido?
        do
        {
            capat.cls();
            try
            {
                capat.println("¿Número de segundos?");
                segundos = tecl.leerNumeroEntero();
                capat.saltoLinea();
                if (segundos<1)
                {
                    capat.println("Introduzca un valor mayor que cero.\nPresione una tecla para continuar");
                    tecl.leerCaracter();
                    lotenemos = false;
                }
                else lotenemos = true;
            } catch (Exception e)
            {
                capat.println("Introduzca un valor numérico.\nPresione una tecla para continuar");
                tecl.leerCaracter();
                lotenemos = false;
            }                   
        } while (!lotenemos);
        
        // Pasamos los segundos a milisegundos
        segundos = segundos * 1000;
        
        inicial = LocalTime.now();
        do
        {    
            // Medimos la duracion del lapso transcurrido
            estemomento = LocalTime.now();
            lapso = Duration.between(inicial,estemomento);
            duracion = (int) (lapso.toMillis());
            
            // Calculamos el porcentaje de progreso y asignamos a la barra su 
            // nuevo tamaño
            proporcion = (float) duracion / segundos;
            anchoactual = anchobarra * proporcion;
            porcentaje = (int) (proporcion * 100) + " %";
            porcenx = (columnas / 2) - (porcentaje.length() / 2);
            tamx = (int) anchoactual;
            
            // Imprimimos la barra y el porcentaje
            rect = new Rectangle(posx, posy, tamx, tamy);
            graficos.draw(rect);
            graficos.fill(rect);
            capat.print(porceny, porcenx, porcentaje);
        } while (duracion<segundos);
        
        // Esperamos una pulsacion de tecla para salir
        capat.print(3,0,"Presione una tecla para salir");
        tecl.leerCaracter();
    }
    
}
