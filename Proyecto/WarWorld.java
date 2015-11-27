
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
    public LanzaCohetes lanzacohetes1 = new LanzaCohetes();
    public LanzaCohetes lanzacohetes2 = new LanzaCohetes();
    public Torre torre1 = new Torre();
    public Torre torre2 = new Torre();
    private Torre torre3 = new Torre();
    
    
    public Counter nivel;
    private Counter puntos;
    
    private Vida VID=new Vida();
    public Reloj reloj;

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
        Greenfoot.setWorld(new MENU());
        //Greenfoot.playSound( "MDrums.mp3");

        
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
       nivel.setValue(0);
       cambiaNivel();
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
       B=1;
       addBon();
       
      }
      
      if(nivel.getValue() == 2)
      {
       List listaArtilleros = this.getObjects(Artillero.class); 
       List listaBalasJ = this.getObjects(BalaJug.class);
       
       this.removeObjects(listaArtilleros);
       this.removeObjects(listaBalasJ);
       removeObject(tanque);
       
       setBackground("campodebatalla2.jpg");   

       addImaLv2();
       B=2;
       addBon();
       
       
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
       
       B=3;
       addBon();
       
       setBackground("Ima(1).jpg");   
      }
      
      if(nivel.getValue() > 3)
      {
       nivel.setValue(3);   
       Greenfoot.setWorld(new MENU());   
      }
      
    }
    
    public void agregaBalaArtillero()
    {
      List listaArtilleros = this.getObjects(Artillero.class); 
      
      Artillero a = dimeArtillero();  
      
      //listaArtilleros = a.getX();
      
      //addObject(new BalaEnemy(),,220);
      
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
    
    public void addImaLv2()
    {
     addObject(tanque, 346, 435);
     
     addObject (lanzacohetes1, 550, 90);
     addObject (new Muro(), 550, 115);
     
     addObject (lanzacohetes2, 150, 90);
     addObject (new Muro(), 150, 115);  

    }
    
    public void addBalaEnL2()
    {
      Greenfoot.playSound( "Gun.wav");  
     if(lanzacohetes1.vida>0)
     {
      addObject (new BalaEnemy(), 537, 55);   
     } 
     
     if(lanzacohetes2.vida>0)
     {
      addObject (new BalaEnemy(), 137, 55);   
     } 
    }
    
    public void addImaLvL3()
    {
      lanzacohetes1 = new LanzaCohetes();
      lanzacohetes2 = new LanzaCohetes();
      
      addObject(tanque, 346, 435);
      
      addObject (torre1, 145, 87);
      addObject (torre2, 355, 87);
      addObject (torre3, 565, 87);

      addObject (lanzacohetes1, 230, 170);
      addObject (lanzacohetes2, 480, 170);
       
      addObject (new Muro(), 230, 199);
      addObject (new Muro(), 480, 199);
     
    }
    
    public void addBalaEnTor()
    {
      Greenfoot.playSound( "Bomba.mp3");  
        if(torre1.vida>0)
      {  
       addObject (new BalaEnemy(), 122, 55);
       addObject (new BalaEnemy(), 168, 55);
      }
      
      if(torre2.vida>0)
      {  
       addObject (new BalaEnemy(), 360, 55);
      }
      
      if(torre3.vida>0)
      {  
       addObject (new BalaEnemy(), 545, 55);
       addObject (new BalaEnemy(), 588, 55);
      }
    }
    
     public void addBalaEnL3()
    {
      Greenfoot.playSound( "Gun.wav");  
        if(lanzacohetes1.vida>0)
      { 
       addObject (new BalaEnemy(), 225, 140);
      }
      
      if(lanzacohetes2.vida>0)
      { 
       addObject (new BalaEnemy(), 475, 140);
      }
    }
    
    public void ganaste()
    {
     if(lanzacohetes1.vida<=0 && lanzacohetes2.vida<=0)   
     {
      if(torre1.vida<=0 && torre2.vida<=0 && torre3.vida<=0)   
      {
       Greenfoot.setWorld(new Ganaste());   
       Greenfoot.delay(300);
       Greenfoot.setWorld(new MENU()); 
       Greenfoot.stop();
       
      }
     }
    }
    
    public void addBon()
    {
      
      
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