package chatGUIClient;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class chatFrameClient {
	
	
	networkStuffClient network;
	clickEvents click ;
	JFrame myFrame = new JFrame("A simple chat client");
	JPanel bottomPanel = new JPanel();
	JTextField messageText = new JTextField(30);
	JButton send = new JButton("Send");
	JPanel topPanel = new JPanel();
	JTextArea textArea = new JTextArea(20,45);
	JLabel msgLabel = new JLabel("Enter Message");
	JLabel textAreaLabel = new JLabel("Chat Window");
	JTextField ipaddressText = new JTextField(7);
	JLabel ip = new JLabel("Enter Server ip: ");
	JPanel middlePanel = new JPanel();
	JScrollPane scrollPane ;
	JButton connect = new JButton("Connect");
	JLabel portLabel = new JLabel("Port"); 
	JTextField portText = new JTextField(4);
	
	
	public chatFrameClient(networkStuffClient network,clickEvents click){
		
		super();
		this.network = network;
		this.click=click;
		
		
		 scrollPane = new JScrollPane(textArea);
		 topPanel.add(textAreaLabel);
		 topPanel.add(scrollPane);		 
		 textArea.setEditable(false);
		 textArea.setLineWrap(true);
		 
		 middlePanel.add(ip);
		 middlePanel.add(ipaddressText);
		 middlePanel.add(portLabel);
		 middlePanel.add(portText);
		 middlePanel.add(connect);
		 
		 bottomPanel.add(msgLabel);
		 bottomPanel.add(messageText);
		 bottomPanel.add(send);
		 
		 myFrame.setSize(650, 400);
		 
		 myFrame.getContentPane().add(middlePanel,BorderLayout.NORTH);
		 myFrame.getContentPane().add(topPanel,BorderLayout.CENTER);		
		 myFrame.getContentPane().add(bottomPanel,BorderLayout.SOUTH);
		 myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 myFrame.setVisible(true);
		 
		 connect.addActionListener(click.connect);
		 send.addActionListener(click.send);
	 }	
}
