
package utiles;

import bpc.daw.consola.*;
import java.awt.Color;

/**
 * Un bolígrafo que puede escribir en la CapaTexto de la Consola DAW
 * @author rperblac
 */
public class Boligrafo {
    /**
     * La lista COLORES guarda los colores con los que puede escribir el bolígrafo. Estos colores son (en este orden): rojo, verde, azul, blanco, amarillo.
     */
    private static final Color[] COLORES;
    private int color;
    private CapaTexto ct;
    static {
        COLORES = new Color[]{Color.RED, Color.GREEN, Color.BLUE, Color.WHITE, Color.YELLOW};
    }
    
    /**
     * Crea un bolígrafo para escribir en la capa de texto que se pasa como parámetro. La propiedad “color” es la posición del color con el que se va a dibujar, dentro la lista COLORES. Inicialmente estará activado el color rojo.
     * @param ct capa de texto en la que se va a escribir (de la libreria ConsolaDAW)
     */
    public Boligrafo(CapaTexto ct) {
        this.ct = ct;
        this.color = 0;
    }
    
    /**
     * Define el color en el que se va a escribir.
     * @param n número de posición del color con el que se va a escribir el texto
     */
    public void setColor(int n) {
        this.color = n;
    }
    
    /**
     * Recibe un String y lo escribe en la capa de texto con el color activo.
     * @param texto texto a escribir
     */
    public void escribir(String texto) {
        this.ct.setColorTexto(COLORES[this.color]);
        this.ct.print(texto);
    }
    
    /**
     * Recibe un String y lo escribe en la capa de texto, usando un color diferente de la lista de colores para cada letra.
     * @param texto texto a escribir
     */
    public void escribirGuay(String texto) {
        for (int i = 0; i < texto.length();i++)
        {
            char c = texto.charAt(i);
            this.ct.setColorTexto(COLORES[this.color]);
            this.ct.print(c);
            if (!Character.isSpaceChar(c))
            {
                if (this.color == (COLORES.length -1)) this.color = 0;
                else this.color++;                
            }
        }
        
    }
}
