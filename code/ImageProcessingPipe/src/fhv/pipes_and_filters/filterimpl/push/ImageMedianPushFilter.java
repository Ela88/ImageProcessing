package fhv.pipes_and_filters.filterimpl.push;

import fhv.pipes_and_filters.abstracts.PushFilter;
import fhv.pipes_and_filters.abstracts.PushPipe;
import fhv.pipes_and_filters.utils.ImageDisplay;
import fhv.pipes_and_filters.utils.ImageFilters;
import javax.media.jai.PlanarImage;

public class ImageMedianPushFilter extends PushFilter<PlanarImage> {

	public ImageMedianPushFilter(PushPipe<PlanarImage> pipe) {
		super(pipe);
	}

    @Override
	public void process(PlanarImage in) {
		ImageFilters imageFilter = new ImageFilters();
		ImageDisplay id = new ImageDisplay();
		id.displayImage(in);
		_pipe.write(imageFilter.medianFilter(in));
	}
}
