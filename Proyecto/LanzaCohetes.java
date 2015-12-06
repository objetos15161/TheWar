import greenfoot.*;

/**
 * Write a description of class LanzaCohetes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LanzaCohetes extends Soldado
{
    /**
     * Act - do whatever the LanzaCohetes wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */    
    public int vida=200;
    
    public void act() 
    {
      disminuyeVida();
    }
    
    public void disminuyeVida()
    {
        WarWorld mundo = (WarWorld) getWorld(); 
        
        Tanque t = mundo.dimeTanque();
        
        if(t.daño==1)
        {
          if(vida<=200 && vida>0)
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
           if(vida<=200 && vida>0)
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