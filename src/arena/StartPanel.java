/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arena;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Mark
 */
public class StartPanel extends JPanel implements ActionListener, ChangeListener{

    JButton startPlanetButton;
    JButton startAtomButton;
    JButton startChainedParticleButton;
    JButton showrms;
    JButton startButton;
    JButton quitButton;
    
    JButton bigScreenButton;
    JButton littleScreenButton;
    JButton fullScreenButton;
    JButton linearMovementButton;
    JButton centeredGravityButton;
    JSlider numberOfParticles;
    JSlider sizeOfParticles;
    JSlider speedOfParticles;
    JSlider speedLimitOfParticles;
    JLabel numOfParticles;
    JLabel speedLimitOfParticlesLabel;
    JLabel sizeOfParticlesLabel;
    JLabel speedOfParticlesLabel;
    
    public StartPanel(){
        
       super();
       setLayout(null);
       setBackground(Color.black);
       startPlanetButton = new JButton("Start Planets");
       startPlanetButton.setBounds(column(2), row(1), 120, 40);
       startPlanetButton.addActionListener(this);
       add(startPlanetButton); 
       startAtomButton = new JButton("Start Atom");
       startAtomButton.setBounds(column(2), row(2), 120, 40);
       startAtomButton.addActionListener(this);
       add(startAtomButton); 
       startChainedParticleButton = new JButton("Start Chained Particles");
       startChainedParticleButton.setBounds(column(2), row(3), 220, 40);
       startChainedParticleButton.addActionListener(this);
       add(startChainedParticleButton); 
        
       
       bigScreenButton = new JButton("Big Screen");
       bigScreenButton.setBounds(column(1), row(1), 120, 40);
       bigScreenButton.addActionListener(this);
       add(bigScreenButton);
       littleScreenButton = new JButton("Little Screen");
       littleScreenButton.setBounds(column(1), row(2), 120, 40);
       littleScreenButton.addActionListener(this);
       add(littleScreenButton);
       fullScreenButton = new JButton("Full Screen");
       fullScreenButton.setBounds(column(1), row(3), 120, 40);
       fullScreenButton.addActionListener(this);
       add(fullScreenButton);
       
        numberOfParticles = new JSlider(JSlider.HORIZONTAL, 1, 6000, arena.Arena.globalAmountOfEnemies);
        numberOfParticles.addChangeListener(this);
        numberOfParticles.setMajorTickSpacing(100);
        numberOfParticles.setPaintTicks(true);
        numberOfParticles.setBounds(column(1), 330, 400, 40);// horizontal
        //numberOfParticles.setBounds(column(1), 160, 40, 200);// vertical
        add(numberOfParticles);
        
        sizeOfParticles = new JSlider(JSlider.HORIZONTAL, 1, 80, arena.Arena.globalPlayerSize);
        sizeOfParticles.addChangeListener(this);
        sizeOfParticles.setMajorTickSpacing(100);
        sizeOfParticles.setPaintTicks(true);
        sizeOfParticles.setBounds(column(1), 380, 400, 40);// horizontal
        //numberOfParticles.setBounds(10, 160, 40, 200);// vertical
        add(sizeOfParticles);
        
        speedOfParticles = new JSlider(JSlider.HORIZONTAL, 1, 1000, arena.Arena.globalTimerSpeed);
        speedOfParticles.addChangeListener(this);
        speedOfParticles.setMajorTickSpacing(100);
        speedOfParticles.setPaintTicks(true);
        speedOfParticles.setBounds(column(1), 430, 400, 40);// horizontal
        //numberOfParticles.setBounds(10, 160, 40, 200);// vertical
        add(speedOfParticles);
        
        speedLimitOfParticles = new JSlider(JSlider.HORIZONTAL, 1, 100, arena.Arena.globalSpeedlimit);
        speedLimitOfParticles.addChangeListener(this);
        speedLimitOfParticles.setMajorTickSpacing(100);
        speedLimitOfParticles.setPaintTicks(true);
        speedLimitOfParticles.setBounds(column(1), 480, 400, 40);// horizontal
        //numberOfParticles.setBounds(10, 160, 40, 200);// vertical
        add(speedLimitOfParticles);
        
        
        numOfParticles = new JLabel(arena.Arena.globalAmountOfEnemies + " particles");
        numOfParticles.setBounds(column(3), 330, 100, 40);
     
        add(numOfParticles);
        sizeOfParticlesLabel = new JLabel("size: " + arena.Arena.globalPlayerSize );
        sizeOfParticlesLabel.setBounds(column(3), 380, 100, 40);
        add(sizeOfParticlesLabel);
        speedOfParticlesLabel = new JLabel("speed: " + arena.Arena.globalTimerSpeed);
        speedOfParticlesLabel.setBounds(column(3), 430, 100, 40);
        add(speedOfParticlesLabel);
         speedLimitOfParticlesLabel = new JLabel("speed limit: " + arena.Arena.globalSpeedlimit);
        speedLimitOfParticlesLabel.setBounds(column(3), 480, 100, 40);
        add(speedLimitOfParticlesLabel);
        
       showrms = new JButton();
       checkrmsPic();
       showrms.setBounds(column(2), 160, 200, 100);
       showrms.addActionListener(this);
       add(showrms); 
        
       quitButton = new JButton("quit");
       quitButton.setBounds(column(2), row(7), 80, 40);
       quitButton.addActionListener(this);
       add(quitButton);
       
       startButton = new JButton("start");
       startButton.setBounds(column(1), row(7), 80, 40);
       startButton.addActionListener(this);
       add(startButton);
       
       
       linearMovementButton = new JButton("linear movement = " + arena.Arena.linearMovement);
       linearMovementButton.setBounds(column(1), row(4), 200, 40);
       linearMovementButton.addActionListener(this);
       add(linearMovementButton);
       
       centeredGravityButton = new JButton("singular gravity = " + arena.Arena.globalSingularGravity);
       centeredGravityButton.setBounds(column(1), row(5), 200, 40);
       centeredGravityButton.addActionListener(this);
       add(centeredGravityButton);
       
    }  // end constructor

