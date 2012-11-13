/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lot.bv;

import java.awt.image.RenderedImage;
import java.awt.image.renderable.ParameterBlock;
import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;

/**
 *
 * @author Raphaela
 */
public class TheresholdOperator {

    public static PlanarImage thresholdLoetstellen(PlanarImage image, double a, double b, double c, int bnd) {
        // Set up the operation parameters
        PlanarImage src = image;
        double[] low, high, map;
        int bands = bnd;

        low = new double[bands];
        high = new double[bands];
        map = new double[bands];

        for (int i = 0; i < bands; i++) {
            low[i] = a;
            high[i] = b;
            map[i] = c;
        }

        //Create the threshold operation.
        ParameterBlock pb = new ParameterBlock();
        pb.addSource(src);
        pb.add(low);
        pb.add(high);
        pb.add(map);
        RenderedImage dst = JAI.create("threshold", pb);
        PlanarImage finalImg = (PlanarImage) dst;
        JAI.create("filestore", finalImg, "loetstellen_roi_threshold.jpg", "JPEG");
        return finalImg;

    }
}
