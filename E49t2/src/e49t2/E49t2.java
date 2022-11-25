package e49t2;

/** Enunciado: En la librería “Efecto Imagen” se encuentra la clase EfectoBuilder, que sirve para
aplicar efectos a una imagen. Consulta su documentación y realiza un programa que haga esto:
 Pregunte al usuario la ruta de un archivo con una imagen
 Utiliza la clase ImageIO de la librería “java 2d” para cargar la imagen
 Utiliza la clase EfectoImagen para aplicar, en este orden, los efectos “invertir”,
“blurred” y “escala de grises” a la fotografía.
 Cuando hayas terminado de aplicar los efectos, muestra una ventana en la que se vea
la imagen final.
 *
 * @author rperblac
 */
import daw.efectoimagen.EfectoBuilder;
import java.util.Scanner;
import static java.lang.System.out;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class E49t2 {

    public static void main(String[] args) {
        boolean rutacorrecta = false;
        File archivo = null; 
        do
        {
            out.println("Introduzca imagen: ");
            String ruta = new Scanner(System.in).next();
            
            try
            {
                archivo = new File(ruta);
                if (archivo.exists())
                {
                    rutacorrecta = true;
                } else
                {
                    out.println("No se pudo cargar la imagen\n");
                }
            } catch (Exception error)
            {
                out.println("No se pudo cargar la imagen\n"+error);                
            }

        } while (!rutacorrecta);
        
        BufferedImage imagen = null;
        try
        {
            imagen = ImageIO.read(archivo);
        } catch (Exception error)
        {
            out.println("Error de carga\n"+error);            
        }
        
        EfectoBuilder efecto = null;
        try
        {
            efecto = new EfectoBuilder(imagen);
        } catch (Exception error)
        {
            out.println("Error al crear el generador de efectos\n"+error);
        }
        
        try
        {
            efecto.aplicarEfecto(EfectoBuilder.INVERTIR);
            efecto.aplicarEfecto(EfectoBuilder.BLURRED);
            efecto.aplicarEfecto(EfectoBuilder.ESCALA_GRISES);
            efecto.build();
        } catch (NullPointerException npe)
        {
            out.println("NullPointerException (archivo no existe)\n"+ npe);
        }
                
    }
  
}
