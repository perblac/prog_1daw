
package e26t4;

/**
 *
 * @author rperblac
 */
public class E26t4 {

    public static void main(String[] args) {
        Altavoz a = new Altavoz();
        for (int v = 0; v <= 255; v += 10)
        {
            a.setVolumen(v);
            System.out.println(a.toString());
        }
        System.out.println(a.getClass().getName());
    }

}
