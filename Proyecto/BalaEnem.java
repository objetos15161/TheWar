import greenfoot.*;

/**
 * Crea la Clase de las Balas de los Enemigos
 * 
 * @author Villegas Puente Ruben,Quistian Martinez Alberto 
 * @version 2015.11.7
 */
public class BalaEnem extends Municion
{
    /**
     * La bala que representa al enemigo
     */
    public void act() 
    {
        mueve();///Hace qu la bala se mueve hacia abajo donde esta el tanque

        Check();//Verifica si esta tocando la coordenada mas alta en Y del MUNDO esta se elimina 
    }    
    
    /**Hace que la bala se mueve hacia abajo donde esta el tanque*/
    public void mueve()
    {
        setRotation(90); //270
        move(2);
    }
    
    /**Verifica si esta tocando la coordenada mas alta en Y del MUNDO esta se elimina */
    public void Check ()
    {
        WarWorld mundo = (WarWorld) getWorld();
        if(getY()>=499)
        {
            mundo.removeObject(this);     
        }

    }  
}
