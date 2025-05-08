package Controller;

import gov.nasa.worldwind.awt.WorldWindowGLCanvas;
import gov.nasa.worldwind.layers.RenderableLayer;
import Map.PathObject;
import Model.Kinematic;
import Simulation.Simulator;
import gov.nasa.worldwind.geom.Position;

import java.util.ArrayList;
import java.util.List;

public class WorldWindController {

    public static List<Position> generateDetailedPath() {
        List<Position> sPosition = List.of(
                Position.fromDegrees(39.9, 32.8, 5000), // ank
                Position.fromDegrees(41.0, 29.0, 5000),
                Position.fromDegrees(38.4, 27.1, 5000),
                Position.fromDegrees(37.5, 30.5, 5000)  // ant
        );

        List<Position> detailedPath = new ArrayList<>();

        System.out.println(sPosition.size());
        for (int i = 0; i < sPosition.size() - 1; i++) {
            Position start = sPosition.get(i);
            Position end = sPosition.get(i + 1);

            for (int j = 0; j <= 20; j++) {
                double fraction = (double) j / 20;
                double lat = start.latitude.degrees + fraction * (end.latitude.degrees - start.latitude.degrees);
                double lon = start.longitude.degrees + fraction * (end.longitude.degrees - start.longitude.degrees);
                detailedPath.add(Position.fromDegrees(lat, lon, 5000));
            }
        }

        return detailedPath;
    }

    public WorldWindController(WorldWindowGLCanvas canvas) {
        RenderableLayer layer = new RenderableLayer();
        List<Position> flightPath = generateDetailedPath();

        Kinematic kinematic = new Kinematic(1, flightPath.get(0).latitude.degrees, flightPath.get(0).longitude.degrees, 5000, "ceng");
        PathObject pathObject = new PathObject(flightPath);

        pathObject.addToLayer(layer);
        layer.addRenderable(kinematic.getPlacemark());

        canvas.getModel().getLayers().add(layer);


    }
}
