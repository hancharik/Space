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
    JButton quitButton;
    
    JButton bigScreenButton;
    JButton littleScreenButton;
    
    JSlider numberOfParticles;
    
    JLabel numOfParticles;
    
    public StartPanel(){
        
       super();
       setLayout(null);
       setBackground(Color.black);
       startPlanetButton = new JButton("Start Planets");
       startPlanetButton.setBounds(380, 80, 120, 40);
       startPlanetButton.addActionListener(this);
       add(startPlanetButton); 
       startAtomButton = new JButton("Start Atom");
       startAtomButton.setBounds(580, 80, 120, 40);
       startAtomButton.addActionListener(this);
       add(startAtomButton); 
       startChainedParticleButton = new JButton("Start Chained Particles");
       startChainedParticleButton.setBounds(380, 200, 220, 40);
       startChainedParticleButton.addActionListener(this);
       add(startChainedParticleButton); 
        
       
       bigScreenButton = new JButton("Big Screen");
       bigScreenButton.setBounds(10, 10, 120, 40);
       bigScreenButton.addActionListener(this);
       add(bigScreenButton);
       littleScreenButton = new JButton("Little Screen");
       littleScreenButton.setBounds(10, 60, 120, 40);
       littleScreenButton.addActionListener(this);
       add(littleScreenButton);
       
       
        numberOfParticles = new JSlider(JSlider.VERTICAL, 1, 600, 9);
        numberOfParticles.addChangeListener(this);
        numberOfParticles.setMajorTickSpacing(100);
        numberOfParticles.setPaintTicks(true);
        numberOfParticles.setBounds(10, 120, 40, 200);
        add(numberOfParticles);
        numOfParticles = new JLabel("Num of particles");
        numOfParticles.setBounds(10, 340, 100, 40);
        add(numOfParticles);
        
        
       showrms = new JButton();
       checkrmsPic();
       showrms.setBounds(580, 300, 200, 100);
       showrms.addActionListener(this);
       add(showrms); 
        
       quitButton = new JButton("quit");
       quitButton.setBounds(380, 360, 80, 40);
       quitButton.addActionListener(this);
       add(quitButton);
       
    }  // end constructor

    @Override
    public void actionPerformed(ActionEvent e) {
        
        	Object obj = e.getSource();
       
    
        
        
       	if (obj == startAtomButton){
            
          arena.Arena.globalSingularGravity = true;
           
          
           
              arena.Arena.globalPlayerSize = 4;
               arena.Arena.globalHeroSize = checkForStallman(32);
    //arena.Arena.globalPlayerSizeMultiplier = 8;
  // arena.Arena.globalAmountOfEnemies = 6000;
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
//arena.Arena.globalPlayerSizeMultiplier = 2;
  // arena.Arena.globalAmountOfEnemies = (int)(Math.random() * 9) + 1;
    arena.Arena.globalSingularGravity = true;
    
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
  // arena.Arena.globalAmountOfEnemies = 1000;
  
    
    arena.Arena.globalEnemySpeed = 1;
    
   arena.Arena.globalheroSpeed = 10;
  arena.Arena.globalTimerSpeed = 1;
  arena.Arena.globalSpeedlimit = 12;// + heroSize;// douglas adams is max
   arena.Arena.globalMinSpeed = 2;
   
    arena.Arena.screen.start(); 
           
            
       	}
        
        
        if (obj == showrms){
            
            
            if(arena.Arena.showStallman){
              //showrms.setText("Hiding rms");
                showrms.setIcon(new ImageIcon("images/Eric.png")); 
           arena.Arena.showStallman = false;   
            }else{
            
           //System.exit();
            //showrms.setText("Showing rms");
           showrms.setIcon(new ImageIcon("images/rms200x100.png"));
           arena.Arena.showStallman = true;
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
        
        
        
        if (obj == quitButton){
            
           //System.exit();
           arena.Arena.screen.dispose();
            
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
    }

    
} // end
