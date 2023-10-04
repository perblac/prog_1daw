/**Enunciado: Repite el ejercicio 1 usando variables para almacenar los datos. ¿Qué ventajas o inconvenientes observas con respecto a dicho ejercicio?
 *
 * @author rperblac
 */
import java.util.Scanner;

public class E7t1 {
    public static void main(String[] args) {
        int ruben = 1, perblac = ruben + 10;
        String var1 = "ruben", var2 = "perblac";
        boolean verdad = true;
        System.out.print("La variable " + var1 + " vale " + ruben + " y la variable " + var2 + " vale " + perblac);
        System.out.println("\nNo verdad: " + !verdad + " verdad: " + verdad);
        int cubo = perblac * perblac;
        System.out.println("11²: " + perblac * perblac + "\t11³: " + perblac * perblac * perblac + "\t11⁴: " + cubo * cubo);
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        String leido = leer.next();
        System.out.println(leido);
        String javaver, javahome, osname, osarch, osver;
        osname = System.getProperty("os.name");
        osarch = System.getProperty("os.arch");
        osver = System.getProperty("os.version");
        javaver = System.getProperty("java.version");
        javahome = System.getProperty("java.home");
        System.out.println("Versión java: " + javaver);
        System.out.println("Home: " + javahome);
        System.out.println("S.O.: " + osname + " " + osarch + " " + osver);
        System.exit(0);
    }
}
