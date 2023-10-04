package e1t3;

/** Enunciado: Realiza un programa en el que haya 5 archivos mp3 y se muestre en pantalla una lista numerada con los títulos de las 5 canciones (por ejemplo: 1 – Jackson.mp3). El usuario introducirá un número del 1 al 5 y se usará el bloque switch-case para reproducir la canción elegida por el usuario.
 *
 * @author rperblac
 */
import bpc.daw.reproductor.*;
import java.util.Scanner;

public class E1t3 {

    public static void main(String[] args) {
        ArchivoMP3 cancion1, cancion2, cancion3, cancion4, cancion5;
        cancion1 = new ArchivoMP3("./cancion1.mp3");
        cancion2 = new ArchivoMP3("./cancion2.mp3");
        cancion3 = new ArchivoMP3("./cancion3.mp3");
        cancion4 = new ArchivoMP3("./cancion4.mp3");
        cancion5 = new ArchivoMP3("./cancion5.mp3");
        System.out.println("Menú musical\n------------");
        System.out.println("1 - " + cancion1.getTitulo());
        System.out.println("2 - " + cancion2.getTitulo());
        System.out.println("3 - " + cancion3.getTitulo());
        System.out.println("4 - " + cancion4.getTitulo());
        System.out.println("5 - " + cancion5.getTitulo());
        boolean bien = false;
        int opcion = 0;
        while (!bien)
        {
            System.out.print("Escoja 1 a 5: ");
            try
            {
                opcion = new Scanner(System.in).nextInt();
                bien = true;
            } catch (Exception e)
            {
                System.out.println("Por favor introduzca un número entre 1 y 5");
                bien = false;
            }
            if ((opcion<1||opcion>5)&&bien)
            {
                System.out.println("Por favor introduzca un número entre 1 y 5");
                bien = false;
            }
        }
        Reproductor escuchar = null;
        switch (opcion)
        {
            case 1:
                escuchar = new Reproductor(cancion1, false, true);
                break;
            case 2:
                escuchar = new Reproductor(cancion2, false, true);
                break;
            case 3:
                escuchar = new Reproductor(cancion3, false, true);
                break;
            case 4:
                escuchar = new Reproductor(cancion4, false, true);
                break;
            case 5:
                escuchar = new Reproductor(cancion5, false, true);
                break;
        }
        escuchar.play();
    }
    
}
