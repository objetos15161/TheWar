import greenfoot.*;

/**
 * Write a description of class Regresar_Boton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RegresarBoton extends Boton
{
    /**
     Representa el boton de REGRESAR de la AYUDA
     */
    public void act() 
    {
        regresar();
    }    
    
    public void regresar()
    {
        if(Greenfoot.mousePressed(this))/**Cuando se hace click en la imagen se vuelve al MENU*/
         {
          Greenfoot.setWorld(new Menu());
         }
    }
}
