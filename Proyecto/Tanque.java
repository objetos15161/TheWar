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
    private int vida=300;
    
   
   private int Esc=0;
   private int Dan=0;
    
    private Message message = null;
    
    /**
     * Act - do whatever the Tanque wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
      mueve();
      disminuyeVidas();
      veifBoni();
    }    
    
    public Tanque(int numVidas)
    {
      vidas = new Counter ("Vidas: ");
      vidas.setValue(numVidas);   
      message = new Message("¡¡Game Over... Perdiste!!");

    }
    
    protected void addedToWorld(World mundo)
    {
        mundo.addObject(vidas, 50, 10);
    }
    
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
      
    public void disminuyeVidas()
    {
        World mundo = getWorld();
        
         if(vida<=300 && vida>0 && Esc==0)
         {  
          if(isTouching(BalaEnemy.class))
           {
            removeTouching(BalaEnemy.class);
            vida=vida-100;
            setLocation(mundo.getWidth()/2, mundo.getHeight()-50);

           }
         }
         
        if( vida<=0  )
        {
          vidas.setValue( vidas.getValue() - 1);
          
          if(vidas.getValue()<=0)
          {
           mundo.addObject(message,250,100);
           Greenfoot.delay(200);
           Greenfoot.setWorld(new MENU());   
           //Greenfoot.stop();
          }
           else
           {
            setLocation(mundo.getWidth()/2, mundo.getHeight()-50);
           }
          vida=300;
        }
    }
    
    public void veifBoni()
    {      
        World mundo = getWorld();
      
        if(isTouching(Vida.class))
        {
            
          removeTouching(Vida.class); 
          vidas.setValue(vidas.getValue() + 1);     
      
        }
        else
        {
            if(isTouching(Escudo.class))
            {
              removeTouching(Escudo.class); 
               
            } 
             
                
             /* System.out.println("TIME="+REL.valor.getValue());
               REL.valor.setValue(0); 
                Esc=1;
              if( REL.valor.getValue() ==10)
              {
                  Esc=0;
               }*/
            else
            {
                if(isTouching(Daño.class))
                {
                    removeTouching(Daño.class);   
                    Dan=1;
                }    
            }
        }
        
    }
}