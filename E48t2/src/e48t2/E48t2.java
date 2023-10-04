package e48t2;

/** Enunciado: En la librería “Objetos Sencillos” está la clase MarcadorMejorado. Haz un programa en el que se cree un partido de baloncesto para el partido que van a jugar el Estudiantes y el CB Granada. Registra las siguientes canastas y muestra el nombre de los equipos, los puntos que tiene cada uno, el nombre del equipo que va ganando y el que va perdiendo. Compara el código con el del ejercicio 12. ¿Cuál crees que es mejor?
    E ->2, CB -> 3, E->2, CB->2, CB->3, E->1, E->1, CB->2
 *
 * @author rperblac
 */
import bpc.daw.objetos.MarcadorMejorado;

public class E48t2 {

    public static void main(String[] args) {
        String equipolocal = "Estudiantes", equipovisitante = "CB Granada";
        MarcadorMejorado marcador = new MarcadorMejorado(equipolocal, equipovisitante);
        marcador.anotarCanasta(marcador.CANASTA_LOCAL, marcador.NORMAL);
        marcador.anotarCanasta(marcador.CANASTA_VISITANTE, marcador.TRIPLE);
        marcador.anotarCanasta(marcador.CANASTA_LOCAL, marcador.NORMAL);
        marcador.anotarCanasta(marcador.CANASTA_VISITANTE, marcador.NORMAL);
        marcador.anotarCanasta(marcador.CANASTA_VISITANTE, marcador.TRIPLE);
        marcador.anotarCanasta(marcador.CANASTA_LOCAL, marcador.TIRO_LIBRE);
        marcador.anotarCanasta(marcador.CANASTA_LOCAL, marcador.TIRO_LIBRE);
        marcador.anotarCanasta(marcador.CANASTA_VISITANTE, marcador.NORMAL);
        System.out.println(marcador.getNombreLocal() + ": " + marcador.getPuntosLocal() + " puntos");
        System.out.println(marcador.getNombreVisitante() + ": " + marcador.getPuntosVisitante() + " puntos");
        System.out.println("Va ganando: " + marcador.getNombreEquipoGanador() + "\nVa perdiendo: " + marcador.getNombreEquipoPerdedor());
    }
    
}
