package e4t2;

/**Enunciado: Haz un programa en el que se cree un muñeco de Luigi situado a una distancia en diagonal, de 500 píxeles a partir de la esquina superior izquierda de la pantalla, y un muñeco de Mario a su lado. El programa deberá mostrar por pantalla las coordenadas (x,y) en la que se encuentran los dos muñecos.
 *
 * @author rperblac
 */
import bpc.daw.mario.*;
public class E4t2 {

    public static void main(String[] args) {
        Luigi l = new Luigi(500);
        Mario m = new Mario(l, 0);
        System.out.println("(x,y) Luigi: ("+l.getX()+","+l.getY()+"); (x,y) Mario: ("+m.getX()+","+m.getY()+")");
    }
    
}
