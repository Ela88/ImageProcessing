package fhv.pipes_and_filters.pipeimpl;

import javax.media.jai.PlanarImage;

import fhv.pipes_and_filters.abstracts.PullFilter;
import fhv.pipes_and_filters.abstracts.PullPipe;

public class PlanarImagePullPipe extends PullPipe<PlanarImage>  {

	public PlanarImagePullPipe(PullFilter<PlanarImage> filter) {
		super(filter);
	}

}
