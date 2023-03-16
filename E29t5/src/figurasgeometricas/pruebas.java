
package figurasgeometricas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Pruebas de las clases de figuras geométricas
 * @author rperblac
 */
public class pruebas {

    public static void main(String[] args) {
        // Puntos a, b y c para el triángulo
        Point a = new Point (10,10);
        System.out.println("a:" + a.toString());
        Point b = new Point (50,10);
        System.out.println("b:" + b.toString());
        Point c = new Point (10,40);
        System.out.println("c:" + c.toString());
        Triangulo t = new Triangulo(a, b, c);
        
        // Esquinas superior izquierda e inferior derecha para el rectángulo
        Point esi = new Point(100,10);
        Point eid = new Point(160, 30);
        Rectangulo r = new Rectangulo(esi, eid, Color.CYAN);
        
        // Centro y radio para el círculo
        Point centro = new Point(60,60);
        int radio = 25;
        Circulo cir = new Circulo(centro, radio, Color.GREEN);
        
        // Esquina superior izquierda y longitud del lado para el cuadrado
        Point cuadEsi = new Point(80, 120);
        int lado = 40;
        Cuadrado cuad = new Cuadrado(cuadEsi, lado, Color.ORANGE);
        
        // Métodos de obtención de datos del triángulo
        int base = t.getLongitudBase();
        int alt = t.getLongitudAltura();
        double area = t.getArea();
        int perim = t.getPerimetro();
        
        // Salida por consola de dichos datos
        /*
        System.out.println("base: " + base);
        System.out.println("altura: " + alt);
        System.out.println("area: " + area);
        System.out.println("perimetro: " + perim);
        */
        
        // Creamos un panel para la salida gráfica
        JPanel panel = new JPanel();
        // Nuevo frame con nombre "Dibujar Figuras"
        JFrame frame = new JFrame("Dibujar Figuras");
        // Que salga del programa al cerrarlo
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // De tamaño fijo
        frame.setResizable(false);
        
        // Añadimos el panel al frame
        frame.add(panel);
        
        // Configuramos el frame a 400x400 px y lo hacemos visible para poder obtener el objeto Graphics
        int ancho = 400, alto = 400;
        frame.setSize(ancho, alto);
        frame.setVisible(true);
        
        // Obtenemos el objeto Graphics para dibujar
        Graphics g = panel.getGraphics();
        
        // Ponemos el color a gris
        g.setColor(Color.lightGray);
        g.setPaintMode();
        
// linea mágica
        System.out.print(g.toString());
        
        // Hacemos una rejilla de 10 px de ancho
        for (int i = 1; i <= ancho +1; i += 10)
        {
// otra linea mágica            
            //System.out.print(g.toString());
            g.drawLine(i, 0, i, alto);
            g.drawLine(0, i, ancho, i);
        }
        
        // Dibujamos las figuras
        t.dibujar(g);
        r.dibujar(g);
        cir.dibujar(g);
        cuad.dibujar(g);
        
        // Escribimos los datos del triángulo
        g.setColor(Color.red);
        g.setFont(new Font("arial",0,14));
        g.drawString("v1: " + a.x + ", " + a.y + " - v2: " + b.x + ", " + b.y + " - v3: " + c.x + ", " + c.y, 10, alto/2 - 12);
        g.drawString("base: " + base + " altura: " + alt + " area: " + area + " perimetro: " + perim, 10, alto/2);
    }

}
