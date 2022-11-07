package e3t2;

/**Enunciado: Haz un programa en el que se vea un muñeco de Mario, un Luigi, una seta, tres plantas y un cañón situados donde quieras. Realiza con los muñecos las siguientes acciones:
    a) La seta debe moverse hacia la esquina superior izquierda de la pantalla.
    b) El muñeco de Mario debe pegar un salto.
    c) El cañón debe disparar al muñeco de Luigi.
    d) Las plantas tienen que estar comiendo.
 *
 * @author rperblac
 */
import bpc.daw.mario.*;
public class E3t2 {

    public static void main(String[] args) {
        Mario m = new Mario(100,772);
        Luigi g = new Luigi(360,772);
        Seta s = new Seta(500, 772);
        Planta p1 = new Planta(600,772);
        Planta p2 = new Planta(700,772);
        Planta p3 = new Planta(800,772);
        Cañon c = new Cañon(0,752);
        s.andarHacia(0,0);
        m.saltar();
        c.disparar(360,752);
        p1.comer(true);
        p2.comer(true);
        p3.comer(true);
    }
    
}
