package e52t2;

/** Enunciado: En este ejercicio vamos a guardar las asociaciones entre la matrícula de un coche
y el color de dicho coche. Consulta la documentación de la interfaz Map<K,V>, la clase
HashMap<K,V> y la clase Color del paquete java.awt y haz un programa que haga esto:
    a) Crea un Map<String,Color> y rellenarlo con un HashMap<String,Color> vacío
    b) Añade al objeto creado en el apartado anterior estas asociaciones:
        12535ABC Color rojo
        98525KWX Color amarillo
        17632MSE Color verde
        85321ABC Color amarillo
    c) Muestra en pantalla el tamaño del map
    d) Llama al método toString del map y muestra lo que produce por pantalla
    e) Muestra en pantalla el color del coche cuya matrícula se introduce por teclado. En
    caso de introducir una matrícula que no esté en el map, se mostrará el mensaje “No
    existe esa matrícula”
 *
 * @author rperblac
 */
import java.awt.Color;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class E52t2 {
    public static String dimecolor(String c) {
        switch (c)
        {
            case "java.awt.Color[r=255,g=0,b=0]":
                return "rojo";
            case "java.awt.Color[r=0,g=255,b=0]":
                return "verde";
            case "java.awt.Color[r=255,g=255,b=0]":
                return "amarillo"; 
            default:
                return "[sin-color]";
        }
        
}
    public static void main(String[] args) {
// a) Crea un Map<String,Color> y rellenarlo con un HashMap<String,Color> vacío        
        Map<String,Color> mapa = new HashMap();
        
// b) Añade al objeto creado en el apartado anterior estas asociaciones        
        mapa.put("12535ABC", Color.red);
        mapa.put("98525KWX", Color.yellow);
        mapa.put("17632MSE", Color.green);
        mapa.put("85321ABC", Color.yellow);
        
// c) Muestra en pantalla el tamaño del map        
        System.out.println("El tamaño del mapa es " + mapa.size());
        
// d) Llama al método toString del map y muestra lo que produce por pantalla        
        System.out.println("El método toString del mapa produce lo siguiente:\n" + mapa.toString());
        
// e) Muestra en pantalla el color del coche cuya matrícula se introduce por teclado. En caso de introducir una matrícula que no esté en el map, se mostrará el mensaje “No existe esa matrícula”        
        boolean matriculacorrecta = false;
        String matricula = null;
        while (!matriculacorrecta)
        {
            System.out.print("Introduzca matrícula: ");
            matricula = new Scanner(System.in).next();
            if (mapa.containsKey(matricula))
            {
                matriculacorrecta = true;
            }
            else
            {
                System.out.println("No existe esa matrícula");
            }
        }
        String colorcoche = mapa.get(matricula).toString();
        System.out.println("El coche con matrícula " + matricula + " es de color " + dimecolor(colorcoche));
        
    }
    
}
