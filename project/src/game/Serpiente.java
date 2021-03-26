
package game;

import static game.Game.contador;
import static game.Game.fee;
import static game.Inicio.ventanaJuego;
import java.awt.Color;
import java.awt.Font;

import java.awt.Point;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;



public class Serpiente 
{
    
    public static ArrayList<JLabel> lista = new ArrayList<JLabel>();
    public Serpiente()
    {
        
    }
    static JLabel fee2;
    public static void add(int posX,int posY,int ancho,int largo)
    {
        fee = new JLabel("Jugador: Pedro  ||  Puntaje:" );
        try{Inicio.ventanaJuego.remove(fee2);}catch(NullPointerException e){}
        fee2 = new JLabel(String.valueOf(contador ));
        Inicio.ventanaJuego.add(fee2);
        Inicio.ventanaJuego.add(fee);
        Font fue = new Font("Segoe Ui",Font.BOLD,20);
        fee2.setBounds(350,17,30,20);
        fee2.setFont(fue);
        fee.setFont(fue);
        fee.setBounds(90, 10, 300, 30);
        
        
        lista.add(new JLabel(new ImageIcon("imagenes/detener.png")));
        int  posicion = lista.size() -1;
        JLabel f = lista.get(posicion);
        Inicio.ventanaJuego.add(f);
        f.setBounds(posX,posY,ancho,largo);
        f.setBackground(new Color(161,194,230));
        String nombre =String.valueOf(posicion);
        
        f.setName(nombre);
        
        Game.refrescar(Inicio.ventanaJuego);
        
    }
    
    public static void addLastSerpiente()
    {
        Inicio.ventanaJuego.contador++;
        
        if(GameLoop.movimiento.equals("derecha"))
        {
            System.out.println("entro");
           Point posicionUltimaSerpiente =  lista.get(lista.size() -1).getLocation();
           add((int)posicionUltimaSerpiente.getX() -20,(int)posicionUltimaSerpiente.getY(),20,20);
            
        }
        else if(GameLoop.movimiento.equals("izquierda"))
        {
            System.out.println("entro");
           Point posicionUltimaSerpiente =  lista.get(lista.size() -1).getLocation();
           add((int)posicionUltimaSerpiente.getX() +20,(int)posicionUltimaSerpiente.getY(),20,20);
            
        }
        else if(GameLoop.movimiento.equals("arriba"))
        {
           System.out.println("entro");
           Point posicionUltimaSerpiente =  lista.get(lista.size() -1).getLocation();
           add((int)posicionUltimaSerpiente.getX() ,(int)posicionUltimaSerpiente.getY() - 20,20,20);
            
        }
        else if(GameLoop.movimiento.equals("abajo"))
        {
            System.out.println("entro");
           Point posicionUltimaSerpiente =  lista.get(lista.size() -1).getLocation();
           add((int)posicionUltimaSerpiente.getX() ,(int)posicionUltimaSerpiente.getY() + 20,20,20);
            
        }
    }
           
    
}
