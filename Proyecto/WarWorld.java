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
    public Tanque tanque= new Tanque();   
    private Counter nivel;
    
    int nEnemigos=0;
    
    /**
     * Constructor for objects of class WarWorld.
     * 
     */
    public WarWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 500, 1); 
        Greenfoot.setWorld(new MENU());
        prepare();
    }
    
    public void act()
    {
      agregaEnemigo();  
      agregaBalaJ();
    }
    
    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        //Tanque tanque = new Tanque();
        addObject(tanque, 346, 435);

        nivel = new Counter("Nivel: ");
        nivel.setValue(1);
        
        addObject(nivel, 350, 10);

        //Artillero artillero = new Artillero();
        //addObject(artillero, 348, 58);

        //BalaJugador balaJ = new BalaJugador();
        //addObject(balaJ, 345, 351);
    }
    
    public void agregaEnemigo()
    {
     if(nEnemigos < 10)
     {
      if(Greenfoot.getRandomNumber(400)<2)
      {
       addObject (new Artillero(), Greenfoot.getRandomNumber(690)+10, 80);
       nEnemigos++;
      }
       
      if(nEnemigos >=10)
      {
       cambiaNivel();   
      }
     }
    }
    
    public Tanque dimeTanque()
    {
      return tanque;  
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
       
       this.removeObjects(listaArtilleros);
       removeObject(tanque);
       setBackground("campodebatalla.jpg");   
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
     if(Greenfoot.isKeyDown("a"))
     {
       Tanque t = dimeTanque();
       int x=t.getX(),y=t.getY();
       addObject(new BalaJug(),x,y);
     }
    }
}
