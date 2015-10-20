/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arena;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Mark
 */
public class Apanel extends JPanel implements ActionListener, KeyListener{
    
    int playerSize = arena.Arena.globalPlayerSize;
    int amountOfEnemies = arena.Arena.globalAmountOfEnemies;
    int heroSize = arena.Arena.globalHeroSize;
     //int heroSize = amountOfEnemies;
    
    int enemySpeed = arena.Arena.globalEnemySpeed;
    
    int heroSpeed = 10;
    int timerSpeed = arena.Arena.globalTimerSpeed;
    int speedlimit = arena.Arena.globalSpeedlimit;// + heroSize;// douglas adams is max
    int minSpeed = arena.Arena.globalMinSpeed;
    Abutton hero;
    ArrayList<Abutton> enemies = new ArrayList();
     ArrayList<Abutton> stuffBucket = new ArrayList();
     int stuffBucketSize = arena.Arena.level;
    JButton gameOverButton = new JButton();
    
    //Abutton[] stuffBucket = new Abutton[arena.Arena.level*120];
    //BucketPanel bucket = new BucketPanel();
    
    Timer timer;
    boolean singularGravity = true;
    
    
    int Xcord;// = (int) (Math.random() * 400) + 1;
         int Ycord;/// = (int) (Math.random() * 340) + 1;
    
    
    
    
    
    
    
    
    public Apanel(){
       
       super();
       
       setLayout(null);
       setBackground(Color.black);
       
       gameOverButton.setBackground(Color.red);
       gameOverButton.setText("GAME OVER");
       gameOverButton.setBounds(600, 500, 200, 100);
       gameOverButton.addActionListener(this);
      // addEnemies();
      // addEnemies();
        addHero();
        
        
      addEnemies();
      
      createTreasureButtons();
      
      singularGravity = arena.Arena.globalSingularGravity;
      //addTreasureButtons();
       //hideTreasureButtons();
       //timerSpeed = 2;//0 - (arena.Arena.level * 2);//100 - (arena.Arena.level * 8);// 100-20 raange, based on 1-10
        //timerSpeed = 200 - (arena.Arena.level * 16);// 100-20 raange, based on 1-10
       timer = new Timer( timerSpeed, this);
       timer.start();
       hero.requestFocus();
       
    }
 
    public void addHero(){
        Xcord = arena.Arena.screen.width/2 - 40;
         Ycord = arena.Arena.screen.height/2 - 60;
         //heroSize = arena.Arena.globalHeroSize;
        hero = new Abutton();
        hero.setBounds(Xcord, Ycord, heroSize, heroSize);
        hero.setBackground(Color.green);
        hero.addActionListener(this);
        hero.addKeyListener(this);
        if(arena.Arena.showStallman){
        hero.makeHero();
        }
        add(hero);   
    }
  
      public void addEnemies(){
          
         
         for(int i = 0; i < amountOfEnemies; i++){
             Xcord = hero.getX() - ((int)(Math.random() * 200) + 1);//(int) (Math.random() * (arena.Arena.screen.width-300)) + 200;
         Ycord = hero.getY() - ((int)(Math.random() * 100) + 100);//(int) (Math.random() * (arena.Arena.screen.height-300)) + 200;
         int xsp = 30;
         int ysp = -10;
         
         if(arena.Arena.particles){
             Xcord = (int) (Math.random() * (arena.Arena.screen.width-300)) + 200;
         Ycord = (int) (Math.random() * (arena.Arena.screen.height-300)) + 200;  
          xsp = 0;
          ysp = 0;
         }
          Abutton a = new Abutton();
         
        //enemies.get(i) = new Abutton();
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
                  arena.Arena.screen.startPanel();
                  //  }else{
               //  arena.Arena.screen.restart();
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
                        
                  arena.Arena.screen.restart();      
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
                        
                  arena.Arena.screen.restart();      
		}
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
 
    
    }
 
    
          
  public void createTreasureButtons(){
      for(int i = 0; i < stuffBucketSize; i++){
          Abutton stuff = new Abutton(); 
          stuff.makeTreasure();
          stuff.setBackground(Color.yellow);
//stuff.setIcon(stuff.icons[i]);
          stuffBucket.add(stuff);
          //enemiesbutton.Arena.screen.bucket.treasures[i] = stuff;
      }
       
   } 
    
