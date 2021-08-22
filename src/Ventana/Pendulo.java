
package Ventana;

import java.awt.Color;
import java.awt.Graphics2D;


/**
 *
 * @author Arrecis
 */
public class Pendulo extends Thread {
     Graphics2D dibuja;
     double grados = 45, radianes = 0, dato1 = 0, dato2 = 0, dato3 = 0;
     public Pendulo (Graphics2D dibuja){
         this.dibuja = dibuja;
     }
    
     @Override
     public void run(){
         try{
           Thread.sleep(100);
           dibuja.setColor(Color.red);
           dibuja.fillOval(450,600,20,20);  //CENTRO
           Thread.sleep(1000);
           dibuja.setColor(Color.ORANGE);
           dibuja.fillOval(450,600,20,20);
           dibuja.setColor(Color.red);
           Thread.sleep(1000);
           dibuja.fillOval(350,560,20,20);
           dibuja.setColor(Color.ORANGE);
           dibuja.fillOval(350,560,20,20);
           dibuja.setColor(Color.red);
           dibuja.fillOval(550,560,20,20);
           Thread.sleep(1000);
           dibuja.setColor(Color.ORANGE);
           dibuja.fillOval(550,560,20,20);
            
            
         }
         catch(Exception e){
             System.err.println("P "+e);
         }
       
     }
}
