import greenfoot.*;

/**
 * Write a description of class Regresar_Boton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Regresar_Boton extends Boton
{
    /**
     * Act - do whatever the Regresar_Boton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        regresar();
    }    
    
    public void regresar()
    {
        if(Greenfoot.mousePressed(this))
         {
          Greenfoot.setWorld(new MENU());
         }
    }
}
