package fhv.pipes_and_filters.filterimpl.push;

import fhv.pipes_and_filters.abstracts.PushFilter;
import fhv.pipes_and_filters.abstracts.PushPipe;
import fhv.pipes_and_filters.utils.ImageDisplay;
import fhv.pipes_and_filters.utils.Treshhold;
import javax.media.jai.PlanarImage;

public class ImageThresholdPushFilter extends PushFilter<PlanarImage>{

	int _a;
	int _b;
	int _c;
	int _d;
	
	public ImageThresholdPushFilter(PushPipe<PlanarImage> pipe,int a, int b, int c, int d) {
		super(pipe);
		_a = a;
		_b = b;
		_c = c;
		_d = d;
	}

    @Override
	public void process(PlanarImage in) {
		Treshhold trs = new Treshhold();
		ImageDisplay id = new ImageDisplay();
		id.displayImage(in);
		_pipe.write(trs.applyThreshold(in, _a, _b, _c, _d));
	}
}
