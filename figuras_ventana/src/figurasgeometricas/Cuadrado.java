
package figurasgeometricas;

import java.awt.Color;
import java.awt.Point;

/**
 * Tipo de rectángulo que tiene todos sus lados iguales. Está definido mediante la longitud de su lado y el punto cuyas coordenadas son la esquina superior izquierda del cuadrado.
 * @author rperblac
 */
public class Cuadrado extends Rectangulo{
    private int longitudLado;
    public Cuadrado(Point esquinaSuperiorIzquierda, int longitudLado, Color color) {
        super(esquinaSuperiorIzquierda, new Point(esquinaSuperiorIzquierda.x + longitudLado, esquinaSuperiorIzquierda.y + longitudLado), color);
    }
}
