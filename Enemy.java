import java.awt.Canvas; 
import java.awt.Graphics;
import javax.swing.JFrame;
import java.lang.Math;

public class Enemy{

   private Position pos;
   private int velocity;
   private int dmg;
   private int health;
   private double direction;
   
   public Enemy(Position pos){
      this.velocity = 1;
      dmg = (int)((Math.random() * 40) + 11);
      this.pos = pos;
      health = (int)((Math.random() * 4 + 2));
   }
   public void update(Position tower, int towerHealth){
      this.move(tower);
      if(this.collide(tower)){
         towerHealth-= 10; 
      } 
   }
   public boolean isHit(int mouseX, int mouseY){
      if(pos.getX() - mouseX >= -25 && pos.getX() - mouseX <= 25){
         if(pos.getY() - mouseY >= -25 && pos.getY() - mouseY <= 25){
            return true;
         }
      }
      return false;  
   }
   public boolean collide(Position tower){
      if(tower.getX() - this.pos.getX() <= 220 && tower.getY() - this.pos.getY() <= 220){
         return true;
      }
      return false; 
   }
   public int getDamage(){
      return dmg;
   }
   public int getVelocity(){
      return velocity;
   }
   public Position getPosition(){
      return pos;
   }
   public int getHealth(){
      return health;
   }
   public void minusHealthBy(int i){
      this.health -= i;
   }
   
   public boolean isDead(){
      return health <= 0;
   }
      public void move(Position tower){
         //difference in coords
         double dx = tower.getX() - this.pos.getX(); 
         double dy = tower.getY() - this.pos.getY(); 
         
      
         double r; 
         
         r = Math.sqrt(Math.pow((dx), 2) + Math.pow(dy, 2)); 
         
         if(dx == 0){
           dx = 1; 
         }
         
         //get angle to tower
         double angle = Math.atan(dy/dx); 
         
         direction = angle; 
         
         this.pos.setX((int)(r*Math.cos(direction)*0.005)); 
         this.pos.setY((int)(r*Math.sin(direction)*0.005));
         
      }
   }
   