package fhv.pipes_and_filters.filterimpl.pull;

import fhv.pipes_and_filters.abstracts.filter.PullFilter;
import fhv.pipes_and_filters.abstracts.pipe.PullPipe;
import fhv.pipes_and_filters.utils.DilationAndErosion;
import javax.media.jai.PlanarImage;

public class ImageOpenPullFilter extends PullFilter<PlanarImage> {

	float[] _kernelMatrix;
	int _matrixSize;
	
	public ImageOpenPullFilter(PullPipe<PlanarImage> pipe, float[] kernelMatrix, int matrixSize) {
		super(pipe);
		_kernelMatrix = kernelMatrix;
		_matrixSize = matrixSize;
	}

    @Override
	public PlanarImage process() {
		DilationAndErosion dae = new DilationAndErosion();
		return dae.doOpen(_pipe.read(), _kernelMatrix, _matrixSize);
	}

}
