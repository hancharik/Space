/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

/**
 *
 * @author Mark
 */
public class Aframe extends JFrame{
    
    
    int height = space.Space.height;
    int width = space.Space.width;
    
    
   
    Apanel gamePanel;// = new Apanel();
   
    StartPanel startPanel;// = new StartPanel();
    
    
    
    public Aframe(){
        
		super ("BES Particle Simulator");
                getContentPane().setLayout(new BorderLayout());
                setExtendedState(JFrame.MAXIMIZED_BOTH);//setSize (width, height);
                
                startPanel = new StartPanel();
		getContentPane().add(startPanel,"Center");
                setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
                
        }
    
    
    public void startPanel(){
        
        getContentPane().removeAll();
        //getContentPane().setLayout(new BorderLayout());
               // setSize (width, height);
                startPanel = new StartPanel();
                
		getContentPane().add(startPanel,"Center");
                //setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
       // gamePanel.helio.requestFocus();
        
    }
    
    
    
    
    
    
     public void start(){
         
                getContentPane().remove(startPanel);
                //bucket = new BucketPanel();
                gamePanel = new Apanel();
                
               
                getContentPane().add(gamePanel,"Center");
                //getContentPane().add(bucket,"West");
                setVisible(true);
                gamePanel.helio.requestFocus();
        
    }   
     
     
     public void restart(){
         
                getContentPane().remove(gamePanel);
                //getContentPane().remove(bucket);
               // bucket = new BucketPanel();
                gamePanel = new Apanel();
               
                getContentPane().add(gamePanel, "Center");
               // getContentPane().add(bucket, "West");
                setVisible(true);
                gamePanel.helio.requestFocus();
        
    }
 

}  // end
