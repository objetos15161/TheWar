import greenfoot.*;

/**
 * Write a description of class BalaJug here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BalaJug extends Municion
{
    int eliminados=0;
    
    /**
     * Act - do whatever the BalaJug wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        mueve();
    }   
    
    public void mueve()
    {
     WarWorld mundo = (WarWorld) getWorld();
     
     if(Greenfoot.isKeyDown("a"))
     { 
      //Tanque t = mundo.dimeTanque();
      //t.regresaCoordenadas();
     
      mundo.addObject(new BalaJug(),100, 100); 
     }
    }
    
    public void checa()
    {
      WarWorld mundo = (WarWorld) getWorld();
      
      if(this.isTouching(Artillero.class)) 
      {
        eliminados++;
        
        if(eliminados==10)
        {
         mundo.cambiaNivel();   
        }
      }
    }
}
