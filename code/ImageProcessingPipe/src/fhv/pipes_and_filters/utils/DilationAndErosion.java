package fhv.pipes_and_filters.utils;

import java.awt.image.RenderedImage;
import java.awt.image.renderable.ParameterBlock;
import javax.media.jai.JAI;
import javax.media.jai.KernelJAI;
import javax.media.jai.PlanarImage;

public class DilationAndErosion {

	//APPLYS THE OPEN OPERATION ON THE IMAGE
	//OUTPUT OF THIS OPERATION DEPENDS
	//ON THE USED KERNELMATRIX
	public PlanarImage doOpen(PlanarImage image, float[] kernelMatrix, int length) {
		KernelJAI kernel = new KernelJAI( length, length, kernelMatrix );
		image = doErode(image, kernel);
		image = doDeliate(image, kernel);
		return image;
	}
	
	private PlanarImage doDeliate(RenderedImage image, KernelJAI kernel) {
		ParameterBlock dilateParams = new ParameterBlock();
		dilateParams.addSource( image );
		dilateParams.add( kernel );
		return (PlanarImage)JAI.create("dilate", dilateParams, null);
	}
	
	private PlanarImage doErode(RenderedImage image, KernelJAI kernel) {
		ParameterBlock erodeParams = new ParameterBlock();
		erodeParams.addSource( image );
		erodeParams.add( kernel );
		return (PlanarImage)JAI.create("erode", erodeParams, null);
	}
}
