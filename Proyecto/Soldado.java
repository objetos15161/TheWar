import greenfoot.*;

/**
 * Write a description of class Soldado here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Soldado extends Actor
{
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
      
      move(2);
      
      if(super.getX()>=699)
      {
        setLocation(x-2,y);
      }
      
      if(super.getX()<=0)
      {
        setLocation(x+2,y);
      }
    }
}