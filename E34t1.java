/**Enunciado: : Realiza un programa con las variables que aparecen a continuación, y a continuación muestre por pantalla su suma y su producto.
	String n1 = "125";
	String n2 = "456";
 *
 * @author rperblac
 */
public class E34t1 {

    public static void main(String[] args) {
        String n1 = "125";
        String n2 = "456";
        int suma = (Integer.parseInt(n1))+(Integer.parseInt(n2));
        int producto = (Integer.parseInt(n1))*(Integer.parseInt(n2));
        System.out.println("Suma: "+suma+"\nProducto: "+producto);
    }
    
}
