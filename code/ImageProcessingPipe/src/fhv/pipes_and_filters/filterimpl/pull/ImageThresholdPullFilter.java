package fhv.pipes_and_filters.filterimpl.pull;

import fhv.pipes_and_filters.abstracts.filter.PullFilter;
import fhv.pipes_and_filters.abstracts.pipe.PullPipe;
import fhv.pipes_and_filters.utils.Treshhold;
import javax.media.jai.PlanarImage;

public class ImageThresholdPullFilter extends PullFilter<PlanarImage>{

	int _a;
	int _b;
	int _c;
	int _d;
	
	public ImageThresholdPullFilter(PullPipe<PlanarImage> pipe,int a, int b, int c, int d) {
		super(pipe);
		_a = a;
		_b = b;
		_c = c;
		_d = d;
	}

	public PlanarImage process() {
		Treshhold trs = new Treshhold();
		return trs.applyThreshold(this._pipe.read(), _a, _b, _c, _d);
	}

}
