
package Ventana;


import java.applet.AudioClip;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Calendar;
import java.util.GregorianCalendar;


/**
 *
 * @author Arrecis
 */
public class Hora extends Thread {
    
    Calendar calendario = Calendar.getInstance();
    Calendar fecha = new GregorianCalendar();
    boolean seguir=false;
    String Seg="",Min="",Hor="";

    int hora = fecha.get(Calendar.HOUR_OF_DAY);
    int minuto = fecha.get(Calendar.MINUTE);
    int segundo = fecha.get(Calendar.SECOND);
   
    double grados = 0, radianes = 0, dato1 = 0, dato2 = 0, dato3 = 0;
    Graphics2D dibuja;
    AudioClip tic = java.applet.Applet.newAudioClip(getClass().getResource("/Ventana/campana.wav"));

    public Hora(Graphics2D dibuja) {
        this.dibuja = dibuja;
    }

    @Override
    public void run() {
        try {
           
            dibuja.setStroke(new BasicStroke(2));
            grados = hora * 30;
            radianes = Math.toRadians(grados);
            dato1 = Math.sin(radianes) * 60;
            dato2 = Math.cos(radianes) * 60;
            dibuja.setColor(Color.GREEN);
            dibuja.drawLine(455, 310, 455 + (int) dato1, 310 - (int) dato2);

            grados = minuto * 6;
            radianes = Math.toRadians(grados);
            dato1 = Math.sin(radianes) * 85;
            dato2 = Math.cos(radianes) * 85;
            dibuja.setColor(Color.GREEN);
            dibuja.drawLine(455, 310, 455 + (int) dato1, 310 - (int) dato2);

            grados = segundo * 6;
            radianes = Math.toRadians(grados);
            dato1 = Math.sin(radianes) * 100;
            dato2 = Math.cos(radianes) * 100;
            dibuja.setColor(Color.red);
            dibuja.drawLine(455, 310, 455 + (int) dato1, 310 - (int) dato2);
            if(minuto<10){
                Min = "0"+String.valueOf(minuto);
            }
            else{
             Min = String.valueOf(minuto);
            }
            if(segundo<10){
               Seg = "0"+String.valueOf(segundo);
            }
            else{
               Seg = String.valueOf(segundo);
            }
            String dato = (String.valueOf(hora)+" : "+Min+" : "+Seg);
            dibuja.drawString(dato,380,150); //mostramos hora
            Thread.sleep(1000);
            
            if(hora==12 && minuto==0 && segundo==0){
                tic.play();
                Thread.sleep(1000);
                tic.play();
                Thread.sleep(1000);
                tic.play();
            }
            
            if(minuto==0 && segundo==0){
                tic.play();            
            }
            
        } catch (Exception e) {
            System.out.println("." + e);
        }
    }
    
}
