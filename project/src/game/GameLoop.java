package game;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GameLoop extends Thread 
{

    public static String movimiento;
    public static boolean condicion;

    @Override
    public void run() 
    {
        reiniciar();
        JLabel[] array = new JLabel[31];
        int y = 150;
        int x = 1;
        movimiento = "";
        Serpiente.add(200, 130, 20, 20);
        Serpiente.add(180, 130, 20, 20);
        Serpiente.add(160, 130, 20, 20);
        Serpiente.add(140, 130, 20, 20);/*
        Serpiente.add(120, 130, 20, 20);
        Serpiente.add(100, 130, 20, 20);*/
        
        Game.refrescar(Inicio.ventanaJuego);

        Inicio.ventanaJuego.generarManzanas();
        condicion = true;
        
        while (condicion)
        {
            detectarAutoColision();
            movimiento();
            int result = Serpiente.lista.size() - 1;
           
            detectarColisionBordes();
            Inicio.ventanaJuego.detectarColicion();

            try
            {
                Thread.sleep(120);
            } catch (InterruptedException ex)
            {
                try
                {
                    Thread.sleep(121);
                } catch (InterruptedException ex1)
                {
                    Logger.getLogger(GameLoop.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }

        }

    }

    public void movimiento() 
    {
        thread2 = new SnakeAnimation();
        thread2.start();
    }

    public static Point generaNumero() 
    {
        Dimension size = Inicio.ventanaJuego.getSize();
        //f.drawRect(30, 50, 470, 280);
        int x = (int) Math.floor(Math.random() * ((size.getWidth() - 60) - 30 + 1) + 30);
        int y = (int) Math.floor(Math.random() * ((size.getHeight() - 40) - 30 + 1) + 30);

        return new Point(x, y);
    }

    public static void detectarAutoColision() 
    {
        ArrayList<JLabel> listaSecundaria = new ArrayList<JLabel>(Serpiente.lista);

        for (JLabel awt : listaSecundaria)
        {
            boolean colision = Game.intersects(awt, Serpiente.lista.get(0));
            if (colision == true && !awt.getName().equals("0"))
            {
                condicion = false;
                JOptionPane.showMessageDialog(null, "Has perdido por chocar contigo mismo");
                Ventana.ventana.setMinimumSize(new Dimension(470, 330));
                Ventana.ventana.setMaximumSize(new Dimension(470, 330));
                Ventana.ventana.setSize(new Dimension(470, 330));
                Ventana.ventana.getContentPane().removeAll();
                Ventana.ventana.add(Ventana.inicio);
                Ventana.ventana.setVisible(true);

                Thread.currentThread().interrupt();

            }

        }
    }

    public void detectarColisionBordes() 
    {
        for (JLabel r : Serpiente.lista)
        {
            if (r.getX() >= 485 || r.getX() <= 30 || r.getY() >= 330 || r.getY() <= 45)
            {
                JOptionPane.showMessageDialog(null, "Has perdido por chocar con bordes");

                condicion = false;
                System.out.println(Ventana.inicio.getSize());
                Ventana.ventana.setMinimumSize(new Dimension(470, 330));
                Ventana.ventana.setMaximumSize(new Dimension(470, 330));
                Ventana.ventana.setSize(new Dimension(470, 330));
                Ventana.ventana.getContentPane().removeAll();
                Ventana.ventana.add(Ventana.inicio);
                Ventana.ventana.setVisible(true);

                break;
            }
        }
    }

    public void reiniciar() 
    {
        Serpiente.lista.clear();
        Game.listaManzanas.clear();
        Inicio.ventanaJuego.removeAll();
    }
    Thread thread2;
}
