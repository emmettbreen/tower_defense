import java.util.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.*; 
import javax.swing.JPanel; 
import javax.swing.*;
   
public class Game{
   
   public static int score;
   
   public static void main(String[] args){
      //creates a JFrame to hold the game in
      JFrame frame = new JFrame("Tower Defense");
       
	   GameCanvas canvas = new GameCanvas();
      //makes tower
      Position tower = new Position(700, 680);
      int towerHealth = 10000;
      int mouseX = 0;
      int mouseY= 0;
      //makes enemies
      ArrayList<Enemy> enemies = new ArrayList<Enemy>();
      
      //canvas add mouselistener
      canvas.addMouseListener(new Listener());  
    
      canvas.setPreferredSize(new Dimension(600, 600));
      canvas.setMaximumSize(new Dimension(600, 600));
      canvas.setMinimumSize(new Dimension(600, 600));
      
      frame.setSize(600, 600);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLocationRelativeTo(null);

      //makes thread
      Thread thread = new Thread(); 
        
   
      frame.add(canvas);
      frame.pack();
         
      boolean running = true;      
      
      int then;
      int time;
      int fps = 60;
      int nspf = 16949152; 

      int count = 0;
      while(running){
         then = (int)System.nanoTime();
         //randomly adds enemies
         //the 90 and 120 adjust the rate at which enemies spawn
         if(count < 2500 && count % (100 - (count / 40)) == 0){
            enemies.add(new Enemy(new Position(0, (int)(Math.random() * 400))));
         }
         else if(count % 80 == 0){
            enemies.add(new Enemy(new Position(0, (int)(Math.random() * 400)))); 
         }
         if(count < 3000 && count % (120 - (count / 40)) == 0){
            enemies.add(new Enemy(new Position((int)(Math.random() * 400), 0)));
         }
         else if(count % 100 == 0){
            enemies.add(new Enemy(new Position((int)(Math.random() * 400), 0)));   
         }
    
         for(int i = 0; i<enemies.size(); i++){
            enemies.get(i).move(tower);
            if(enemies.get(i).collide(tower)){
               towerHealth -= 10;
            }
         }
         Listener.enemyListReceiver(enemies); 
         canvas.listReceiver(enemies, tower, towerHealth);
         canvas.repaint();
         count++;
          
         time = (int)System.nanoTime() - then;
         if(nspf-time >= 0){
            try{
               thread.sleep((nspf-time)/1000000);
            }catch(Exception e){} 
         }
         
         if(towerHealth <= 0){
            running = false;
            frame.dispose();
            System.out.print("Your score: " + score);
          }
      }   
   }//end of main

   //a nested mouse listener class!
   public static class Listener implements MouseListener{
   
      private static ArrayList<Enemy> enemies; 
       
      public void mouseClicked(MouseEvent e){

         for(int i = 0; i<enemies.size(); i++){
            if(enemies.get(i).isHit(e.getX(), e.getY())){
               enemies.remove(i);
               score++;
            }
         }
       
       
      }
   
      public void mouseEntered(MouseEvent e){
   
      }
   
      public void mouseExited(MouseEvent e){
   
      }
   
      public void mousePressed(MouseEvent e){

      }
   
      public void mouseReleased(MouseEvent e){
   
      }
   
      public static void enemyListReceiver(ArrayList<Enemy> list){
         enemies = list; 
      }
   }
    

}
