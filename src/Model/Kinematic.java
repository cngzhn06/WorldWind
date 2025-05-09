package Model;

import gov.nasa.worldwind.render.*;
import gov.nasa.worldwind.geom.Position;
import gov.nasa.worldwind.WorldWind;

import java.awt.*;

public class Kinematic {
    private int id;
    private double lat, lon, alt,speed;
    private String name;

    private PointPlacemark placemark;

    public Kinematic(int id, double lat, double lon, double alt, String name, double speed) {
        this.id = id;
        this.lat = lat;
        this.lon = lon;
        this.alt = alt;
        this.name = name;
        this.speed = speed;

        this.placemark = new PointPlacemark(Position.fromDegrees(lat, lon, alt));
        this.placemark.setLabelText(name);
        this.placemark.setAltitudeMode(WorldWind.ABSOLUTE);

        PointPlacemarkAttributes attrs = new PointPlacemarkAttributes();
        attrs.setImageAddress("src/ship.png");
        attrs.setScale(0.03);

        this.placemark.setAttributes(attrs);
    }

    public void updatePosition(double lat, double lon, double alt) {
        this.lat = lat;
        this.lon = lon;
        this.alt = alt;
        this.placemark.setPosition(Position.fromDegrees(lat, lon, alt));
    }


    public PointPlacemark getPlacemark() {
        return placemark;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public double getAlt() {
        return alt;
    }

    public double getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }
}
