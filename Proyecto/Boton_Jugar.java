import greenfoot.*;

/**
 * Representa el boton de JUGAR del MENU con este da inicio al juego
 * 
 * @author Villegas Puente Ruben,Quistian Martinez Alberto 
 * @version 2015.11.7
 */

public class Boton_Jugar extends Boton
{
    private GreenfootSound muJuego; 
  
    public void act() 
    {
       Jugar();
       muJuego= new GreenfootSound("musica de guerra.wav");    }    
    
    public void Jugar()/**Cuando se hace click en la imagen el juego inicia*/
    {
        if(Greenfoot.mousePressed(this))            {
                Greenfoot.setWorld(new WarWorld());
                muJuego.play();
            }
    }
}
