package Model;

import gov.nasa.worldwind.render.*;
import gov.nasa.worldwind.geom.Position;
import gov.nasa.worldwind.WorldWind;

import java.awt.*;

public class Kinematic {
    private int id;
    private double lat, lon, alt;
    private String name;
    private PointPlacemark placemark;

    public Kinematic(int id, double lat, double lon, double alt, String name) {
        this.id = id;
        this.lat = lat;
        this.lon = lon;
        this.alt = alt;
        this.name = name;

        this.placemark = new PointPlacemark(Position.fromDegrees(lat, lon, alt));
        this.placemark.setLabelText(name);
        this.placemark.setAltitudeMode(WorldWind.ABSOLUTE);

        PointPlacemarkAttributes attrs = new PointPlacemarkAttributes();
        attrs.setImageAddress("src/shipIcon.png");
        attrs.setScale(0.03);

        this.placemark.setAttributes(attrs);
    }

    public PointPlacemark getPlacemark() {
        return placemark;
    }
}
