import greenfoot.*;

/**
 * Crea el boton de Creditos
 * 
 * @author Villegas Puente Ruben,Quistian Martinez Alberto 
 * @version 2015.11.7
 */
public class BotonCreditos extends Boton
{
    /**
     *Representa el boton de SALIR del MENU 
     */
    public void act() 
    {
      salir();
    }    
    
    public void salir()
    {
     if(Greenfoot.mousePressed(this))/**Cuando se hace click en la imagen aparece una imagen con los Creditose*/
     {
      Greenfoot.setWorld(new Creditos());
     }   
    }
}