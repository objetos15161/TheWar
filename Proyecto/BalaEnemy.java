import greenfoot.*;

/**
 * Write a description of class BalaEnemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BalaEnemy extends Municion
{
    
    
    /**
     * Act - do whatever the BalaEnemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       mueve();

       Check();
    }    
    public void mueve()
    {
       setRotation(90); //270
       move(2);
    }
    
    public void Check ()
    {
        WarWorld mundo = (WarWorld) getWorld();
        if(getY()>=499)
        {
         mundo.removeObject(this);     
        }

    }  
}