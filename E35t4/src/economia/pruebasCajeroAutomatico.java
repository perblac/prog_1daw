
package economia;

/**
 * Pruebas de la clase CajeroAutomatico
 * @author rperblac
 */
public class pruebasCajeroAutomatico {

    public static void main(String[] args) {
        CajeroAutomatico c = new CajeroAutomatico();
        for (int i = 0; i < 10;i++)
        {
            System.out.println(c.añadirDinero(187));
            System.out.println(c.getDineroTotal());
            System.out.println("50:" + c.getTotal50() + "\n20:" + c.getTotal20() + "\n10:" + c.getTotal10() + "\n5:" + c.getTotal5() + "\n1:" + c.getTotal1());
        }
        
        for (int i = 0; i < 10;i++)
        {
            System.out.println(c.retirarDinero(288));
            System.out.println("50:" + c.getTotal50() + "\n20:" + c.getTotal20() + "\n10:" + c.getTotal10() + "\n5:" + c.getTotal5() + "\n1:" + c.getTotal1());
            System.out.println(c.getDineroTotal()+"\n");
        }
    }

}
