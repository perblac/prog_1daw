package e31t2;

/**Enunciado: En la librería Música se encuentran clases para reproducir una sencilla partitura en un instrumento musical. Haz un programa que reproduzca en un piano la siguiente canción. Modifica el programa para que al finalizar, se vuelva a reproducir con una guitarra.
 *
 * @author rperblac
 */
import bpc.daw.musica.*;

public class E31t2 {
    public static void main(String[] args) {
        Cancion cancion = new Cancion("melodia");
//      Piano piano = new Piano();
        Guitarra guitarra = new Guitarra();
        NotaMusical don = new NotaMusical(0,2);
        NotaMusical soln = new NotaMusical(4,2);
        NotaMusical lan = new NotaMusical(5,2);
        NotaMusical solb = new NotaMusical(4,1);
        NotaMusical fac = new NotaMusical(3,3);
        NotaMusical mic = new NotaMusical(2,3);
        NotaMusical res = new NotaMusical(1,4);
        NotaMusical mis = new NotaMusical(2,4);
        NotaMusical fas = new NotaMusical(3,4);
        cancion.añadir(don);
        cancion.añadir(don);
        cancion.añadir(soln);
        cancion.añadir(soln);
        cancion.añadir(lan);
        cancion.añadir(lan);
        cancion.añadir(solb);
        cancion.añadir(fac);
        cancion.añadir(fac);
        cancion.añadir(mic);
        cancion.añadir(mic);
        cancion.añadir(res);
        cancion.añadir(mis);
        cancion.añadir(fas);
        cancion.añadir(res);
        cancion.añadir(don);
//      piano.reproducir(cancion);
        guitarra.reproducir(cancion);                
    }
    
}
