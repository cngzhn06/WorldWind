package Map;

import gov.nasa.worldwind.WorldWind;
import gov.nasa.worldwind.avlist.AVKey;
import gov.nasa.worldwind.geom.Position;
import gov.nasa.worldwind.layers.RenderableLayer;
import gov.nasa.worldwind.render.BasicShapeAttributes;
import gov.nasa.worldwind.render.Material;
import gov.nasa.worldwind.render.Path;
import gov.nasa.worldwind.render.ShapeAttributes;

import java.util.List;

public class PathObject {
    private List<Position> pathPoints;

    public PathObject(List<Position> pathPoints) {
        this.pathPoints = pathPoints;
    }

    public List<Position> getPathPoints() {
        return pathPoints;
    }

    public void addToLayer(RenderableLayer layer) {
        ShapeAttributes attributes = new BasicShapeAttributes();
        attributes.setOutlineMaterial(Material.CYAN);
        attributes.setOutlineWidth(2);

        Path path = new Path(pathPoints);
        path.setAttributes(attributes);
        path.setAltitudeMode(WorldWind.ABSOLUTE);
        path.setPathType(AVKey.GREAT_CIRCLE);

        layer.addRenderable(path);
    }
}
