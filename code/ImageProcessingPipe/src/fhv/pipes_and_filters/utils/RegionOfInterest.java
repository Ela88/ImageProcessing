package fhv.pipes_and_filters.utils;

import java.awt.Rectangle;
import java.awt.image.RenderedImage;
import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;

public class RegionOfInterest {
	
	/*
	 * Crops an Image
	 * the Region of Interest is defined by the User
	 */
	public PlanarImage getregionOfInterest(int x, int y, int width, int height, String filename){
		try{
			PlanarImage image = JAI.create("fileload", filename);
			Rectangle rectangle = new Rectangle( x, y,  width, height);
			image = PlanarImage.wrapRenderedImage((RenderedImage)image.getAsBufferedImage(rectangle, image.getColorModel()));
			return image;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
