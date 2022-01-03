import java.lang.Math;
public class Position{
   private int x;
   private int y;
   
   public Position(int x, int y){
      this.x = x;
      this.y = y; 
   }
   
   public int getX(){
      return this.x;
   }
   public int getY(){
      return this.y;
   }
   public void setX(int x){
      this.x += x;
   }
   public void setY(int y){
      this.y += y;
   }
   public void setXY(int x, int y){
      this.x = x;
      this.y = y;
   }
   public double distanceFrom(Position pos){
      int a = this.x - pos.getX();
      int b = this.y - pos.getY();
      return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
   }
   public boolean equals(Position a){
      return this.x == a.getX() && this.y == a.getY();
   }
   
}