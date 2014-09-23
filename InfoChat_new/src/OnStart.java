import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class OnStart extends JFrame {
	
	JTextField inputIp;
	JTextField inputPort;
	JButton save;
	
	public OnStart (){
		setTitle("Settings");
		setSize(200, 150);
		
		//START: Gui-Components
		
		inputIp = new JTextField("localhost");
		inputIp.setColumns(15);
		
		inputPort = new JTextField("5555");
		inputPort.setColumns(15);
		
		save = new JButton("Speichern");
		save.addActionListener(new ButtonHandler());
		
		//END: Gui-Components
		
		//START: Adding Components to GUI 
		
		add(inputIp);
		add(inputPort);
		add(save);
		
		//END: Adding Components to GUI 
		
		setLayout(new FlowLayout());
		setResizable(false);
		setVisible(true);
	}
	public class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == save){
				
				int port = Integer.parseInt(inputPort.getText());
				
				setVisible(false);
				
				JFrame jf = new Gui(inputIp.getText(), port);
				//m.conntectToServer(inputIp.getText(), port);
			}
		}
	}
}
