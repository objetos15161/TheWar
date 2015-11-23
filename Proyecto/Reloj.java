import greenfoot.*;

/**
 * Write a description of class Reloj here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Reloj extends Actor
{
    private SimpleTimer timer;
    private Counter valor;
    private BalaEnemy BEN;
    
    public Reloj()
    {
        valor = new Counter("Tiempo: ");
        timer = new SimpleTimer();
    }    
    protected void addedToWorld(World mundo)
    {
        mundo.addObject(valor, 250, 10);
    }
    
    /**
     * Act - do whatever the Reloj wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        WarWorld mundo = (WarWorld) getWorld();
        if(timer.millisElapsed()>1000)
        {
            valor.add(1);
            timer.mark();
        }
        if(valor.getValue()>3)
        {
          if(valor.getValue()%20==0){

             Greenfoot.stop();
             //setLocation(mundo.getWidth()/2, mundo.getHeight()-50);
            }
        }
        if(valor.getValue()>6)
        {
          if(valor.getValue()%2==0)
          {
             mundo.addBalaEn(); 
          }
        }
    }    
}