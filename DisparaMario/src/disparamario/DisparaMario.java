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
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double h= screenSize.getHeight();
        double w= screenSize.getWidth();
        boolean haciaAbajo= true;
        int muertes = 0, marioX, cañonX,contacto;
        Planta e = new Planta (0,(int)h/2);
        marioX = (int)(200*(Math.random()));
        cañonX =(int) ((w-(w/2)-(w/4))*(Math.random()))+300;
        Cañon c = new Cañon(cañonX,(int)h/2);
        Disparo p = new Disparo(cañonX,(int)h/2,-100,(int) h/2);
        Mario m = new Mario(marioX,0);
        contacto = 25;
        System.out.print("Muertes: ");
        do
        {
            if (haciaAbajo){
                if (m.getY()<40)
                {
                    m.correrHacia(marioX, (int)h);
                }
                if (m.getY()>(int)(h-40)){
                
                    haciaAbajo= false;
                }
            } else
            {
                if (m.getY()>(int)(h-40))
                {
                    m.correrHacia(marioX, 0);
                }
                
                if (m.getY()<40){
                    haciaAbajo=true;
                }
            }
            if ((Math.abs((p.getX()-m.getX()))<contacto)&&((Math.abs(p.getY()-m.getY()))<contacto))
            {
                ++muertes;
                System.out.print(muertes+" ");
                //Linea de debug:
                System.out.println("pX"+p.getX()+" mX"+m.getX()+" (<"+contacto+":"+((p.getX()-m.getX())<contacto)+") pY"+p.getY()+" mY"+m.getY()+" (<"+contacto+":"+((p.getY()-m.getY())<contacto)+")");
                marioX = (int)(200*(Math.random()));
                m.eliminar();
                m = new Mario(marioX,0);
                c.eliminar();
                cañonX=cañonX-10;
                c = new Cañon(cañonX,(int)h/2);
                p.eliminar();
                p = new Disparo(cañonX,(int)h/2,-100,(int) h/2);
            }
            if (p.getX()<10)
            {
                p.eliminar();
                p = new Disparo(cañonX,(int)h/2,-100,(int) h/2);
            }
        } while (muertes<10);
        System.exit(0);
    } 
    
}
