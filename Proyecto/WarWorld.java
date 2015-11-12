import greenfoot.*;

/**
 * Write a description of class WarWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WarWorld extends World
{
    public Tanque tanque;
    
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
        agregaEnemigo();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        Tanque tanque = new Tanque();
        addObject(tanque, 346, 435);

        //Artillero artillero = new Artillero();
        //addObject(artillero, 348, 58);

        //BalaJugador balaJ = new BalaJugador();
        //addObject(balaJ, 345, 351);
    }
    
    public void agregaEnemigo()
    {
     if(Greenfoot.getRandomNumber(400)<300)
     {
      addObject (new Artillero(), Greenfoot.getRandomNumber(690)+10, 58);
     }   
    }
    
    public Tanque dimeTanque()
    {
      return tanque;  
    }
}