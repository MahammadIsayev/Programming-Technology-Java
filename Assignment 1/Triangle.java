package FirstAssignment;

import java.util.ArrayList;

public class Triangle extends Polygon {
    
    public Triangle (double x, double y, double length) {
        super(x, y, length);
    }
    
    @Override
    public ArrayList<Point> getCoordinates() {
        
        //if (this.getLength() <= 0) return null;
        
        ArrayList<Point> result = new ArrayList<Point>();
        
        double height = ( Math.sqrt( this.getLength() * this.getLength() - (this.getLength()/2) * (this.getLength()/2) ) )/2.0;
        
        result.add(new Point(this.getCenter().getX() + this.getLength()/2, this.getCenter().getY() - height));
        result.add(new Point(this.getCenter().getX() - this.getLength()/2, this.getCenter().getY() - height));
        result.add(new Point(this.getCenter().getX(),  this.getCenter().getY() + height));
        
        return result;
    }
    
    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.getCoordinates().size(); i++) {
            sb.append(this.getCoordinates().get(i).toString() + "\n");
        }
        return sb.toString();
    }
    
}
