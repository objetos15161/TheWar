import greenfoot.*;
import greenfoot.GreenfootSound.*;


/**
 * Es la imagen principal del juego donde acorde al botón seleccionado se hace una 	 
 * acción determinada dentro del juego	

 * @author Villegas Puente Ruben,Quistian Martinez Alberto 
 * @version 2015.11.7
 */

public class MENU extends World
{
    private Boton_Jugar boton_jugar;
    private Salir_Boton salir_boton;
    private Boton_Ayuda boton_ayuda;
   

    
    /**
     * Crea el MENU del juego con sus respectivos botones
     */
    public MENU()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 500, 1); 

        crearBotones();
        act();

   
      
    }
    public void crearBotones()/**Crea los botones del juego asignandoles una posición*/
    {
       boton_jugar = new Boton_Jugar();
       salir_boton = new Salir_Boton();

       boton_ayuda = new Boton_Ayuda();
       
       this.addObject(boton_jugar, 343, 156); /** Agrega el boton de jugar */
       this.addObject(salir_boton, 343, 404);
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
