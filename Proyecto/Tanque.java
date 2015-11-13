import greenfoot.*;

/**
 * Write a description of class Tanque here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tanque extends Actor
{
    private Counter vidas;  
    
    public int x;
    public int y;
    
    /**
     * Act - do whatever the Tanque wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
      mueve();
    }    
    
    /*public void Tanque(int numVidas)
    {
      //World mundo = getWorld();
      
      vidas = new Counter ("Vidas: ");
      vidas.setValue(numVidas);   
      
      //mundo.addObject(vidas, 100, 100);
    }
    
    protected void addedToWorld(World mundo)
    {
        mundo.addObject(vidas, 50, 10);
    }*/
    
    public void mueve()
    {
      if(Greenfoot.isKeyDown("right"))
      {
        move(3);
      }
      
      if(Greenfoot.isKeyDown("left"))
      {
        move(-3);
      }
    }
    
    public void regresaCoordenadas()
    {
      x=getX();
      y=getY();
    }
}
