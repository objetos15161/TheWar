import greenfoot.*;


/**
 * Representa un enemigo del juego en el nivel 3  
 * 
 * @author Villegas Puente Ruben,Quistian Martinez Alberto 
 * @version 2015.11.7
 */


public class Torre extends Soldado
{

    
    public int vida=300;//La vida que tiene la Torre
 
    public void act() 
    {
     disminuyeVida();
    } 
    
    public void disminuyeVida()/**calcula la vida de la torre cuando esta es tocada por la 				  bala del jugador  */

    {
     WarWorld mundo = (WarWorld) getWorld(); 
        
     Tanque t = mundo.dimeTanque();
        
        if(t.daño==1)/**verifica si aun tiene la bonificacion el tanque */
        {
          if(vida<=300 && vida>0)/**verifica si aun tiene vida el soldado */
          {  
            if(this.isTouching(BalaJug.class))/**cuando esta tocando la BalaJug la bala se elimina */
            {
             removeTouching(BalaJug.class);/** se eliminala balaJug*/
             vida=vida-200; /** se decrementa la vida*/
            }
          }
        }
         else
         {  
           if(vida<=300 && vida>0)
           {
            if(isTouching(BalaJug.class))
            {
             removeTouching(BalaJug.class);
             vida=vida-100; /** se decrementa la vida*/
            }
           }
         }
         
     if( vida<=0  )/**cuando ya no tiene vida el soldado este se elimina  */
     {
      mundo.removeObject(this);
     }
    }
}

