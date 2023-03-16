
package figurasgeometricas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * Representa un rectángulo definido por los dos puntos que se pasan como
 * parámetro. Uno tiene las coordenadas de la esquina superior izquierda del
 * rectángulo y el otro las de la esquina inferior derecha.
 *
 * @author rperblac
 */
public class Rectangulo implements Centrable, Apoyable{
    /**
     * Punto de la esquina superior izquierda
     */
    protected Point esquinaSuperiorIzquierda;
    
    /**
     * Punto de la esquina inferior derecha
     */
    protected Point esquinaInferiorDerecha;
    
    /**
     * Color del rectángulo
     */
    private Color color;
    
    /**
     * Crea un rectángulo con ambas esquinas y un color
     * @param esi esquina superior izquierda
     * @param eid esquina inferior derecha
     * @param c color del rectángulo
     */
    public Rectangulo(Point esi, Point eid, Color c) {
        this.esquinaSuperiorIzquierda = esi;
        this.esquinaInferiorDerecha = eid;
        this.color = c;        
    }

    /**
     * Devuelve el centro del rectángulo
     * @return Point del centro
     */
    @Override
    public Point getCentro() {
        int x = this.esquinaSuperiorIzquierda.x + (this.getLongitudBase() / 2);
        int y = this.esquinaSuperiorIzquierda.y + (this.getLongitudAltura() / 2);
        return new Point(x,y);
    }

    /**
     * Devuelve la longitud de la basa
     * @return longitud de la basa
     */
    @Override
    public int getLongitudBase() {
        return (this.esquinaInferiorDerecha.x - this.esquinaSuperiorIzquierda.x);
    }

    /**
     * Devuelve la altura
     * @return altura
     */
    @Override
    public int getLongitudAltura() {
        return (this.esquinaInferiorDerecha.y - this.esquinaSuperiorIzquierda.y);
    }

    @Override
    public double getArea() {
        return (double) this.getLongitudBase() * this.getLongitudAltura();
    }

    @Override
    public int getPerimetro() {
        return this.getLongitudAltura() * 2 + this.getLongitudBase() * 2;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(this.color);
        g.setPaintMode();        
        g.drawRect(this.esquinaSuperiorIzquierda.x, this.esquinaSuperiorIzquierda.y, this.getLongitudBase(), this.getLongitudAltura());
        g.fillRect(this.esquinaSuperiorIzquierda.x, this.esquinaSuperiorIzquierda.y, this.getLongitudBase(), this.getLongitudAltura());
    }

}
