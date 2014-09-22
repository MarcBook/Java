import javax.swing.JFrame;


public class Gui extends JFrame{
	public Gui (){
		setTitle("Chat");
		setSize(200, 400);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
}
