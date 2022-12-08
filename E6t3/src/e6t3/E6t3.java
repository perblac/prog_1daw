package e6t3;

/** Enunciado: Usa la Consola DAW para hacer un programa que pregunte al usuario por la ruta de
una imagen y la ponga como imagen de fondo. El programa entonces preguntará "¿Desea
poner otra imagen?". Si el usuario pulsa la tecla S, se repetirá el proceso, y si pulsa cualquier
otra tecla, finalizará.
 *
 * @author rperblac
 */
import bpc.daw.consola.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class E6t3 {

    public static void main(String[] args) {
        String entrada;
        Consola cons = new Consola();
        Teclado tecl = cons.getTeclado();
        CapaTexto capat = cons.getCapaTexto();
        CapaFondo capaf = cons.getCapaFondo();
        BufferedImage imagen = null;
        File cargarimagen;
        char leetecla;
        boolean imagenvalida = false; // ¿Es la ruta a la imagen correcta?
        boolean salir; // ¿Salimos del programa?
        do  // Bucle principal
        {            
            do  // Bucle de entrada de imagen
            {
                entrada = null;
                try
                {
                    capat.println("Introduzca la ruta a una imagen: ");
                    entrada = tecl.leerCadenaCaracteres();
                    cargarimagen = new File(entrada);
                    imagen = ImageIO.read(cargarimagen);
                    if (cargarimagen.exists()) imagenvalida = true;
                } catch (IOException e)
                {
                    capat.println(e.getLocalizedMessage());
                    imagenvalida = false;
                }
            } while (!imagenvalida);
            
            // Ponemos la imagen como fondo
            FondoImagen fondo = new FondoImagen(imagen);
            fondo.setEscalado(true);            
            capaf.setFondo(fondo);
                        
            capat.println("¿Desea poner otra imagen? (S/N)");            
            leetecla = tecl.leerCaracter();
            capat.saltoLinea();
            salir = ((leetecla != 'S') && (leetecla != 's')); // Solo salimos si la tecla pulsada es 'S' o 's'
            
        } while (!salir);
    }
    
}
