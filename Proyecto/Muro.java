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
    int L;
    //int ContM=0;
    int Mval;
    
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
        
      L=mundo.nivel.getValue();
      
         if(vida<=200 && vida>0)
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

        /* if(isTouching(BalaJug.class))
         {     
           //ContM++;
           mundo.removeObject(this);   
         }  */   
    }
    
    /*public void regresaVal(int )
    {
       Mval=ContM; 
    }
    */
}