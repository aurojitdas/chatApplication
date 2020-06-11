package chatGUIClient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class clickEvents {
	
	networkStuffClient network;
	chatFrameClient f;
	String temp;
	
	
	
	 public void initData(networkStuffClient network, chatFrameClient f) {
		
		
		this.network = network;
		this.f = f;
		
	}

	 public clickEvents() {
			
		}


	ActionListener connect = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
			
				try {	
					if(!network.connected){
						if(network.frame==null){
							network.initClient(f);
						}						
						network.initConnection();
					
						network.connected=true;
						network.connectionStatus = true;
						f.connect.setText("Connected");
						
					}else{
						
					}
						
					
					
				} catch (Exception e) {
					
					
				}
				
			}
		};
		
		ActionListener send = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					if(network.connected){
						
						network.dos.writeUTF(f.messageText.getText());
						f.textArea.append("You: "+f.messageText.getText()+"\n");
						f.messageText.setText("");
						
					}
					
					
				} catch (Exception e) {
					
				}
				
			}
		};
		
		public void display(){
			}
}