     public void addTreasureButtons(){
      for(int i = 0; i < stuffBucketSize; i++){
          
         Xcord = (int) (Math.random() * (arena.Arena.screen.width - 200)) + 100;
         Ycord = (int) (Math.random() * (arena.Arena.screen.height - 200)) + 100;// int Ycord = (int) (Math.random() * enemiesbutton.Arena.screen.height) + 1;
          
         // enemiesbutton.Arena.screen.bucket.treasures[i].setBounds(Xcord, Ycord, 60, 60);
         //add(enemiesbutton.Arena.screen.bucket.treasures[i]);
          stuffBucket.get(i).setBounds(Xcord, Ycord, playerSize, playerSize);
         add(stuffBucket.get(i));
      }
       
   }   
   
     
          public void hideTreasureButtons(){
         
           for(int i = 0; i < stuffBucketSize; i++){
       
                  remove(stuffBucket.get(i));// enemiesbutton.Arena.screen.bucket.removeButton(i);//treasures[i].setVisible(false);//.remove(enemiesbutton.Arena.screen.gamePanel.stuffBucket[i]); 
       
       
       
       }
     }
     
     
     
     
     public void removeTreasureButtons(){
         
           for(int i = 0; i < stuffBucketSize; i++){
       if (hero.getBounds().intersects(stuffBucket.get(i).getBounds())){
          // enemiesbutton.Arena.screen.stuffBucket[i]  
                    stuffBucket.get(i).setVisible(false);
                    arena.Arena.screen.bucket.treasures[i].setVisible(true);//.remove(enemiesbutton.Arena.screen.gamePanel.stuffBucket[i]); 
        }     
       
       
       }
     }
     
     public void moveEnemy(){
       
         
         for(int i = 0; i < enemies.size(); i++){
      /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
       int moveX = (enemies.get(i).getX()+ (playerSize/2)) - (hero.getX() + (heroSize/2));
       int moveY = (enemies.get(i).getY()+ (playerSize/2)) - (hero.getY()+ (heroSize/2));
       // chase the tail!
           // moveX = enemies.get(i).getX() - enemies.get(enemies.size()-1).getX();
           // moveY = enemies.get(i).getY() - enemies.get(enemies.size()-1).getY(); 
       int move = enemySpeed;
        if(!singularGravity){
       if(i > 0){
            moveX = enemies.get(i).getX() - enemies.get(i-1).getX();
            moveY = enemies.get(i).getY() - enemies.get(i-1).getY(); 
           
          // move = enemySpeed - i;
       }
        }
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
       /*
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
       
              */
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
                
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if (moveX > 0){
                   
                   enemies.get(i).xVel--;
                }else{
                   enemies.get(i).xVel++; 
                }
                if (moveY > 0){
                    enemies.get(i).yVel--;
                }else{
                   enemies.get(i).yVel++; 
                }
       
              ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////            
                
               //  enemies.get(0).setBackground(Color.WHITE);
                enemies.get(i).move();
                enemies.get(i).checkCollision();
            }  // end for loop
       
   }   // end move enemy
     
     
   public void gameOver(){
      
       
        for(int i = 0; i < enemies.size(); i++){
            
            
       
      if (hero.getBounds().intersects(enemies.get(i).getBounds())){
          
          timer.stop();
          
          remove(hero);
          remove(enemies.get(i));
          add(gameOverButton);
          gameOverButton.setText("You Lose! Level " + arena.Arena.level);
          //singularGravity = false;
          //gameOverButton.removeActionListener(this);
          hideTreasureButtons();
          repaint();
          
          
          
          
      }

     }
   }  
 
   public void win(){
  int count = 0;
       for(int i = 0; i < arena.Arena.level; i++){
          
       if(arena.Arena.screen.bucket.treasures[i].isVisible()){
         count++;  
           }
       
       }  
       
       if(count == arena.Arena.level){
           timer.stop();
          remove(hero);
           for(int i = 0; i < enemies.size(); i++){
          remove(enemies.get(i));
           }
          add(gameOverButton);
          gameOverButton.setBackground(Color.green);
          gameOverButton.setText("You Win! Level " + arena.Arena.level);
          arena.Arena.level++;
          gameOverButton.addActionListener(this);
          repaint();
       }
   }
    
}
