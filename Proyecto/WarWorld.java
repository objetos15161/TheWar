import greenfoot.*;
import java.util.List;

/**
 * Crea el los escenarios del juego de acuerdo al nivel 
 * 
 * @author Villegas Puente Ruben,Quistian Martinez Alberto 
 * @version 2015.11.7
 */
public class WarWorld extends World
{
    /** Crea un objeto de las clases*/
    private Tanque tanque = new Tanque(3);  
    private Artillero artillero = new Artillero(); 
    private InfanteriaPesada infanteriaP1 = new InfanteriaPesada(); 
    private InfanteriaPesada infanteriaP2 = new InfanteriaPesada(); 
    private Granadero granadero;
    private Granadero granadero1 = new Granadero();
    private Granadero granadero2 = new Granadero();
    private Torre torre1 = new Torre();
    private Torre torre2 = new Torre();
    private Torre torre3 = new Torre();
    private BotonJugar botonJug;
    
    public Counter nivel; /** Contador del nivel */
    private Counter puntos; /** Contador de puntos */
    
    private Vida VID = new Vida(); /** Contador de vidas */
    private Reloj reloj; 
    private GreenfootSound muLcohete;
    private GreenfootSound muTorre; 
    private GreenfootSound muWin; 
    int nEnemigos=0;
    int nEnemigosNv2=0;
    int eliminados=0;
    int B=0; 
   
    /**
     * Constructor for objects of class WarWorld.
     * 
     */
    
