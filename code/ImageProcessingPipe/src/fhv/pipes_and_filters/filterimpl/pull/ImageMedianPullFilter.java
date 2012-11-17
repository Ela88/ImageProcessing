package fhv.pipes_and_filters.filterimpl.pull;

import fhv.pipes_and_filters.abstracts.filter.PullFilter;
import fhv.pipes_and_filters.abstracts.pipe.PullPipe;
import fhv.pipes_and_filters.utils.ImageFilters;
import javax.media.jai.PlanarImage;

public class ImageMedianPullFilter extends PullFilter<PlanarImage>{

	public ImageMedianPullFilter(PullPipe<PlanarImage> pipe) {
		super(pipe);
	}

    @Override
	public PlanarImage process() {
		ImageFilters imageFilter = new ImageFilters();
		return imageFilter.medianFilter(_pipe.read());
	}

}
