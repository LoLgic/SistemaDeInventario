 
package sistemainventario;

import interfaz.FrameEliminarCliente;
import interfaz.FrameHome;
import interfaz.FrameLogin;


public class SistemaInventario {

 
    public static void main(String[] args) {
   
        java.awt.EventQueue.invokeLater(() -> {
            new FrameLogin().setVisible(true);
            //new FrameHome().setVisible(true);
            //new FrameEliminarCliente().setVisible(true);
            //new FrameMensajeSuccess().setVisible(true);
        });
        
    }
    
}
