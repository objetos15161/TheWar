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
   
    private Message message = null;
 
    int n;
    //int i=0;
    
    public Reloj()
    {
        valor = new Counter("Tiempo: ");
        timer = new SimpleTimer();
        message = new Message("¡¡Game Over... Perdiste!!");
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
        
        if(timer.millisElapsed()>900)
        {
            valor.add(1);
            timer.mark();
            
            mundo.agregaBalaJ(); 
            
            reiniciaReloj(); 
            
             /*n=mundo.nivel.getValue();
            if(n==2)
            {
             activaBalE2();
            }
             if(n==3)
            {
             activanivel3();
             
            }*/     
        }           
    }    
    
     public void reiniciaReloj()
    {
      WarWorld mundo = (WarWorld) getWorld();  
      
      n=mundo.nivel.getValue();
      
      if(n==1)
      {
        terminaJuego();  
      }
      
      if(n==2)
      {    
       //if(i==0)
       //{
        activaBalE2();
        //valor.setValue(0);
        //i=1;
        //}
        //terminaJuego();  
      }
      
      if(n==3)
      {
       //if(i==1)
       //{
        activanivel3();   
        //valor.setValue(0);  
        //i=2;
       }
        //terminaJuego();  
      }
    
    public void activaBalE2()
    {
                WarWorld mundo = (WarWorld) getWorld();
               /*if(valor.getValue()>3)
               {
                  if(valor.getValue()%60==0)
                  {

                  //Greenfoot.stop();
                  //setLocation(mundo.getWidth()/2, mundo.getHeight()-50);
                  }
               }*/
               
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
      
    public void terminaJuego()
    {
     World mundo = getWorld();
      
     if(valor.getValue() == 59)
     {
      mundo.addObject(message,250,100);
      Greenfoot.stop();   
     }
    }
    
}