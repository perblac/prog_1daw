
package figurasgeometricas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * Un triángulo definido por tres puntos que son sus tres vértices, y su color siempre es azul.
 * @author rperblac
 */
public class Triangulo implements Apoyable{
    private Point[] vertices;
    private Color color;
    public Triangulo(Point v1, Point v2, Point v3) {
        this.vertices = new Point[] {v1, v2, v3};
        this.color = Color.BLUE;
    }

    @Override
    public int getLongitudBase() {
        double dist0 = this.vertices[0].distance(this.vertices[1].x, this.vertices[1].y);
        double dist1 = this.vertices[1].distance(this.vertices[2].x, this.vertices[2].y);
        double dist2 = this.vertices[2].distance(this.vertices[0].x, this.vertices[0].y);
        double mayor = dist2 > (dist0 > dist1 ? dist0 : dist1) ? dist2 : ((dist0 > dist1) ? dist0 : dist1);
        System.out.println("a-b:" + dist0 + " b-c:" + dist1 + " c-a:" + dist2);
        return (int) Math.round(mayor);
    }

    // A = 1/2bh ; h = A / (1/2 * b)
    @Override
    public int getLongitudAltura() {
        int base = this.getLongitudBase();
        double area = this.getArea();
        int altura = (int) Math.round(area / (base * 0.5));
        return altura;
    }

    // área = el valor absoluto de Ax (By - Cy) + Bx (Cy - Ay) + Cx (Ay - By) dividido por 2
    @Override
    public double getArea() {
        double Ax = this.vertices[0].x, Ay = this.vertices[0].y;
        double Bx = this.vertices[1].x, By = this.vertices[1].y;
        double Cx = this.vertices[2].x, Cy = this.vertices[2].y;
        double area = Math.abs(((Ax * (By - Cy)) + (Bx * (Cy - Ay)) + (Cx * (Ay - By)))) / 2;
        return area;
    }

    @Override
    public int getPerimetro() {
        double dist0 = this.vertices[0].distance(this.vertices[1].x, this.vertices[1].y);
        double dist1 = this.vertices[1].distance(this.vertices[2].x, this.vertices[2].y);
        double dist2 = this.vertices[2].distance(this.vertices[0].x, this.vertices[0].y);
        return (int) Math.round(dist0 + dist1 + dist2);
    }

    @Override
    public void dibujar(Graphics g) {
        int[] xs = {(int) this.vertices[0].x,(int) this.vertices[1].x,(int) this.vertices[2].x};
        int[] ys = {(int) this.vertices[0].y,(int) this.vertices[1].y,(int) this.vertices[2].y};
        g.setColor(this.color);
        g.setPaintMode();        
        g.drawPolygon(xs, ys, 3);
        g.fillPolygon(xs, ys, 3);
    }    
    
    @Override
    public Color getColor() {
        return this.color;
    }

}
