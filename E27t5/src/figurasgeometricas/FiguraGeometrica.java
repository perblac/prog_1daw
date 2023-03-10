
package figurasgeometricas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * Una figura geométrica cualquiera.
 * @author rperblac
 */

public interface FiguraGeometrica extends Coloreable{
    /**
     * Devuelve el área de la figura
     * @return área de la figura
     */
    public double getArea();
    /**
     * Devuelve el perímetro de la figura
     * @return perímetro de la figura
     */
    public int getPerimetro();
    /**
     * Recibe un objeto Graphics y dibuja con él la figura
     * @param g objeto Graphics donde se dibujará la figura
     */
    public void dibujar(Graphics g);
    /**
     * Devuelve un cuadrado que tenga igual área que la figura. Dicho cuadrado
     * tiene como esquina superior izquierda el Point pasado como parámetro.
     *
     * @param esquinaSuperiorIzquierda esquina superior izquierda del cuadrado que se devolverá
     * @return cuadrado de igual área que la figura
     */
    public default Cuadrado crearCuadradoIgualArea(Point esquinaSuperiorIzquierda) {        
        double lado = Math.sqrt(this.getArea());
        return new Cuadrado(esquinaSuperiorIzquierda, Math.round(lado), Color.black);
    }
}
