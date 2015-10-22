/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

/**
 *
 * @author Mark
 */




public class Space {
    

    public static double universalGravitationConstant = 6.673;
    public static double universalGravitationConstantMultiplier = .001;  //this is a double value in powers of ten
    
    public static Aframe screen;
    public static int height = 1000;
    public static int width = 1880;
    public static int level = 1;
    
    public static int globalParticleSize = 16;
    public static double globalParticleMass = 10.0;
   public static int globalAmountOfParticles = 1000;
   
   public static int gravityWellDistance = 200;
    public static double massOfCenter = 10.0;
   
    public static boolean globalSingularGravity = true; // when true, there is one point of gravity, when false, chained gravity
     public static boolean particles = false;  // when true, particles start everywhere
     public static boolean showStallman = false;
     public static boolean linearMovement = false;  // when true, this is our original movement 
     public static boolean gravityGetsStronger = true;
     public static boolean allParticlesHaveGravity = true; // leave this off until we get a fast processor!
     
     
     public static int globalStallmanSize = 80;// * globalParticleSizeMultiplier;
    public static int globalEnemySpeed = 1;
    
  
  public static int globalTimerSpeed = 1;
  public static  int globalSpeedlimit = 12;// + heroSize;// douglas adams is max
   public static int globalMinSpeed = 2;
    
   
   // these have yet to be added to the start panel
    public static int globalParticleSizeMultiplier = 3;
    public static int globalheroSpeed = 10;
   public static int globalHeroSize = 20;// * globalParticleSizeMultiplier;
   
   
   
   
   
   
   
   
   
   
    public static void main(String[] args) {
       
        
        screen = new Aframe(); 
        
        
        
    }
}
