import greenfoot.*;

/**
 * Write a description of class Muro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Muro extends Actor
{
    private int vida=200;
    
    /**
     * Act - do whatever the Muro wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act() 
    {
      checa();
    }   
    
    public void checa()
    {
      WarWorld mundo = (WarWorld) getWorld(); 
      
      Tanque t = mundo.dimeTanque();
        
        if(t.daño==1)/**verifica si aun tiene la bonificacion el tanque */
        {
          if(vida<=200 && vida>0)/**verifica si aun tiene vida el muro */
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
