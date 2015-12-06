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
     * Act - do whatever the Boton_Jugar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       Jugar();
       muJuego= new GreenfootSound("musica de guerra.wav");   
    }    
    
    public void Jugar()
    {
        if(Greenfoot.mousePressed(this))
            {

                Greenfoot.setWorld(new WarWorld());
                muJuego.play();
            }
    }
}
