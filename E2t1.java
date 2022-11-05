/*  Enunciado:  En el ejercicio 1 coloca un comentario de bloque al principio explicando lo que hace el programa, el nombre del autor, el número de versión del programa y la fecha en que se programó. Añade comentarios de línea que consideres apropiados para explicar lo que va haciendo el programa.

    Este programa imprime unos datos por pantalla
    Autor: Rubén Perblac
    Version 1.0
    Fecha 25-sept-2022
*/
public class E2t1 {

    public static void main(String[] args) {
        int nif = 78787878;//número de dni en un int
        char letradni = 'A'; // char va entre comillas simples
        System.out.println("Dni: "+ nif + letradni);
        String nombre = "Rubén", apellidos = "Perblac";//dos cadenas String para nombre y apellidos
        System.out.println("Nombre: " + nombre + "\nApellidos: " + apellidos);
        int dia = 1, mes = 1, año = 1981;//tres int para dia mes y año
        System.out.println("Fecha de nacimiento: " + dia + "/" + mes + "/" + año);
        int edad = 40;//la edad se podria calcular a partir del dato anterior (a investigar)
        System.out.println("Edad: " + edad);
        String direccion = "C/ Baker nº 221B", localidad = "Granada";
        System.out.println("Dirección: " + direccion + "\nLocalidad: " + localidad);//el salto de line está ahi porque el enunciado del ejercicio pedia una línea por dato
        int telefono = 622626262;
        System.out.println("Teléfono: " + telefono);
        String email = "rperb@granada.es";
        System.out.println("E-mail: " + email);
    }
    
}
