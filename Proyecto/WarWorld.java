import greenfoot.*;
import java.util.List;

/**
 * Write a description of class WarWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WarWorld extends World
{
    public Tanque tanque = new Tanque(3);   
    public Artillero artillero = new Artillero();
    
    public Counter nivel;
    private Counter puntos;
     
    public Reloj reloj;
    
   
    int nEnemigos=0;
    int nEnemigosNv2=0;
    int eliminados=0;
    
    /**
     * Constructor for objects of class WarWorld.
     * 
     */
    public WarWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 500, 1); 
        Greenfoot.setWorld(new MENU());
        puntos = new Counter("Puntos: ");
        puntos.setValue(0);
        addObject(puntos, 650, 10);
        prepare();
        //cambiaNivel();
        
    }
    
    public void act()
    {
     agregaEnemigo();  
    }
    
    public void actualizaPuntos()
    {
     puntos.setValue(puntos.getValue() + 2);   
    }
    
    private void prepare()
    {
       addObject(tanque, 346, 435);
       reloj = new Reloj();
       addObject (reloj,250, 10);

       nivel = new Counter("Nivel: ");
       nivel.setValue(1);
   
       addObject(nivel, 440, 10);     
    }
    
    public void agregaEnemigo()
    {
      if(nivel.getValue() == 1)
      { 
        if(nEnemigos <= 15)
        {  
          if(Greenfoot.getRandomNumber(400)<2)
          {
            addObject (new Artillero(), Greenfoot.getRandomNumber(690)+10, 80);
            nEnemigos++;
          }
        }
      }
       else{
             if(nivel.getValue() == 2)
             {
               if(nEnemigosNv2 <= 10)
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

     /*public void agregaBalaE()
     {
      Artillero a = dimeArtillero();
      int x= a.getX(),y= a.getY();
      
      addObject(new BalaEnem(),x,y);
     }*/
    
    public Tanque dimeTanque()
    {
      return tanque;  
    }
    
    public Artillero dimeArtillero()
    {
      return artillero;  
    }
    
    public void cambiaNivel()
    {
      nivel.setValue(nivel.getValue() + 1);     
      
      if(nivel.getValue() == 1)
      {
       setBackground("descarga4.jpg");   
      }
      
      if(nivel.getValue() == 2)
      {
       List listaArtilleros = this.getObjects(Artillero.class); 
       List listaBalasJ = this.getObjects(BalaJug.class);
       
       this.removeObjects(listaArtilleros);
       this.removeObjects(listaBalasJ);
       removeObject(tanque);
       
       setBackground("campodebatalla2.jpg");   

       addImaLvL2();
      }
      
      if(nivel.getValue() == 3)
      {   
       List listaArtilleros = this.getObjects(Artillero.class); 
       List listaBalasJ = this.getObjects(BalaJug.class);
       List listaLanzaCohetes = this.getObjects(LanzaCohetes.class);
       List listaMuros = this.getObjects(Muro.class);
       List listaBalasEnem = this.getObjects(BalaEnemy.class);
       
       this.removeObjects(listaArtilleros);
       this.removeObjects(listaBalasJ);
       this.removeObjects(listaLanzaCohetes);
       this.removeObjects(listaMuros);
       this.removeObjects(listaBalasEnem);
       removeObject(tanque);  
       
       addImaLvL3();
       
       
       setBackground("Ima(1).jpg");   
      }
      
      if(nivel.getValue() > 3)
      {
       nivel.setValue(3);   
       Greenfoot.stop(); 
      }
      
    }
    
    public void agregaBalaJ()
    {
     if(Greenfoot.isKeyDown("space"))
     {
       Tanque t = dimeTanque();
       int x=t.getX(),y=t.getY();

       addObject(new BalaJug(),x,y-60);
     }
    }
    
    public void aumentaEliminados()
    {
      eliminados++;  
      //System.out.println("Eliminados="+eliminados);
      
      if(nivel.getValue() == 1)
      {
       if(eliminados>=5)
       { 
        cambiaNivel();   
        eliminados=0;
       } 
      }

      if(nivel.getValue() == 2)
      {
        if(eliminados>=5)
        { 
         cambiaNivel();   
        }  
      }  
    }
    
    public void addBalaEnL2()
    {
       addObject (new BalaEnemy(), 137, 55);
       addObject (new BalaEnemy(), 537, 75);
    }
    
    public void addImaLvL2()
    {
       /*reloj = new Reloj();
       addObject (reloj,220, 10);*/
       
       addObject(tanque, 346, 435);
       addObject (new LanzaCohetes(), 550, 90);
       addObject (new LanzaCohetes(), 150, 90);
       addObject (new Muro(), 550, 115);
       addObject (new Muro(), 150, 115);
       
       
    }   
    
    public void  addImaLvL3()
    {
       addObject(tanque, 346, 435);
       addObject (new Torre(), 145, 87);
       addObject (new Torre(), 360, 87);
       addObject (new Torre(), 565, 87);
       addObject (new LanzaCohetes(), 240, 170);
       addObject (new LanzaCohetes(), 488, 170);
       addObject (new Muro(), 230, 199);
       addObject (new Muro(), 480, 199);

    }
    
    
    public void addBalaEnTor()
     {
       addObject (new BalaEnemy(), 122, 55);
       addObject (new BalaEnemy(), 168, 55);
       addObject (new BalaEnemy(), 360, 55);
       addObject (new BalaEnemy(), 545, 55);
       addObject (new BalaEnemy(), 588, 55);
     }
    
     public void addBalaEnL3()
    {
       addObject (new BalaEnemy(), 225, 140);
       addObject (new BalaEnemy(), 475, 180);
    }
     
}