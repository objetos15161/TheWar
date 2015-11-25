import greenfoot.*;

/**
 * Write a description of class Reloj here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Reloj extends Actor
{
    public SimpleTimer timer;
    private Counter valor;
    private BalaEnemy BEN;
   
    
    int n;
    
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
            
            mundo.agregaBalaJ(); 
            
             n=mundo.nivel.getValue();
            if(n==2)
            {
             activaBalE2();
            }
             if(n==3)
            {
             activanivel3();
             
            }
           
        } 

            
    }    
    
    
    public void activaBalE2()
    {
                WarWorld mundo = (WarWorld) getWorld();
               if(valor.getValue()>3)
               {
                  if(valor.getValue()%60==0)
                  {

                  //Greenfoot.stop();
                  //setLocation(mundo.getWidth()/2, mundo.getHeight()-50);
                  }
               }
               if(valor.getValue()>6)
                {
                  if(valor.getValue()%6==0 )
                  {
                    mundo.addBalaEnL2(); 
                  }
               }
    }
    
    
    public void activanivel3()
    {
                WarWorld mundo = (WarWorld) getWorld();
               if(valor.getValue()>3)
               {
                  if(valor.getValue()%60==0)
                  {

                  //Greenfoot.stop();
                  //setLocation(mundo.getWidth()/2, mundo.getHeight()-50);
                  }
               }
               if(valor.getValue()>6)
                {
                  if(valor.getValue()%3==0 )
                  {
                    mundo.addBalaEnTor(); 
                  }
                  if(valor.getValue()%5==0 )
                  {
                    mundo.addBalaEnL3(); 
                  }
               }
    }
}