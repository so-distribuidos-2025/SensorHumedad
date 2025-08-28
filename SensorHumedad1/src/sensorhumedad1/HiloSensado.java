/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sensorhumedad1;
import java.io.PrintWriter;
import java.lang.Math;
import java.net.Socket;

/**
 *
 * @author Alumnos
 */


public class HiloSensado extends Thread {
    private boolean on;
    private float humedad;
    private Socket cnxServidor;
    PrintWriter pw;

    public HiloSensado(Socket s, PrintWriter pw) {
        this.on = true;
        this.humedad = 0;
        this.cnxServidor = s;
        this.pw = pw;
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
            pw.println(this.humedad);
            System.out.println("Humedad: " + leerHumedad());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
           
        }
    }
    
    
}
