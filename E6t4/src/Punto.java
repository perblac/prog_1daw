
import java.awt.Toolkit;


/**
 * Un punto de la pantalla que está en unas coordenadas (x,y) comprendidas entre 0 y el tamaño de la pantalla
 *
 * @author rperblac
 */
public class Punto {
    /**
     * coordenada horizontal
     */
    public int x;
    /**
     * coordenada vertical
     */
    public int y;
    /**
     * Crea un punto situado en las coordenadas (0,0).
     */
    public Punto() {
        x = 0;
        y = 0;
    }    
    /**
     * Crea un punto situado en las coordenadas (x,y). Si las coordenadas caen fuera de la pantalla el punto se pondrá en la esquina inferior derecha de la pantalla.
     */
    public Punto(int x, int y) {
        if ((x > Toolkit.getDefaultToolkit().getScreenSize().width)||
                (x < 0)||
                (y > Toolkit.getDefaultToolkit().getScreenSize().height)||
                (y < 0))
        {
            this.x = Toolkit.getDefaultToolkit().getScreenSize().width;
            this.y = Toolkit.getDefaultToolkit().getScreenSize().height;
        }
        else
        {
            this.x = x;
            this.y = y;
        }        
    }
    /**
     * Crea un punto situado en el punto medio del origen (0,0) y el punto pasado como parámetro.
     */
    public Punto(Punto p) {
        this.x = p.x / 2;
        this.y = p.y / 2;        
    }
    /**
     * Crea un punto situado a un ángulo y distancia del origen.
     */
    public Punto(double angulo, double distancia) {
        // sen(angulo) = lado_contrario / hipotenusa
        // x: cos(angulo) * distancia
        // y: sen(angulo) * distancia
        double ang = Math.toRadians(angulo);
        double x = Math.cos(ang)*distancia;
        double y = Math.sin(ang)*distancia;
        this.x = (int) Math.round(Math.abs(x));
        this.y = (int) Math.round(Math.abs(y));
    }

}
