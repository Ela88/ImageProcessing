package fhv.pipes_and_filters.pipeimpl;

import javax.media.jai.PlanarImage;

import fhv.pipes_and_filters.abstracts.PushFilter;
import fhv.pipes_and_filters.abstracts.PushPipe;
import fhv.pipes_and_filters.utils.ImageDisplay;

public class OutputPushPipe extends PushPipe<PlanarImage>{

	public OutputPushPipe(PushFilter<PlanarImage> filter) {
		super(filter);
	}
	
	@Override
	public void write(PlanarImage in){
		ImageDisplay id = new ImageDisplay();
		id.displayImage(in);
	}
}
