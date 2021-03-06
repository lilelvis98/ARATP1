/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aratp1;

import java.net.DatagramPacket;
import java.io.IOException;
import java.net.DatagramSocket;

/**
 *
 * @author p1507338 p1506450
 */
public class RX302Server extends Com{


    //opens a RX302 server on port DEFAULT_SERVER_PORT
    public RX302Server(){
    	super(DEFAULT_SERVER_PORT);
    }

    public void runRX302(){
	while(true){

	    try{
		System.out.println("Waiting for new client...");
		byte[] data = new byte[512];
                
		dp = new DatagramPacket(data, data.length);
		ds.receive(dp);
		
		DatagramSocket newSock = this.scan(1, 65000);
		Integer newPort = newSock.getLocalPort();
		System.out.println("New thread : " + newPort);
                
		CommunicationThread CT = new CommunicationThread(newSock, dp, newPort);
		new Thread(CT).start();
	    }
	    catch(IOException ioe){
		System.out.println("IUException : runtime interrupted");
	    }
	}
    }

    public static void main(String[] args) {
	RX302Server serv = new RX302Server();
	serv.runRX302();
    }
}
