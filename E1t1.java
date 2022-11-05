/** Enunciado: Ejercicio 1: Haz un programa Java llamado Datos_Juan, Datos_Ana… según tu nombre, que muestre por pantalla tu ficha personal: dni, nombre, apellidos, fecha de nacimiento, edad, dirección, localidad, teléfono y email mostrando cada dato en una línea diferente. Compila y ejecútalo para comprobar que funciona.
 *
 * @author rperc
 */
import java.lang.*;
public class E1t1 {
    public static void main(String[] args) {
        int nif = 78787878;
        char letradni = 'A'; // char va entre comillas simples
        System.out.println("Dni: "+ nif + letradni);
        String nombre = "Rubén", apellidos = "Perblac";
        System.out.println("Nombre: " + nombre + "\nApellidos: "+apellidos);
        int dia = 1, mes = 1, año = 1981;
        System.out.println("Fecha de nacimiento: " + dia + "/" + mes + "/" + año);
        int edad = 40;
        System.out.println("Edad: " + edad);
        String direccion = "C/ Baker nº 221B", localidad = "Granada";
        System.out.println("Dirección: " + direccion + "\nLocalidad: " + localidad);
        int telefono = 622626262;
        System.out.println("Teléfono: " + telefono);
        String email = "rperb@granada.es";
        System.out.println("E-mail: " + email);
    }
    
}
