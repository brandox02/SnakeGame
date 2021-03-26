
package game;

import java.awt.Color;
import java.awt.Dimension;

public class Ventana extends javax.swing.JFrame 
{

    public Ventana() 
    {
        initComponents();
        this.setMinimumSize(new Dimension(450,330));
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        
          try 
          {
    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Windows".equals(info.getName())) {
            javax.swing.UIManager.setLookAndFeel(info.getClassName());
            break;
        }
    }
} catch (ClassNotFoundException ex) {
    java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
} catch (InstantiationException ex) {
    java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
} catch (IllegalAccessException ex) {
    java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
} catch (javax.swing.UnsupportedLookAndFeelException ex) {
    java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
}
        
        
    }

   
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(450, 330));
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        pack();
    }//GEN-END:initComponents

    public static void main(String args[]) {
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() 
            {
                ventana = new Ventana();
                ventana.setVisible(true);
                inicio = new Inicio();
                //ventana.setMinimumSize(new Dimension(436,285));
                //ventana.setMinimumSize(new Dimension(450,330));
                 ventana.add(inicio);
                 
            }
        });
    }
public static Ventana ventana;
public static Inicio inicio;

    private static class login {

        public login() 
        {
            
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
