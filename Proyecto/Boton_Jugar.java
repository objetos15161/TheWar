import greenfoot.*;

/**
 * Write a description of class Boton_Jugar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boton_Jugar extends Boton
{
    private GreenfootSound muJuego; 
    /**
    Representa el boton de JUGAR del MENU */
    public void act() 
    {
       Jugar();
       muJuego= new GreenfootSound("musica de guerra.wav");/**Se reproduce el sonido del juego*/
    }    
    
    public void Jugar()
    {
        if(Greenfoot.mousePressed(this))/**Cuando se hace click en la imagen el juego inicia*/
            {

                Greenfoot.setWorld(new WarWorld());
                muJuego.play();
            }
    }
}
