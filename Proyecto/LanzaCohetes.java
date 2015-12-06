import greenfoot.*;

/**
 * Write a description of class LanzaCohetes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LanzaCohetes extends Soldado
{
    /**
     * Act - do whatever the LanzaCohetes wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */    
    public int vida=200;//La vida que tiene el LanzaCohete
    
    
    public void act() 
    {
      disminuyeVida();//El contador de las vidas se actualiza cuando este es tocado por la balaJug
    }
    
    public void disminuyeVida()
    {
        WarWorld mundo = (WarWorld) getWorld(); 
        
        Tanque t = mundo.dimeTanque();
        
        if(t.daño==1)/**verifica si aun tiene la bonificacion el tanque */
        {
          if(vida<=200 && vida>0)/**verifica si aun tiene vida el soldado */
          {  
            if(this.isTouching(BalaJug.class))/**cuando esta tocando la BalaJug la bala se elimina */
            {
             removeTouching(BalaJug.class);/** se eliminala balaJug*/
             vida=vida-200;   /** se decrementa la vida*/
            }
          }
        }
         else
         {  
           if(vida<=200 && vida>0)
           {
            if(isTouching(BalaJug.class))
            {
             removeTouching(BalaJug.class);/** se eliminala balaJug*/
             vida=vida-100; /** se decrementa la vida*/
            }
           }
          }
          
        if( vida<=0  )/**cuando ya no tiene vida el soldado este se elimina  */
        {
         mundo.removeObject(this);
        }
    }
}