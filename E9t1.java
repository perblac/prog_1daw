/**Enunciado:Realiza una copia del archivo del ejercicio anterior. Sobre la copia, haz las modificaciones oportunas para que el programa nos informe de que la reunión de evaluación de 1º de ESO será el lunes 20 de junio y que las notas se publicarán a las 13:45.
 *
 * @author rperblac
 */
public class E9t1 {
    public static void main(String[] args) {
		String nombreDia = "lunes", mes = "junio", curso = "ESO", centro = "IES HLanz", ciudad = "Granada", hora = "13:45";
        int dia = 20, nivel = 1;
        System.out.println("El " + nombreDia + " día " + dia + " de " + mes + " tendrá lugar la reunión de evaluación del " + nivel + "º curso de " + curso + " en el " + centro + " de " + ciudad + ". Los profesores calificarán al alumnado y se prevé que a las " + hora + " horas las notas estén publicadas en el tablón de anuncios del centro.");
    }
}
