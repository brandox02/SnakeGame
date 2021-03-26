package game;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;

public class Inicio extends javax.swing.JPanel 
{
    
    public Inicio() 
    {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        lblSnakeGame = new javax.swing.JLabel();
        btnJugar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        setMaximumSize(new java.awt.Dimension(0, 0));
        setMinimumSize(new java.awt.Dimension(450, 290));
        setPreferredSize(new java.awt.Dimension(450, 290));
        setLayout(null);

        lblSnakeGame.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        lblSnakeGame.setText("Snake Game");
        add(lblSnakeGame);
        lblSnakeGame.setBounds(58, 16, 194, 32);

        btnJugar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnJugar.setText("Jugar");
        btnJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugarActionPerformed(evt);
            }
        });
        add(btnJugar);
        btnJugar.setBounds(250, 100, 90, 29);

        btnSalir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        add(btnSalir);
        btnSalir.setBounds(70, 100, 100, 29);

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(txtNombre);
        txtNombre.setBounds(230, 70, 141, 26);

        lblNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNombre.setText("Nombre de Usuario");
        add(lblNombre);
        lblNombre.setBounds(68, 69, 132, 20);

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));
        add(jPanel1);
        jPanel1.setBounds(468, 553, 0, 0);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Title 1"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setResizable(false);
        }

        add(jScrollPane1);
        jScrollPane1.setBounds(60, 150, 347, 120);
    }//GEN-END:initComponents

    private void btnJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugarActionPerformed
        Ventana.ventana.getContentPane().removeAll();
        ventanaJuego = new Game();
        
        //ventanaJuego.setSize(410,240);
        
        Ventana.ventana.add(ventanaJuego);
        
        
        Ventana.ventana.setMinimumSize(new Dimension(550,380));
        
        Dimension dimension = ventanaJuego.getSize();
        ventanaJuego.setLayout(null);
        ventanaJuego.setFocusable(true);
        ventanaJuego.requestFocus();
        
        thread = new GameLoop();
        thread.start();
        System.out.println("el thread del gameloop se llama: " + thread.getName());
        
    }//GEN-LAST:event_btnJugarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    public static Thread thread;
    public static Game ventanaJuego;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnJugar;
    public javax.swing.JButton btnSalir;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lblNombre;
    public javax.swing.JLabel lblSnakeGame;
    public javax.swing.JTable tabla;
    public javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
