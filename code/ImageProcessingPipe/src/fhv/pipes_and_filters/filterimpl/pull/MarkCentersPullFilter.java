package fhv.pipes_and_filters.filterimpl.pull;

import fhv.pipes_and_filters.abstracts.filter.PullFilter;
import fhv.pipes_and_filters.abstracts.pipe.PullPipe;
import fhv.pipes_and_filters.utils.FindMiddlePointsInWhiteBalls;
import javax.media.jai.PlanarImage;

public class MarkCentersPullFilter extends PullFilter<PlanarImage> {

	public MarkCentersPullFilter(PullPipe<PlanarImage> pipe) {
		super(pipe);
	}

    @Override
	public PlanarImage process() {
		FindMiddlePointsInWhiteBalls fmpiwb = new FindMiddlePointsInWhiteBalls();
		return fmpiwb.getMiddlePointsAndMarkMiddle(_pipe.read().getData(), _pipe.read());
	}

}
