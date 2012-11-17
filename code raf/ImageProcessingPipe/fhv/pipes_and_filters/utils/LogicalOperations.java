package fhv.pipes_and_filters.utils;

import java.awt.image.renderable.ParameterBlock;
import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;

public class LogicalOperations {

	public static PlanarImage andImage(PlanarImage im0, PlanarImage im1){
		// Set up the parameter block and add the two source images to it.
		ParameterBlock pb = new ParameterBlock();
		pb.addSource(im0);
		// The first image
		pb.addSource(im1);	
		// The second image
		// AND the two images together.
		return JAI.create("and", pb, null);
	}
	
	public static PlanarImage orImage(PlanarImage im0, PlanarImage im1){
		ParameterBlock pb = new ParameterBlock();
		pb.addSource(im0);
		// The first image
		pb.addSource(im1);	
		// OR the two images. 
		return JAI.create("or", im0, im1);
	}
	
}
