/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sensorhumedad1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SensorHumedad1 {

    public static void main(String[] args) {
        String id = args[0];
        InetAddress ipServidor = null;
        PrintWriter pw;
        try {
            ipServidor = InetAddress.getByName("localhost");
            Socket cliente = new Socket(ipServidor, 20000);
            System.out.println(cliente);
            pw = new PrintWriter(cliente.getOutputStream(), true); //El segundo parametro activa el autoflush para escribir en el buffer
            pw.println("humedad");
            pw.println(id);
            HiloSensado sensor = new HiloSensado(cliente, pw);
            sensor.start();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);

        }

    }
}
