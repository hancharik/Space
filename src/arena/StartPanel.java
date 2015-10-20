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
    JButton startParticleButton;
    JButton quitButton;
    
    
    
    
    public StartPanel(){
        
       super();
       setLayout(null);
       setBackground(Color.black);
       startPlanetButton = new JButton("Start Planets");
       startPlanetButton.setBounds(380, 80, 200, 100);
       startPlanetButton.addActionListener(this);
       add(startPlanetButton); 
       startParticleButton = new JButton("Start Particles");
       startParticleButton.setBounds(380, 200, 200, 100);
       startParticleButton.addActionListener(this);
       add(startParticleButton); 
        
       quitButton = new JButton("quit");
       quitButton.setBounds(380, 360, 320, 100);
       quitButton.addActionListener(this);
       add(quitButton);
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        	Object obj = e.getSource();
       
    
        
        
       	if (obj == startPlanetButton){
            
          arena.Arena.globalSingularGravity = true;
           arena.Arena.screen.start(); 
            
       	}
        
        if (obj == startParticleButton){
            
           arena.Arena.globalSingularGravity = false;
           arena.Arena.screen.start(); 
            
       	}
        
        if (obj == quitButton){
            
           //System.exit();
           arena.Arena.screen.dispose();
            
       	}
        
    }
    
    
    
    
    

    
}
