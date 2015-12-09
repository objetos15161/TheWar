
import greenfoot.*;

/**
     * @author Villegas Puente Ruben,Quistian Martinez Alberto 
     * @version 2015.11.7
     *
     * Es donde hace que que se mueva el artillero y elimina el artillero 
     * cuando es tocado por la balaJugador
     */

public class Artillero extends Soldado
{
    public void act() 
    {
       mueve();
       elimina();
    }    
    
     public void elimina()/** Cuan el Artillero es tocado por la balaJugador esta se                   			      elimina e incrementa el contador de los eliminados  */
    {
     WarWorld mundo = (WarWorld) getWorld();
     
     if(isTouching(BalaJug.class))
     {
        removeTouching(BalaJug.class);
         mundo.removeObject(this); 
     }
    }
}