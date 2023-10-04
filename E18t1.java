/**Enunciado: Un estudiante de universidad cobra 7€ por cada hora de sus clases particulares. Haz un programa que muestre por pantalla:
	a) Cuánto ganará en un mes si tiene dos alumnos, a los que les da 2 y 3 clases semanales respectivamente.
	b) ¿Cuántas horas de clase debe dar al mes si quiere ganar 900€?
 *
 * @author rperblac
 */
public class E18t1 {

    public static void main(String[] args) {
        int cobrahora = 7;
        System.out.println("¿Cuánto gana en un mes con dos a lumnos, a 2 y 3 horas semanales?"+((cobrahora*2*4)+(cobrahora*3*4)));
        System.out.println("Horas al mes para ganar 900€: "+900/cobrahora);        
    }
    
}
