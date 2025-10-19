import java.util.Scanner;

// Base class for accommodation areas
class AccommodationArea {
    protected String name;
    protected int capacity;
    protected boolean isOpen;

    public AccommodationArea(String name, int capacity, boolean isOpen) {
        this.name = name;
        this.capacity = capacity;
        this.isOpen = isOpen;
    }

    public void openArea() {
        isOpen = true;
        System.out.println(name + " is now OPEN.");
    }

    public void closeArea() {
        isOpen = false;
        System.out.println(name + " is now CLOSED.");
    }

    public void displayInfo() {
        System.out.println("Area: " + name);
        System.out.println("Capacity: " + capacity);
        System.out.println("Status: " + (isOpen ? "Open" : "Closed"));
        System.out.println("---------------------------");
    }
}

// Subclass for the Gym area
class GymArea extends AccommodationArea {
    private String equipmentType;

    public GymArea(String name, int capacity, boolean isOpen, String equipmentType) {
        super(name, capacity, isOpen);
        this.equipmentType = equipmentType;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Equipment Type: " + equipmentType);
        System.out.println("===========================");
    }
}

// Subclass for the Swimming area
class SwimmingArea extends AccommodationArea {
    private double poolDepth;

    public SwimmingArea(String name, int capacity, boolean isOpen, double poolDepth) {
        super(name, capacity, isOpen);
        this.poolDepth = poolDepth;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Pool Depth: " + poolDepth + " meters");
        System.out.println("===========================");
    }
}

// Main Application Class
public class EstateManagerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create sample areas
        GymArea gym = new GymArea("Speke Gym", 30, true, "Cardio & Strength Machines");
        SwimmingArea pool = new SwimmingArea("Speke Swimming Pool", 50, false, 2.5);

        int choice;
        do {
            System.out.println("\n========== SPEKE APARTMENTS MANAGEMENT ==========");
            System.out.println("1. View All Areas");
            System.out.println("2. Open an Area");
            System.out.println("3. Close an Area");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n--- Accommodation Areas ---");
                    gym.displayInfo();
                    pool.displayInfo();
                    break;

                case 2:
                    System.out.println("Which area do you want to OPEN? (1=Gym, 2=Pool)");
                    int openChoice = sc.nextInt();
                    if (openChoice == 1)
                        gym.openArea();
                    else if (openChoice == 2)
                        pool.openArea();
                    else
                        System.out.println("Invalid Option!");
                    break;

                case 3:
                    System.out.println("Which area do you want to CLOSE? (1=Gym, 2=Pool)");
                    int closeChoice = sc.nextInt();
                    if (closeChoice == 1)
                        gym.closeArea();
                    else if (closeChoice == 2)
                        pool.closeArea();
                    else
                        System.out.println("Invalid Option!");
                    break;

                case 4:
                    System.out.println("Exiting system... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}
