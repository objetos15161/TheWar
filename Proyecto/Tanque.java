import greenfoot.*;

/**
 * Crea la clase Tanque con sus caracteristicas
 * 
 * @author Villegas Puente Ruben,Quistian Martinez Alberto 
 * @version 2015.11.7
 */
public class Tanque extends Actor
{
   private Counter vidas;  
   private int vida=300;  
   
   private int Esc=0;
   private int Dan=0;
   public int daño=0;
   public int escudoActivo=0;
   
   private GreenfootSound muLcohete;
   private GreenfootSound muTorre;
   
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
    
    /** Inicializa objetos del tanque*/
    public Tanque(int numVidas)
    { 
      vidas = new Counter ("Vidas: ");
      vidas.setValue(numVidas);   
      message = new Message("¡¡Game Over... Perdiste!!");

    }
   
    /** Agrega el contador vidas al mundo*/
    protected void addedToWorld(World mundo)
    {
      mundo.addObject(vidas, 50, 10);
    }
    
    /** Mueve el Tanque*/
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
      
    /** Disminuye las vidas del Tanque*/
    public void disminuyeVidas()
    {
        WarWorld mundo = (WarWorld) getWorld(); 
        
        Reloj r = mundo.dimeReloj();
        //BotonJugar BJ = mundo.dimeBotonJug();
        
        if(escudoActivo==0)
        {
         if(vida<=300 && vida>0 && Esc==0)
         {  
          if(isTouching(Granada.class))
           {
            removeTouching(Granada.class);
            System.out.println(vida);
            vida=vida-100;
            setLocation(mundo.getWidth()/2, mundo.getHeight()-50);
           } 
            else
            {
               if(isTouching(BalaEnem.class))
               {
                removeTouching(BalaEnem.class);
                System.out.println(vida);
                vida=vida-100;
                setLocation(mundo.getWidth()/2, mundo.getHeight()-50);
               }    
            }
         }
        }
        
        if(escudoActivo==1)
        {
         r.tiempoBonifEsc();   
        }
         
        if( vida<=0  )
        {
          vidas.setValue( vidas.getValue() - 1);
          
          if(vidas.getValue()<=0)
          {
           mundo.addObject(message,250,100);
           Greenfoot.delay(200);
           muLcohete.stop();
           muTorre.stop();
           //BJ.detenMusica();
           Greenfoot.setWorld(new Menu());   
          }
           else
           {
            setLocation(mundo.getWidth()/2, mundo.getHeight()-50);
           }
          vida=300;
        }
    }
    
    /** Verifica si el Tanque esta tocando alguna bonificacion y la activa*/
    public int veifBoni()
    {      
        WarWorld mundo = (WarWorld) getWorld(); 
        
        Reloj r = mundo.dimeReloj();
        
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
              escudoActivo=1;
            } 

            else
            {
                if(isTouching(Daño.class))
                {
                    removeTouching(Daño.class);   
                    daño=1;
                }    
            }
        }
        
        //System.out.println("activo "+daño);
        if(daño==1)
        {
           r.tiempoBonifBala();
        }
        return daño;
    }
}