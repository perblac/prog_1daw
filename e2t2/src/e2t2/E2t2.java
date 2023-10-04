package e2t2;

/**Enunciado: Consulta la documentación de la librería Mario Bros y haz un programa que cree los siguientes objetos en la pantalla:
a) Dos muñecos de Mario, uno a 100 píxeles de distancia de la esquina superior izquierda de la pantalla y otro en las coordenadas (640,320)
b) Una Seta en la esquina superior izquierda de la pantalla
c) Un cañón en las coordenadas (100,320)
d) Tres plantas en las coordenadas (400,500), (450,500) y (500,500)
e) Un muñeco de Luigi situado a 200 píxeles de la esquina superior izquierda de la pantalla y uno de Mario situado a 50 píxeles horizontales de él.
 *
 * @author rperblac
 */
import bpc.daw.mario.*;

public class E2t2 {

    public static void main(String[] args) {
        Mario n = new Mario(100);
        Mario o = new Mario(640,320);
        Seta s = new Seta(0,0);
        Cañon c = new Cañon(100,320);
        Planta p1 = new Planta(400,500);
        Planta p2 = new Planta(450,500);
        Planta p3 = new Planta(500,500);
        Luigi l = new Luigi(200);
        Mario m = new Mario(l,50);
    }
    
}
