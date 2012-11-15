package fhv.pipes_and_filters.filterimpl;

import javax.media.jai.PlanarImage;

import fhv.pipes_and_filters.abstracts.PullFilter;
import fhv.pipes_and_filters.abstracts.PullPipe;
import fhv.pipes_and_filters.utils.Treshhold;

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
