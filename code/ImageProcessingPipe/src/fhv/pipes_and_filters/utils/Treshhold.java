package fhv.pipes_and_filters.utils;

import java.awt.image.RenderedImage;
import java.awt.image.renderable.ParameterBlock;
import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;

public class Treshhold {
	
	/*
	 * The Threshold operation takes one rendered image,
	 * and maps all the pixels of this image whose values
	 * fall within a specified range to a specified constant.
	 * The range is specified by a low value and a high value.
	 */
	
	public PlanarImage applyThreshold(PlanarImage image, double a, double b, double c, int bnd){
		//Set up the operation parameters
		PlanarImage src = image;
		double[] low;
		double[] high, map;
		int bands = bnd;

		low = new double[bands];
		high = new double[bands];
		map = new double[bands];

		for(int i = 0; i < bands; i++){
			low[i] = a;
			high[i] = b;
			map[i] = c;
		}

		//Create the thrshold operation.
		ParameterBlock pb = new ParameterBlock();
		pb.addSource(src);
		pb.add(low);
		pb.add(high);
		pb.add(map);
		RenderedImage dst = JAI.create("threshold", pb);
		PlanarImage finalImg = (PlanarImage) dst;
		return finalImg;
	}
}
