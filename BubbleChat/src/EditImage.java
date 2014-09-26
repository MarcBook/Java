import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;


public class EditImage {
	public static Color getAverage (BufferedImage image){
		
		int r = 0;
		int g = 0;
		int b = 0;
		
		int width = image.getWidth();
		int height= image.getHeight();
		
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				int rgb = image.getRGB(x, y);
				Color color = new Color(rgb);
				r += color.getRed();
				g += color.getGreen();
				b += color.getBlue();
			}
		}
		int pixels = width * height;
		r = r/pixels;
		g = g/pixels;
		b = b/pixels;
		
		Color colorAverage = new Color(r, g, b);
		
		return colorAverage;
	}
}
