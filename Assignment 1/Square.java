package FirstAssignment;

import java.util.ArrayList;

public class Square extends Polygon {
    
    public Square(double x, double y, double length) {
        super(x, y, length);
    }
    
    @Override
    public ArrayList<Point> getCoordinates() {
        
       // if (this.getLength() <= 0) return null;
        
        ArrayList<Point> result = new ArrayList<Point>();
        
        result.add(new Point(this.getCenter().getX() + this.getLength()/2, this.getCenter().getY() - this.getLength()/2));
        result.add(new Point(this.getCenter().getX() - this.getLength()/2, this.getCenter().getY() - this.getLength()/2));
        result.add(new Point(this.getCenter().getX() + this.getLength()/2, this.getCenter().getY() + this.getLength()/2));
        result.add(new Point(this.getCenter().getX() - this.getLength()/2, this.getCenter().getY() + this.getLength()/2));

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
