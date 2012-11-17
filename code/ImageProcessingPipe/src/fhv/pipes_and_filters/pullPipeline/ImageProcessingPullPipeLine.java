package fhv.pipes_and_filters.pullPipeline;

import com.sun.media.jai.widget.DisplayJAI;
import fhv.pipes_and_filters.filterimpl.pull.ImageMedianPullFilter;
import fhv.pipes_and_filters.filterimpl.pull.ImageOpenPullFilter;
import fhv.pipes_and_filters.filterimpl.pull.ImageSourcePullFilter;
import fhv.pipes_and_filters.filterimpl.pull.ImageThresholdPullFilter;
import fhv.pipes_and_filters.filterimpl.pull.MarkCentersPullFilter;
import fhv.pipes_and_filters.pipeimpl.pull.BalledImagePullPipe;
import fhv.pipes_and_filters.pipeimpl.pull.FilteredImagePullPipe;
import fhv.pipes_and_filters.pipeimpl.pull.PlanarImagePullPipe;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.media.jai.PlanarImage;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class ImageProcessingPullPipeLine {
	
	static float[] kernelMatrix  = new float[]{
		0,0,0,0,0,1,0,0,0,0,0,
		0,0,0,1,1,1,1,1,0,0,0,
		0,0,1,1,1,1,1,1,1,0,0,
		0,1,1,1,1,1,1,1,1,1,0,
		1,1,1,1,1,1,1,1,1,1,1,
		1,1,1,1,1,1,1,1,1,1,1,
		1,1,1,1,1,1,1,1,1,1,1,
		0,1,1,1,1,1,1,1,1,1,0,
		0,1,1,1,1,1,1,1,1,1,0,
		0,0,1,1,1,1,1,1,1,0,0,
		0,0,0,0,1,1,1,0,0,0,0
	};
	
	public static void main(String[] args) {
		
		ImageSourcePullFilter imgSrc = new ImageSourcePullFilter(null, "loetstellen.jpg",0, 60, 450, 50);
		PlanarImagePullPipe sourceImgPipe = new PlanarImagePullPipe(imgSrc);
		displayImage(sourceImgPipe.read());
		
		ImageThresholdPullFilter tresholdFilter = new ImageThresholdPullFilter(sourceImgPipe, 0, 47, 255, 3);
		PlanarImagePullPipe imgThresholdPipe = new PlanarImagePullPipe(tresholdFilter);
		displayImage(imgThresholdPipe.read());
		
		ImageMedianPullFilter medianPullFilter  = new ImageMedianPullFilter(imgThresholdPipe);
		FilteredImagePullPipe filterimagePullPipe  = new FilteredImagePullPipe(medianPullFilter);
		displayImage(filterimagePullPipe.read());
		
		ImageOpenPullFilter imageOpenFilter = new ImageOpenPullFilter(filterimagePullPipe, kernelMatrix, 11);
		displayImage(imageOpenFilter.read());
		BalledImagePullPipe balledImagePullPipe = new BalledImagePullPipe(imageOpenFilter);
		
		MarkCentersPullFilter markCentersFilter = new MarkCentersPullFilter(balledImagePullPipe);
		displayImage(markCentersFilter.read());
	}
	
	public static void displayImage(PlanarImage image){
		// Create a frame for display.
		JFrame frame = new JFrame();
		frame.setTitle("DisplayJAI, Imageprocessing");

		// Get the JFrame: ContentPane.
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BorderLayout());

		// Create an instance of DisplayJAI.
		DisplayJAI dj = new DisplayJAI(image);

		// Add to the JFrame: ContentPane an instance of JScrollPane
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
