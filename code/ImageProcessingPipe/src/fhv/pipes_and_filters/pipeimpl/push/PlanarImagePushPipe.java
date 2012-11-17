package fhv.pipes_and_filters.pipeimpl.push;

import fhv.pipes_and_filters.abstracts.PushFilter;
import fhv.pipes_and_filters.abstracts.PushPipe;
import javax.media.jai.PlanarImage;

public class PlanarImagePushPipe extends PushPipe<PlanarImage> {

	public PlanarImagePushPipe(PushFilter<PlanarImage> filter) {
		super(filter);
	}

}
