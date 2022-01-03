import java.awt.Color;
import java.awt.Canvas; 
import java.awt.Graphics;
import java.awt.Graphics2D; 
import javax.swing.JFrame; 
import java.util.*; 
import java.awt.event.*; 

public class GameCanvas extends Canvas implements MouseListener{

   private ArrayList<Enemy> enemies;
   private Position tower;
   private int health; 
   
   public void paint(Graphics g){
      super.paint(g);
      Graphics2D g2d = (Graphics2D) g;
      g2d.setColor(Color.RED);
      g2d.fillRect(tower.getX()-220, tower.getY()-220, 200, 200); 
      g2d.setColor(Color.GREEN);
      g2d.fillRect(0, 550, 600, 50);
      g2d.setColor(Color.RED);
      g2d.fillRect(490, 420, 105, 25); 
      g2d.setColor(Color.MAGENTA); 
      //resize rectangle with health
      g2d.fillRect(492, 422, health/100, 20); 
      for(Enemy e: enemies){
         g2d.setColor(Color.BLUE);
         g2d.fillOval(e.getPosition().getX()-10, e.getPosition().getY()-10, 20, 20);
      }  
   }
   
   public void listReceiver(ArrayList<Enemy> enemies, Position tower, int towerHealth){
      this.enemies = enemies; 
      this.tower = tower; 
      this.health = towerHealth;
   }
   public void mousePressed(MouseEvent e) {
 
    }

    public void mouseReleased(MouseEvent e) {
       
    }

    public void mouseEntered(MouseEvent e) {
       
    }

    public void mouseExited(MouseEvent e) {
       
    }

    public void mouseClicked(MouseEvent e) {
       
    }

}