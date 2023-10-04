package e12t2;

/**Enunciado: En la librería ObjetosSencillos.jar se encuentra la clase MarcadorBaloncesto. Haz un programa en el que se cree un partido de baloncesto para el partido que van a jugar el Estudiantes y el CB Granada. Registra las siguientes canastas y muestra el nombre de los equipos, los puntos que tiene cada uno, el nombre del equipo que va ganando y el que va perdiendo.
    E ->2, CB -> 3, E->2, CB->2, CB->3, E->1, E->1, CB->2
 *
 * @author rperblac
 */
import bpc.daw.objetos.MarcadorBaloncesto;

public class E12t2 {

    public static void main(String[] args) {
        String visitante, local, ganador, perdedor;
        int puntosl, puntosv;
        MarcadorBaloncesto marcador = new MarcadorBaloncesto("Estudiantes", "CB Granada");
        marcador.anotarCanasta('L', 2);
        marcador.anotarCanasta('V', 3);
        marcador.anotarCanasta('L', 2);
        marcador.anotarCanasta('V', 2);
        marcador.anotarCanasta('V', 3);
        marcador.anotarCanasta('L', 1);
        marcador.anotarCanasta('L', 1);
        marcador.anotarCanasta('V', 2);
        local = marcador.getNombreLocal();
        visitante = marcador.getNombreVisitante();
        ganador = marcador.getNombreEquipoGanador();
        perdedor = marcador.getNombreEquipoPerdedor();
        puntosl = marcador.getPuntosLocal();
        puntosv = marcador.getPuntosVisitante();
        System.out.println("Equipo Local: " + local + " con " + puntosl + " puntos"
                + "\t\tEquipo Visitante: " + visitante + " con " + puntosv + " puntos\nGanando: " + ganador + "\nPerdiendo: " + perdedor);
    }

}
