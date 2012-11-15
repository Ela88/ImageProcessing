package fhv.pipes_and_filters.filterimpl;

import javax.media.jai.PlanarImage;

import fhv.pipes_and_filters.abstracts.PullFilter;
import fhv.pipes_and_filters.abstracts.PullPipe;
import fhv.pipes_and_filters.utils.FindMiddlePointsInWhiteBalls;

public class MarkCentersPullFilter extends PullFilter<PlanarImage> {

	public MarkCentersPullFilter(PullPipe<PlanarImage> pipe) {
		super(pipe);
	}

	public PlanarImage process() {
		FindMiddlePointsInWhiteBalls fmpiwb = new FindMiddlePointsInWhiteBalls();
		return fmpiwb.getMiddlePointsAndMarkMiddle(_pipe.read().getData(), _pipe.read());
	}

}
