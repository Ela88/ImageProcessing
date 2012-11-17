package fhv.pipes_and_filters.utils;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.LinkedList;
import javax.media.jai.PlanarImage;

public class FindMiddlePointsInWhiteBalls {
	
	/*
	 * Finds the pixels that fall into the colorrange of white and bright grey (240 - 255)
	 * collects these pixels and finds the middle of this set of pixels
	 */
	
public PlanarImage getMiddlePointsAndMarkMiddle(Raster ras, PlanarImage img){
		
		LinkedList<LinkedList<Point>> allBalls = new LinkedList<LinkedList<Point>>();
		LinkedList<Point> ball = new LinkedList<Point>();
		boolean isBall = false;
		StringBuffer results = new StringBuffer();
		
		//Go horizontal through the raster
		for(int x = 0; x < ras.getWidth(); x ++){
			
			isBall = false;
			
			//Go vertical through the raster
			for(int y = 0; y < ras.getHeight(); y++){

				int[] dArray = new int[3];
				ras.getPixel(x, y, dArray);
				
				//Check the color of the pixel and when it falls in the defined range add it to the set
				if(dArray[0] == 255 && dArray[1] == 255 && dArray[2] == 255 || dArray[0] > 240 && dArray[1] > 240 && dArray[2] > 240){
					ball.add(new Point(x, y));
					isBall = true;
				}
			}
			//Check if one set of pixels finished
			if(isBall == false && ball.size() > 0){
				allBalls.add(ball);
				ball = new LinkedList<Point>();
			}
		}
		
		//Mark the center of the white pixel set with an blue spot
		//And print out the coordinates
		BufferedImage buf = img.getAsBufferedImage();
		for(LinkedList<Point> currentBall : allBalls){
			Point middlePoint = getCenter(currentBall);
	        Graphics g = buf.createGraphics();
	        
            g.setColor(Color.BLUE);
            g.fillOval(middlePoint.x - 2, middlePoint.y - 2, 4, 4);
            System.out.println("");
            System.out.println("Center coordinates");
            System.out.println("X: " + middlePoint.x);
            System.out.println("Y: " + middlePoint.y);
            
            results.append("Center coordinates\n");
            results.append("X: " + middlePoint.x + "\n");
            results.append("Y: " + middlePoint.y + "\n");
            results.append("\n");
		}
		
		Writer out = null;
        File file = new File("write.txt");
        //WRITE THE MIDDLEPOINTS INTO A TEXT FILE
        try {
			out = new BufferedWriter(new FileWriter(file));
			out.write(results.toString());
	        out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		PlanarImage output = PlanarImage.wrapRenderedImage(buf);
		
		return output;
	}

//Calculates the center of an set of white pixels 
	private Point getCenter(LinkedList<Point> linkedList) {
		
		int minX = Integer.MAX_VALUE;
		int maxX = -1;
		
		int minY = Integer.MAX_VALUE;
		int maxY = -1;
		
		Point currentP;
		//LinkedList<Point> currentList = linkedList;
		
		//FIND THE MAXIMUM AND THE MINIMUM OF THE COORDINATES
		//IN X AND IN Y DIRECTION
		//AND TAKE THE HALF OF THE DISTANCE
		for(int i = 0; i < linkedList.size(); i ++){
			currentP = linkedList.get(i);
			
			if(currentP.x < minX){
				minX = currentP.x;
			}
			if(currentP.x > maxX){
				maxX = currentP.x;
			}
			
			if(currentP.y < minY){
				minY = currentP.y;
			}
			if(currentP.y > maxY){
				maxY = currentP.y;
			}
		}
		
		//PUT THE COORDINATES IN A POINT OBJECT
		int middleOf_X = (minX + maxX) / 2;
		int middleOf_Y = (minY + maxY) / 2;
		
		return new Point(middleOf_X, middleOf_Y);
	}
	
}
