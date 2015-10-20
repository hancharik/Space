/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arena;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import javax.swing.JPanel;

/**
 *
 * @author Mark
 */
public class StartPanel extends JPanel implements ActionListener{

    JButton startPlanetButton;
    JButton startAtomButton;
    JButton startChainedParticleButton;
    JButton quitButton;
    
    
    
    
    public StartPanel(){
        
       super();
       setLayout(null);
       setBackground(Color.black);
       startPlanetButton = new JButton("Start Planets");
       startPlanetButton.setBounds(380, 80, 200, 100);
       startPlanetButton.addActionListener(this);
       add(startPlanetButton); 
       startAtomButton = new JButton("Start Atom");
       startAtomButton.setBounds(580, 80, 200, 100);
       startAtomButton.addActionListener(this);
       add(startAtomButton); 
       startChainedParticleButton = new JButton("Start Chained Particles");
       startChainedParticleButton.setBounds(380, 200, 200, 100);
       startChainedParticleButton.addActionListener(this);
       add(startChainedParticleButton); 
        
       quitButton = new JButton("quit");
       quitButton.setBounds(380, 360, 320, 100);
       quitButton.addActionListener(this);
       add(quitButton);
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        	Object obj = e.getSource();
       
    
        
        
       	if (obj == startAtomButton){
            
          arena.Arena.globalSingularGravity = true;
           
          
           
              arena.Arena.globalPlayerSize = 6;
    arena.Arena.globalPlayerSizeMultiplier = 2;
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
                   
              arena.Arena.globalPlayerSize = 26;
    arena.Arena.globalPlayerSizeMultiplier = 3;
   arena.Arena.globalAmountOfEnemies = (int)(Math.random() * 9) + 1;
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
    arena.Arena.globalPlayerSizeMultiplier = 3;
   arena.Arena.globalAmountOfEnemies = 1000;
  
    
    arena.Arena.globalEnemySpeed = 1;
    
   arena.Arena.globalheroSpeed = 10;
  arena.Arena.globalTimerSpeed = 1;
  arena.Arena.globalSpeedlimit = 12;// + heroSize;// douglas adams is max
   arena.Arena.globalMinSpeed = 2;
    arena.Arena.screen.start(); 
           
            
       	}
        
        if (obj == quitButton){
            
           //System.exit();
           arena.Arena.screen.dispose();
            
       	}
        
    }
    
    
    
    
    

    
}
