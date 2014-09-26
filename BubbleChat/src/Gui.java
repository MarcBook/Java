import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.text.AttributedCharacterIterator;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Gui extends JFrame{
	public Gui () throws IOException{
		setTitle("Bubble Chat");
		setSize(500, 500);
		
		BufferedImage image = ImageIO.read(new File("C:\\xampp\\htdocs\\jgbtl14\\images\\default.jpg"));
		System.out.println(EditImage.getAverage(image));
		
		JLabel label = new JLabel();
		label.setOpaque(true);
		label.setBackground(EditImage.getAverage(image));
		add(label);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
}
