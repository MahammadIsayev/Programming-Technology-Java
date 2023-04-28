package FirstAssignment;

import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandling {
    
    private final ArrayList<Polygon> shapes;

    public FileHandling() {
        this.shapes = new ArrayList<>();
    }

    public ArrayList<Polygon> getShapes() {
        return shapes;
    }
    
    public void populating(String fname) throws FileNotFoundException, InvalidInputException {
        
        try (Scanner scanner = new Scanner(new FileReader(new File(fname)))) {
            
            while (scanner.hasNext()) {
                
                String[] vals = scanner.nextLine().split(" ");
                
                try {
                    switch(vals[0]) {
                        case "C": this.shapes.add(new Circle(Double.parseDouble(vals[1]), Double.parseDouble(vals[2]), Double.parseDouble(vals[3])));
                                  break;
                        case "S": this.shapes.add(new Square(Double.parseDouble(vals[1]), Double.parseDouble(vals[2]), Double.parseDouble(vals[3])));
                                  break;
                        case "T": this.shapes.add(new Triangle(Double.parseDouble(vals[1]), Double.parseDouble(vals[2]), Double.parseDouble(vals[3])));
                                  break;
                        case "H": this.shapes.add(new Hexagon(Double.parseDouble(vals[1]), Double.parseDouble(vals[2]), Double.parseDouble(vals[3])));
                                  break;
                        default:  throw new InvalidInputException("Oops! Not a regular shape!");
                                 
                    }
                } catch (InvalidInputException e) { System.out.println("The given figure can only be a regular triangle, hexagon, square or circle"); } //Length (radius) cannot be negative or 0!
          }
        } catch (FileNotFoundException e) {
            System.out.println("No file found!");
            System.exit(-1);
        }
    }
    
    public String findBox() {
        
        if(this.shapes.isEmpty()) return "Empty file!";
        ArrayList<Point> allCoordinates = new ArrayList<>();
    
        for(Polygon p: this.shapes) {
            allCoordinates.addAll(p.getCoordinates());
        }
        
        ArrayList<Point> boxCoordinates = new ArrayList<>();
        
        double maxX =  allCoordinates.get(0).getX();
        double minX =  allCoordinates.get(0).getX();
        double maxY =  allCoordinates.get(0).getY();
        double minY =  allCoordinates.get(0).getY();
            
        for(int i = 0; i < allCoordinates.size(); i++) {
            
            if(allCoordinates.get(i).getX() >= maxX) {
                maxX = allCoordinates.get(i).getX();
            }
            if(allCoordinates.get(i).getX() < minX) {
                minX = allCoordinates.get(i).getX();
            }
            if(allCoordinates.get(i).getY() >= maxY) {
                maxY = allCoordinates.get(i).getY();
            }
            if(allCoordinates.get(i).getY() < minY) {
                minY = allCoordinates.get(i).getY();
            }
        }
        
        boxCoordinates.add(new Point(minX,minY));
        boxCoordinates.add(new Point(minX,maxY));
        boxCoordinates.add(new Point(maxX,maxY));
        boxCoordinates.add(new Point(maxX,minY));
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < boxCoordinates.size(); i++) {
            sb.append(boxCoordinates.get(i).toString() + ",");
        }
        
        return sb.toString();
    }    
}
