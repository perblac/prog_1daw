package e35t2;

/**Enunciado: Realiza las siguientes tareas y responde las preguntas que se indican:
    a) Crea dos objetos diferentes ArchivoMP3, pero que usen la misma ruta de archivo.
        a. Compáralos con el signo == como si fuesen tipos básicos. ¿Qué sucede?
        b. Compáralos con el método equals. ¿Qué sucede?
        c. Muestra los hashCode de dichos objetos. ¿Coinciden?
    b) Crea un objeto Reproductor y muestra por pantalla la salida de su método toString. ¿Qué aparece?
    c) Crea un objeto ArchivoMP3 y muestra por pantalla la salida de su método toString. ¿Qué aparece? ¿Tiene el mismo formato que la salida de toString de Reproductor? ¿a qué crees que puede ser debido?
 *
 * @author rperblac
 */
import bpc.daw.reproductor.*;

public class E35t2 {

    public static void main(String[] args) {
// a)
        ArchivoMP3 objetomp3_1, objetomp3_2;
        String ruta = "./cancion.mp3";
        objetomp3_1 = new ArchivoMP3(ruta);
        objetomp3_2 = new ArchivoMP3(ruta);
        
        // a.
        try
        {
            System.out.print("a)a. Comparados con \"==\"");
            if (objetomp3_1==objetomp3_2)
            {
                System.out.println(" son iguales " + objetomp3_1 + " " + objetomp3_2);
            } else
            {
                System.out.println(" son distintos " + objetomp3_1 + " " + objetomp3_2);
            }
        } catch (Exception error)
        {
            System.out.println(" " + error);
        }
        
        // b.
        try
        {
            System.out.print("a)b. Comparados con \".equals\"");
            if (objetomp3_1.equals(objetomp3_2))
            {
                System.out.println(" son iguales " + objetomp3_1 + " " + objetomp3_2);
            } else
            {
                System.out.println(" son distintos " + objetomp3_1 + " " + objetomp3_2);
            }
        } catch (Exception error)
        {
            System.out.println(" " + error);
        }
        
        // c.
        System.out.print("a)c. " + objetomp3_1.hashCode() + " " + objetomp3_2.hashCode());
        if ((objetomp3_1.hashCode())==(objetomp3_2.hashCode()))
        {
            System.out.println(". Son iguales");
        } else
        {
            System.out.println(". Son distintos");
        }
        
// b)
        Reproductor escuchar;
        escuchar = new Reproductor(objetomp3_1,false,false);
        System.out.println("b) " + escuchar.toString());
        
// c)   Respuestas: ¿Tiene el mismo formato que la salida de toString de Reproductor? No ¿a qué crees que puede ser debido? A que el objeto ArchivoMP3 tiene su propio metodo toString()
        ArchivoMP3 objetomp3_3;
        objetomp3_3 = new ArchivoMP3(ruta);
        System.out.println("c) " + objetomp3_3.toString());
    }
    
}
