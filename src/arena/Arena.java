/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arena;

/**
 *
 * @author Mark
 */




public class Arena {

    public static Aframe screen;
    public static int height = 1000;
    public static int width = 1880;
    public static int level = 1;
    
    public static int globalPlayerSize = 16;
    public static int globalPlayerSizeMultiplier = 3;
   public static int globalAmountOfEnemies = 1000;
   
   
   
    public static boolean globalSingularGravity = true; // when true, there is one point of gravity, when false, chained gravity
     public static boolean particles = false;  // when true, particles start everywhere
     public static boolean showStallman = false;
     public static boolean linearMovement = false;  // when true, this is our original movement 
     
     
     public static int globalHeroSize = 20;// * globalPlayerSizeMultiplier;
     public static int globalStallmanSize = 80;// * globalPlayerSizeMultiplier;
    public static int globalEnemySpeed = 1;
    
   public static int globalheroSpeed = 10;
  public static int globalTimerSpeed = 1;
  public static  int globalSpeedlimit = 12;// + heroSize;// douglas adams is max
   public static int globalMinSpeed = 2;
    
    public static void main(String[] args) {
       
        
        screen = new Aframe(); 
        
        
        
    }
}
