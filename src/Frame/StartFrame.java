package Frame;

import Controller.WorldWindController;
import gov.nasa.worldwind.BasicModel;
import gov.nasa.worldwind.awt.WorldWindowGLCanvas;
import javax.swing.*;

public class StartFrame extends JFrame {
    public StartFrame() {
        WorldWindowGLCanvas worldWindCanvas = new WorldWindowGLCanvas();
        worldWindCanvas.setModel(new BasicModel());

        new WorldWindController(worldWindCanvas);

        setTitle("wwinddddddddd");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 800);
        add(worldWindCanvas);
        setVisible(true);
    }
}