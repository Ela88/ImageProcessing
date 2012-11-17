package fhv.pipes_and_filters.pushPipeline;

import fhv.pipes_and_filters.filterimpl.ImageMedianPushFilter;
import fhv.pipes_and_filters.filterimpl.ImageOpenPushFilter;
import fhv.pipes_and_filters.filterimpl.ImageSourcePushFilter;
import fhv.pipes_and_filters.filterimpl.ImageThresholdPushFilter;
import fhv.pipes_and_filters.filterimpl.MarkCentersPushFilter;
import fhv.pipes_and_filters.pipeimpl.OutputPushPipe;
import fhv.pipes_and_filters.pipeimpl.PlanarImagePushPipe;

public class ImageProcessingPushPipeLine {
	
	static float[] kernelMatrix  = new float[]{
		0,0,0,0,0,1,0,0,0,0,0,
		0,0,0,1,1,1,1,1,0,0,0,
		0,0,1,1,1,1,1,1,1,0,0,
		0,1,1,1,1,1,1,1,1,1,0,
		1,1,1,1,1,1,1,1,1,1,1,
		1,1,1,1,1,1,1,1,1,1,1,
		1,1,1,1,1,1,1,1,1,1,1,
		0,1,1,1,1,1,1,1,1,1,0,
		0,1,1,1,1,1,1,1,1,1,0,
		0,0,1,1,1,1,1,1,1,0,0,
		0,0,0,0,1,1,1,0,0,0,0
	};
	
	public static void main(String[] args){
		OutputPushPipe outpushPipe = new OutputPushPipe(null);
		MarkCentersPushFilter markCenterPush = new MarkCentersPushFilter(outpushPipe);
		PlanarImagePushPipe pp1 = new PlanarImagePushPipe(markCenterPush);
		ImageOpenPushFilter imageOpenPushFilter = new ImageOpenPushFilter(pp1, kernelMatrix, 11);
		PlanarImagePushPipe pp2 = new PlanarImagePushPipe(imageOpenPushFilter);
		ImageMedianPushFilter medianPushFilter = new ImageMedianPushFilter(pp2);
		PlanarImagePushPipe pp3 = new PlanarImagePushPipe(medianPushFilter);
		ImageThresholdPushFilter thresholdPushFilter = new ImageThresholdPushFilter(pp3, 0, 47, 255, 3);
		PlanarImagePushPipe pp4 = new PlanarImagePushPipe(thresholdPushFilter);
		ImageSourcePushFilter imgSourcePush = new ImageSourcePushFilter(pp4, "loetstellen.jpg",0, 60, 450, 50);
		imgSourcePush.write();
	}
}
