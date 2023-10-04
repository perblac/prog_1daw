package e53t2;

/** Enunciado: Repite los apartados a,b,c y d del ejercicio anterior pero rellenando el Map<String,Color> con un TreeMap<String,Color>. ¿Notas alguna diferencia en la salida del programa? Respuesta: No
 *
 * @author rperblac
 */
import java.awt.Color;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;

public class E53t2 {
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
        Map<String,Color> mapa = new TreeMap<String,Color>();
        
        mapa.put("12535ABC", Color.red);
        mapa.put("98525KWX", Color.yellow);
        mapa.put("17632MSE", Color.green);
        mapa.put("85321ABC", Color.yellow);
        
        System.out.println("El tamaño del mapa es " + mapa.size());
        
        System.out.println("El método toString del mapa produce lo siguiente:\n" + mapa.toString());
        
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
