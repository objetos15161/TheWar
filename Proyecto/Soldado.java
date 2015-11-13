import greenfoot.*;

/**
 * Write a description of class Soldado here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Soldado extends Actor
{
    int v=1;
    /**
     * Act - do whatever the Soldado wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       mueve();
    }    
    
    public void mueve()
    {
      int x=getX();
      int y=getY();

      setLocation(x+v,y);
      
      if(super.getX()>=699)
      {
        v=-1;
      }
      
      if(super.getX()<=0)
      {
        v=1;
      }
    }
}