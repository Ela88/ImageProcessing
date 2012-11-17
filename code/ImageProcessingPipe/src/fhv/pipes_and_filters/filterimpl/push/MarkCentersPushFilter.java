package fhv.pipes_and_filters.filterimpl.push;

import fhv.pipes_and_filters.abstracts.PushFilter;
import fhv.pipes_and_filters.abstracts.PushPipe;
import fhv.pipes_and_filters.utils.FindMiddlePointsInWhiteBalls;
import fhv.pipes_and_filters.utils.ImageDisplay;
import javax.media.jai.PlanarImage;

public class MarkCentersPushFilter extends PushFilter<PlanarImage> {

	public MarkCentersPushFilter(PushPipe<PlanarImage> pipe) {
		super(pipe);
	}

    @Override
	public void process(PlanarImage in) {
		ImageDisplay id = new ImageDisplay();
		id.displayImage(in);
		FindMiddlePointsInWhiteBalls fmpiwb = new FindMiddlePointsInWhiteBalls();
		_pipe.write(fmpiwb.getMiddlePointsAndMarkMiddle(in.getData(), in));
	}
}

