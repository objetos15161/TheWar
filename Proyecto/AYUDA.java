import greenfoot.*;

/**
 * Crea la imagen de las instrucciones  del juego
 * 
 * @author Villegas Puente Ruben , Quistian Martinez Alberto
 * @version 2015.11.7
 */
public class AYUDA extends World
{
   private Regresar_Boton regresar_boton;
   
  
    public AYUDA()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(500, 500, 1); 
        
        regresar_boton = new Regresar_Boton();
        addObject(regresar_boton,72,40);  
        
        
    }   
  
}
