import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;


public class EditImage {
	public static Color getAverage (Image image){
		
		PixelReader reader = image.getPixelReader();
			
		double r = 0;
		double g = 0;
		double b = 0;
		
		int width = (int) image.getWidth();
		int height= (int) image.getHeight();
				
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				Color color = reader.getColor(x, y);
				r += color.getRed();
				g += color.getGreen();
				b += color.getBlue();
				
			}
		}
		
		r = r/(width * height);
		g = g/(width * height);
		b = b/(width * height);
		
		Color averageColor = new Color(r, g, b, 1f);
		
		return averageColor;
	}
}
