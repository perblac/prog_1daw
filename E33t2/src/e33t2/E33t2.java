package e33t2;

/**Enunciado: Haz un programa que cree una lista de reproducción titulada “Lista de Ejemplo” y añádele tres canciones a ellas. El programa deberá guardar dicha lista en el disco duro (puedes inventar el nombre del archivo) y luego reproducir las tres canciones de forma síncrona.
 *
 * @author rperblac
 */
import bpc.daw.reproductor.*;

public class E33t2 {
    public static void main(String[] args) {
// Crea la lista vacia
        PlayList lista = new PlayList();
// Asigna un nombre a la lista
        lista.setTitulo("Lista de Ejemplo");
        
// Añade tres canciones
        ArchivoMP3 cancion1 = null, cancion2 = null, cancion3 = null;
        String rutacancion1 = "./cancion1.mp3";
        String rutacancion2 = "./cancion2.mp3";
        String rutacancion3 = "./cancion3.mp3";
        
        try
        {
            cancion1 = new ArchivoMP3(rutacancion1);
        } catch (Exception error)
        {
            System.out.println("No se pudo cargar "+rutacancion1);
            System.out.println(error);
        }
        
        try
        {
            cancion2 = new ArchivoMP3(rutacancion2);
        } catch (Exception error)
        {
            System.out.println("No se pudo cargar "+rutacancion2);
            System.out.println(error);
        }
        
        try
        {
            cancion3 = new ArchivoMP3(rutacancion3);
        } catch (Exception error)
        {
            System.out.println("No se pudo cargar "+rutacancion3);
            System.out.println(error);
        }
        
        ArchivoMP3[] variascanciones = {cancion1, cancion2, cancion3};
        lista.añadirVarias(variascanciones);

// Guarda la lista en el disco duro        
        try
        {
            lista.guardar("./lista.txt");
        } catch (Exception error)
        {
            System.out.println("No se pudo guardar la lista");
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
