/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.call;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.SourceDataLine;

/**
 *
 * @author gwthm
 */
public class PlayThread extends Thread {
    public DatagramSocket datain;
    public SourceDataLine aud_out;
    byte buff[] = new byte[512];
    @Override
    public void run(){
        int i = 0;
        DatagramPacket in = new DatagramPacket(buff,buff.length);
        while(ServerCall.calling){
            try {
                datain.receive(in);
                buff = in.getData();
                aud_out.write(buff, 0, buff.length);
                System.out.println(i++);
            } catch (IOException ex) {
                Logger.getLogger(PlayThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        aud_out.close();
        aud_out.drain();
        System.out.println("Stop");
    }
}
