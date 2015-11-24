
import greenfoot.*;
import java.util.List;

/**
 * Write a description of class WarWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WarWorld extends World
{
    public Tanque tanque = new Tanque(3);   
    public Artillero artillero = new Artillero();
    
    public Counter nivel;
    private Counter puntos;
     
    public Reloj reloj;
    
   
    int nEnemigos=0;
    int eliminados=0;
    
    /**
     * Constructor for objects of class WarWorld.
     * 
     */
    public WarWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 500, 1); 
        Greenfoot.setWorld(new MENU());
        puntos = new Counter("Puntos: ");
        puntos.setValue(0);
        addObject(puntos, 650, 10);
        prepare();
        //cambiaNivel();//
        
    }
    
    public void act()
    {
      agregaEnemigo();  
      //agregaBalaJ();
    }
    
    public void actualizaPuntos()
    {
     puntos.setValue(puntos.getValue() + 2);   
    }
    
    private void prepare()
    {
        addObject(tanque, 346, 435);
        reloj = new Reloj();
       addObject (reloj,250, 10);

        nivel = new Counter("Nivel: ");
        nivel.setValue(1);
        
        addObject(nivel, 380, 10);
    }
    
    public void agregaEnemigo()
    {
      if(nEnemigos <= 15)
      {
         if(Greenfoot.getRandomNumber(400)<2)
         {
          addObject (new Artillero(), Greenfoot.getRandomNumber(690)+10, 80);
          //agregaBalaE();
          nEnemigos++;
         }
      } 
     }
     
     /*public void agregaBalaE()
     {
      Artillero a = dimeArtillero();
      int x= a.getX(),y= a.getY();
      
      addObject(new BalaEnem(),x,y);
     }*/
    
    public Tanque dimeTanque()
    {
      return tanque;  
    }
    
    public Artillero dimeArtillero()
    {
      return artillero;  
    }
    
    public void cambiaNivel()
    {
      nivel.setValue(nivel.getValue() + 1);
      
      
      if(nivel.getValue() == 1)
      {
       setBackground("descarga4.jpg");   
      }
      
      if(nivel.getValue() == 2)
      {
       List listaArtilleros = this.getObjects(Artillero.class); 
       List listaBalasJ = this.getObjects(BalaJug.class);
       
       this.removeObjects(listaArtilleros);
       this.removeObjects(listaBalasJ);
       removeObject(tanque);
       
       setBackground("campodebatalla.jpg");   
       
       addLvL2();
       
       //addObject (new BalaEnemy(), 137, 165);
       //addObject (new BalaEnemy(), 537, 165);
       
       
    
      }
      
      if(nivel.getValue() == 3)
      {
       setBackground("images1.jpg");   
      }
      
      if(nivel.getValue() > 3)
      {
       nivel.setValue(3);   
       Greenfoot.stop(); 
      }
      
    }
    
    public void agregaBalaJ()
    {
     if(Greenfoot.isKeyDown("space"))
     {
       Tanque t = dimeTanque();
       int x=t.getX(),y=t.getY();
       addObject(new BalaJug(),x,y-60);
     }
    }
    
    public void aumentaEliminados()
    {
      eliminados++;  
      System.out.println("Eliminados="+eliminados);
      
      if(eliminados>=10)
      {
       cambiaNivel();   
      }
    }
    
    public void addBalaEn()
    {
       addObject (new BalaEnemy(), 137, 165);
       addObject (new BalaEnemy(), 537, 165);
    }
    
    public void addLvL2()
    {
        reloj = new Reloj();
       addObject (reloj,220, 10);
       
       addObject(tanque, 346, 435);
       addObject (new LanzaCohetes(), 550, 200);
       addObject (new LanzaCohetes(), 150, 200);
       addObject (new Muro(), 550, 225);
       addObject (new Muro(), 150, 225);
       
       
    }
    
    
}