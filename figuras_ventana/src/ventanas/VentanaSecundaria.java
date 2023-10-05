
package ventanas;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 * Lienzo para el programa Figuras geométricas
 * @author rperblac
 */
public class VentanaSecundaria extends JFrame implements ActionListener {
    VentanaPrincipal mainWindow;
    Canvas lienzo;
    
    public VentanaSecundaria(VentanaPrincipal vp) {
        
        mainWindow=vp;
        
        iniciarComps();
        setSize(400,400);
        setLocationRelativeTo(null);
	setResizable(false);
        setTitle("Lienzo");
    }
    
    private void iniciarComps() {
        getContentPane().setLayout(null);
        
        lienzo = new Canvas();
        lienzo.setBounds(0, 0, 400, 400);
        lienzo.setBackground(Color.white);
        lienzo.setVisible(true);
        
        mainWindow.abreLienzo.addActionListener(this);
        
        getContentPane().add(lienzo);
    }

//    protected void grabar() {
//        java.awt.Container pane = this.getContentPane();
//        java.awt.image.BufferedImage img = new java.awt.image.BufferedImage(pane.getWidth(), pane.getHeight(), java.awt.image.BufferedImage.TYPE_INT_RGB);
//        java.awt.Graphics2D g2d = img.createGraphics();
//        pane.printAll(g2d);
//        g2d.dispose();
//        try {
//            javax.imageio.ImageIO.write(img, "png", new java.io.File("save.png"));
//        } catch (java.io.IOException ex) {
//            ex.printStackTrace();
//        }
//    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println("Clic");
    }

}
