package fhv.pipes_and_filters.filterimpl;

import javax.media.jai.PlanarImage;

import fhv.pipes_and_filters.abstracts.PushFilter;
import fhv.pipes_and_filters.abstracts.PushPipe;
import fhv.pipes_and_filters.utils.DilationAndErosion;
import fhv.pipes_and_filters.utils.ImageDisplay;

public class ImageOpenPushFilter extends PushFilter<PlanarImage> {

	float[] _kernelMatrix;
	int _matrixSize;
	
	public ImageOpenPushFilter(PushPipe<PlanarImage> pipe, float[] kernelMatrix, int matrixSize) {
		super(pipe);
		_kernelMatrix = kernelMatrix;
		_matrixSize = matrixSize;
	}

	@Override
	public void process(PlanarImage in) {
		DilationAndErosion dae = new DilationAndErosion();
		ImageDisplay id = new ImageDisplay();
		id.displayImage(in);
		_pipe.write(dae.doOpen(in, _kernelMatrix, _matrixSize));
	}

}
