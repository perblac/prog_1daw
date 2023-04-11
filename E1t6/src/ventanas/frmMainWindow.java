package ventanas;

import java.awt.EventQueue;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

/**
 *
 * @author rperblac
 */
public class frmMainWindow extends JFrame {
    
    private Label lblMensaje;
    private int ancho = 300;
    private int alto = 100;
    
    public frmMainWindow() {
        lblMensaje = new java.awt.Label();

        lblMensaje.setAlignment(Label.CENTER);

        lblMensaje.setText("Pasa el ratón por la etiqueta");

        lblMensaje.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                lblMensajeMouseEntered(evt);
            }
            public void mouseExited(MouseEvent evt) {
                lblMensajeMouseExited(evt);
            }
        });
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(lblMensaje);
        setSize(ancho,alto);
    }
    
    private void lblMensajeMouseEntered(MouseEvent evt) {                                        
        lblMensaje.setText("El ratón está dentro de la etiqueta");
    }                                       

    private void lblMensajeMouseExited(MouseEvent evt) {                                       
        lblMensaje.setText("El ratón está fuera de la etiqueta");
    }
    
    public static void main(String args[]){
        EventQueue.invokeLater(
            new Runnable() {
                public void run() {
                    new frmMainWindow().setVisible(true);
                }
            }
        );
    }
    
    
}
