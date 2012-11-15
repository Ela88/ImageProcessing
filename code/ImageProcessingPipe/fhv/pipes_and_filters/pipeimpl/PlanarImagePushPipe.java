package fhv.pipes_and_filters.pipeimpl;

import javax.media.jai.PlanarImage;

import fhv.pipes_and_filters.abstracts.PushFilter;
import fhv.pipes_and_filters.abstracts.PushPipe;

public class PlanarImagePushPipe extends PushPipe<PlanarImage> {

	public PlanarImagePushPipe(PushFilter<PlanarImage> filter) {
		super(filter);
	}

}
