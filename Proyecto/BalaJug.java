
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
    int a;
    Muro M;
    
    /**
     * Act - do whatever the BalaJug wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act() 
    {
       mueve();
       checa();

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
        
        mundo.actualizaPuntos();
        mundo.aumentaEliminados();
      }
      else
      {
       if(getY()== 0)   
       {
           
       mundo.removeObject(this);   
       }
      }    
      
        
    
      
    }
    public Muro dimeMuro()
    {
      return M ;  
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