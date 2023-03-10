package figurasgeometricas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * Representa un círculo e implementa todas las interfaces asociadas.
 *
 * @author rperblac
 */
public class Circulo implements FiguraGeometrica, Centrable {

    /**
     * Centro del círculo
     */
    private Point centro;
    
    /**
     * Radio del círculo
     */
    private int radio;
    
    /**
     * Color del círculo
     */
    private Color color;

    /**
     * Crea un círculo con un centro, un radio y un color
     *
     * @param centro centro del círculo
     * @param radio radio del círculo
     * @param color color del círculo
     */
    public Circulo(Point centro, int radio, Color color) {
        this.centro = centro;
        this.radio = radio;
        this.color = color;
    }
    
    /**
     * Devuelve el área del círuclo
     * @return área del círculo
     */
    public double getArea() {
        return Math.PI * (Math.pow(radio, 2));
    }
    
    /**
     * Devuelve el perímetro del círculo
     * @return perímetro del círculo
     */
    public int getPerimetro() {
        return (int) Math.round(2 * Math.PI * this.radio);
    }
    
    /**
     * Recibe un objeto Graphics y dibuja con él el círculo
     * @param g objeto Graphics donde se dibujará el círculo
     */
    public void dibujar(Graphics g) {
        g.setColor(this.color);
        g.drawOval(this.centro.x - this.radio, this.centro.y - this.radio, this.radio * 2, this.radio * 2);
    }
    
    /**
     * Devuelve un cuadrado que tenga igual área que el círculo. Dicho cuadrado
     * tiene como esquina superior izquierda el Point pasado como parámetro.
     *
     * @param esquinaSuperiorIzquierda esquina superior izquierda del cuadrado que se devolverá
     * @return cuadrado de igual área que la figura
     */
    @Override
    public Cuadrado crearCuadradoIgualArea(Point esquinaSuperiorIzquierda) {
        double lado = Math.sqrt(this.getArea());
        return new Cuadrado(esquinaSuperiorIzquierda, Math.round(lado), this.color);
    }
    
    /**
     * Devuelve el centro del círculo
     * @return Point del centro
     */
    @Override
    public Point getCentro() {
        return this.centro;
    }

    /**
     * Devuelve el color del círculo
     * @return Color del círculo
     */
    @Override
    public Color getColor() {
        return this.color;
    }
}
