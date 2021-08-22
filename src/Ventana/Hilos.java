/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;


import javax.swing.JLabel;



/**
 *
 * @author Arrecis
 */
public class Hilos  extends Thread{
    int i=0;
    JLabel temp;
    boolean seguir=true;
   
      
    public Hilos (JLabel temp){
        this.temp = temp;
        
    }
    
    
    @Override
    public void run(){
        
        
        try{
            while(seguir){
              
            Thread.sleep(1000);
            temp.setText(String.valueOf(i));
            i++;
        }
            
        }catch(InterruptedException e){
        
        }
    }
    
    public void terminar(){
        
            stop();
    }

    
   
    
    
 
    
}
