package fhv.pipes_and_filters.filterimpl;

import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;
import fhv.pipes_and_filters.abstracts.PullFilter;
import fhv.pipes_and_filters.abstracts.PullPipe;
import fhv.pipes_and_filters.utils.RegionOfInterest;

public class ImageSourcePullFilter extends PullFilter<PlanarImage> {

	String _filename;
	int _x;
	int _y;
	int _width;
	int _height;
	

	public ImageSourcePullFilter(PullPipe<PlanarImage> pipe) {
		super(pipe);
	}
	
	public ImageSourcePullFilter(PullPipe<PlanarImage> pipe, String filename,int x , int y, int width, int height) {
		super(pipe);
		_filename = filename;
		_x = x;
		_y = y;
		_width = width;
		_height = height;
	}

	public PlanarImage process() {
		
		RegionOfInterest roi = new RegionOfInterest();
		PlanarImage image = roi.getregionOfInterest(_x, _y, _width, _height, _filename);
		JAI.create("filestore", image, _filename+"_roi.jpg", "JPEG");
		return image;
	}
}
