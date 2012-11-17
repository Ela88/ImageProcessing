package fhv.pipes_and_filters.utils;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.media.jai.PlanarImage;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import com.sun.media.jai.widget.DisplayJAI;

public class ImageDisplay {
	
	public void displayImage(PlanarImage image){
		// Create a frame for display.
		JFrame frame = new JFrame();
		frame.setTitle("DisplayJAI, Imageprocessing");

		// Get the JFrame’ ContentPane.
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BorderLayout());

		// Create an instance of DisplayJAI.
		DisplayJAI dj = new DisplayJAI(image);

		// Add to the JFrame’ ContentPane an instance of JScrollPane
		// containing the DisplayJAI instance.
		contentPane.add(new JScrollPane(dj),BorderLayout.CENTER);

		// Get some information about the image
		String imageInfo = "Dimensions: "+image.getWidth()+"x"+image.getHeight()+ " Bands:"+image.getNumBands();

		// Add a text label with the image information.
		contentPane.add(new JLabel(imageInfo),BorderLayout.SOUTH);

		// Set the closing operation so the application is finished.   
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,200); // adjust the frame size.
		frame.setVisible(true); // show the frame.
		frame.pack();
	}
	
}
