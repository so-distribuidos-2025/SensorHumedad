/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sensorhumedad1;
import java.lang.Math;
/**
 *
 * @author Alumnos
 */


public class HiloSensado extends Thread {
    private boolean on;
    private float humedad;

    public HiloSensado(boolean on, float humedad) {
        this.on = on;
        this.humedad = humedad;
    }
    
    public HiloSensado() {
        this.on = true;
        this.humedad = 0;
    }
    
    
    public float generarHumedad(){
    return ((float) Math.random()*100);
    }
    
    public void encender(){
        on = true;
    }
    
    public void apagar(){
        on = false;
    }
    
    public float leerHumedad(){
    return humedad;
    }
    
    public void run(){
        /*en este while medimos la humedad*/
        while(on/*o while(on)*/){
            this.humedad = generarHumedad();
            System.out.println("Humedad: " + leerHumedad());
            
           
        }
    }
    
    
}
