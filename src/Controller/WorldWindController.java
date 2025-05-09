package Controller;

import gov.nasa.worldwind.awt.WorldWindowGLCanvas;
import gov.nasa.worldwind.layers.MarkerLayer;
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
                Position.fromDegrees(45, 36.5, 0),
                Position.fromDegrees(44.4, 34.4, 0),
                Position.fromDegrees(41.222474375923255, 29.13295017032769, 0),
                Position.fromDegrees(41.16548927118333, 29.067048257770235, 0),
                Position.fromDegrees(41.13951064558663, 29.067825244254003, 0),
                Position.fromDegrees(41.121150333760724, 29.07966987897106, 0),
                Position.fromDegrees(41.10110328292507, 29.059070513986963, 0),
                Position.fromDegrees(41.077685754147645, 29.057525561590158, 0),
                Position.fromDegrees(41.04699893758007, 29.037041479021756, 0),
                Position.fromDegrees(41.03806881401087, 29.016627386441858, 0),
                Position.fromDegrees(41.013427707978984, 28.993355319947298, 0),
                Position.fromDegrees(40.966738351503146, 28.994988446768502, 0)
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
                detailedPath.add(Position.fromDegrees(lat, lon, 0));
            }
        }

        return detailedPath;
    }

    public WorldWindController(WorldWindowGLCanvas canvas) {
        RenderableLayer layer = new RenderableLayer();
        List<Position> flightPath = generateDetailedPath();

        Kinematic kinematic = new Kinematic(1, flightPath.get(0).latitude.degrees, flightPath.get(0).longitude.degrees, 5000, "ceng",50);
        PathObject pathObject = new PathObject(flightPath);

        pathObject.addToLayer(layer);
        layer.addRenderable(kinematic.getPlacemark());

        Simulator simulator = new Simulator(kinematic, pathObject);
        simulator.startSimulation();


        canvas.getModel().getLayers().add(layer);


    }
}
