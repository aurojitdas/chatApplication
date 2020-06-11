package chatGUIServer;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class clickEventsServer {
	
	networkStuffServer network;
	chatFrameServer f;
	String temp;
	Boolean connected=false;
	threadIncomingMessageServer chatService = new threadIncomingMessageServer();
	
	 public void initData(networkStuffServer network, chatFrameServer f) {
		
		
		this.network = network;
		this.f = f;
		
	}

	 public clickEventsServer() {
			
		}


	ActionListener connect = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try{
					
					network.getPortNumber();					
					network.start();
					chatService.initchatwindow(network, f);
					chatService.start();
				}catch(NumberFormatException e){
					f.textArea.setText("Enter valid Port Number");
				} 	
			}
		};
		
		ActionListener send = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {					
						network.dos.writeUTF(f.messageText.getText());
						f.textArea.append("You: "+f.messageText.getText()+"\n");
						f.messageText.setText("");
						
										
				} catch (Exception e) {					
				}			
			}
		};
}
