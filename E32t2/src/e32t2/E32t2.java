package e32t2;

/**Enunciado: En la librería ReproductorMúsica.jar se encuentran clases para reproducir archivos mp3 y crear listas de reproducción que pueden guardarse en el disco. Su diagrama de clases y documentación vienen en el pdf que acompaña la librería. Realiza un programa que reproduzca en segundo plano (asíncrona) un archivo mp3 que tengas en tu disco duro. Una vez comenzada la reproducción, se mostrará el título de la canción, su autor y su duración.
 *
 * @author rperblac
 */
import bpc.daw.reproductor.*;

public class E32t2 {

    public static void main(String[] args) {

// Carga la canción
        ArchivoMP3 cancion = null;
        try
        {
//          cancion = new ArchivoMP3("./prueba.mp3"); // Este archivo es de más de dos horas, para probar la lectura de duración
            cancion = new ArchivoMP3("./prueba2.mp3");
        } catch (Exception error)
        {
            System.out.println(error);
        }

// Crea el reproductor        
        Reproductor escuchar = null;
        try
        {
            escuchar = new Reproductor(cancion,false,false);
        } catch (Exception error)
        {
            System.out.println(error);
        }

// Lee el título de la canción        
        String titulo = null;
        try
        {
            titulo = cancion.getTitulo();
        } catch (Exception error)
        {
            System.out.println(error);
        }
        
// Lee el autor de la canción        
        String autor = null;
        try
        {
            autor = cancion.getAutor();
        } catch (Exception error)
        {
            System.out.println(error);
        }

// Lee la duración y calcula el tiempo        
        int horas, minutos, segundos, milisegundos = 0;
        
        try
        {
            milisegundos = (int) (cancion.getDuracion());
        } catch (Exception error)
        {
            System.out.println(error);            
        }
        
        segundos = (int) (milisegundos / 1000);
        minutos = (int) (segundos / 60);
        horas = (int) (minutos / 60);

        minutos = minutos - (horas * 60);
        segundos = segundos - (horas * 3600) - (minutos * 60);
        milisegundos = milisegundos % 1000;

// Reproduce la canción        
        escuchar.play();

// Escribe los datos        
        System.out.println("Título: " + cancion.getTitulo());
        System.out.println("Autor: " + cancion.getAutor());
        System.out.println("Duración: " + horas + ":" + minutos + ":" + segundos + "." + milisegundos);
    }
    
}
