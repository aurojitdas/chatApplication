package chatGUIServer;

import java.io.IOException;


public class chatApplicationServer {
	
	public static void main(String[] args) throws IOException {
		networkStuffServer network = new networkStuffServer();
		clickEventsServer click = new clickEventsServer();
		chatFrameServer f = new chatFrameServer(network, click);
		network.initServer(f);
		click.initData(network, f);				
	}

}
