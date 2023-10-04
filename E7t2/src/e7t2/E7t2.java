package e7t2;

/**Enunciado: Haz un proyecto nuevo y añade la librería “ObjetosSencillos.jar”. En dicha librería encontrarás la clase DepósitoAgua. Haz un programa en el que haya un depósito de agua con capacidad máxima 50 litros y capacidad inicial 15 litros. Dibújalo en la pantalla y calcula el tanto por ciento de ocupación del depósito.
 *
 * @author rperblac
 */
import bpc.daw.objetos.*;

public class E7t2 {

    public static void main(String[] args) {
        int capacidad = 50, cantidad = 15;
        DepositoAgua d = new DepositoAgua(capacidad, cantidad);
        d.dibujar();
        float porcentajeocupacion = ((cantidad * 100) / capacidad);
        System.out.println("Porcentaje: " + porcentajeocupacion + "%");
    }

}
