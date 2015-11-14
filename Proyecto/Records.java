import greenfoot.*;

/**
 * Write a description of class Records here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Records extends World
{
    private Regresar_Boton regresar_boton;
    
    /**
     * Constructor for objects of class Records.
     * 
     */
    public Records()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        regresar_boton = new Regresar_Boton();
        addObject(regresar_boton,550,370);  
        
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
