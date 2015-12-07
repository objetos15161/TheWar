import greenfoot.*;

/**
 * Write a description of class Boton_Ayuda here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boton_Ayuda extends Boton
{
    /**
     * Representa el boton de AYUDA del MENU 
     */
    public void act() 
    {
        ayuda();
    }    
    
    public void ayuda()
    {
         if(Greenfoot.mousePressed(this))/**Cuando se hace click en la imagen aparece una imagen
                                            con las intrucciones del juego*/
            {
              Greenfoot.setWorld(new AYUDA());
            }
    }
}
