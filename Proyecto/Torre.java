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
     WarWorld mundo = (WarWorld) getWorld(); 
        
     Tanque t = mundo.dimeTanque();
        
        if(t.res==1)
        {
          if(vida<=300 && vida>0)
          {  
            if(this.isTouching(BalaJug.class))
            {
             removeTouching(BalaJug.class);
             vida=vida-200;
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
             vida=vida-100;
            }
           }
         }
         
     if( vida<=0  )
     {
      mundo.removeObject(this);
     }
    }
}

