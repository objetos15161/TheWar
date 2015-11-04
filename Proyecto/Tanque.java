import greenfoot.*;

/**
 * Write a description of class Tanque here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tanque extends Actor
{
    /**
     * Act - do whatever the Tanque wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
      mueve();
    }    
    
    public void mueve()
    {
      if(Greenfoot.isKeyDown("right"))
      {
        move(1);
        setRotation(0);
      }
      
      if(Greenfoot.isKeyDown("left"))
      {
        move(1);
        setRotation(180);
      }
      
      if(Greenfoot.isKeyDown("down"))
      {
        move(1);
        setRotation(90);
      }
      
      if(Greenfoot.isKeyDown("up"))
      {
        move(1);
        setRotation(270);
      }
    }
}
