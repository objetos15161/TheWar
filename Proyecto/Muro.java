import greenfoot.*;

/**
 * Representa una protección para el enemigo en el juego
 * 
 * @author Villegas Puente Ruben,Quistian Martinez Alberto 
 * @version 2015.11.7
 */

public class Muro extends Actor
{
    private int vida=200;
    
  
    
    public void act() 
    {
      checa();
    }   
    
    public void checa()/**  verifica si aun tiene vida el muro */

    {
      WarWorld mundo = (WarWorld) getWorld(); 
      
      Tanque t = mundo.dimeTanque();
        
        if(t.daño==1)/**verifica si aun tiene la bonificacion el tanque */
        {
          if(vida<=200 && vida>0)
          {  
            if(this.isTouching(BalaJug.class))/**cuando esta tocando la BalaJug la bala se elimina */
            {
             removeTouching(BalaJug.class);/** se eliminala balaJug*/
             vida=vida-200;/** se decrementa la vida*/
            }
          }
        }
         else
         {  
          if(vida<=200 && vida>0)
          { 
           if(isTouching(BalaJug.class))
           {
            removeTouching(BalaJug.class);
            vida=vida-100; 
           }
          }
         }
         
        if( vida<=0  )/**cuando ya no tiene vida el muro este se elimina  */
        {
         mundo.removeObject(this);
        }
     }
}
