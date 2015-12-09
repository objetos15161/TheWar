import greenfoot.*;

/**
 * Write a description of class Salir_Boton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
     if(Greenfoot.mousePressed(this))/**Cuando se hace click en la imagen el juego se detiene*/
     {
      Greenfoot.stop();
     }   
    }
}