package fhv.pipes_and_filters.pipeimpl.pull;

import fhv.pipes_and_filters.abstracts.filter.PullFilter;
import fhv.pipes_and_filters.abstracts.pipe.PullPipe;
import javax.media.jai.PlanarImage;

public class PlanarImagePullPipe extends PullPipe<PlanarImage>  {

	public PlanarImagePullPipe(PullFilter<PlanarImage> filter) {
		super(filter);
	}

}
