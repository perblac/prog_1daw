package disparamario;

/**
 *
 * @author rperblac
 */
import java.awt.Toolkit;
import java.awt.Dimension;
import bpc.daw.mario.*;

public class DisparaMario {

    public static void main(String[] args) {
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double h= screenSize.getHeight();
        double w= screenSize.getWidth();
        Mario m = new Mario(0,0);
        Cañon c = new Cañon((int)w-40,(int)h/2);
        Disparo p = new Disparo((int)w-40,(int)h/2,-100,(int) h/2);
        boolean haciaAbajo= true;
        int muertes = 0;
        do
        {
            if (haciaAbajo){
                if (m.getY()<40)
                {
                    m.correrHacia(0, (int)h);
                }
                if (m.getY()>(int)(h-40)){
                
                    haciaAbajo= false;
                }
            } else
            {
                if (m.getY()>(int)(h-40))
                {
                    m.correrHacia(0, 0);
                }
                
                if (m.getY()<40){
                    haciaAbajo=true;
                }
            }
            if (((p.getX()-m.getX())<100)&&((p.getY()-m.getY())<100))
            {
                System.out.println(p.getX()+" "+m.getX()+" "+((p.getX()-m.getX())<100)+" "+p.getY()+" "+m.getY()+" "+((p.getY()-m.getY())<100));
                m.eliminar();
                ++muertes;
                System.out.print(muertes+" ");
                m = new Mario(0,0);                
            }
            if (p.getX()<10)
            {
                p.eliminar();
                p = new Disparo((int)w-40,(int)h/2,-100,(int) h/2);
            }
        } while (muertes<10);
        System.exit(0);
    } 
    
}
