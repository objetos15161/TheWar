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
       checa();
    }   
    
    public void mueve()
    {
       /*WarWorld mundo = (WarWorld)getWorld();
       Tanque t =mundo.dimeTanque();
       int x=t.getX(),y=t.getY();
       int a=x,b=y;
       setLocation(a,b+1);*/
       setRotation(270);
       move(2);
    }
    
    public void checa()
    {
      World mundo = (WarWorld) getWorld();
      
      if(isTouching(Artillero.class)) 
      {
        //eliminados++;
        mundo.removeObject(this);
        
        /*if(eliminados==10)
        {
         mundo.cambiaNivel();   
        }*/
      }
      else
      {
       if(getY()== 0)   
       {
       mundo.removeObject(this);   
      }
    }    
}
}
