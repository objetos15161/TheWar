import greenfoot.*;

/**
 * Write a description of class Torre here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Torre extends Soldado
{
    /**
     * Act - do whatever the Torre wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public int vida=300;
    
    public void act() 
    {
     disminuyeVida();
    } 
    
    public void disminuyeVida()
    {
     World mundo = getWorld();
        
     if(vida<=300 && vida>0)
     {  
       if(isTouching(BalaJug.class))
       {
        removeTouching(BalaJug.class);
        vida=vida-100;
       }
     }
         
     if( vida<=0  )
     {
      mundo.removeObject(this);
     }
    }
}
