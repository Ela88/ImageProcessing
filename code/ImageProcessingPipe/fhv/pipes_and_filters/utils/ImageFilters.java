package fhv.pipes_and_filters.utils;

import java.awt.image.RenderedImage;
import java.awt.image.renderable.ParameterBlock;

import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;
import javax.media.jai.operator.MedianFilterDescriptor;

public class ImageFilters {

	/*
	 * Applys a median filter on a image.
	 * This will remove small pixelgroups
	 */
	public PlanarImage medianFilter(PlanarImage image){
		ParameterBlock pb = new ParameterBlock();
		pb.addSource(image);
		pb.add(MedianFilterDescriptor.MEDIAN_MASK_SQUARE);
		pb.add(3);

		RenderedImage dst = JAI.create("MedianFilter", pb);
		PlanarImage finalImg = (PlanarImage) dst;
		return finalImg;
	}
	
	public PlanarImage toGrayScale(RenderedImage imageToBinarize) {
		ParameterBlock bandCombineParams = new ParameterBlock();
		bandCombineParams.addSource(imageToBinarize);
		bandCombineParams.add( new double[][]{ {0.2,0.3,0.4,0.5} } );
		return JAI.create("bandcombine", bandCombineParams, null);
	}
	
}
