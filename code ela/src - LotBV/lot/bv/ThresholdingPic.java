/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lot.bv;

import java.awt.Rectangle;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.ParameterBlock;
import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;

/**
 *
 * @author Raphaela
 */
public class ThresholdingPic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PlanarImage src, dst;
        
        PlanarImage image = JAI.create("fileload", "C:\\WebSpace\\School\\SA\\SA2\\loetstellen.jpg");
        Rectangle rectangle = new Rectangle(10, 20, 448, 180);
        
        // Get some information about the image
        String imageInfo = "Dimensions: " + image.getWidth() + "x" + image.getHeight() + " Bands:" + image.getNumBands();
        
        image = PlanarImage.wrapRenderedImage((RenderedImage)image.getAsBufferedImage(rectangle, image.getColorModel()));

        
        Integer[] low, high, map;
        int bands = image.getNumBands();

        low = new Integer[bands];
        high = new Integer[bands];
        map = new Integer[bands];

        for (int i = 0; i < bands; i++) {
            low[i] = new Integer(args[1]);
            high[i] = new Integer(args[2]);
            map[i] = new Integer(args[3]);
        }

        // Create the threshold operation.
        ParameterBlock pb = new ParameterBlock();
        pb.addSource("C:\\WebSpace\\School\\SA\\SA2\\loetstellen.jpg");
        pb.add(low);
        pb.add(high);
        pb.add(map);
        dst = JAI.create("fileload", pb);
    }
}
