import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.ScrollPane;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;


public class Gui extends JFrame {
	
	static JTextArea messages;
	JTextField inputUser;
	JTextField inputMessage;
	
	JScrollPane scrollPane;
	
	JButton send;
	Message m;
	
	public static String newMessage;
	
	public static void getMessage (String message){
		newMessage = message;
		System.out.println(":" + newMessage);
		messages.setText(messages.getText() + "\n" + message);
	}
	
	public Gui (String ip, int port){
		
		m = new Message();
		m.conntectToServer(ip, port);
		
		setTitle("Chat");
		setSize(200, 400);
		
		Message.createThread();
		
		//START: GUI-Components
		
		messages = new JTextArea(15, 15);
		messages.setEditable(false);
		messages.setLineWrap(true);
		messages.setWrapStyleWord(true);
//		messages.setPreferredSize(new Dimension(180, 280));
		
		scrollPane = new JScrollPane(messages);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		inputUser = new JTextField("User");
		inputUser.setColumns(15);
		
		inputMessage = new JTextField();
		inputMessage.setColumns(15);
		
		send = new JButton("Senden");
		send.addActionListener(new ButtonHandler());
		
		
		//END: GUI-Components
		
		//START: Adding Components to GUI 
		
//		add(messages);
		add(scrollPane);
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
			if(e.getSource() == send && messages.getText() != ""){
				String username = inputUser.getText();
				String message = inputMessage.getText();
				
				message = "<" + username + "> " + message;
				
				inputMessage.setText("");
				
				m.sendMessageToServer(message);
				
//				messages.setText(messages.getText() + message + "\n");
			}
		}
		
	}
}
