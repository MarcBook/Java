import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Gui extends JFrame{
	public Gui (){
		setTitle("Chat");
		setSize(200, 400);
		
		//START: Gui-Components
		
		JLabel messages = new JLabel("Keine Nachrichten verfügbar");
		
		JTextField inputMessage = new JTextField();
		inputMessage.setColumns(15);
		
		JButton sendMessage = new JButton("Senden");
		
		//END: Gui-Components
		
		//START: Adding Components to GUI 
		add(messages);
		add(inputMessage);
		add(sendMessage);
		//END: Adding Components to GUI 
		
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
}
