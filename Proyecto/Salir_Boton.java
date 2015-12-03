import greenfoot.*;

/**
 * Write a description of class Salir_Boton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Salir_Boton extends Boton
{
    /**
     * Act - do whatever the Salir_Boton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
      salir();
    }    
    
    public void salir()
    {
     if(Greenfoot.mousePressed(this))
            {
               Greenfoot.stop();
            }   
    }
}
