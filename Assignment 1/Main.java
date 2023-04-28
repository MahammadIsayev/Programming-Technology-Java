package FirstAssignment;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        
        FileHandling fileData = new FileHandling();
        
        try {
            fileData.populating("invalid.txt"); 
        } catch (FileNotFoundException ex) {
            System.out.println("File not found!");
            System.exit(-1);
        } catch (InvalidInputException ex) {
            System.out.println("Invalid input!");
            System.exit(-1);
        }
        System.out.print(fileData.findBox());
    }
}
    
