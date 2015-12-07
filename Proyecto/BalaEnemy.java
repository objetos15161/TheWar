import greenfoot.*;

/**
 * Write a description of class BalaEnemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BalaEnemy extends Municion
{
    
    
    /**
     * La bala que representa al enemigo
     */
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
    
    public void Check ()
    {
        WarWorld mundo = (WarWorld) getWorld();
        if(getY()>=499)
        {
         mundo.removeObject(this);     
        }

    }  
}
