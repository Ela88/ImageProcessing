/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lot.bv;

import com.sun.media.jai.widget.DisplayJAI;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Rectangle;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.ParameterBlock;
import javax.media.jai.JAI;
import javax.media.jai.KernelJAI;
import javax.media.jai.PlanarImage;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

/**
 *
 * @author Raphaela
 */
public class LoadChangedPic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        PlanarImage image = JAI.create("fileload", "C:\\WebSpace\\School\\SA\\SA2\\loetstellen.jpg");
        Rectangle rectangle = new Rectangle(10, 20, 448, 180);
        
        // Get some information about the image
        String imageInfo = "Dimensions: " + image.getWidth() + "x" + image.getHeight() + " Bands:" + image.getNumBands();
        
        image = PlanarImage.wrapRenderedImage((RenderedImage)image.getAsBufferedImage(rectangle, image.getColorModel()));

        // Create a frame for display.
        JFrame frame = new JFrame();
        frame.setTitle("DisplayJAI: loetstellen.jpg");

        // Get the JFrame - ContentPane.
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());

// Create an instance of DisplayJAI.
        DisplayJAI dj = new DisplayJAI(image);


// Add to the JFrame� ContentPane an instance of JScrollPane
// containing the DisplayJAI instance.
        contentPane.add(new JScrollPane(dj), BorderLayout.CENTER);

// Add a text label with the image information.
        contentPane.add(new JLabel(imageInfo), BorderLayout.SOUTH);

// Set the closing operation so the application is finished.   
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200); // adjust the frame size.
        frame.setVisible(true); // show the frame.
        JAI.create("filestore", image, "bild.jpg", "JPEG");
    }
}
