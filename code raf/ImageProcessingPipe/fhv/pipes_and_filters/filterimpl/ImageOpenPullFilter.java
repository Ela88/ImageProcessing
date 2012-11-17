package fhv.pipes_and_filters.filterimpl;

import javax.media.jai.PlanarImage;

import fhv.pipes_and_filters.abstracts.PullFilter;
import fhv.pipes_and_filters.abstracts.PullPipe;
import fhv.pipes_and_filters.utils.DilationAndErosion;

public class ImageOpenPullFilter extends PullFilter<PlanarImage> {

	float[] _kernelMatrix;
	int _matrixSize;
	
	public ImageOpenPullFilter(PullPipe<PlanarImage> pipe, float[] kernelMatrix, int matrixSize) {
		super(pipe);
		_kernelMatrix = kernelMatrix;
		_matrixSize = matrixSize;
	}

	public PlanarImage process() {
		DilationAndErosion dae = new DilationAndErosion();
		return dae.doOpen(_pipe.read(), _kernelMatrix, _matrixSize);
	}

}
