package chatGUIClient;

import java.io.IOException;

public class chatApplication {
	
	public static void main(String[] args) throws IOException {
		
		
		networkStuffClient network = new networkStuffClient();
		clickEvents click = new clickEvents();				
		chatFrameClient f = new chatFrameClient(network,click);
		click.initData(network, f);
		threadIncomingMessageClient chatWindow = new threadIncomingMessageClient();
		chatWindow.initThreadChat(network, f);
		chatWindow.start();
	
	}

}
