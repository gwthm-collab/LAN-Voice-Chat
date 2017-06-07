/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.call;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.TargetDataLine;

/**
 *
 * @author gwthm
 */
public class RecThread extends Thread {
    public TargetDataLine aud_in = null;
    public DatagramSocket dataout;
    byte buff[] = new byte[512];
    public InetAddress ser_IP;
    public int ser_port;
    @Override
    public void run(){
        int i=0;
        while(ClientCall.calling){
            try {
                aud_in.read(buff, 0,buff.length);
                DatagramPacket data = new DatagramPacket(buff,buff.length,ser_IP,ser_port);
                System.out.println("Send "+(i++));
                dataout.send(data);
            } catch (IOException ex) {
                Logger.getLogger(RecThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        aud_in.close();
        aud_in.drain();
        System.out.println("Tread Stop");
    }
}
