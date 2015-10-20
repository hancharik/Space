/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arena;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author Mark
 */
public class Aframe extends JFrame{
    
    
    int height = arena.Arena.height;
    int width = arena.Arena.width;
    
    
    BucketPanel bucket;// = new BucketPanel();
    Apanel gamePanel;// = new Apanel();
    Abutton[] stuffBucket = new Abutton[arena.Arena.level];
    StartPanel startPanel;// = new StartPanel();
    
    
    
    public Aframe(){
        
		super ("Arena");
                getContentPane().setLayout(new BorderLayout());
                setSize (width, height);
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
        gamePanel.hero.requestFocus();
        
    }
    
    
    
    
    
    
     public void start(){
         
                getContentPane().remove(startPanel);
                //bucket = new BucketPanel();
                gamePanel = new Apanel();
                getContentPane().add(gamePanel,"Center");
                //getContentPane().add(bucket,"West");
                setVisible(true);
                gamePanel.hero.requestFocus();
        
    }   
     
     
     public void restart(){
         
                getContentPane().remove(gamePanel);
                //getContentPane().remove(bucket);
               // bucket = new BucketPanel();
                gamePanel = new Apanel();
                getContentPane().add(gamePanel, "Center");
               // getContentPane().add(bucket, "West");
                setVisible(true);
                gamePanel.hero.requestFocus();
        
    }

    
}
