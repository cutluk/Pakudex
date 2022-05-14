
import java.util.Scanner;

public class PakuriProgram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //prints out welcome message
        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!");
        int capacity;

        //try catch funciton that asks for max capacity of the pakudex and makes sure a valid input is given
        while (true) {
            try{
                System.out.print("Enter max capacity of the Pakudex: ");
                capacity = input.nextInt();
                if (capacity > 0) {
                    System.out.println("The Pakudex can hold " + capacity + " species of Pakuri.");
                    break;
                }
                else {
                    System.out.println("Please enter a valid size.");
                }
            }catch(Exception e){
                System.out.println("Please enter a valid size.");
                input.next();
            }
        }

        Pakudex pakudex = new Pakudex(capacity);

        //Main menu is printed and prompts user for input
        while (true) {
            System.out.println("\n" + "Pakudex Main Menu");
            System.out.println("-----------------");
            System.out.println("1. List Pakuri");
            System.out.println("2. Show Pakuri");
            System.out.println("3. Add Pakuri");
            System.out.println("4. Evolve Pakuri");
            System.out.println("5. Sort Pakuri");
            System.out.println("6. Exit");
            System.out.println("\n" + "What would you like to do?");

            //Whole switch is put in try catch to make sure user only puts in valid inputs
            try {
                int menu = input.nextInt();

                if (menu <= 6 && menu >= 1) {
                    switch (menu) {
                        //Lists the pakudex stored in Species Array
                        //If none exist tells user no pakuri exist
                        case 1:
                            String[] speciesArray = pakudex.getSpeciesArray();
                            if (speciesArray == null) {
                                System.out.println("No Pakuri in Pakudex yet!");
                            } else {
                                System.out.println("Pakuri In Pakudex:");
                                int count = 1;
                                for (int i = 0; i < speciesArray.length; i++) {
                                    System.out.println(count++ + ". " + speciesArray[i]);
                                }
                            }
                            break;
                        // Prompts user to enter name of the species they want to see
                        //if none exist, code outputs error message
                        // if one does exist, code prints out the pakuri's stats
                        case 2:
                            System.out.print("Enter the name of the species to display: ");
                            String showPakuri = input.next();
                            int[] getStats = pakudex.getStats(showPakuri);
                            if (getStats == null) {
                                System.out.println("Error: No such Pakuri!");
                            } else {
                                System.out.println("Species: " + showPakuri);
                                System.out.println("Attack: " + getStats[0]);
                                System.out.println("Defense: " + getStats[1]);
                                System.out.println("Speed: " + getStats[2]);
                            }
                            break;
                        // Add function to add Pakuri to the Pakudex
                        // If pakudex is already full, outputs error
                        // Other adds users pakuri granted it doesn't already exist
                        case 3:
                            if (pakudex.getSize()==pakudex.getCapacity()){
                                System.out.println("Error: Pakudex is full!");
                            }
                            else {
                                System.out.print("Enter the name of the species to add: ");
                                String newPakuri = input.next();
                                boolean addPakuri = pakudex.addPakuri(newPakuri);

                                if (addPakuri == true) {
                                    System.out.println("Pakuri species " + newPakuri + " successfully added!");
                                } else if (addPakuri == false) {
                                    System.out.println("Error: Pakudex already contains this species!");
                                }
                            }
                            break;
                        // Prompts user to input the name of the species they would like to evolve
                        // If the Pakuri exists, it evolves the pakuri and tells the user such
                        // If the pakuri doesn't exist, it outputs an error message
                        case 4:
                            System.out.print("Enter the name of the species to evolve: ");
                            String name = input.next();
                            boolean evolved = pakudex.evolveSpecies(name);
                            if (evolved == true) {
                                System.out.println(name + " has evolved!");
                            } else {
                                System.out.println("Error: No such Pakuri!");
                            }
                            break;
                        // Sorts the Pakuri into lexicographical order using sortPakuri
                        // Outputs a confirmation message letting the user know the process was successful
                        case 5:
                            pakudex.sortPakuri();
                            System.out.println("Pakuri have been sorted!");
                            break;
                        // Ends the program and thanks user for using the program
                        case 6:
                            System.out.println("Thanks for using Pakudex! Bye!");
                            return;
                    }
                // these check for invalid integer and string inputs
                } else {
                    System.out.println("Unrecognized menu selection!");
                }
            }catch(Exception e){
                System.out.println("Unrecognized menu selection!");
                input.next();
            }
        }
    }
}
