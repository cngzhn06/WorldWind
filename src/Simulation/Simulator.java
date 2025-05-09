package Simulation;

import Map.PathObject;
import Model.Kinematic;
import gov.nasa.worldwind.geom.Position;

import java.util.Timer;
import java.util.TimerTask;

public class Simulator {
    private Kinematic kinematic;
    private PathObject pathObject;
    private int currentIndex = 0;

    public Simulator(Kinematic kinematic, PathObject pathObject) {
        this.kinematic = kinematic;
        this.pathObject = pathObject;
        System.out.println(kinematic.getSpeed());
        System.out.println();
    }



    public void startSimulation() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (currentIndex < pathObject.getPathPoints().size()) {
                    Position nextPosition = pathObject.getPathPoints().get(currentIndex);
                    kinematic.updatePosition(nextPosition.latitude.degrees, nextPosition.longitude.degrees, nextPosition.elevation);
                    currentIndex++;
                } else {
                    timer.cancel();
                }
            }
        }, 0, 1000);
    }

    private double calculateDistance(Position p1, Position p2) {
        double latDiff = p2.latitude.degrees - p1.latitude.degrees;
        double lonDiff = p2.longitude.degrees - p1.longitude.degrees;
        return Math.sqrt(latDiff * latDiff + lonDiff * lonDiff);
    }


}
