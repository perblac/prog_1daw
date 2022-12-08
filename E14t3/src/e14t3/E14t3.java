package e14t3;

/** Enunciado: Haz un programa que dibuje en la pantalla 8 rectángulos cuyas coordenadas, dimensiones y color sean aleatorios.
 *
 * @author rperblac
 */
import bpc.daw.consola.*;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;
import java.util.Random;

public class E14t3 {
    public static void main(String[] args) {
        // Generador de numeros aleatorios
        Random generador = new Random();
        
        // Objetos de la consola
        Consola cons = new Consola();
        CapaTexto capat = cons.getCapaTexto();
        Teclado tecl = cons.getTeclado();
        CapaCanvas capaGr = cons.getCapaCanvas();
        Graphics2D graficos = (Graphics2D) capaGr.getGraphics();

        // Tamaño de pantalla: Ancho/Alto del texto por nº Columnas/Filas
        int ancho = (int) capat.getAnchoTexto() * capat.getNumeroColumnas();
        int alto = (int) capat.getAltoTexto() * capat.getNumeroFilas();
        
        // Rectángulo
        Rectangle rect;
        
        // Variables para tamaño, posición y componentes de color
        int tamx, tamy, posx, posy, rojo, verde, azul;
        Color color;
        
        // Comprobamos que el rectángulo va a entrar en pantalla
        boolean buenancho, buenalto;

        for (int i = 0; i < 8; i++)
        {
            // Componentes de color entre 0 y 255
            rojo = generador.nextInt(256);
            verde = generador.nextInt(256);
            azul = generador.nextInt(256);
            color = new Color(rojo, verde, azul);                
            graficos.setPaint(color);

            // Ancho: como mucho un cuarto del ancho de pantalla
            tamx = generador.nextInt(ancho/4);
            // Alto: como mucho un cuarto del alto de pantalla
            tamy = generador.nextInt(alto/4);

            // Coordenadas de la esquina superior izquierda. Comprobamos que el
            // rectágulo entra en pantalla, sino buscamos una nueva coordenada
            do
            {
                buenancho = false;
                posx = generador.nextInt(ancho + 1);
                if (posx + tamx <= ancho) buenancho = true;
            } while (!buenancho);
            do
            {
                buenalto = false;
                posy = generador.nextInt(alto + 1);
                if (posy + tamy <= alto) buenalto = true;
            } while (!buenalto);
            
            // Dibujamos el rectángulo
            rect = new Rectangle(posx, posy, tamx, tamy);
            graficos.draw(rect);
            graficos.fill(rect);
        }
        //Pausa antes de terminar
        tecl.leerCaracter();
    }
    
}
