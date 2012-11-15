package fhv.pipes_and_filters.filterimpl;

import javax.media.jai.PlanarImage;
import fhv.pipes_and_filters.abstracts.PullFilter;
import fhv.pipes_and_filters.abstracts.PullPipe;
import fhv.pipes_and_filters.utils.ImageFilters;

public class ImageMedianPullFilter extends PullFilter<PlanarImage>{

	public ImageMedianPullFilter(PullPipe<PlanarImage> pipe) {
		super(pipe);
	}

	public PlanarImage process() {
		ImageFilters imageFilter = new ImageFilters();
		return imageFilter.medianFilter(_pipe.read());
	}

}
