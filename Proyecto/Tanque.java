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
    private int vidX=300;
    
    public int x;
    public int y;
    
    /**
     * Act - do whatever the Tanque wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
      mueve();
      disminuyeVidas();
    }    
    
    public Tanque(int numVidas)
    {
      vidas = new Counter ("Vidas: ");
      vidas.setValue(numVidas);   

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
    
    
    public void regresaCoordenadas(int x,int y)
    {
      x=getX();
      y=getY();
    }
    
    
    public void disminuyeVidas()
    {
        World mundo = getWorld();
        
         if(vidX<=300 && vidX>0){  
          if(isTouching(BalaEnemy.class))
           {
            vidX=vidX-100;
            setLocation(mundo.getWidth()/2, mundo.getHeight()-50);
           }
        }//super.isTouching(Lemon.class))
        if( vidX<=0  )
        {
            vidas.setValue( vidas.getValue() - 1);
            if(vidas.getValue()<=0)
            {
               mundo.showText("Game Over.....Perdiste .",350,300);
                Greenfoot.stop();
                
            }
            else
            {
                setLocation(mundo.getWidth()/2, mundo.getHeight()-50);
            }
            vidX=300;
        }
    }
}
