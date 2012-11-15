package fhv.pipes_and_filters.pipeimpl;

import javax.media.jai.PlanarImage;

import fhv.pipes_and_filters.abstracts.PullFilter;
import fhv.pipes_and_filters.abstracts.PullPipe;

public class FilteredImagePullPipe extends PullPipe<PlanarImage> {

	public FilteredImagePullPipe(PullFilter<PlanarImage> filter) {
		super(filter);
	}

}
