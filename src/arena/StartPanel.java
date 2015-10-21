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
    JButton fixedParticleButton;
    JButton relativeGravityButton;
    
    JSlider numberOfParticles;
    JSlider sizeOfParticles;
    JSlider speedOfParticles;
    JSlider speedLimitMaxOfParticles;
    JSlider speedLimitMinOfParticles;
    JLabel numOfParticles;
    JLabel speedLimitMaxOfParticlesLabel;
    JLabel sizeOfParticlesLabel;
    JLabel speedOfParticlesMaxLabel;
    JLabel speedLimitMinOfParticlesLabel;
    
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
        numberOfParticles.setBounds(column(1), row(8), 400, 40);// horizontal
        //numberOfParticles.setBounds(column(1), 160, 40, 200);// vertical
        add(numberOfParticles);
        
        sizeOfParticles = new JSlider(JSlider.HORIZONTAL, 1, 80, arena.Arena.globalPlayerSize);
        sizeOfParticles.addChangeListener(this);
        sizeOfParticles.setMajorTickSpacing(100);
        sizeOfParticles.setPaintTicks(true);
        sizeOfParticles.setBounds(column(1), row(9), 400, 40);// horizontal
        //numberOfParticles.setBounds(10, 160, 40, 200);// vertical
        add(sizeOfParticles);
        
        speedOfParticles = new JSlider(JSlider.HORIZONTAL, 1, 1000, arena.Arena.globalTimerSpeed);
        speedOfParticles.addChangeListener(this);
        speedOfParticles.setMajorTickSpacing(100);
        speedOfParticles.setPaintTicks(true);
        speedOfParticles.setBounds(column(1), row(10), 400, 40);// horizontal
        //numberOfParticles.setBounds(10, 160, 40, 200);// vertical
        add(speedOfParticles);
        
        speedLimitMaxOfParticles = new JSlider(JSlider.HORIZONTAL, 1, 100, arena.Arena.globalSpeedlimit);
        speedLimitMaxOfParticles.addChangeListener(this);
        speedLimitMaxOfParticles.setMajorTickSpacing(100);
        speedLimitMaxOfParticles.setPaintTicks(true);
        speedLimitMaxOfParticles.setBounds(column(1), row(11), 400, 40);// horizontal
        //numberOfParticles.setBounds(10, 160, 40, 200);// vertical
        add(speedLimitMaxOfParticles);
        
        speedLimitMinOfParticles = new JSlider(JSlider.HORIZONTAL, 1, 20, arena.Arena.globalMinSpeed);
        speedLimitMinOfParticles.addChangeListener(this);
        speedLimitMinOfParticles.setMajorTickSpacing(100);
        speedLimitMinOfParticles.setPaintTicks(true);
        speedLimitMinOfParticles.setBounds(column(1), row(12), 400, 40);// horizontal
        //numberOfParticles.setBounds(10, 160, 40, 200);// vertical
        add(speedLimitMinOfParticles);
        
        
        numOfParticles = new JLabel("<html><h2><font color='white'># of particles: </font><font color='red'>" + arena.Arena.globalAmountOfEnemies + "</font><h2></html>");
        numOfParticles.setBounds(column(3), row(8), 220, 40);
     
        add(numOfParticles);
        sizeOfParticlesLabel = new JLabel("<html><h2><font color='white'>size: </font><font color='red'>" + arena.Arena.globalPlayerSize + "</font><h2></html>");
        sizeOfParticlesLabel.setBounds(column(3), row(9), 220, 40);
        add(sizeOfParticlesLabel);
        //speedOfParticlesMaxLabel = new JLabel("speed: " + arena.Arena.globalTimerSpeed);
        speedOfParticlesMaxLabel = new JLabel("<html><h2><font color='white'>speed: </font><font color='red'>" + arena.Arena.globalTimerSpeed + "</font><h2></html>");
        speedOfParticlesMaxLabel.setBounds(column(3), row(10), 220, 40);
        add(speedOfParticlesMaxLabel);
        
         speedLimitMaxOfParticlesLabel = new JLabel("<html><h2><font color='white'>max speed limit: </font><font color='red'>" + arena.Arena.globalSpeedlimit + "</font><h2></html>");
        speedLimitMaxOfParticlesLabel.setBounds(column(3), row(11), 220, 40);
        add(speedLimitMaxOfParticlesLabel);
        
         speedLimitMinOfParticlesLabel = new JLabel("<html><h2><font color='white'>min speed limit: </font><font color='red'>" + arena.Arena.globalMinSpeed + "</font><h2></html>");
        speedLimitMinOfParticlesLabel.setBounds(column(3), row(12), 2200, 40);
        speedLimitMinOfParticlesLabel.setBackground(Color.red);
        add(speedLimitMinOfParticlesLabel);
        
       showrms = new JButton();
       checkrmsPic();
       showrms.setBounds(column(2), row(4), 200, 100);
       showrms.addActionListener(this);
       add(showrms); 
        
       quitButton = new JButton("quit");
       quitButton.setBounds(column(2), row(15), 80, 40);
       quitButton.addActionListener(this);
       add(quitButton);
       
       startButton = new JButton("start");
       startButton.setBounds(column(1), row(15), 80, 40);
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
       
       fixedParticleButton = new JButton("diffuse particles = " + arena.Arena.particles);
       fixedParticleButton.setBounds(column(1), row(6), 200, 40);
       fixedParticleButton.addActionListener(this);
       add(fixedParticleButton);
       
       relativeGravityButton = new JButton("relative gravity = " + arena.Arena.gravityGetsStronger);
       relativeGravityButton.setBounds(column(1), row(7), 200, 40);
       relativeGravityButton.addActionListener(this);
       add(relativeGravityButton);
       
       
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
 arena.Arena.globalSpeedlimit = 12;// + heroSize;// douglas adams 42 is max
   arena.Arena.globalMinSpeed = 2;
   
    arena.Arena.screen.start(); 
           
            
       	}
        
        
        if (obj == showrms){
            
            
            if(arena.Arena.showStallman){
              //showrms.setText("Hiding rms");
                showrms.setIcon(new ImageIcon("images/be200x100.png")); 
           arena.Arena.showStallman = false;   
          // arena.Arena.gravityGetsStronger = false;
            }else{
            
           //System.exit();
            //showrms.setText("Showing rms");
           showrms.setIcon(new ImageIcon("images/rms200x100.png"));
           arena.Arena.showStallman = true;
                  // arena.Arena.gravityGetsStronger = true;

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
            
            arena.Arena.screen.setExtendedState(JFrame.MAXIMIZED_BOTH); 
            arena.Arena.height = arena.Arena.screen.getHeight();
            arena.Arena.width= arena.Arena.screen.getWidth();
            arena.Arena.screen.dispose();
            arena.Arena.screen = new Aframe();
            arena.Arena.screen.setExtendedState(JFrame.MAXIMIZED_BOTH); 
           // arena.Arena.height = arena.Arena.screen.getHeight();
           // arena.Arena.width= arena.Arena.screen.getWidth();
            
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
        
        if (obj == fixedParticleButton){
            if(arena.Arena.particles){
            arena.Arena.particles = false; 
            fixedParticleButton.setText("diffuse particles = " + arena.Arena.particles);
            }else{
              arena.Arena.particles = true; 
              fixedParticleButton.setText("diffuse particles = " + arena.Arena.particles);
            }
            
       	}
        
         if (obj == relativeGravityButton){
            if(arena.Arena.gravityGetsStronger){
            arena.Arena.gravityGetsStronger = false; 
            relativeGravityButton.setText("relative gravity = " + arena.Arena.gravityGetsStronger);
            }else{
              arena.Arena.gravityGetsStronger = true; 
              relativeGravityButton.setText("relative gravity = " + arena.Arena.gravityGetsStronger);
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
            showrms.setIcon(new ImageIcon("images/be200x100.png"));
          
            }
    
    
}    

    @Override
        public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider)e.getSource();
        if (source == numberOfParticles) {
            arena.Arena.globalAmountOfEnemies = (int)source.getValue();
            //numOfParticles.setText(arena.Arena.globalAmountOfEnemies + " particles");
            numOfParticles.setText("<html><h2><font color='white'># of particles: </font><font color='red'>" + arena.Arena.globalAmountOfEnemies + "</font><h2></html>");
        }
        if (source == sizeOfParticles) {
            arena.Arena.globalPlayerSize  = (int)source.getValue();
            
            sizeOfParticlesLabel.setText("<html><h2><font color='white'>size: </font><font color='red'>" + arena.Arena.globalPlayerSize + "</font><h2></html>");
        }
        if (source == speedOfParticles) {
            arena.Arena.globalTimerSpeed = (int)source.getValue();
            speedOfParticlesMaxLabel.setText("<html><h2><font color='white'>speed: </font><font color='red'>" + arena.Arena.globalTimerSpeed + "</font><h2></html>");
        }
        if (source == speedLimitMaxOfParticles) {
            arena.Arena.globalSpeedlimit = (int)source.getValue();
            speedLimitMaxOfParticlesLabel.setText("<html><h2><font color='white'>max speed limit: </font><font color='red'>" + arena.Arena.globalSpeedlimit + "</font></h2></html>");
        }
         if (source == speedLimitMinOfParticles) {
            arena.Arena.globalMinSpeed = (int)source.getValue();
            speedLimitMinOfParticlesLabel.setText("<html><h2><font color='white'>min speed limit: </font><font color='red'>" + arena.Arena.globalMinSpeed + "</font></h2></html>");
        }
    } // end state changed

  
        
                //////////////////////////////////////////////////////////////////////////////////////////////////////////
 
private int row(int r){
    int pixelNumber = ((r-1)*arena.Arena.height/16)+10;
    return pixelNumber;
}   

private int column(int c){ 
    int columnPixelNumber = 0;
    
    switch(c){  // these arent in cardinal order, i've been readjusting layouts
        //case 1: columnPixelNumber = (arena.Arena.width/8)*1; break;
            
            case 1: columnPixelNumber = 10; break;
                case 2: columnPixelNumber = (arena.Arena.width/7)*1 + 200; break;
        //case 2: columnPixelNumber = 260; break;
        case 3: columnPixelNumber = ((arena.Arena.width/7)*2) - 100; break;
        case 4: columnPixelNumber = 90; break;
    }
    return columnPixelNumber;
} // end column
    

////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
     
        
        
        
        
        
        
        
} // end
