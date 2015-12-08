import greenfoot.*;

/**
 * Representa el boton de AYUDA del MENU  donde te aparecen las instrucciones del juego
 * 
 * @author Villegas Puente Ruben,Quistian Martinez Alberto 
 * @version 2015.11.7
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
    
    public void ayuda()/**Cuando se hace click en la imagen aparece una imagen
                          con las instrucciones del juego*/
    {
         if(Greenfoot.mousePressed(this))
            {
              Greenfoot.setWorld(new AYUDA());
            }
    }
}
