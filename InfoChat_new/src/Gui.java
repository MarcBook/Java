import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Gui extends JFrame {
	
	JTextArea messages;
	JTextField inputUser;
	JTextField inputMessage;
	JButton send;
	Message m;
	
	public static String newMessage;
	
	public static void getMessage (String message){
		newMessage = message;
		System.out.println(":" + newMessage);
	}
	
	public Gui (String ip, int port){
		
		m = new Message();
		m.conntectToServer(ip, port);
		
		setTitle("Chat");
		setSize(200, 400);
		
		Message.createThread();
		
		//START: GUI-Components
		
		messages = new JTextArea();
		messages.setEditable(false);
		messages.setColumns(15);
		
		inputUser = new JTextField("User");
		inputUser.setColumns(15);
		
		inputMessage = new JTextField();
		inputMessage.setColumns(15);
		
		send = new JButton("Senden");
		send.addActionListener(new ButtonHandler());
		
		
		//END: GUI-Components
		
		//START: Adding Components to GUI 
		
		add(messages);
		add(inputUser);
		add(inputMessage);
		add(send);
		
		//END: Adding Components to GUI 
		
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	public class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == send){
				String username = inputUser.getText();
				String message = inputMessage.getText();
				
				m.sendMessageToServer(message);
				
				messages.setText(messages.getText() + "<" + username + ">: " + message + "\n");
			}
		}
		
	}
}