    public WarWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 500, 1); 
        Greenfoot.setWorld(new Menu());

        
        muWin= new GreenfootSound("aplausos.mp3");
        muLcohete= new GreenfootSound("Gun.wav");
        muTorre= new GreenfootSound( "Bomba.mp3");
        puntos = new Counter("Puntos: ");
        puntos.setValue(0);
        addObject(puntos, 650, 10);
        prepare();
        started();
    }
    
    public void act()
    {
     agregaEnemigo(); 
     addBon();
    }
    
    /** Actualiza los puntos del jugador*/
    public void actualizaPuntos()
    {
     puntos.setValue(puntos.getValue() + 2);   
    }
    
    /** Inicia los objetos del mundo*/
    private void prepare()
    {
       addObject(tanque, 346, 435);
       reloj = new Reloj();
       addObject (reloj,250, 10);

       nivel = new Counter("Nivel: ");
       nivel.setValue(0);
       cambiaNivel();
       addObject(nivel, 440, 10);     
    }
    
    /** Agrega los enemigos Artilleros en una coordenada en x al azar y en un tiempo al azar*/
    public void agregaEnemigo()
    {
      if(nivel.getValue() == 1)
      { 
        if(nEnemigos <= 10)
        {  
          if(Greenfoot.getRandomNumber(400)<2)
          {
            addObject (new Artillero(), Greenfoot.getRandomNumber(690)+10, 200);
            nEnemigos++;
          }
        }
      }
       else{
             if(nivel.getValue() == 2)
             {
               if(nEnemigosNv2 <= 8)
               {    
                 if(Greenfoot.getRandomNumber(400)<2)
                 {
                  addObject (new Artillero(), Greenfoot.getRandomNumber(690)+10, 210);
                  nEnemigosNv2++;
                 }  
               }
             }
            }
    }
    
    /** Regresa la clase Tanque*/
    public Tanque dimeTanque()
    {
      return tanque;  
    }
    
    /** Regresa la clase Artillero*/
    public Artillero dimeArtillero()
    {
      return artillero;  
    }
    
    /** Regresa la clase Granadero*/
    public Granadero dimeLanzaCohetes()
    {
      return granadero;  
    }   
    
    /** Regresa la clase Reloj*/
    public Reloj dimeReloj()
    {
     return reloj;   
    }
   
    /** Crea los niveles del juego */
    public void cambiaNivel()
    { 
      nivel.setValue(nivel.getValue() + 1);     
       
      if(nivel.getValue() == 1)
      {
       setBackground("descarga4.jpg");  
       addImaLv1();
       addBon();    
      }
      
      if(nivel.getValue() == 2)
      {
       List listaArtilleros = this.getObjects(Artillero.class); 
       List listaBalasJ = this.getObjects(BalaJug.class);
       List listaInfanteriaP = this.getObjects(InfanteriaPesada.class);
       List listaBalasE = this.getObjects(BalaEnem.class);
       
       this.removeObjects(listaArtilleros);
       this.removeObjects(listaBalasJ);
       this.removeObjects(listaInfanteriaP);
       this.removeObjects(listaBalasE);
       removeObject(tanque);
       
       setBackground("campodebatalla2.jpg");   

       addImaLv2();
       addBon();  
      }
      
      if(nivel.getValue() == 3)
      {   
       
       muLcohete.stop();   
       List listaArtilleros = this.getObjects(Artillero.class); 
       List listaBalasJ = this.getObjects(BalaJug.class);
       List listaGranaderos = this.getObjects(Granadero.class);
       List listaMuros = this.getObjects(Muro.class);
       List listaBalasEnem = this.getObjects(Granada.class);
       
       this.removeObjects(listaArtilleros);
       this.removeObjects(listaBalasJ);
       this.removeObjects(listaGranaderos);
       this.removeObjects(listaMuros);
       this.removeObjects(listaBalasEnem);
       removeObject(tanque);  
       
       addImaLvL3();
       addBon();
       
       setBackground("Ima(1).jpg");   
      }
      
      if(nivel.getValue() > 3)
      {
       nivel.setValue(3);   
       Greenfoot.setWorld(new Menu());   
      }
      
    }
    
    public void agregaBalaJ() /**verifica si se esta presionando la tecla espacio y se crea una BalaJug
                                en las coordenadas actuales en donde esta el tanque*/
    {
     if(Greenfoot.isKeyDown("space"))
     {
       Tanque t = dimeTanque();
       int x=t.getX(),y=t.getY();

       addObject(new BalaJug(),x,y-60);
     }
    }
    
    public void aumentaEliminados()/**Incrementa el numero de eliminados y verifica el numero de eliminados */
    {
      eliminados++;  
      //System.out.println("Eliminados="+eliminados);
      
      if(nivel.getValue() == 1)
      {
       if(eliminados>=4)
       { 
        cambiaNivel();   
        eliminados=0;
       } 
      }

      if(nivel.getValue() == 2)
      {
        if(eliminados>=4)
        { 
         cambiaNivel();   
        }  
      }  
    }
    
    public void addImaLv1()
    {
     addObject(infanteriaP1,180,80 ); 
     addObject(infanteriaP2,500,80 ); 
    }
    
    public void addImaLv2()/**Agrega los enemigos del nivel 2 */
    {
     addObject(tanque, 346, 435);
     
     addObject (granadero1, 550, 90);
     addObject (new Muro(), 550, 115);
     
     addObject (granadero2, 150, 90);
     addObject (new Muro(), 150, 115);  
    }
    
    public void addBalaEnL1()/**Agrega las  balas de los enemigos  del nivel 1 */
    
    {
      //Greenfoot.playSound( "Gun.wav");  
      
     if(infanteriaP1.vida>0)
     {
      addObject (new BalaEnem(), 180, 90 );   
     } 
     muLcohete.play();
     if(infanteriaP2.vida>0)
     {
      addObject (new BalaEnem(), 500, 90);   
     } 
    }
    
    public void addBalaEnL2()/**Agrega las  balas de los enemigos  del nivel 2 */
    
    {
      //Greenfoot.playSound( "Gun.wav");  
      
     if(granadero1.vida>0)
     {
      addObject (new Granada(), 537, 55);   
     } 
     muLcohete.play();
     if(granadero2.vida>0)
     {
      addObject (new Granada(), 137, 55);   
     } 
    }
    
    public void addImaLvL3()/**Agrega los enemigos del nivel 3 */
    {
      granadero1 = new Granadero();
      granadero2 = new Granadero();
      
      addObject(tanque, 346, 435);
      
      addObject (torre1, 145, 87);
      addObject (torre2, 355, 87);
      addObject (torre3, 565, 87);

      addObject (granadero1, 230, 170);
      addObject (granadero2, 480, 170);
       
      addObject (new Muro(), 230, 199);
      addObject (new Muro(), 480, 199);
     
    }
    
    public void addBalaEnTor()/**Agrega la bala de la torre en nivel 3 */
    {
      muTorre.play();
       
      if(torre1.vida>0)
      {  
       addObject (new Granada(), 122, 55);
       addObject (new Granada(), 168, 55);

      }

      if(torre2.vida>0)
      {  
       addObject (new Granada(), 360, 55);

      }

      if(torre3.vida>0)
      {  
       addObject (new Granada(), 545, 55);
       addObject (new Granada(), 588, 55);

      }
    }
    
    public void addBalaEnL3()/**Agrega la bala del lanzacohetes en nivel 3 */
    {
      if(granadero1.vida>0)
      { 
       addObject (new Granada(), 225, 140);
      }
      muLcohete.play();
      if(granadero2.vida>0)
      { 
       addObject (new Granada(), 475, 140);
      }

    }
    
    public void ganaste()/**verifica si aun hay enemigos y si ya no hay aparece la imagen de GANASTE
                            y el juego termian y regresa al MENU*/
    {
     if(granadero1.vida<=0 && granadero2.vida<=0)   
     {
      if(torre1.vida<=0 && torre2.vida<=0 && torre3.vida<=0)   
      {
       muLcohete.stop();
       muTorre.stop();
       muWin.play();
       Greenfoot.setWorld(new Ganaste());   
       Greenfoot.delay(300);
       muWin.stop();
       Greenfoot.setWorld(new Menu());       
      }
     }
    }
    
    public void addBon()/**Agrega las bonificaciones */
    { 
      if(Greenfoot.getRandomNumber(820)<1)
      {  
       B=Greenfoot.getRandomNumber(3)+1;  
      
       switch(B)
       {
         case 1: 
         addObject (VID, Greenfoot.getRandomNumber(670)+10, 444);
         break;
         
         case 2:
         addObject (new Escudo(), Greenfoot.getRandomNumber(670)+10, 444);
         break;
         
         case 3:
         addObject (new Daño(), Greenfoot.getRandomNumber(670)+10, 444);
         break;         
       }
      }
    }
}