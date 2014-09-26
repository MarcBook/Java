import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacpp.opencv_highgui;
import org.bytedeco.javacpp.opencv_highgui.CvCapture;
import org.bytedeco.javacv.CanvasFrame;

public class Gui extends JFrame {
	
	JButton btnOpenImage;
	JButton btnOpenWebcam;
	
	public Gui (){
		setTitle("Webcam");
		setSize(640, 420);
		
		
		btnOpenImage = new JButton("Open Image");
		btnOpenImage.addActionListener(new ButtonHandler());
		
		btnOpenWebcam = new JButton("Open Webcam");
		btnOpenWebcam.addActionListener(new ButtonHandler());
		
		add(btnOpenImage);
		add(btnOpenWebcam);
		
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnOpenImage) {
				System.exit(0);
			}
			
			if(e.getSource() == btnOpenWebcam) {
				Thread webcam = new Thread(){
					public void run(){
						CvCapture capture = opencv_highgui.cvCreateCameraCapture(0);
//						opencv_highgui.cvSetCaptureProperty(capture, opencv_highgui.CV_CAP_PROP_FRAME_HEIGHT, 720);
//						opencv_highgui.cvSetCaptureProperty(capture, opencv_highgui.CV_CAP_PROP_FRAME_WIDTH, 1280);
						
						IplImage grabbedImage = opencv_highgui.cvQueryFrame(capture);
						CanvasFrame frame = new CanvasFrame("Webcam");
						while(frame.isVisible() && (grabbedImage = opencv_highgui.cvQueryFrame(capture)) != null){
							frame.showImage(grabbedImage);
							System.out.println(grabbedImage);
						}
					}
				};
				webcam.start();
			}
		}
		
	}
}