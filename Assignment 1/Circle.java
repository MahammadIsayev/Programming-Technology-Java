package FirstAssignment;

import java.util.ArrayList;

public class Circle extends Polygon {
    
    public Circle(double x, double y, double length) {
        super(x, y, length);
    }
    
    @Override
    public ArrayList<Point> getCoordinates() {
        
        ArrayList<Point> result = new ArrayList<Point>();
        
        result.add(new Point(this.getCenter().getX() + this.getLength(), this.getCenter().getY()));
        result.add(new Point(this.getCenter().getX() - this.getLength(), this.getCenter().getY()));
        result.add(new Point(this.getCenter().getX(), this.getCenter().getY() + this.getLength()));
        result.add(new Point(this.getCenter().getX(), this.getCenter().getY() - this.getLength()));
        
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
