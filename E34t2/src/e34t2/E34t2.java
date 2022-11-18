package e34t2;

/**Enunciado: Haz un programa que cargue la lista de reproducción guardada en el ejercicio anterior y la reproduzca de forma síncrona.
 *
 * @author rperblac
 */
import bpc.daw.reproductor.*;

public class E34t2 {
    public static void main(String[] args) {
        String ruta = "./lista.txt";
        
// Carga la lista
        PlayList lista = null;
        try
        {
            lista = new PlayList(ruta);
        } catch (Exception error)
        {
            System.out.println("No se pudo cargar la lista");
            System.out.println(error);
        }
        
// Reproduce las canciones de la lista
        Reproductor escuchar = null;
        try
        {
            escuchar = new Reproductor(lista,false,true);
        } catch (Exception error)
        {
            System.out.println(error);
        }
        
        escuchar.play();
    }
    
}
