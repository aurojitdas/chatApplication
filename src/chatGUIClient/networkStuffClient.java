package chatGUIClient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
public class networkStuffClient {
	
	boolean connectionStatus = false;
	Socket socket;
	DataInputStream dis;
	DataOutputStream dos;
	chatFrameClient frame;
	String ipaddress;
	String port;
	int portno;
	Boolean connected=false;
	public void initClient(chatFrameClient frame){
		this.frame = frame;	
	}	
	public void initConnection(){	
		try {			
			ipaddress =  frame.ipaddressText.getText();
			port =  frame.portText.getText();
			portno = Integer.parseInt(port);
			System.out.println(portno+ipaddress);
			socket = new Socket(ipaddress,portno);
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
					
		} catch (Exception e) {			
			frame.textArea.setText("Connection problem\n");		
			connectionStatus = false;
			try {
				socket.close();
			} catch (IOException e1) {
				
			}
			
		}	
	} 
}
