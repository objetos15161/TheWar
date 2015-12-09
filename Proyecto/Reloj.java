import greenfoot.*;
import java.util.List;

/**
 * Con el reloj dependenden varias clases como las bonificaciones que duran cierto tiempo
 * tambien las balas que aparecen cada determinando tiempo 
 * @author (your name) 
 * @version (1.5)
 */

public class Reloj extends Actor
{
    protected SimpleTimer timer;
    protected Counter valor;
    protected Counter bonif;

    private Message message = null;
    private int tiempoBon=250;
    private int tiempoBonEsc=230;
    private int n;

    public Reloj()/**Se asigna a cada variable el tipo de objeto a usar*/
    {
        valor = new Counter("Tiempo: ");
        bonif = new Counter("Bonificacion: ");
        timer = new SimpleTimer();
        message = new Message("¡¡Game Over... Perdiste!!");

        bonif.setValue(10);
    }    

    /**@param World mundo 
     * Se añade al mundo el contador del tiempo y de la bonificacion*/
    protected void addedToWorld(World mundo)
    {
        mundo.addObject(valor, 250, 10);
        mundo.addObject(bonif, 620, 480);  
    }

    /**
     *@param tiene un limite maximo 
     *Es donde se añaden las balas  y se le asigna el tiempo a las bonificaciones
     */
    public void act() 
    {
        WarWorld mundo = (WarWorld) getWorld();

        if(timer.millisElapsed()>800)
        {
            valor.add(1);
            timer.mark();

            mundo.agregaBalaJ(); 

            reiniciaReloj();  
        }           
    }    

    public void reiniciaReloj() /** Se reinicia el reloj cada vez que cambia de nivel
    Hace el llamado para que agregue las balas 
    del enemigo acorde el nivel */
    {
        WarWorld mundo = (WarWorld) getWorld();  

        n=mundo.nivel.getValue();

        if(n==1)
        {
            activaBalE1();  
            terminaJuego();  
        }

        if(n==2)
        {    
            activaBalE2();
        }

        if(n==3)
        {
            activanivel3();   
        }
    }

    public void activaBalE1()/** Hace el llamado para que agregue las balas 
    del enemigo en nivel 1*/
    {
        WarWorld mundo = (WarWorld) getWorld();

        List listaInfanteriaPesada = mundo.getObjects(InfanteriaPesada.class);

        if(valor.getValue()>6)
        {
            if(valor.getValue()%6==0 )
            {
                if(listaInfanteriaPesada.size()>0)
                {
                    mundo.addBalaEnL1();              
                }
            }
        }
    }   

    public void activaBalE2()/** Hace el llamado para que agregue las balas 
    del enemigo en nivel 2*/
    {
        WarWorld mundo = (WarWorld) getWorld();

        List listaLanzaCohetes = mundo.getObjects(Granadero.class);

        if(valor.getValue()>6)
        {
            if(valor.getValue()%6==0 )
            {
                if(listaLanzaCohetes.size()>0)
                {
                    mundo.addBalaEnL2();              
                }
            }
        }
    }  

    public void activanivel3()/** Hace el llamado para que agregue las balas 
    del enemigo en nivel 3*/
    {
        WarWorld mundo = (WarWorld) getWorld();

        List listaTorres = mundo.getObjects(Torre.class);
        List listaLanzaCohetes = mundo.getObjects(Granadero.class);

        mundo.ganaste();

        if(valor.getValue()>6)
        {
            if(valor.getValue()%3==0 )
            {
                if(listaTorres.size()>0)
                {                   

                    mundo.addBalaEnTor(); 
                }
            }
            if(valor.getValue()%5==0 )
            {
                if(listaLanzaCohetes.size()>0)
                {                         
                    mundo.addBalaEnL3(); 
                }
            }
        }
    }

    public void terminaJuego()/** Si al inicio el tiempo llega a 59 el juego termina*/
    {
        World mundo = getWorld();

        if(valor.getValue() == 60)
        {
            mundo.addObject(message,250,100);
            Greenfoot.delay(300);
            Greenfoot.setWorld(new Menu());   
        }
    }   

    public void tiempoBonifBala()/**Asigna el tiempo a la bonificacion de ATAQUE*/
    {
        WarWorld mundo = (WarWorld) getWorld(); 

        Tanque t = mundo.dimeTanque(); 

        if(tiempoBon>=0)
        {       
            if(timer.millisElapsed()>794.9)
            {
                bonif.setValue(bonif.getValue()-1);   
                //System.out.println(tiempoBon);
            }

            if(valor.getValue()%2==0)
            {
                tiempoBon--;  
            } 
        }
        else
        {
            bonif.setValue(10);
            t.daño=0;
            tiempoBon=250;
        }
    }

    public void tiempoBonifEsc()/**Asigna el tiempo a la bonificacion de ESCUDO*/
    {
        WarWorld mundo = (WarWorld) getWorld(); 

        Tanque t = mundo.dimeTanque();  

        if(tiempoBonEsc>=0)
        {   
            if(timer.millisElapsed()>794.9)
            {
                bonif.setValue(bonif.getValue()-1);   
                //System.out.println(tiempoBonEsc);
            }

            if(valor.getValue()%2==0)
            {
                tiempoBonEsc--;  
            } 
        }
        else
        {
            bonif.setValue(10);
            t.escudoActivo=0; 
            tiempoBonEsc=250;
        }
    }

    public void agregaBonif()/**Agrega el objeto de la bonificacion a el juego*/
    {
        WarWorld mundo = (WarWorld) getWorld(); 

        if(valor.getValue()%30==1)
        {
            mundo.addBon();   
        }
    }
}