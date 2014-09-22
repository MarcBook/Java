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
import javax.swing.JTextField;


public class Gui extends JFrame{
	
	JLabel messages;
	JTextField inputMessage;
	JButton sendMessage;
	JButton settings;
	
	
	public Gui (){
		setTitle("Chat");
		setSize(200, 400);
		
		//START: Gui-Components
		
		messages = new JLabel("Keine Nachrichten verfügbar");
		
		inputMessage = new JTextField();
		inputMessage.setColumns(15);
		
		sendMessage = new JButton("Senden");
		sendMessage.addActionListener(new ButtonListener());
		
		settings = new JButton("Config");
		settings.addActionListener(new ButtonListener());
		
		//END: Gui-Components
		
		//START: Adding Components to GUI 
		
		add(messages);
		add(inputMessage);
		add(sendMessage);
		add(settings);
		
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
				Message.send(inputMessage.getText());
				messages.setText("<html><body>" + messages.getText() + "<br /><br />" + inputMessage.getText() + "</body></html>");
			}
			
			if(e.getSource() == settings){
				System.out.println("Settings");
				JFrame se = new Settings();
			}
		}
		
	}
}

