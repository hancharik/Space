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

    JButton easyStartButton;
    JButton hardStartButton;
    JButton quitButton;
    
    
    
    
    public StartPanel(){
        
       super();
       setLayout(null);
       setBackground(Color.black);
       easyStartButton = new JButton("Start Easy Level");
       easyStartButton.setBounds(380, 80, 200, 100);
       easyStartButton.addActionListener(this);
       add(easyStartButton); 
       hardStartButton = new JButton("Start Hard Level");
       hardStartButton.setBounds(380, 200, 200, 100);
       hardStartButton.addActionListener(this);
       add(hardStartButton); 
        
       quitButton = new JButton("quit");
       quitButton.setBounds(380, 360, 320, 100);
       quitButton.addActionListener(this);
       add(quitButton);
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        	Object obj = e.getSource();
       
    
        
        
       	if (obj == easyStartButton){
            
           arena.Arena.level = 1;
           arena.Arena.screen.start(); 
            
       	}
        
        if (obj == hardStartButton){
            
           arena.Arena.level = 9;
           arena.Arena.screen.start(); 
            
       	}
        
        if (obj == quitButton){
            
           //System.exit();
           arena.Arena.screen.dispose();
            
       	}
        
    }
    
    
    
    
    

    
}
