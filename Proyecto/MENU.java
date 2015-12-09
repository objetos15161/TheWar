import greenfoot.*;
import greenfoot.GreenfootSound.*;


/**
 * Es la imagen principal del juego donde acorde al botón seleccionado se hace una 	 
 * acción determinada dentro del juego	

 * @author Villegas Puente Ruben,Quistian Martinez Alberto 
 * @version 2015.11.7
 */

public class Menu extends World
{
    private BotonJugar botonJugar;
    private BotonCreditos salirBoton;
    private BotonAyuda botonAyuda;

    /**
     * Crea el MENU del juego con sus respectivos botones
     */
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 500, 1); 

        crearBotones();
        act(); 
    }
    
    public void crearBotones()/**Crea los botones del juego asignandoles una posición*/
    {
       botonJugar = new BotonJugar();
       salirBoton = new BotonCreditos();

       botonAyuda = new BotonAyuda();
       
       this.addObject(botonJugar, 343, 156); /** Agrega el boton de jugar */
       this.addObject(salirBoton, 343, 404);
       this.addObject(botonAyuda, 343, 294);
   
    }
}