import greenfoot.*;

/**
 *La bala que representa al enemigo
 * Hace que la bala se mueve hacia abajo donde esta el tanque y
 * Verifica si esta tocando la coordenada mas alta en Y del MUNDO esta se elimina 
 *
 * @author Villegas Puente Ruben , Quistian Martinez Alberto 
 * @version 2015.11.7
 */
public class Granada extends Municion
{
 
    public void act() 
    {
        mueve();///Hace qu la bala se mueve hacia abajo donde esta el tanque

        Check();//Verifica si esta tocando la coordenada mas alta en Y del MUNDO esta se elimina 
    }    

    public void mueve()
    {
        setRotation(90); //270
        move(2);
    }
    
    public void Check ()/**Verifica si esta tocando el borde de la coordenada maxima en Y */
    {
        WarWorld mundo = (WarWorld) getWorld();
        if(getY()>=499)
        {
            mundo.removeObject(this);     
        }
    }  
}