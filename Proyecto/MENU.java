import greenfoot.*;

/**
 * Write a description of class MENU here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MENU extends World
{

    /**
     * Constructor for objects of class MENU.
     * 
     */
    public MENU()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 500, 1); 
        prepare();
    }
    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        Boton_Jugar boton_jugar = new Boton_Jugar();
        addObject(boton_jugar, 283, 500);

        removeObject(boton_jugar);
        Boton_Jugar boton_jugar2 = new Boton_Jugar();
        addObject(boton_jugar2, 296, 247);
        boton_jugar2.setLocation(220, 189);
        boton_jugar2.setLocation(408, 185);
        boton_jugar2.setLocation(427, 124);
        Boton_Ayuda boton_ayuda = new Boton_Ayuda();
        addObject(boton_ayuda, 238, 256);
        Boton_Ayuda boton_ayuda2 = new Boton_Ayuda();
        addObject(boton_ayuda2, 210, 257);
        removeObject(boton_ayuda2);
        removeObject(boton_ayuda);
        Boton_Ayuda boton_ayuda3 = new Boton_Ayuda();
        addObject(boton_ayuda3, 185, 255);
        Record_Boton record_boton = new Record_Boton();
        addObject(record_boton, 663, 258);
        Salir_Boton salir_boton = new Salir_Boton();
        addObject(salir_boton, 431, 433);
        record_boton.setLocation(660, 273);
        boton_ayuda3.setLocation(163, 274);
    }
}
