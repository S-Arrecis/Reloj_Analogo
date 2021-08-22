
package Ventana;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Arrecis
 */
public class Letrero extends Thread {
    
     int velocidad=1000;
    String cadena="";
    boolean seguir=true;
     String Error = "";
     JLabel Mensaje;
     JLabel Cadena;
    private Font[] fuentes;
    private int minimo = 10;
    private int maximo = 30;
    int contador;
    Random numeros =new Random(); 
    
  public Letrero(JLabel Cadena)
    {
        this.cadena = "Sin cadena ingresada...";
        this.velocidad = 1000;
        this.Cadena = Cadena;
        //this.Mensaje = Mensaje;
    }
    
    public Letrero(String cadena, int sleep, JLabel lblCadena, JLabel lblMensaje) throws Exception
    {
        try
        {
            this.cadena = cadena;
            this.velocidad = sleep;
            
            this.cadena = this.cadena.trim();
            
            if(this.cadena.length() == 0) Error = "Ingrese una cadena no vacía. ";
           //if(this.velocidad < 0) Error = "Ingrese un valor para sleep mayor o igual que cero (0). ";
            if(!Error.equals("")) throw new Exception(Error);
            
            this.Cadena = lblCadena;
            this.Mensaje = lblMensaje;
            
        }catch(Exception ex)
        {
            throw new Exception("Hilos()." + ex.getMessage());
        }
    }
       
  
   
     @Override
 public void run(){
        
    fuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
    int indiceFuente = 0;
    int tamanioFuente = 0;
    String[] palabras = this.cadena.split(" ");
    contador = 0;
    while(true){
            
        try {
            indiceFuente = (int) Math.round(Math.random() * fuentes.length);
            tamanioFuente = (int) Math.round(Math.random() * (this.maximo - this.minimo + 1) + this.minimo);
            Font fuente = new Font(fuentes[indiceFuente].getFontName(), Font.PLAIN, tamanioFuente);
             
            Cadena.setFont(fuente);
            Cadena.setText(palabras[contador]);
                
                
            Color c = new Color(numeros.nextInt(256),numeros.nextInt(256),numeros.nextInt(256),numeros.nextInt(256));
                
            Cadena.setForeground(c);
            Mensaje.setText("Fuente: " + fuente.getName() + ", tamaño: " + String.valueOf(tamanioFuente));
            Thread.sleep(velocidad);
            contador++;
            if(contador == palabras.length) contador = 0;
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
 
 public void parar(){
     stop();
 }
    
}
