package chatGUIServer;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;




public class chatFrameServer {

	
	networkStuffServer network;
	clickEventsServer click ;
	JFrame myFrame = new JFrame("A simple chat Server");
	JPanel bottomPanel = new JPanel();
	JTextField messageText = new JTextField(30);
	JButton send = new JButton("Send");
	JPanel middlePanel = new JPanel();
	JTextArea textArea = new JTextArea(20,45);
	JLabel msgLabel = new JLabel("Enter Message");
	JLabel textAreaLabel = new JLabel("Chat Window");
	JTextField ipaddressText = new JTextField(7);
	JLabel ip = new JLabel("Server ip: ");
	JPanel topPanel = new JPanel();
	JScrollPane scrollPane ;
	JTextField portText = new JTextField(4);
	JLabel portLabel = new JLabel("Port");
	JButton connect = new JButton("Connect");
	
	
	 public chatFrameServer(networkStuffServer network,clickEventsServer click){		 
		 
		super();
		this.network = network;
		this.click=click;
			
		 scrollPane = new JScrollPane(textArea);
		 middlePanel.add(textAreaLabel);
		 middlePanel.add(scrollPane);		 
		 textArea.setEditable(false);
		 textArea.setLineWrap(true);
		 
		 topPanel.add(ip);
		 topPanel.add(ipaddressText);
		 topPanel.add(portLabel);
		 topPanel.add(portText);
		 topPanel.add(connect);
		 
		 bottomPanel.add(msgLabel);
		 bottomPanel.add(messageText);
		 bottomPanel.add(send);
		 
		 ipaddressText.setEditable(false);
		 ipaddressText.setBackground(Color.WHITE);
		 
		 myFrame.setSize(650, 400);		 
		 myFrame.getContentPane().add(topPanel,BorderLayout.NORTH);
		 myFrame.getContentPane().add(middlePanel,BorderLayout.CENTER);		
		 myFrame.getContentPane().add(bottomPanel,BorderLayout.SOUTH);
		 myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 myFrame.setVisible(true);	 
		 
		 send.addActionListener(click.send);
		 connect.addActionListener(click.connect);
		 
		 portText.setText("8065");		 
		 
	 }
}
