
import greenfoot.*;

/**
 * Write a description of class BalaJug here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BalaJug extends Municion
{
    //private Counter puntos;  
    
    int eliminados=0;
    
  
    
    /**
     * Act - do whatever the BalaJug wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act() 
    {
       mueve();//Hace qu la bala se mueve hacia arriba 
       checa();//Verifica si esta tocando un soldado y actualiza estados de puntuacion y vidas

    } 
    
   /* protected void addedToWorld(World mundo)
    {
     puntos = new Counter("Puntos: ");
     mundo.addObject(puntos, 650, 10);
    } */ 
    
    public void mueve()
    {
       setRotation(270); 
       move(2);
    }
    
    public void checa()
    {
      WarWorld mundo = (WarWorld) getWorld();
      
      
      if(isTouching(Artillero.class)) 
      { 
        
        mundo.actualizaPuntos();//actualiza el contador de los puntos
        mundo.aumentaEliminados();//actualiza la bandera de los eliminados
      }
      else
      {
       if(getY()== 0)   
       {
           
       mundo.removeObject(this);   //elimina la bala
       }
      }     
    }    
   
    
  
    /*public void checkMuro()
    {
        WarWorld mundo = (WarWorld) getWorld();
        M=dimeMuro();
        a=M.ContM;
        if(a>0 && a<=2)
        {
         mundo.removeObject(this);    
        }
    }
    */
}
