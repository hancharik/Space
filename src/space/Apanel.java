/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Mark
 */
public class Apanel extends JPanel implements ActionListener, KeyListener, MouseListener {
    
    int playerSize = space.Space.globalParticleSize;
    int amountOfEnemies;// = space.Space.globalAmountOfEnemies;
    int heroSize = space.Space.globalHeroSize;
     //int heroSize = amountOfEnemies;
    
    int enemySpeed = space.Space.globalEnemySpeed;
    
    int heroSpeed = 10;
    int timerSpeed = space.Space.globalTimerSpeed;
    int speedlimit = space.Space.globalSpeedlimit;// + heroSize;// douglas adams is max
    int minSpeed = space.Space.globalMinSpeed;
    Sbutton hero;
    ArrayList<Sbutton> enemies = new ArrayList();
     ArrayList<Sbutton> stuffBucket = new ArrayList();
     int stuffBucketSize = space.Space.level;
    JButton gameOverButton = new JButton();
    
    //Abutton[] stuffBucket = new Sbutton[space.Space.level*120];
    //BucketPanel bucket = new BucketPanel();
    
    Timer timer;
    boolean singularGravity = true;
    
    
    int Xcord;// = (int) (Math.random() * 400) + 1;
         int Ycord;/// = (int) (Math.random() * 340) + 1;
    
    
    
    
    
    
    
    
    public Apanel(){
       
       super();
       
       setLayout(null);
       setBackground(Color.black);
        addMouseListener(this);
       gameOverButton.setBackground(Color.red);
       gameOverButton.setText("GAME OVER");
       gameOverButton.setBounds(600, 500, 200, 100);
       gameOverButton.addActionListener(this);
      // addEnemies();
      // addEnemies();
        addHero();
        
        
      addEnemies();
      
      
      //addMouseListener(this);
      addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				hero.setBounds(e.getX(), e.getY(), heroSize, heroSize);
     hero.setBackground(Color.red);
			}
		});
      
     // createTreasureButtons();
      
      
      //addTreasureButtons();
       //hideTreasureButtons();
       //timerSpeed = 2;//0 - (space.Space.level * 2);//100 - (space.Space.level * 8);// 100-20 raange, based on 1-10
        //timerSpeed = 200 - (space.Space.level * 16);// 100-20 raange, based on 1-10
       timer = new Timer( timerSpeed, this);
       timer.start();
       hero.requestFocus();
       //requestFocus();
    }
 
    public void setVariables(){
        
        singularGravity = space.Space.globalSingularGravity;
          playerSize = space.Space.globalParticleSize;
   amountOfEnemies= space.Space.globalAmountOfParticles;
     heroSize = space.Space.globalHeroSize;
     //int heroSize = amountOfEnemies;
    
     enemySpeed = space.Space.globalEnemySpeed;
    
    heroSpeed = 10;
    timerSpeed = space.Space.globalTimerSpeed;
     speedlimit = space.Space.globalSpeedlimit;// + heroSize;// douglas adams is max
     minSpeed = space.Space.globalMinSpeed;
        
    }
    
    
    
    public void addHero(){
        Xcord = space.Space.screen.width/2 - 40;
         Ycord = space.Space.screen.height/2 - 60;
         //heroSize = space.Space.globalHeroSize;
         
        hero = new Sbutton();
        hero.setBounds(Xcord, Ycord, heroSize, heroSize);
        hero.setBackground(Color.green);
        hero.addActionListener(this);
        hero.addKeyListener(this);
        if(space.Space.showStallman){
            heroSize = space.Space.globalStallmanSize;
        hero.makeHero();
        }
        hero.setBounds(Xcord, Ycord, heroSize, heroSize);
        hero.mass = 1000.0;
        add(hero);   
    }
  
      public void addEnemies(){
          
          amountOfEnemies = space.Space.globalAmountOfParticles;
         
         for(int i = 0; i < amountOfEnemies; i++){
             Xcord = hero.getX() - ((int)(Math.random() * 200) + 1);//(int) (Math.random() * (space.Space.screen.width-300)) + 200;
         Ycord = hero.getY() - ((int)(Math.random() * 100) + 100);//(int) (Math.random() * (space.Space.screen.height-300)) + 200;
         int xsp = 30;
         int ysp = -10;
         
         if(space.Space.particles){
             Xcord = (int) (Math.random() * (space.Space.screen.width)) + 1;
         Ycord = (int) (Math.random() * (space.Space.screen.height)) + 1;  
          xsp = 0;
          ysp = 0;
         }
          Sbutton a = new Sbutton();
         
        //enemies.get(i) = new Sbutton();
        a.setBounds(Xcord, Ycord, playerSize, playerSize);
        a.setBackground(Color.red);
        a.xVel = xsp;
        a.yVel = ysp;
        a.addActionListener(this);
       // a.makeZombie();
        a.speedLimit = (int)(Math.random() * speedlimit) + minSpeed;
        a.setColor(speedlimit);
         enemies.add(a);
        add(a);   
        
         }
    }
 
         public void actionPerformed(ActionEvent event) 
    {

       	Object obj = event.getSource();
       
    
        
        
       	if (obj == timer){
            
            
            	
            hero.checkCollision();
            if(enemies.size()>0){
            for(int i = 0; i < amountOfEnemies; i++){
            enemies.get(i).checkCollision();
            }
            }
           // gameOver();
           // win();
            moveEnemy();
            hero.requestFocus();
       	}
        
        
       
   

		if (obj == hero) //t)
		{
                    timer.stop();
                    
                    //if(singularGravity == false){
                  space.Space.screen.startPanel();
                  //  }else{
               //  space.Space.screen.restart();
                //    }
                
		}
    
    }

    @Override
    public void keyTyped(KeyEvent e) {
        int k = e.getKeyCode();
	if(k == e.VK_UP){
			hero.setBounds(hero.getX(), hero.getY() - heroSpeed, heroSize, heroSize);
		}
                if(k == e.VK_DOWN){
			hero.setBounds(hero.getX(), hero.getY() + heroSpeed, heroSize, heroSize);
		}
                if(k == e.VK_LEFT){
		hero.setBounds(hero.getX() - heroSpeed, hero.getY(), heroSize, heroSize);
		}
		if(k == e.VK_RIGHT){
                    hero.setBounds(hero.getX() + heroSpeed, hero.getY(),heroSize, heroSize);
		
		}
                
                if(k == e.VK_E){
                        
                  space.Space.screen.restart();      
		}
                
                if(k == e.VK_R){
                        
                     Xcord = (int) (Math.random() * (space.Space.screen.width-300)) + 200;
                    Ycord = (int) (Math.random() * (space.Space.screen.height-300)) + 200; 
                    hero.setBounds(Xcord, Ycord, heroSize, heroSize);
		} 
                
    }

    @Override
    public void keyPressed(KeyEvent e) {
                int k = e.getKeyCode();
		if(k == e.VK_UP){
			hero.setBounds(hero.getX(), hero.getY() - heroSpeed, heroSize, heroSize);
		}
                if(k == e.VK_DOWN){
			hero.setBounds(hero.getX(), hero.getY() + heroSpeed, heroSize, heroSize);
		}
                if(k == e.VK_LEFT){
		hero.setBounds(hero.getX() - heroSpeed, hero.getY(), heroSize, heroSize);
		}
		if(k == e.VK_RIGHT){
                    hero.setBounds(hero.getX() + heroSpeed, hero.getY(),heroSize, heroSize);
		
		}
		
                if(k == e.VK_E){
                        
                  space.Space.screen.restart();      
		}
                
                
               if(k == e.VK_R){
                        
                     Xcord = (int) (Math.random() * (space.Space.screen.width-300)) + 200;
                    Ycord = (int) (Math.random() * (space.Space.screen.height-300)) + 200; 
                    hero.setBounds(Xcord, Ycord, heroSize, heroSize);
		} 
                
                
                
                
                
                
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
 
    
    }
 


     
     

     public void moveEnemy(){
       
         
         for(int i = 0; i < enemies.size(); i++){
      /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
       int moveX = (enemies.get(i).getX()+ (playerSize/2)) - (hero.getX() + (heroSize/2));
       int moveY = (enemies.get(i).getY()+ (playerSize/2)) - (hero.getY()+ (heroSize/2));
       // chase the tail!
           // moveX = enemies.get(i).getX() - enemies.get(enemies.size()-1).getX();
           // moveY = enemies.get(i).getY() - enemies.get(enemies.size()-1).getY(); 
      //int amountOfForce = getDistance(enemies.get(i).getX(),enemies.get(i).getY(), hero.getX(), hero.getY());
      
       
                if(!space.Space.globalSingularGravity){
                        if(i > 0){
                             moveX = enemies.get(i).getX() - enemies.get(i-1).getX();
                             moveY = enemies.get(i).getY() - enemies.get(i-1).getY(); 

                           // move = enemySpeed - i;
                        }
                }
                
                
            if(space.Space.linearMovement){
                
             
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
       
                
                 int move = enemySpeed;
                
        if (moveX > 0){
                    if(Math.abs(moveX - move)>move){
                   enemies.get(i).setBounds(enemies.get(i).getX() - move, enemies.get(i).getY(), playerSize, playerSize); 
                    }
                }else{
                    if(Math.abs(moveX - move)>move){
                  enemies.get(i).setBounds(enemies.get(i).getX() + move, enemies.get(i).getY(), playerSize, playerSize); 
                    }
                }
                if (moveY > 0){
                    if(Math.abs(moveY - move)>move){
                   enemies.get(i).setBounds(enemies.get(i).getX(), enemies.get(i).getY() - move, playerSize, playerSize);
                    }
                }else{
                        if(Math.abs(moveY - move)>move){
                    
                  enemies.get(i).setBounds(enemies.get(i).getX(), enemies.get(i).getY() + move, playerSize, playerSize);  
                        }
                }
       
              
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
                
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        } else{ 
                 double amountOfForce = calculateGravity(enemies.get(i).getX(),enemies.get(i).getY(), hero.getX(), hero.getY(), enemies.get(i).mass, hero.mass);
                if(!space.Space.gravityGetsStronger){
                amountOfForce = 1;
                }
                
                if (moveX > 0){
                   
                   enemies.get(i).xVel = enemies.get(i).xVel - amountOfForce;
                }else{
                   enemies.get(i).xVel = enemies.get(i).xVel + amountOfForce;
                }
                if (moveY > 0){
                    enemies.get(i).yVel = enemies.get(i).yVel - amountOfForce;
                }else{
                   enemies.get(i).yVel = enemies.get(i).yVel + amountOfForce;
                }
       
              ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////            
                
               //  enemies.get(0).setBackground(Color.WHITE);
                enemies.get(i).move();
                enemies.get(i).checkCollision();
            }
            
            
            
            
            }  // end for loop
       
   }   // end move enemy
     
  
     
    public int getDistance(int x, int y, int dx, int dy){
        
        int forceAmount = 1;
        
        
        double gravityWell = space.Space.gravityWellDistance;
        double mass = space.Space.massOfCenter;
        double distance = Math.sqrt((dx-x)*(dx-x)+(dy-y)*(dy-y));
      
        
        
        
       
        
        
        
        
       
        if(distance < gravityWell){
           forceAmount = (int)(mass * .2); 
        }
        if(distance < gravityWell * .9){
          forceAmount = (int)(mass * .3); 
        }
        if(distance < gravityWell * .8){
           forceAmount = (int)(mass * .4); 
        }
        if(distance < gravityWell * .7){
            forceAmount = (int)(mass * .5); 
        }
        if(distance < gravityWell * .6){
            forceAmount = (int)(mass * .6); 
        }
        if(distance < gravityWell * .5){
          forceAmount = (int)(mass * .7); 
        }
        if(distance < gravityWell * .4){
           forceAmount = (int)(mass * .8); 
        }
        if(distance < gravityWell * .3){
            forceAmount = (int)(mass * .9); 
        }
        if(distance < gravityWell * .2){
            forceAmount = (int)(mass); 
        }
        
        
        
       return forceAmount; 
    } //end get distance
     
    
    
    
    
    
        public double calculateGravity(int x, int y, int dx, int dy, double m1, double m2){
        
        double forceAmount = 1;
        
        
        
        double distance = Math.sqrt((dx-x)*(dx-x)+(dy-y)*(dy-y));
        
        double uniGravConst = space.Space.universalGravitationConstant;
        
        double gravitationalAttraction = (uniGravConst * m1 * m2) / (distance * distance);
        
        
        
        forceAmount = gravitationalAttraction; 
        
        
        
    
       return forceAmount; 
       
    } //end calculate gravity
     
     
     
     
     
     
     
     
     
     
   public void gameOver(){
      
       
        for(int i = 0; i < enemies.size(); i++){
            
            
       
      if (hero.getBounds().intersects(enemies.get(i).getBounds())){
          
          timer.stop();
          
          remove(hero);
          remove(enemies.get(i));
          add(gameOverButton);
          gameOverButton.setText("You Lose! Level " + space.Space.level);
          //singularGravity = false;
          //gameOverButton.removeActionListener(this);
          //hideTreasureButtons();
          repaint();
          
          
          
          
      }

     }
   }  

    @Override
    public void mouseClicked(MouseEvent e) {
     hero.setBounds(e.getX(), e.getY(), heroSize, heroSize);
     hero.setBackground(Color.red);
    }

    @Override
    public void mousePressed(MouseEvent e) {
         hero.setBounds(e.getX(), e.getY(), heroSize, heroSize);
          hero.setBackground(Color.red);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
         hero.setBounds(e.getX(), e.getY(), heroSize, heroSize);
          hero.setBackground(Color.red);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 

    
}
