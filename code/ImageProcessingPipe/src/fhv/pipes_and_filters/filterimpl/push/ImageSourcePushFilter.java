package fhv.pipes_and_filters.filterimpl.push;

import fhv.pipes_and_filters.abstracts.PushFilter;
import fhv.pipes_and_filters.abstracts.PushPipe;
import fhv.pipes_and_filters.utils.RegionOfInterest;
import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;

public class ImageSourcePushFilter extends PushFilter<PlanarImage> {

	String _filename;
	int _x;
	int _y;
	int _width;
	int _height;
	
	public ImageSourcePushFilter(PushPipe<PlanarImage> pipe, String filename,int x , int y, int width, int height) {
		super(pipe);
		_filename = filename;
		_x = x;
		_y = y;
		_width = width;
		_height = height;
	}
	
	public void write(){
		process();
	}
	
	public void process() {
		RegionOfInterest roi = new RegionOfInterest();
		PlanarImage image = roi.getregionOfInterest(_x, _y, _width, _height, _filename);
		JAI.create("filestore", image, _filename+"_roi.jpg", "JPEG");
		_pipe.write(image);
	}

	@Override
	public void process(PlanarImage in) {
	}
}
