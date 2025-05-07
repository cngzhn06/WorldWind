package Frame;

import gov.nasa.worldwind.BasicModel;
import gov.nasa.worldwind.awt.WorldWindowGLCanvas;

import javax.swing.*;

public class StartFrame extends JFrame {

    public StartFrame(){


        WorldWindowGLCanvas worldWindCanvas = new WorldWindowGLCanvas();
        worldWindCanvas.setModel(new BasicModel());
        setTitle("World Wind");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        add(worldWindCanvas);
        setVisible(true);


    }

}
