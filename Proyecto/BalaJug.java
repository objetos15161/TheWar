
import greenfoot.*;

/**
 * La bala que sale del tanque en dirección hacia los enemigos
 * 
*
 * @author Villegas Puente Ruben , Quistian Martinez Alberto 
 * @version 2015.11.7
 */
public class BalaJug extends Municion
{    
    int eliminados=0;
    
 
    public void act() 
    {
       mueve();
       checa();//Verifica si esta tocando un soldado y actualiza estados de puntuacion y vidas

    } 
    
    public void mueve()/** Hace que la bala se mueve hacia arriba  */

    {
       setRotation(270); 
       move(2);
    }
    
    public void checa()/**Verifica si esta tocando un soldado y actualiza estados de 				   puntuación y vidas*/

    {
      WarWorld mundo = (WarWorld) getWorld();
      
      
      if(isTouching(Artillero.class)) 
      { 
        mundo.actualizaPuntos();//actualiza el contador de los puntos
        mundo.aumentaEliminados();//actualiza la bandera de los eliminados
      }
      else
      {
       if(getY()== 0)   
       {     
        mundo.removeObject(this);   //elimina la bala
       }
      }     
    }    
}
