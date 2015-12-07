
import greenfoot.*;

public class Artillero extends Soldado
{
    /**
     * Act - do whatever the Artillero wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    
    public void act() 
    {
       mueve();//es llamada este metodo desde SOLDADO y Hace que se mueva el artiller0
       elimina(); //Elimina el artillero cuando es tocado por la balaJugador
    }    
    
     public void elimina()
    {
     WarWorld mundo = (WarWorld) getWorld();
     
     if(isTouching(BalaJug.class))
     {
        removeTouching(BalaJug.class);
         mundo.removeObject(this); 
     }
    }
}