
import greenfoot.*;

public class Artillero extends Soldado
{
    /**
     * Act - do whatever the Artillero wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //int eliminados=0;
    
    public void act() 
    {
       mueve();
       elimina(); 
    }    
    
     public void elimina()
    {
     WarWorld mundo = (WarWorld) getWorld();
     
     if(isTouching(BalaJug.class))
     {
        mundo.removeObject(this); 
        /*eliminados++;
        System.out.println("ELIMINADOS="+eliminados);
        if(eliminados>=10)
        {
         mundo.cambiaNivel();   

        }*/
        }
     }
}