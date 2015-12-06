import greenfoot.*;
import java.util.List;

/**
 * Write a description of class Reloj here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Reloj extends Actor
{
    protected SimpleTimer timer;
    protected Counter valor;
    protected Counter bonif;
    private BalaEnemy BEN;
   
    private Message message = null;
    private int tiempoBon=250;
    private int tiempoBonEsc=230;
    private int n;
    
    public Reloj()
    {
        valor = new Counter("Tiempo: ");
        bonif = new Counter("Bonificacion: ");
        timer = new SimpleTimer();
        message = new Message("¡¡Game Over... Perdiste!!");
        
        bonif.setValue(10);
    }    
    
    protected void addedToWorld(World mundo)
    {
      mundo.addObject(valor, 250, 10);
      mundo.addObject(bonif, 620, 480);  
    }
    
    /**
     * Act - do whatever the Reloj wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        WarWorld mundo = (WarWorld) getWorld();

        if(timer.millisElapsed()>800)
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
               
      List listaLanzaCohetes = mundo.getObjects(LanzaCohetes.class);
               
      if(valor.getValue()>6)
      {
        if(valor.getValue()%6==0 )
        {
          if(listaLanzaCohetes.size()>0)
          {
           mundo.addBalaEnL2();              
          }
        }
      }
    }  
    
    public void activanivel3()
    {
                WarWorld mundo = (WarWorld) getWorld();
                
                List listaTorres = mundo.getObjects(Torre.class);
                List listaLanzaCohetes = mundo.getObjects(LanzaCohetes.class);
                
               mundo.ganaste();
               
               if(valor.getValue()>6)
                {
                  if(valor.getValue()%3==0 )
                  {
                    if(listaTorres.size()>0)
                    {                   

                        mundo.addBalaEnTor(); 
                    }
                  }
                  if(valor.getValue()%5==0 )
                  {
                    if(listaLanzaCohetes.size()>0)
                    {                         
                        mundo.addBalaEnL3(); 
                    }
                  }
               }
    }
      
    public void terminaJuego()
    {
     World mundo = getWorld();
     
     if(valor.getValue() == 59)
     {
      mundo.addObject(message,250,100);
      Greenfoot.delay(300);
      Greenfoot.setWorld(new MENU());   
     }
    }   
    
    public void tiempoBonifBala()
    {
      WarWorld mundo = (WarWorld) getWorld(); 
        
      Tanque t = mundo.dimeTanque(); 
      
      if(tiempoBon>=0)
      {       
        if(timer.millisElapsed()>795)
        {
         bonif.setValue(bonif.getValue()-1);   
         //System.out.println(tiempoBon);
        }
        
        if(valor.getValue()%2==0)
        {
         tiempoBon--;  
        } 
      }
       else
       {
        bonif.setValue(10);
        t.daño=0;
        tiempoBon=250;
       }
    }
    
    public void tiempoBonifEsc()
    {
      WarWorld mundo = (WarWorld) getWorld(); 
        
      Tanque t = mundo.dimeTanque();  
      
      if(tiempoBonEsc>=0)
      {   
        if(timer.millisElapsed()>795)
        {
         bonif.setValue(bonif.getValue()-1);   
         System.out.println(tiempoBonEsc);
        }
        
        if(valor.getValue()%2==0)
        {
         tiempoBonEsc--;  
        } 
      }
       else
       {
        bonif.setValue(10);
        t.escudoActivo=0; 
        tiempoBonEsc=250;
       }
    }
    
    public void agregaBonif()
    {
     WarWorld mundo = (WarWorld) getWorld(); 
           
     if(valor.getValue()%30==1)
     {
      mundo.addBon();   
     }
    }
}