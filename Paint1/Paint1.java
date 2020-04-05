import java.util.InputMismatchException;
import java.util.Scanner;

public class Paint1 {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        double wallHeight = 0.0;
        double wallWidth = 0.0;
        double wallArea = 0.0;
        double gallonsPaintNeeded = 0.0;
        String heightString;
        String widthString;
        
        final double squareFeetPerGallons = 350.0;
        
        // Implement a do-while loop to ensure input is valid
        // Prompt user to input wall's height
        //fixed loop to handle all inputs in height and width
        do {
            try {
                System.out.println("Enter wall height (feet): ");
                // obtaining string instead of double for testing
                heightString = scnr.nextLine();
                // creating exception for conversion failure if applicable
                wallHeight = Double.parseDouble(heightString);

                if (wallHeight <= 0) {
                    throw new Exception("Invalid height.");
                }
            }
            catch (Exception excpt) {
                System.out.println("Error encountered: " + excpt.getMessage());
            }

        } while (wallHeight <= 0);

        // fixed height loop and duplicated for width
        do {
            try {
                System.out.println("Enter wall width (feet): ");
                // obtaining string instead of double for testing
                widthString = scnr.nextLine();
                // creating exception for conversion failure if applicable
                wallWidth = Double.parseDouble(widthString);

                if (wallWidth <= 0) {
                    throw new Exception("Invalid width.");
                }
            }
            catch (Exception excpt) {
                System.out.println("Error encountered: " + excpt.getMessage());
            }

        } while (wallWidth <= 0);

        // Calculate and output wall area
        wallArea = wallHeight * wallWidth;
        System.out.println("Wall area:  " + wallArea + " square feet");

        // Calculate and output the amount of paint (in gallons) needed to paint the wall
        gallonsPaintNeeded = wallArea / squareFeetPerGallons;
        System.out.println("Paint needed: " + gallonsPaintNeeded + " gallons");
    }
}
