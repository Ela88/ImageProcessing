package fhv.pipes_and_filters.pipeimpl;

import fhv.pipes_and_filters.abstracts.PullFilter;
import fhv.pipes_and_filters.abstracts.PullPipe;

public class BalledImagePullPipe extends PullPipe {

	public BalledImagePullPipe(PullFilter filter) {
		super(filter);
	}

}
