package JAVA.FirstCode;

import java.util.ArrayList;
import java.util.Scanner;

class Train {
    String trainNumber;
    String trainName;
    String source;
    String destination;
    int totalSeats;
    int availableSeats;

    public Train(String trainNumber, String trainName, String source, String destination, int totalSeats) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }

    public boolean bookSeats(int seats) {
        if (availableSeats >= seats) {
            availableSeats -= seats;
            return true;
        } else {
            return false;
        }
    }

    public void cancelSeats(int seats) {
        availableSeats += seats;
        if (availableSeats > totalSeats) {
            availableSeats = totalSeats;
        }
    }

    public void displayTrainDetails() {
        System.out.println("Train No: " + trainNumber + ", Name: " + trainName + ", From: " + source + ", To: " + destination + ", Available Seats: " + availableSeats);
    }
}

public class SimpleIRCTCApp {
    static ArrayList<Train> trains = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeTrains();

        while (true) {
            System.out.println("\n*** Simple IRCTC App ***");
            System.out.println("1. Search Trains");
            System.out.println("2. Book Tickets");
            System.out.println("3. Cancel Tickets");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    searchTrains(scanner);
                    break;
                case 2:
                    bookTickets(scanner);
                    break;
                case 3:
                    cancelTickets(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using Simple IRCTC App!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void initializeTrains() {
        trains.add(new Train("12345", "Express A", "Delhi", "Mumbai", 100));
        trains.add(new Train("23456", "Express B", "Mumbai", "Chennai", 120));
        trains.add(new Train("34567", "Express C", "Kolkata", "Delhi", 90));
    }

    private static void searchTrains(Scanner scanner) {
        System.out.print("Enter source station: ");
        String source = scanner.next();
        System.out.print("Enter destination station: ");
        String destination = scanner.next();

        boolean found = false;
        for (Train train : trains) {
            if (train.source.equalsIgnoreCase(source) && train.destination.equalsIgnoreCase(destination)) {
                train.displayTrainDetails();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No trains found for this route.");
        }
    }

    private static void bookTickets(Scanner scanner) {
        System.out.print("Enter train number: ");
        String trainNumber = scanner.next();
        Train train = findTrainByNumber(trainNumber);
        if (train == null) {
            System.out.println("Train not found!");
            return;
        }
        System.out.print("Enter number of seats to book: ");
        int seats = scanner.nextInt();

        if (train.bookSeats(seats)) {
            System.out.println("Booking successful! Seats booked: " + seats);
        } else {
            System.out.println("Booking failed! Not enough seats available.");
        }
    }

    private static void cancelTickets(Scanner scanner) {
        System.out.print("Enter train number: ");
        String trainNumber = scanner.next();
        Train train = findTrainByNumber(trainNumber);
        if (train == null) {
            System.out.println("Train not found!");
            return;
        }
        System.out.print("Enter number of seats to cancel: ");
        int seats = scanner.nextInt();
        train.cancelSeats(seats);
        System.out.println("Cancellation successful! Seats cancelled: " + seats);
    }

    private static Train findTrainByNumber(String trainNumber) {
        for (Train train : trains) {
            if (train.trainNumber.equals(trainNumber)) {
                return train;
            }
        }
        return null;
    }
}
