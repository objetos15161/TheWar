import greenfoot.*;
import greenfoot.GreenfootSound.*;

/**
 * Write a description of class MENU here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MENU extends World
{
    private Boton_Jugar boton_jugar;
    private Salir_Boton salir_boton;
    private Boton_Ayuda boton_ayuda;
   

    
    /**
     * Constructor for objects of class MENU.
     * 
     */
    public MENU()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 500, 1); 

        crearBotones();
        act();

   
      
    }
    public void crearBotones()
    {
       boton_jugar = new Boton_Jugar();
       salir_boton = new Salir_Boton();
       //record_boton =new Record_Boton();
       boton_ayuda = new Boton_Ayuda();
       
       this.addObject(boton_jugar, 343, 156);
       this.addObject(salir_boton, 343, 404);
       //this.addObject(record_boton, 590, 290);
       this.addObject(boton_ayuda, 343, 294);
   
    }
    
    /*  
    public void act()
    {
  
        
        if(Greenfoot.getMouseInfo()!=null)
        {
          
            if(Greenfoot.mousePressed(boton_jugar))
            {
                   
                //Greenfoot.setWorld(new WarWorld());
              
            }
            else if(Greenfoot.mousePressed(salir_boton))
            {
               // Greenfoot.stop();
            }
            
            else if(Greenfoot.mousePressed(boton_ayuda))
            {
             // Greenfoot.setWorld(new AYUDA());
            }
           
        }

    }
    */
}