    @Override
    public void actionPerformed(ActionEvent e) {
        
        	Object obj = e.getSource();
       
    
        
        
       	if (obj == startAtomButton){
            
          arena.Arena.globalSingularGravity = true;
           
          
           
              arena.Arena.globalPlayerSize = 4;
               arena.Arena.globalHeroSize = checkForStallman(32);
    arena.Arena.globalPlayerSizeMultiplier = 8;
   arena.Arena.globalAmountOfEnemies = 6000;
    arena.Arena.globalSingularGravity = true;
    arena.Arena.particles = true;
    arena.Arena.globalEnemySpeed = 1;
    
   arena.Arena.globalheroSpeed = 10;
  arena.Arena.globalTimerSpeed = 1;
  arena.Arena.globalSpeedlimit = 42;// + heroSize;// douglas adams is max
   arena.Arena.globalMinSpeed = 12;
           
           
           
      
           
          arena.Arena.screen.start();  
           
           
       	}// end start atom button
        
        
        
        
        
        
        
        
        
        if (obj == startPlanetButton){
            
          arena.Arena.globalSingularGravity = true;
          arena.Arena.particles = false;
                   
              arena.Arena.globalPlayerSize = 12;
    arena.Arena.globalHeroSize = checkForStallman(20);
arena.Arena.globalPlayerSizeMultiplier = 2;
 arena.Arena.globalAmountOfEnemies = (int)(Math.random() * 9) + 1;
    
    
    arena.Arena.globalEnemySpeed = 1;
    
   arena.Arena.globalheroSpeed = 10;
  arena.Arena.globalTimerSpeed = 40;
  arena.Arena.globalSpeedlimit = 32;// + heroSize;// douglas adams is max
   arena.Arena.globalMinSpeed = 6;
   
    arena.Arena.screen.start(); 
       	}// end start planet button
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        if (obj == startChainedParticleButton){
            
           arena.Arena.globalSingularGravity = false;
           arena.Arena.particles = true;
                 arena.Arena.globalPlayerSize = 6;
    arena.Arena.globalHeroSize = checkForStallman(18);
 arena.Arena.globalAmountOfEnemies = 1000;
  
    
 arena.Arena.globalEnemySpeed = 1;
    
  arena.Arena.globalheroSpeed = 10;
  arena.Arena.globalTimerSpeed = 1;
 arena.Arena.globalSpeedlimit = 32;// + heroSize;// douglas adams is max
   arena.Arena.globalMinSpeed = 2;
   
    arena.Arena.screen.start(); 
           
            
       	}
        
        
        if (obj == showrms){
            
            
            if(arena.Arena.showStallman){
              //showrms.setText("Hiding rms");
                showrms.setIcon(new ImageIcon("images/Eric.png")); 
           arena.Arena.showStallman = false;   
          // arena.Arena.globalSingularGravity = false;
            }else{
            
           //System.exit();
            //showrms.setText("Showing rms");
           showrms.setIcon(new ImageIcon("images/rms200x100.png"));
           arena.Arena.showStallman = true;
          // arena.Arena.globalSingularGravity = true;
            }
       	}
        
        
       if (obj == bigScreenButton){
            
            arena.Arena.height = 1000;
            arena.Arena.width= 1880;
             arena.Arena.screen.dispose();
            arena.Arena.screen = new Aframe();
       	}
        if (obj == littleScreenButton){
            
          arena.Arena.height = 500;
            arena.Arena.width= 940;
             arena.Arena.screen.dispose();
            arena.Arena.screen = new Aframe();
       	}
            if (obj == fullScreenButton){
            
            
            arena.Arena.screen.dispose();
            arena.Arena.screen = new Aframe();
            arena.Arena.screen.setExtendedState(JFrame.MAXIMIZED_BOTH); 
            arena.Arena.height = arena.Arena.screen.getHeight();
            arena.Arena.width= arena.Arena.screen.getWidth();
            arena.Arena.screen.setVisible(true);
       	}
        
       
        if (obj == quitButton){
            
           //System.exit();
           arena.Arena.screen.dispose();
            
       	}
        
        if (obj == startButton){
            
            arena.Arena.screen.start(); 
            
       	}
        if (obj == centeredGravityButton){
            
           if(arena.Arena.globalSingularGravity){
            arena.Arena.globalSingularGravity = false; 
            centeredGravityButton.setText("singular gravity = " + arena.Arena.globalSingularGravity);
            }else{
              arena.Arena.globalSingularGravity = true; 
              centeredGravityButton.setText("singular gravity = " + arena.Arena.globalSingularGravity);
            } 
            
       	}
        if (obj == linearMovementButton){
            if(arena.Arena.linearMovement){
            arena.Arena.linearMovement = false; 
            linearMovementButton.setText("linear movement = " + arena.Arena.linearMovement);
            }else{
              arena.Arena.linearMovement = true; 
              linearMovementButton.setText("linear movement = " + arena.Arena.linearMovement);
            }
            
       	}
    } // end action event
    
    
  public int checkForStallman(int rtn){
      
      int size = 80;
      
      if(arena.Arena.showStallman){
       size = 60;   
      }else{
       size = rtn;   
      }
      
      return size;
      
  }  
    
public void checkrmsPic(){
    
     if(arena.Arena.showStallman){
              //showrms.setText("Hiding rms");
                showrms.setIcon(new ImageIcon("images/rms200x100.png"));
             
            }else{
            
           //System.exit();
            //showrms.setText("Showing rms");
            showrms.setIcon(new ImageIcon("images/Eric.png"));
          
            }
    
    
}    

