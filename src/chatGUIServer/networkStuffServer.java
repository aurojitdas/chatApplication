package chatGUIServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class networkStuffServer extends Thread {
	
	ServerSocket serverSocket;
	Socket socket;
	DataInputStream dis;
	DataOutputStream dos;
	chatFrameServer frame;
	int portno;
	public void initServer(chatFrameServer frame){
		this.frame = frame;
		try {
			
			InetAddress ip = InetAddress.getLocalHost();
			
			frame.ipaddressText.setText(ip.getHostAddress());
			
		} catch (UnknownHostException e) {
			frame.ipaddressText.setText("Network error");
			
		}	
			
	}

	
	
	
	public void initConnection(){
		
		try {

			serverSocket = new ServerSocket(portno);
			socket = serverSocket.accept();
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
			
			frame.connect.setText("Connected");			
		} catch (Exception e) {
			frame.connect.setText("Connect");
			e.printStackTrace();
		}	
	}
	
	public void getPortNumber()throws NumberFormatException{
		
		portno = Integer.parseInt(frame.portText.getText());
				
	}
	
	public void run(){
		
		try {

			serverSocket = new ServerSocket(portno);
			frame.connect.setText("Waiting for client");
			frame.connect.setEnabled(false);
			socket = serverSocket.accept();
			System.out.println("Skipped..");
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
			
			frame.connect.setText("Connected");			
		} catch (Exception e) {
			frame.connect.setText("Connect");
			e.printStackTrace();
		}	
		
	}

}
