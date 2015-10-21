/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arena;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

/**
 *
 * @author Mark
 */
public class Aframe extends JFrame  implements MouseListener{
    
    
    int height = arena.Arena.height;
    int width = arena.Arena.width;
    
    
   
    Apanel gamePanel;// = new Apanel();
   
    StartPanel startPanel;// = new StartPanel();
    
    
    
    public Aframe(){
        
		super ("Arena");
                getContentPane().setLayout(new BorderLayout());
                setSize (width, height);
                addMouseListener(this);
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
       // gamePanel.hero.requestFocus();
        
    }
    
    
    
    
    
    
     public void start(){
         
                getContentPane().remove(startPanel);
                //bucket = new BucketPanel();
                gamePanel = new Apanel();
                
                gamePanel.addMouseListener(this);
                addMouseListener(this);
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
                gamePanel.addMouseListener(this);
                addMouseListener(this);
                
                getContentPane().add(gamePanel, "Center");
               // getContentPane().add(bucket, "West");
                setVisible(true);
                gamePanel.hero.requestFocus();
        
    }
  @Override
    public void mouseClicked(MouseEvent e) {
     gamePanel.hero.setBounds(e.getX(), e.getY(), gamePanel.heroSize, gamePanel.heroSize);
     gamePanel.hero.setBackground(Color.red);
    }

    @Override
    public void mousePressed(MouseEvent e) {
         gamePanel.hero.setBounds(e.getX(), e.getY(), gamePanel.heroSize, gamePanel.heroSize);
          gamePanel.hero.setBackground(Color.red);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
         gamePanel.hero.setBounds(e.getX(), e.getY(), gamePanel.heroSize, gamePanel.heroSize);
          gamePanel.hero.setBackground(Color.red);
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
