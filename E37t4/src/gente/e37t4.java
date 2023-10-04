
package gente;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Lista de diez personas ordenadas por altura
 * @author rperblac
 */
public class e37t4 {

    public static void main(String[] args) {
        List<Persona> grupo = new ArrayList<>();
        String[] nombres = {"Jose", "Ignacio", "Estefanía", "María", "Javier", "Manuel", "Juan", "Inés", "Carlos", "Cristina"};
        for (String nombre:nombres)
        {
            grupo.add(new Persona(nombre));
        }
        Collections.sort(grupo);
        for (Persona p:grupo)
        {
            System.out.println(p.getNombre() + ": " + p.getAltura() + " m.");
        }
    }

}
