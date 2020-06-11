package chatGUIServer;

import java.io.IOException;
import java.net.SocketException;

public class threadIncomingMessageServer extends Thread{

	String temp;
	networkStuffServer network;
	chatFrameServer f;
	
	public void initchatwindow(networkStuffServer network,chatFrameServer f){
		this.network = network;
		this.f =f;
	}
	public void run(){
		while(true){
			  try{
				  temp =network.dis.readUTF();  
			        f.textArea.append(temp+"\n");  
			        f.textArea.setCaretPosition(f.textArea.getDocument().getLength());//Automatically Scrolls to the last
			  }catch(SocketException e){
				  f.textArea.setText("Connection Terminated");
				  f.connect.setText("Disconnected");
				  
			  }catch(NullPointerException |IOException e){
				  
			  }	 
		       
			}	
	}
	
	
}