    @Override
        public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider)e.getSource();
        if (source == numberOfParticles) {
            arena.Arena.globalAmountOfEnemies = (int)source.getValue();
            numOfParticles.setText(arena.Arena.globalAmountOfEnemies + " particles");
        }
        if (source == sizeOfParticles) {
            arena.Arena.globalPlayerSize  = (int)source.getValue();
            sizeOfParticlesLabel.setText("size: " + arena.Arena.globalPlayerSize );
        }
        if (source == speedOfParticles) {
            arena.Arena.globalTimerSpeed = (int)source.getValue();
            speedOfParticlesLabel.setText("speed: " + arena.Arena.globalTimerSpeed);
        }
        if (source == speedLimitOfParticles) {
            arena.Arena.globalSpeedlimit = (int)source.getValue();
            speedLimitOfParticlesLabel.setText("speed limit: " + arena.Arena.globalSpeedlimit);
        }
    } // end state changed

  
        
                //////////////////////////////////////////////////////////////////////////////////////////////////////////
 
private int row(int r){
    int pixelNumber = ((r-1)*46)+10;
    return pixelNumber;
}   

private int column(int c){ 
    int columnPixelNumber = 0;
    
    switch(c){  // these arent in cardinal order, i've been readjusting layouts
        case 1: columnPixelNumber = 10; break;
        case 2: columnPixelNumber = 260; break;
        case 3: columnPixelNumber = 410; break;
        case 4: columnPixelNumber = 90; break;
    }
    return columnPixelNumber;
} // end column
    

////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
     
        
        
        
        
        
        
        
} // end
