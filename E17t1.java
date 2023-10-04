/**Enunciado:  Considera la función f(x) = (3*(x/2)^3)/(x^2-x+3). Haz un programa que muestre por pantalla los valores de f(0), f(1) y f(-2)
 *
 * @author rperblac
 */
public class E17t1 {

    public static void main(String[] args) {
        float valor, resultado;
        valor=0;
        resultado = (float) (3.0*((valor/2)*(valor/2)*(valor/2)))/((valor*valor)-valor+3);
        System.out.println("f(0): "+resultado);
        valor = 1;
        resultado = (float) (3.0*((valor/2)*(valor/2)*(valor/2)))/((valor*valor)-valor+3);
        System.out.println("f(1): "+resultado);
        valor = -2;
        resultado = (float) (3.0*((valor/2)*(valor/2)*(valor/2)))/((valor*valor)-valor+3);
        System.out.println("f(-2): "+resultado);
        
    }

}
