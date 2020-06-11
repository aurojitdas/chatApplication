package chatGUIClient;



public class threadIncomingMessageClient extends Thread{

	
	networkStuffClient network;
	String temp;
	chatFrameClient f;
	int counter = 0;
	
	public void initThreadChat(networkStuffClient network,chatFrameClient f){
		this.network = network;
		this.f = f;
	}
	
	@Override
	public void run() {
		
		System.out.println(" connected");
		
		
			while(true){
				try {
					temp = network.dis.readUTF();
					f.textArea.append(temp+"\n");
					f.textArea.setCaretPosition(f.textArea.getDocument().getLength());
					
				} catch (Exception e) {
					//System.out.println("Connection Problem");
				}
			}
		
			}
		
		}
	

