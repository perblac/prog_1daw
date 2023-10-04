package e7t3;

/** Enunciado: Usa la Consola DAW para realizar un programa que pregunte al usuario "¿Cuántos
círculos desea dibujar?". El usuario escribirá un número entero (si el número es incorrecto o
negativo, el programa dirá "Número incorrecto" y finalizará sin hacer nada más) y la pantalla
se borrará y se dibujarán tantos círculos como haya indicado el usuario. Cada círculo tendrá un
color con valores RGB aleatorios entre 0 y 255, y sus coordenadas también serán aleatorias
entre (0,0) y la resolución de la pantalla.
 *
 * @author rperblac
 */
import bpc.daw.consola.*;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.awt.Dimension;
import java.awt.Color;
import java.util.Random;


public class E7t3 {

    public static void main(String[] args) {
        // Generador de numeros aleatorios
        Random generador = new Random();
        
        // Objetos de la consola
        Consola cons = new Consola();
        Teclado tecl = cons.getTeclado();
        CapaTexto capat = cons.getCapaTexto();
        CapaCanvas capaGr = cons.getCapaCanvas();
        Graphics2D graficos = (Graphics2D) capaGr.getGraphics();

        // Tamaño de pantalla: Ancho/Alto del texto por nº Columnas/Filas
        int ancho = (int) capat.getAnchoTexto() * capat.getNumeroColumnas();
        int alto = (int) capat.getAltoTexto() * capat.getNumeroFilas();
        
        // Círculo
        Ellipse2D elipse = new Ellipse2D.Float();
        Color color;
        Point2D loc = new Point2D.Float();
        Dimension2D tamaño;
        
        // Variables para número de círculos, tamaño, posición y componentes de color
        int circulos, radio, posx, posy, rojo, verde, azul;
        
        // Solicitud del número de círculos. Al entrar un dato no numérico
        // ponemos círculos a 0 para sacar "Numero incorrecto"
        capat.println("¿Cuántos círculos desea dibujar?");
        try
        {
        circulos = tecl.leerNumeroEntero();
        } 
        catch (Exception e)
        {
            circulos = 0;
        }
        
        // Si circulos es 0 o negativo, es un numero incorrecto
        if (circulos>0)
        {
            capat.cls();            
            for (int i = 0; i < circulos; i++)
            {
                // Componentes de color entre 0 y 255
                rojo = generador.nextInt(256);
                verde = generador.nextInt(256);
                azul = generador.nextInt(256);
                color = new Color(rojo, verde, azul);                
                graficos.setPaint(color);
                
                // Radio como mucho un cuarto del ancho de pantalla
                radio = generador.nextInt(ancho/4);
                
                // Las coordenadas son de la esquina superior izquierda (0,0)
                // por lo que restamos un radio para que queden centradas en el 
                // punto generado
                posx = generador.nextInt(ancho + 1) - radio;
                posy = generador.nextInt(alto + 1) - radio;
                loc.setLocation(posx, posy);
                
                // Tamaño igual a dos radios
                tamaño = new Dimension(radio * 2, radio * 2);
                
                elipse.setFrame(loc,tamaño);
                graficos.draw(elipse);
                graficos.fill(elipse);
            }
        }
        else
        {
            capat.println("Número incorrecto");
        }
        
        //Pausa antes de terminar
        tecl.leerCaracter();        
    }
    
}
