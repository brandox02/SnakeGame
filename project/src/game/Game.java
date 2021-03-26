package game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.TimerTask;
import javax.swing.JLabel;
import java.util.Timer;
import javax.swing.JButton;

public class Game extends javax.swing.JPanel 
{
    public Game() 
    {
        initComponents();
        this.add(new JButton("Click Me")).setBounds(150, 80,50,30);
        
        
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(500, 330));
        setMinimumSize(new java.awt.Dimension(550, 380));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        setLayout(null);
    }//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            GameLoop.movimiento = "derecha";
        }else if(evt.getKeyCode() == KeyEvent.VK_LEFT)
        {
           GameLoop.movimiento = "izquierda";
        }else if(evt.getKeyCode() == KeyEvent.VK_DOWN)
        {
            GameLoop.movimiento = "abajo";
        }else if(evt.getKeyCode() == KeyEvent.VK_UP)
        {
           GameLoop.movimiento = "arriba";
        }
        
    }//GEN-LAST:event_formKeyPressed

    @Override
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        Graphics2D f = (Graphics2D) g;
        f.setColor(new Color(161, 194, 230));
        f.setStroke(new BasicStroke(3));
        f.drawRect(30, 50, 470, 280);
    }

    public void generarManzanas() 
    {
        Timer timer;
        timer = new Timer();
        TimerTask task = new TimerTask() 
        {
            int tic = 0;
            @Override
            public void run() 
            {
                SnakeAnimation.generarManzanas();
                System.out.println("toc");
            }
        };
        // Empezamos dentro de 10ms y luego lanzamos la tarea cada 1000ms
        timer.schedule(task, 0, 3500);

    }

    public void detectarColicion() 
    {

        listaManzanasFake.addAll(listaManzanas);

        for (JLabel es : listaManzanasFake)
        {
            boolean f = Game.intersects(Serpiente.lista.get(0), es);
            if (f)
            {
                System.out.println("Intersecto!  y la longitud es: " + listaManzanasFake.size());

                //System.out.println("x and y de la manzana es: "+ es.getX() +"," + es.getY());
                listaManzanas.remove(es);
                Inicio.ventanaJuego.remove(es);

                refrescar(Inicio.ventanaJuego);
                refrescar(es);
                Serpiente.addLastSerpiente();

                listaManzanasFake.clear();
                break;
            }
        }

    }

    public static boolean intersects(JLabel testa, JLabel testb) {
        Area areaA = new Area(testa.getBounds());
        Area areaB = new Area(testb.getBounds());

        return areaA.intersects(areaB.getBounds2D());
    }

    public static void refrescar(Component x) 
    {
        x.validate();
        x.revalidate();
        x.repaint();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    public static ArrayList<JLabel> listaManzanas = new ArrayList<JLabel>();
    public static ArrayList<JLabel> listaManzanasFake = new ArrayList<JLabel>();
    public static int contador = 0;
    public static JLabel fee;

}
