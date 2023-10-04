package e39t3;

/** Enunciado: Repite el ejercicio 22 de esta forma:
    a) Crea una lista para guardar los nombres de los alumnos
    b) Crea una tabla para guardar las notas de los alumnos, de tal forma que la fila 0 guarde
    las notas del alumno que ocupe la posición 0 de la lista y así sucesivamente.
    c) Haz un for para recorrer la lista de alumnos y después de mostrar el nombre de un
    alumno, haz un for anidado que recorra la fila de la tabla donde están sus notas y
    calcule su nota media.
 *
 * @author rperblac
 */
public class E39t3 {

    public static void main(String[] args) {
        String[] alumnos = {"Pepe", "Ana", "Juan", "Guillermo", "Roberta"};
        String espacios = "          ";
        int[][] notas = {
            {9, 5, 4, 3},
            {4, 8, 6, 5},
            {2, 5, 10, 2},
            {0, 0, 5, 0},
            {10, 10, 10, 9}
        };
        float sumatorio, media;
        for (int i = 0; i < 5; i++)
        {
            System.out.print("Alumno: " + alumnos[i].concat(espacios.substring(alumnos[i].length())) + " Nota Media: ");            
            sumatorio = 0;
            for (int j = 0; j<4; j++)
            {
                sumatorio= sumatorio + notas[i][j];
            }
            media = sumatorio / 4;
            System.out.printf("%.2f", media);
            System.out.println();
        }
    }
    
}
