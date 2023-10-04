/**Enunciado:Haz un programa que muestre el siguiente texto por pantalla, teniendo en cuenta que los datos que aparecen subrayados deben encontrase guardados en variables.
	El <viernes> día <26> de <mayo> tendrá lugar la reunión de evaluación del <1>º curso de <programación de
	aplicaciones web> en el <IES HLanz> de <Granada>. Los profesores calificarán al alumnado y se prevé que a
	las <20:30> horas las notas estén publicadas en el tablón de anuncios del centro.
 *
 * @author rperblac
 */
public class E8t1 {
    public static void main(String[] args) {
        String nombreDia = "viernes", mes = "mayo", curso = "programación de aplicaciones web", centro = "IES HLanz", ciudad = "Granada", hora = "20:30";
        int dia = 26, nivel = 1;
        System.out.println("El " + nombreDia + " día " + dia + " de " + mes + " tendrá lugar la reunión de evaluación del " + nivel + "º curso de " + curso + " en el " + centro + " de " + ciudad + ". Los profesores calificarán al alumnado y se prevé que a las " + hora + " horas las notas estén publicadas en el tablón de anuncios del centro.");
    }
}
