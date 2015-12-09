import greenfoot.*;

/**
 * Representa a un enemigo del juego 
 * 
 * @author Villegas Puente Ruben,Quistian Martinez Alberto 
 * @version 2015.11.7
 */

public class Granadero extends Soldado
{
    public int vida=200;//La vida que tiene el LanzaCohete

    public void act() 
    {
      disminuyeVida();
    }
    
    public void disminuyeVida()/**El contador de las vidas se actualiza cuando este es tocado por la balaJug*/
    {
        WarWorld mundo = (WarWorld) getWorld(); 
        
        Tanque t = mundo.dimeTanque();
        
        if(t.daño==1)/**verifica si aun tiene la bonificacion el tanque */
        {
          if(vida<=200 && vida>0)/**verifica si aun tiene vida el soldado */
          {  
            if(this.isTouching(BalaJug.class))/**cuando esta tocando la BalaJug la bala se elimina */
            {
             removeTouching(BalaJug.class);/** se eliminala balaJug*/
             vida=vida-200;   /** se decrementa la vida*/
            }
          }
        }
         else
         {  
           if(vida<=200 && vida>0)
           {
            if(isTouching(BalaJug.class))
            {
             removeTouching(BalaJug.class);/** se eliminala balaJug*/
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