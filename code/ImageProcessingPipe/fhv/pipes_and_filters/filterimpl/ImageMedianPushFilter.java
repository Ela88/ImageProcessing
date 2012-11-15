package fhv.pipes_and_filters.filterimpl;

import javax.media.jai.PlanarImage;

import fhv.pipes_and_filters.abstracts.PushFilter;
import fhv.pipes_and_filters.abstracts.PushPipe;
import fhv.pipes_and_filters.utils.ImageDisplay;
import fhv.pipes_and_filters.utils.ImageFilters;

public class ImageMedianPushFilter extends PushFilter<PlanarImage> {

	public ImageMedianPushFilter(PushPipe<PlanarImage> pipe) {
		super(pipe);
	}

	public void process(PlanarImage in) {
		ImageFilters imageFilter = new ImageFilters();
		ImageDisplay id = new ImageDisplay();
		id.displayImage(in);
		_pipe.write(imageFilter.medianFilter(in));
	}
}
