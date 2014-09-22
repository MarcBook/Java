import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Gui extends JFrame{
	
	JLabel ip;
	JTextField inputip;
	
	JLabel port;
	JTextField inputport;
	
	JTextArea messages;
	JTextField inputMessage;
	JButton sendMessage;
	JButton settings;
	
	
	public Gui (){
		setTitle("Chat");
		setSize(200, 400);
		
		//START: Gui-Components
		
		ip = new JLabel("IP-Adresse:");
		
		inputip = new JTextField("localhost");
		inputip.setColumns(15);
		
		port = new JLabel("Port:");
		
		inputport = new JTextField("5555");
		inputport.setColumns(15);
		
		messages = new JTextArea("Keine Nachrichten verfügbar");
		messages.setColumns(15);
		messages.setEditable(false);
		
		inputMessage = new JTextField();
		inputMessage.setColumns(15);
		
		sendMessage = new JButton("Senden");
		sendMessage.addActionListener(new ButtonListener());
		
		settings = new JButton("Config");
		settings.addActionListener(new ButtonListener());
		
		//END: Gui-Components
		
		//START: Adding Components to GUI 
		
		add(ip);
		add(inputip);
		add(port);
		add(inputport);
		add(messages);
		add(inputMessage);
		add(sendMessage);
		//add(settings);
		
		//END: Adding Components to GUI 
		
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

	public class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == sendMessage){
				
				int port = Integer.parseInt(inputport.getText());
				
				Message.send(inputMessage.getText(), inputip.getText(), port);
				messages.setText(messages.getText() + inputMessage.getText());
			}
			
			if(e.getSource() == settings){
				System.out.println("Settings");
				JFrame se = new Settings();
			}
		}
	}
}

