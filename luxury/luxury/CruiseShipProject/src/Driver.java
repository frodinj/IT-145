import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Driver {

    // instance variables (add more as needed)
    private static ArrayList<Ship> shipList = new ArrayList();
    private static ArrayList<Cruise> cruiseList = new ArrayList();
    private static ArrayList<Passenger> passengerList = new ArrayList();


    public static void main(String[] args) {

        initializeShipList();      // initial ships
        initializeCruiseList();     // initial cruises
        initializePassengerList();  // initial passengers
        //printShipList("active");
        //printCruiseList("active");
        /* LEAVING ORIGINAL COMMENTS IN FOR CLAIRTY
         add loop and code here that accepts and validates user input
         and takes the appropriate action. include appropriate
         user feedback and redisplay the menu as needed*/
         // creating scanner to collect inputs
         Scanner scnr = new Scanner(System.in);

         // loop to accept inputs and map to the correct method
        /* displayMenu();
         String userMenuSelection = scnr.next().toUpperCase();
         scnr.nextLine();*/
         boolean validEntry = false;

         // loop to map out the selections
         do {
             displayMenu();
             String userMenuSelection = scnr.next().toUpperCase();
             scnr.nextLine();
             if (userMenuSelection.equals("1")) {
                 addShip();
                 validEntry = true;
                 break;
             }
             else if (userMenuSelection.equals("2")) {
                 editShip();
                 validEntry = true;
                 break;
             }
             else if (userMenuSelection.equals("3")) {
                 addCruise();
                 validEntry = true;
                 break;
             }
             else if (userMenuSelection.equals("4")) {
                 editCruise();
                 validEntry = true;
                 break;
             }
             else if (userMenuSelection.equals("5")) {
                 addPassenger();
                 validEntry = true;
                 break;
             }
             else if (userMenuSelection.equals("6")) {
                 editPassenger();
                 validEntry = true;
                 break;
             }
             else if (userMenuSelection.equalsIgnoreCase("A")) {
                 printShipList("name");
                 validEntry = true;
                 break;
             }
             else if (userMenuSelection.equalsIgnoreCase("B")) {
                 printShipList("active");
                 validEntry = true;
                 break;
             }
             else if (userMenuSelection.equalsIgnoreCase("C")) {
                 printShipList("full");
                 validEntry = true;
                 break;
             }
             else if (userMenuSelection.equalsIgnoreCase("D")) {
                 printCruiseList("list");
                 validEntry = true;
                 break;
             }
             else if (userMenuSelection.equalsIgnoreCase("E")) {
                 printCruiseList("details");
                 validEntry = true;
                 break;
             }
             else if (userMenuSelection.equalsIgnoreCase("F")) {
                 validEntry = true;
                 printPassengerList();
                 break;
             }
             else if (userMenuSelection.equalsIgnoreCase("X")) {
                 break;
             }
             else {
                 System.out.println("Invalid selection. Please try again.");
                 validEntry = false;
             }
         } while (validEntry == false);

    }

    // hardcoded ship data for testing
    // Initialize ship list
    public static void initializeShipList() {
        add("Candy Cane", 20, 40, 10, 60, true);
        add("Peppermint Stick", 10, 20, 5, 40, true);
        add("Bon Bon", 12, 18, 2, 24, false);
        add("Candy Corn", 12, 18, 2, 24, false);
    }

    // hardcoded cruise data for testing
    // Initialize cruise list
    public static void initializeCruiseList() {
        Cruise newCruise = new Cruise("Southern Swirl", "Candy Cane", "Miami", "Cuba", "Miami");
        cruiseList.add(newCruise);
    }

    // hardcoded cruise data for testing
    // Initialize passenger list
    public static void initializePassengerList() {
        Passenger newPassenger1 = new Passenger("Neo Anderson", "Southern Swirl", "STE");
        passengerList.add(newPassenger1);

        Passenger newPassenger2 = new Passenger("Trinity", "Southern Swirl", "STE");
        passengerList.add(newPassenger2);

        Passenger newPassenger3 = new Passenger("Morpheus", "Southern Swirl", "BAL");
        passengerList.add(newPassenger3);
    }

    // custom method to add ships to the shipList ArrayList
    public static void add(String tName, int tBalcony, int tOceanView,
                           int tSuite, int tInterior, boolean tInService) {
        Ship newShip = new Ship(tName, tBalcony, tOceanView, tSuite, tInterior, tInService);
        shipList.add(newShip);
    }


    public static void printShipList(String listType) {
        // printShipList() method prints list of ships from the
        // shipList ArrayList. There are three different outputs
        // based on the listType String parameter:
        // name - prints a list of ship names only
        // active - prints a list of ship names that are "in service"
        // full - prints tabbed data on all ships

        if (shipList.size() < 1) {
            System.out.println("\nThere are no ships to print.");
            return;
        }
        if (listType == "name") {
            System.out.println("\n\nSHIP LIST - Name");
            for (int i = 0; i < shipList.size(); i++) {
                System.out.println(shipList.get(i));
            }
        } else if (listType == "active") {
            // new variable for counting and set to 0 because 
            //we are counting with this variable
            int activeShips = 0;

            System.out.println("\n\nSHIP LIST - Active");
            System.out.println("-------------------------");

            // attempting to iterate through the ship list
            // and output only the active ones
            for (int i = 0; i < shipList.size(); ++i) {
                if (shipList.get(i).getInService()) {
                    System.out.println(shipList.get(i).toString());
                    ++activeShips;
                }
            }
            
            // final option to output with no active ships available
            if (activeShips <= 0) {
                System.out.println("There are no active ships to display, please try a different function.");
            }
            System.out.println("-------------------------");


        } else if (listType == "full") {
            System.out.println("\n\nSHIP LIST - Full");
            System.out.println("----------------------------------------------------------------");
            System.out.println("                    Number of Rooms\t\t\tIn");
            System.out.print("SHIP NAME           Bal\tOV\tSte\tInt\t\tService");
            System.out.println("\n----------------------------------------------------------------");
            for (Ship eachShip: shipList)
                eachShip.printShipData();

        } else
            System.out.println("\n\nError: List type not defined.");
    }

    public static void printCruiseList(String listType) {
        if (cruiseList.size() < 1) {
            System.out.println("\nThere are no cruises to print.");
            return;
        }
        if (listType == "list") {
            System.out.println("\n\nCRUISE LIST");
            for (int i=0; i < cruiseList.size(); i++) {
                System.out.println(cruiseList.get(i));
            }
        // formatted details to adjust line length
        //also adjusted tabbing to keep things neatly in order
        } else if (listType == "details") {
            System.out.println("\n\nCRUISE LIST - Details");
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println("                           |----------------------PORTS-----------------------|");
            System.out.print("CRUISE NAME\tSHIP NAME\tDEPARTURE\tDESTINATION\tRETURN");
            System.out.println("\n------------------------------------------------------------------------------------------");
            for (Cruise eachCruise: cruiseList)
                eachCruise.printCruiseDetails();
        } else
            System.out.println("\n\nError: List type not defined.");
    }

    public static void printPassengerList() {
        if (passengerList.size() < 1) {
            System.out.println("\nThere are no passengers to print.");
            return;
        }
        System.out.println("\n\nPASSENGER LIST");
        System.out.println("-----------------------------------------------------");
        System.out.print("PASSENGER NAME      CRUISE              ROOM TYPE");
        System.out.println("\n-----------------------------------------------------");
        for (Passenger eachPassenger: passengerList)
            eachPassenger.printPassenger();
    }

    // display text-based menu
    public static void displayMenu() {

        System.out.println("\n\n");
        System.out.println("\t\t\tLuxury Ocean Cruise Outings");
        System.out.println("\t\t\t\t\tSystem Menu\n");
        System.out.println("[1] Add Ship            [A] Print Ship Names");
        System.out.println("[2] Edit Ship           [B] Print Ship In Service List");
        System.out.println("[3] Add Cruise          [C] Print Ship Full List");
        System.out.println("[4] Edit Cruise         [D] Print Cruise List");
        System.out.println("[5] Add Passenger       [E] Print Cruise Details");
        System.out.println("[6] Edit Passenger      [F] Print Passenger List");
        System.out.println("[x] Exit System");
        System.out.println("\nEnter a menu selection: ");
    }

    // Add a New Ship
    public static void addShip() {
        // adding needed variables first
        // initialized all variables to get them started
        // adding to shipList arrayList
        String setService;
        Scanner scnr = new Scanner(System.in);
        int i = 0;
        int balconyRoom = 0;
        int oceanViewRoom = 0;
        int suiteRoom = 0;
        int interiorRoom = 0;
        String newShipName = "";

        boolean inService = false;
        boolean validEntry = false;

        do {
            try {
                System.out.println("Enter new ship name: ");
                newShipName = scnr.nextLine();

                // find out if ship name already exists with the following
                // loop
                if (newShipName.equalsIgnoreCase(shipList.get(i).getShipName())) {
                    throw new Exception("Invalid ship name. Each ship must have a unique name.");
                }
                if (newShipName.isEmpty() || newShipName.isBlank()){
                    throw new Exception("No name entered, please enter a valid ship name.");
                }
                else {
                    validEntry = true;
                }
            }
            catch (Exception excpt) {
            System.out.println("Exceptoin found. " + excpt.getMessage());
            }
        } while (validEntry == false);

        // references to a new method to determine whether room
        // amounts are valid and confirming them with the main program
        balconyRoom = roomValidation(scnr, "balcony");
        oceanViewRoom = roomValidation(scnr, "ocean-view");
        suiteRoom = roomValidation(scnr, "suite");
        interiorRoom = roomValidation(scnr, "interior");

        // obtaining all necessary ship aspects (room counts and inService)
        // checkig to make sure they are valid
        validEntry = false;
        do {
            try {
                System.out.println("Is this ship ready to be put into service? (Y/N): ");
                setService = scnr.nextLine();
                // exception to handle invalid input
                if (!setService.equalsIgnoreCase("Y") && !setService.equalsIgnoreCase("N")) {
                    throw new Exception("Invalid entry. Please enter 'Y' or 'N'.");
                }
                else if (setService.equalsIgnoreCase("N")) {
                    inService = false;
                    validEntry = true;
                }
                else if (setService.equalsIgnoreCase("Y")) {
                    inService = true;
                    validEntry = true;
                }
            }
            catch (Exception excpt) {
                System.out.println("Error. " + excpt.getMessage());
            }

        } while (validEntry == false);

        // adding ship with the class variables (strings and integers included below)
        
        add(newShipName, balconyRoom, oceanViewRoom, suiteRoom, interiorRoom, inService);

        return;

    }
    // new method for validating room numbers
    // I made this method because it would be very redundant to code
    // all of this process for each type of room. I thought this would
    // be simpler to follow.
    // SOURCE: Stackoverflow.com general advice used for both this and
    // routeValidation methods.
    public static int roomValidation(Scanner scnr, String roomClass) {
        // variables for use in this method
        boolean validEntry = false;
        int roomCount = 0;
        String roomsAsString; // string needed to parse

        // obtain input on rooms
        // used a try loop in case they type in something like "forty"
        // instead of entering a number
        do {
            try {
                System.out.println("Enter the number of " + roomClass + " rooms.");
                roomsAsString = scnr.nextLine();
                roomCount = Integer.parseInt(roomsAsString);
                // lastly, ensure no negative numbers
                if (roomCount < 0) {
                    throw new Exception("Negative number is not permitted. Enter 0 if there are no rooms of this type.");
                }
                else {
                    validEntry = true;
                }
            }
            catch (Exception excpt) {
                System.out.println("Invalid value entered. " + excpt.getMessage());
            }
        } while (validEntry == false);

        return roomCount;
    }

    // Edit an existing ship
    public static void editShip() {

        // This method does not need to be completed
        System.out.println("The \"Edit Ship\" feature is not yet implemented.");

    }

    // Add a New Cruise
    public static void addCruise() {
        // method variables declared here and initialized to make sure
        // that they will run properly when the program runs.
        // booleans initialized to false to control the loops that will be needed.
        String cruiseName = "";
        Scanner scnr = new Scanner(System.in);
        String cruiseShipName = "";
        String departurePort = "";
        String destination = "";
        String returnPort = "";
        boolean validEntry = false;
        int validShipCount = 0;
        boolean shipInService = false;
        boolean shipHasCruise = false;

        // the first do-while loop checks validity of the cruise name
        // exceptions are handled if invalid entry or entry is the name
        // of another cruise already.
        do {
            try {
                System.out.println("Please enter the cruise name: ");
                cruiseName = scnr.nextLine();
                // here the loop in cruiseList is started
                for (int i = 0; i < cruiseList.size(); ++i) {
                    if (cruiseName.equalsIgnoreCase(cruiseList.get(i).getCruiseName())) {
                        throw new Exception("Cruise name already exists. Please enter a unique name.");
                    }
                    if (cruiseName.isEmpty() || cruiseName.isBlank()) {
                        throw new Exception("No name entered.");
                    }
                }
                validEntry = true;
            }
                catch (Exception excpt) {
                    System.out.println("Error encountered: " + excpt.getMessage());
                }
        } while (validEntry == false);

        // running through a method listed below to confirm valid ports
        // method used here for same reason as the room numbers
        // which is to avoid redundancy
        departurePort = routeValidation(scnr, "departure port");
        destination = routeValidation(scnr, "cruise destination");
        returnPort = routeValidation(scnr, "return port");

        // validation of ships name and whether it is in service or not
        // handles exceptions if encountered
        validEntry = false;         // resetting validEntry boolean for loop
        do {
            try {
                // variables are already initialized above
                cruiseShipName = routeValidation(scnr, "cruise ship name");
                for (int i = 0; i < shipList.size(); ++i) {
                    if (cruiseShipName.equalsIgnoreCase(shipList.get(i).getShipName())) {
                        validShipCount++;
                        // if a match then service status is confirmed
                        if (shipList.get(i).getInService()) {
                            shipInService = true;
                        }
                        shipHasCruise = hasCruise(cruiseShipName);
                    }
                }
                if (validShipCount == 0) {
                    throw new Exception("Invalid name. Please try again.");
                }
                if (shipInService == false) {
                    throw new Exception("Ship is not in service. Please try again.");
                }
                if (shipHasCruise) {
                    throw new Exception("Ship is already assigned to a cruise. Please try again.");
                }
                validEntry = true;
            }
                catch (Exception excpt) {
                    System.out.println("Error encountered: " + excpt.getMessage());
                }
        } while (validEntry == false);

        // finally, adding the cruise to the ArrayList for cruiseList.
        // includes all necessary class variables
        Cruise newCruise = new Cruise(cruiseName, cruiseShipName, departurePort, destination, returnPort);
        cruiseList.add(newCruise);

        return;
    }
    // quick method to determine whether a ship is already in a cruise
    public static boolean hasCruise(String shipName) {
        boolean shipHasCruise = false;
        for (int i = 0; i < cruiseList.size(); ++i) {
            if (shipName.equalsIgnoreCase(cruiseList.get(i).getCruiseShipName())) {
                shipHasCruise = true;
            }
        }
        return shipHasCruise;
    }

    public static String routeValidation(Scanner scnr, String fieldName) {
        // variables for the method
        boolean validEntry = false; // initialized to false for loop below
        String routeInput = "";

        // do while loop for checking for empty values
        do {
            try {
                System.out.println("Enter " + fieldName + ": ");
                routeInput = scnr.nextLine();
                // exceptions for blank entries
                if (routeInput.isEmpty() || routeInput.isBlank()) {
                    throw new Exception ("Please enter a valid " + fieldName + ".");
                }
                validEntry = true;
            }
            catch (Exception excpt) {
                System.out.println("Error: " + excpt.getMessage());
            }
        } while (validEntry == false);
        return routeInput;
    }

    // Edit an existing cruise
    public static void editCruise() {

        // This method does not need to be completed
        System.out.println("The \"Edit Cruise\" feature is not yet implemented.");

    }

    // Add a New Passenger
    public static void addPassenger() {

        Scanner newPassengerInput = new Scanner(System.in);
        System.out.println("Enter the new passenger's name: ");
        String newPassengerName = newPassengerInput.nextLine();

        // ensure new passenger name does not already exist
        for (Passenger eachPassenger: passengerList) {
            if (eachPassenger.getPassengerName().equalsIgnoreCase(newPassengerName)) {
                System.out.println("That passenger is already in the system. Exiting to menu...");
                return; // quits addPassenger() method processing
            }
        }

        // get cruise name for passenger
        System.out.println("Enter cruise name: ");
        String newCruiseName = newPassengerInput.nextLine();

        // ensure cruise exists
        for (Cruise eachCruise: cruiseList) {
            if (eachCruise.getCruiseName().equalsIgnoreCase(newCruiseName)) {
                // cruise does exist
            } else {
                System.out.println("That cruise does not exist in the system. Exiting to menu...");
                return; // quits addPassenger() method processing
            }
        }

        // get room type
        System.out.println("Enter Room Type (BAL, OV, STE, or INT: ");
        String room = newPassengerInput.nextLine();
        // validate room type
        if ((room.equalsIgnoreCase("BAL")) || (room.equalsIgnoreCase("OV")) ||
                (room.equalsIgnoreCase("STE")) || (room.equalsIgnoreCase("INT"))) {
            // validation passed - add passenger
            Passenger newPassenger = new Passenger(newPassengerName, newCruiseName, room.toUpperCase());
            passengerList.add(newPassenger);
        } else {
            System.out.println("Invalid input. Exiting to menu...");
            return; // quits addPassenger() method processing
        }
    }

    // Edit an existing passenger
    public static void editPassenger() {

        // This method does not need to be completed
        System.out.println("The \"Edit Passenger\" feature is not yet implemented.");

    }

    // Method to check if input is a number
    public static boolean isANumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i)) == false)
                return false;
        }
        return true;
    }

}
