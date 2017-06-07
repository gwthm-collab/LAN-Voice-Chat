/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.call;

/**
 *
 * @author gwthm
 */
public class ServerCall {

    /**
     * @param args the command line arguments
     */
    public static boolean calling = false;
    public static void main(String[] args) {
        Server_frame frame = new Server_frame();
        frame.setVisible(true);
    }
    
}
