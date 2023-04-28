package FirstAssignment;


import java.util.ArrayList;

public abstract class Polygon {

    private Point center;
    private double length;

    public Polygon(double x, double y, double length) {
        if(length <= 0) { throw new IllegalArgumentException("Radius can't be negative or zero"); } 
        this.center = new Point(x,y);
        this.length = length;
    }

    public Point getCenter() {
        return center;
    }

    public double getLength() {
        return length;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public void setLength(double length) {
        this.length = length;
    }
    
    public abstract ArrayList<Point> getCoordinates();

}
