/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arena;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Mark
 */
public class BucketPanel extends JPanel{
    
    int size = arena.Arena.level;
    
    Abutton[] treasures = new Abutton[size];
    
    
    
    
   public BucketPanel(){
       
       super();
       
       setLayout(new GridLayout(size,1));
       
       createButtons();
       
   }
    
    
    
  public void createButtons(){
      
      
      for(int i = 0; i < size; i++){
            Abutton stuff = new Abutton();
          int Xcord = (int) (Math.random() * 300) + 1;
          int Ycord = (int) (Math.random() * 300) + 1;
          
        // Abutton thing = new Abutton(); 
          treasures[i] = stuff;
          treasures[i].setBounds(Xcord, Ycord, 60, 60);
          treasures[i].setOpaque(true);
          treasures[i].setBackground(Color.BLUE);
          //treasures[i].setText(" " + i + " ");
          treasures[i].setIcon(stuff.icons[i]);
           treasures[i].setVisible(false);
          add(treasures[i]);
      }
      
  }  
  
  
  public void removeButton(int k){
      
     remove(treasures[k]); 
  }
  
    
  public void createTreasureButtons(){
      for(int i = 0; i < size; i++){
          Abutton stuff = new Abutton(); 
          stuff.setIcon(stuff.icons[i]);
          treasures[i] = stuff;
          //zombiebutton.Arena.screen.bucket.treasures[i] = stuff;
      }
       
   } 
    
     public void addTreasureButtons(){
      for(int i = 0; i < size; i++){
          
        //  int Xcord = (int) (Math.random() * 400) + 1;
         // int Ycord = (int) (Math.random() * 300) + 1;
          
         // zombiebutton.Arena.screen.bucket.treasures[i].setBounds(Xcord, Ycord, 60, 60);
         //add(zombiebutton.Arena.screen.bucket.treasures[i]);
         // treasures[i].setBounds(Xcord, Ycord, 60, 60);
         add(treasures[i]);
      }
       
   }   
   
    
    
}
