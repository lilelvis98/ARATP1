/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aratp1;

import java.net.DatagramPacket;
import java.io.IOException;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author p1507338
 */
public class RX302Server extends Com{
    
    
    //opens a RX302 server on port DEFAULT_SERVER_PORT
    public RX302Server(){
        super(DEFAULT_SERVER_PORT);
    }
    
    public void runRX302(){
        while(true){
            byte[] data = new byte[512];
            dp = new DatagramPacket(data, data.length);
            
            try{
                ds.receive(dp);
                //WAIT
<<<<<<< HEAD
                ArrayList<Integer> listPort = Com.scan(1, 65000);
=======

                ArrayList<Integer> listPort = this.scan(1, 65000);
>>>>>>> a56fc4ff0851587031a144fd416dbaffba800bd1
                Integer newPort = listPort.get(listPort.size() -1);
		System.out.println(newPort);
                DatagramSocket newSock = new DatagramSocket(newPort);
                CommunicationThread CT = new CommunicationThread(newSock, dp, newPort);
                CT.run();
            }catch(IOException ioe){
		    ioe.printStackTrace();
                System.out.println("IOException : runtime interrupted");
            }
        }
    }
    
    public static void main(String[] args) {
        RX302Server serv = new RX302Server();
        serv.runRX302();
    }
}

