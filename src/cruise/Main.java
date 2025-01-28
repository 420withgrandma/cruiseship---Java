package cruise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<CruiseShip> cruiseShips = new ArrayList<>();

    public static void main(String[] args) {
        preloadData();
        showMenu();
    }

    private static void preloadData() {
        CruiseShip ship1 = new CruiseShip("Mediterranean Star", 100);
        ship1.addCabin(new Cabin(101, "Suite", true));
        ship1.addCabin(new Cabin(102, "Standard", false));
        ship1.addExcursion(new Excursion("Rome", "Monday", 30));
        ship1.addPassenger(new Passenger("Alice Brown", 101));
        ship1.addPassenger(new Passenger("John Smith", 102));
        cruiseShips.add(ship1);

        CruiseShip ship2 = new CruiseShip("Ocean Explorer", 120);
        ship2.addCabin(new Cabin(201, "Suite", false));
        ship2.addCabin(new Cabin(202, "Standard", true));
        ship2.addExcursion(new Excursion("Barcelona", "Wednesday", 25));
        ship2.addPassenger(new Passenger("Mary Johnson", 201));
        cruiseShips.add(ship2);
    }
    //In this section some preloaded data is set to fill in the tables
    private static void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Cruise Ship Administration System");
            System.out.println("1. Display Cruise Information");
            System.out.println("2. Display Excursion Information");
            System.out.println("3. Display Passenger Information");
            System.out.println("4. Book Excursion");
            System.out.println("5. Change Passenger Cabin");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayCruiseInformation(scanner);
                    break;
                case 2:
                    displayExcursionInformation(scanner);
                    break;
                case 3:
                    displayPassengerInformation(scanner);
                    break;
                case 4:
                    bookExcursion(scanner);
                    break;
                case 5:
                    changePassengerCabin(scanner);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
    }
    //In this wsection a menu is displayed for the user to interact with
    private static void displayCruiseInformation(Scanner scanner) {
        System.out.println("Select a cruise:");
        for (int i = 0; i < cruiseShips.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, cruiseShips.get(i).getName());
        }
        int choice = scanner.nextInt() - 1;
        if (choice >= 0 && choice < cruiseShips.size()) {
            CruiseShip selectedShip = cruiseShips.get(choice);
            System.out.println(selectedShip);
        } else {
            System.out.println("Invalid choice.");
        }
    }
    //In this section it allowed a way for the user to select a cruise ship and view its details

    private static void displayExcursionInformation(Scanner scanner) {
        System.out.println("Select a cruise:");
        for (int i = 0; i < cruiseShips.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, cruiseShips.get(i).getName());
        }
        int choice = scanner.nextInt() - 1;
        if (choice >= 0 && choice < cruiseShips.size()) {
            CruiseShip selectedShip = cruiseShips.get(choice);
            System.out.println("Available Excursions:");
            for (Excursion excursion : selectedShip.getExcursions()) {
                System.out.println(excursion);
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }
    //In this section it allows the user to select a cruise ship and view the excusrsions available
    private static void displayPassengerInformation(Scanner scanner) {
        System.out.println("Select a cruise:");
        for (int i = 0; i < cruiseShips.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, cruiseShips.get(i).getName());
        }
        int choice = scanner.nextInt() - 1;
        if (choice >= 0 && choice < cruiseShips.size()) {
            CruiseShip selectedShip = cruiseShips.get(choice);
            System.out.println("Passengers on " + selectedShip.getName() + ":");
            for (Passenger passenger : selectedShip.getPassengers()) {
                System.out.println(passenger);
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }
    //In this section it allows the user to select a cruise ship and view all the passengers on board

    private static void bookExcursion(Scanner scanner) {
        System.out.println("Select a cruise:");
        for (int i = 0; i < cruiseShips.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, cruiseShips.get(i).getName());
        }
        int shipChoice = scanner.nextInt() - 1;
        if (shipChoice >= 0 && shipChoice < cruiseShips.size()) {
            CruiseShip selectedShip = cruiseShips.get(shipChoice);

            System.out.println("Select a passenger:");
            List<Passenger> passengers = selectedShip.getPassengers();
            for (int i = 0; i < passengers.size(); i++) {
                System.out.printf("%d. %s\n", i + 1, passengers.get(i).getName());
            }
            int passengerChoice = scanner.nextInt() - 1;

            if (passengerChoice >= 0 && passengerChoice < passengers.size()) {
                Passenger passenger = passengers.get(passengerChoice);
                System.out.println("Available Excursions:");
                for (int i = 0; i < selectedShip.getExcursions().size(); i++) {
                    Excursion excursion = selectedShip.getExcursions().get(i);
                    if (!excursion.isFullyBooked()) {
                        System.out.printf("%d. %s\n", i + 1, excursion);
                    }
                }
                System.out.print("Select an excursion or 0 to cancel: ");
                int excursionChoice = scanner.nextInt() - 1;

                if (excursionChoice >= 0 && excursionChoice < selectedShip.getExcursions().size()) {
                    Excursion excursion = selectedShip.getExcursions().get(excursionChoice);
                    excursion.bookPassenger();
                    passenger.bookExcursion(excursion);
                    System.out.println("Excursion booked successfully for " + passenger.getName());
                } else {
                    System.out.println("Booking cancelled.");
                }
            } else {
                System.out.println("Invalid passenger selection.");
            }
        } else {
            System.out.println("Invalid cruise selection.");
        }
    }
    //In this section it allows the user to book an excursion for a selected passenger on a selected cruise

    private static void changePassengerCabin(Scanner scanner) {
        System.out.println("Select a cruise:");
        for (int i = 0; i < cruiseShips.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, cruiseShips.get(i).getName());
        }
        int shipChoice = scanner.nextInt() - 1;
        if (shipChoice >= 0 && shipChoice < cruiseShips.size()) {
            CruiseShip selectedShip = cruiseShips.get(shipChoice);

            System.out.println("Vacant Cabins:");
            List<Cabin> vacantCabins = selectedShip.getVacantCabins();
            if (vacantCabins.isEmpty()) {
                System.out.println("No vacant cabins available.");
                return;
            }
            for (int i = 0; i < vacantCabins.size(); i++) {
                System.out.printf("%d. %s\n", i + 1, vacantCabins.get(i));
            }
            System.out.println("Select a passenger to move:");
            List<Passenger> passengers = selectedShip.getPassengers();
            for (int i = 0; i < passengers.size(); i++) {
                System.out.printf("%d. %s\n", i + 1, passengers.get(i).getName());
            }
            int passengerChoice = scanner.nextInt() - 1;
            if (passengerChoice >= 0 && passengerChoice < passengers.size()) {
                Passenger passenger = passengers.get(passengerChoice);
                System.out.print("Select a new cabin: ");
                int cabinChoice = scanner.nextInt() - 1;
                if (cabinChoice >= 0 && cabinChoice < vacantCabins.size()) {
                    passenger.setCabinNumber(vacantCabins.get(cabinChoice).getNumber());
                    System.out.println("Cabin changed successfully for " + passenger.getName());
                } else {
                    System.out.println("Invalid cabin choice.");
                }
            } else {
                System.out.println("Invalid passenger selection.");
            }
        } else {
            System.out.println("Invalid cruise selection.");
        }
    }
}
//In this section it allows the user to reassign a passenger to a vacant cabin on a specific cruise
