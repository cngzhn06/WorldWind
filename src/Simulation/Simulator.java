package Simulation;

import Model.Kinematic;
import Map.PathObject;
import gov.nasa.worldwind.geom.Position;

public class Simulator {
    private Kinematic kinematic;
    private PathObject pathObject;

    public Simulator(Kinematic kinematic, PathObject pathObject) {
        this.kinematic = kinematic;
        this.pathObject = pathObject;
    }

}
