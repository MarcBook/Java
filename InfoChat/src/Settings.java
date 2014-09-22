import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Settings extends JFrame{
	
	JLabel ip;
	JTextField inputip;
	
	JLabel port;
	JTextField inputport;
	
	JButton saveSettings;
	
	public Settings() {
		setTitle("Settings");
		setSize(200, 400);
		
		//START: Gui-Components
		
		ip = new JLabel("IP-Adresse:");
		
		inputip = new JTextField("192.168.2.104");
		inputip.setColumns(15);
		
		port = new JLabel("Port:");
		
		inputport = new JTextField("4521");
		inputport.setColumns(15);
		
		saveSettings = new JButton("Speichern");
		
		//END: Gui-Components
		
		//START: Adding Components to GUI 
		add(ip);
		add(inputip);
		add(port);
		add(inputport);
		add(saveSettings);
		//END: Adding Components to GUI 
		
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
}
