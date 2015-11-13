import greenfoot.*;

/**
 * Write a description of class AYUDA here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AYUDA extends World
{
   private Regresar_Boton regresar_boton;
    /**
     * Constructor for objects of class AYUDA.
     * 
     */
    public AYUDA()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(500, 500, 1); 
        
        regresar_boton = new Regresar_Boton();
        addObject(regresar_boton,72,40);  
        
        act();
    }   

    public void act()
    {
       if(Greenfoot.getMouseInfo()!=null)
        {    
         if(Greenfoot.mousePressed(regresar_boton))
         {
          Greenfoot.setWorld(new MENU());
         }
        }
    }
    
}
