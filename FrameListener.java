import java.awt.*;
import java.awt.event.*; 

public class FrameListener extends MouseAdapter{
   int mouseX;
   int mouseY; 
   
   public FrameListener(){ 
   }
   
   public void mouseClicked(MouseEvent e){
      mouseX = e.getX();
      mouseY = e.getY();
      System.out.println("click");

      
   }
   
   public int getMouseX(){
      return mouseX;
   }
   
   public int getMouseY(){
      return mouseY; 
   }
}