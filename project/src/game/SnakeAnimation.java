package game;

import java.awt.Point;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import static game.GameLoop.generaNumero;

public class SnakeAnimation extends Thread {

    public static boolean estadoMovido = false;

    @Override
    public void run() 
    {
        if (GameLoop.movimiento.equals("derecha"))
        {
            //GameLoop.movimiento = "";
            estadoMovido = true;
            GameLoop.condicion = true;
            ArrayList<Point> listaAnt = new ArrayList<Point>();

            for (JLabel e : Serpiente.lista)
            {
                listaAnt.add(e.getLocation());
            }

            Inicio.ventanaJuego.add(Serpiente.lista.get(0));

            for (int i = 0; i < Serpiente.lista.size(); i++)
            {
                if (i == 0)
                {
                    Serpiente.lista.get(0).setBounds((int) listaAnt.get(0).getX() + 20, (int) listaAnt.get(0).getY(), 20, 20);

                    continue;
                }

                Inicio.ventanaJuego.add(Serpiente.lista.get(i));
                Serpiente.lista.get(i).setBounds((int) listaAnt.get(i - 1).getX(), (int) listaAnt.get(i - 1).getY(), 20, 20);
            }

        } else if (GameLoop.movimiento.equals("izquierda"))
        {
            GameLoop.condicion = true;
            estadoMovido = true;
            // GameLoop.movimiento = "";
            ArrayList<Point> listaAnt = new ArrayList<Point>();

            for (JLabel e : Serpiente.lista)
            {
                listaAnt.add(e.getLocation());
            }

            //System.out.println("no te vallas porlfavol");
            Inicio.ventanaJuego.add(Serpiente.lista.get(0));

            for (int i = 0; i < Serpiente.lista.size(); i++)
            {
                if (i == 0)
                {
                    Serpiente.lista.get(0).setBounds((int) listaAnt.get(0).getX() - 20, (int) listaAnt.get(0).getY(), 20, 20);
                    //Inicio.ventanaJuego.detectarColicion();
                    continue;
                }

                Inicio.ventanaJuego.add(Serpiente.lista.get(i));
                Serpiente.lista.get(i).setBounds((int) listaAnt.get(i - 1).getX(), (int) listaAnt.get(i - 1).getY(), 20, 20);

            }
        } else if (GameLoop.movimiento.equals("arriba"))
        {
            GameLoop.condicion = true;
            estadoMovido = true;
            //GameLoop.movimiento = "";
            ArrayList<Point> listaAnt = new ArrayList<Point>();
            JLabel[] array = new JLabel[Serpiente.lista.size()];
            array = Serpiente.lista.toArray(array);
            for (JLabel e : array)
            {
                listaAnt.add(e.getLocation());
            }

            System.out.println("no te vallas porlfavol");
            Inicio.ventanaJuego.add(Serpiente.lista.get(0));

            for (int i = 0; i < Serpiente.lista.size(); i++)
            {
                if (i == 0)
                {

                    Serpiente.lista.get(0).setBounds((int) listaAnt.get(0).getX(), (int) listaAnt.get(0).getY() - 20, 20, 20);
                    //Inicio.ventanaJuego.detectarColicion();
                    continue;
                }

                Inicio.ventanaJuego.add(Serpiente.lista.get(i));
                Serpiente.lista.get(i).setBounds((int) listaAnt.get(i - 1).getX(), (int) listaAnt.get(i - 1).getY(), 20, 20);

            }

        } else if (GameLoop.movimiento.equals("abajo"))
        {
            //GameLoop.condicion = true;
            estadoMovido = true;
            //GameLoop.movimiento = "";
            ArrayList<Point> listaAnt = new ArrayList<Point>();

            for (JLabel e : Serpiente.lista)
            {
                listaAnt.add(e.getLocation());
            }

            Inicio.ventanaJuego.add(Serpiente.lista.get(0));

            for (int i = 0; i < Serpiente.lista.size(); i++)
            {
                if (i == 0)
                {

                    Serpiente.lista.get(0).setBounds((int) listaAnt.get(0).getX(), (int) listaAnt.get(0).getY() + 20, 20, 20);

                    continue;
                }

                Inicio.ventanaJuego.add(Serpiente.lista.get(i));
                Serpiente.lista.get(i).setBounds((int) listaAnt.get(i - 1).getX(), (int) listaAnt.get(i - 1).getY(), 20, 20);

            }

        }
        // try{ Thread.sleep(2000);  } catch (InterruptedException ex)  {  Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex); }

    }

    public static void generarManzanas() {
        Inicio.thread.interrupt();
        int total = Serpiente.lista.size();
        int balance = 0;
        Point f = generaNumero();
        JLabel f4 = new JLabel(new ImageIcon("imagenes/manzana.png"));
        f4.setBounds((int) f.getX(), (int) f.getY(), 20, 20);

        for (JLabel es : new ArrayList<JLabel>(Serpiente.lista))
        {
            boolean interseccion = Game.intersects(f4, es);
            if (interseccion)
            {
                continue;
            } else
            {
                balance++;
            }
            
        }

        if (total == balance)
        {
            System.out.println("no se encuentra en lao de la serpiente");
            JLabel fee = new JLabel(new ImageIcon("imagenes/manzana.png"));
            Game.listaManzanas.add(fee);

            int posActual = Game.listaManzanas.size() - 1;

            Inicio.ventanaJuego.add(Game.listaManzanas.get(posActual));
            Game.listaManzanas.get(posActual).setBounds((int) f.getX(), (int) f.getY(), 20, 20);
            Inicio.thread.resume();

        }

    }
}
