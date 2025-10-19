import java.util.Scanner;
import java.util.Locale;

public class EliteSaccoOpticsApp {
    // fixed interest rate 5% per year
    public static final double INTEREST_RATE = 0.05;

    public static void main(String[] args) {
        // Use US locale to ensure dot decimal parsing if needed
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== ELITE SACCO & CONCAVE MIRROR TOOL ===");
            System.out.println("1. SACCO calculator (For loop)");
            System.out.println("2. SACCO calculator (While loop)");
            System.out.println("3. Concave mirror focal length check");
            System.out.println("4. Example code analysis (sample)");
            System.out.println("5. Exit");
            System.out.print("Choose option (1-5): ");

            int option;
            try {
                option = Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Invalid selection. Try again.");
                continue;
            }

            switch (option) {
                case 1:
                    saccoForLoop(sc);
                    break;
                case 2:
                    saccoWhileLoop(sc);
                    break;
                case 3:
                    concaveMirrorCheck(sc);
                    break;
                case 4:
                    exampleCodeAnalysis();
                    break;
                case 5:
                    System.out.println("Exiting. Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Please choose a valid option 1-5.");
            }
        }
    }

    /**
     * SACCO implementation using a for loop.
     * Asks number of members, reads each member's principal and time (years),
     * computes final value using simple interest: A = P * (1 + r * t)
     */
    public static void saccoForLoop(Scanner sc) {
        System.out.println("\n-- SACCO (For loop) --");
        int n;
        while (true) {
            System.out.print("Enter number of members to process: ");
            try {
                n = Integer.parseInt(sc.nextLine().trim());
                if (n <= 0) {
                    System.out.println("Number must be positive.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid number, try again.");
            }
        }

        double totalInvested = 0.0;
        for (int i = 1; i <= n; i++) {
            System.out.printf("Member %d - enter principal (UGX or units): ", i);
            double principal = Double.parseDouble(sc.nextLine().trim());
            System.out.printf("Member %d - enter time (years): ", i);
            double years = Double.parseDouble(sc.nextLine().trim());

            // simple interest final amount
            double finalAmount = principal * (1 + INTEREST_RATE * years);

            System.out.printf("Member %d final amount after %.2f years at 5%% = %.2f%n",
                    i, years, finalAmount);

            totalInvested += finalAmount;
        }
        System.out.printf("Total (sum of final amounts for %d members): %.2f%n", n, totalInvested);
    }

    /**
     * SACCO implementation using a while loop.
     * Same logic but iteration done with while.
     */
    public static void saccoWhileLoop(Scanner sc) {
        System.out.println("\n-- SACCO (While loop) --");
        int n;
        while (true) {
            System.out.print("Enter number of members to process: ");
            try {
                n = Integer.parseInt(sc.nextLine().trim());
                if (n <= 0) {
                    System.out.println("Number must be positive.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid number, try again.");
            }
        }

        double totalInvested = 0.0;
        int i = 1;
        while (i <= n) {
            System.out.printf("Member %d - enter principal (UGX or units): ", i);
            double principal = Double.parseDouble(sc.nextLine().trim());
            System.out.printf("Member %d - enter time (years): ", i);
            double years = Double.parseDouble(sc.nextLine().trim());

            // simple interest final amount
            double finalAmount = principal * (1 + INTEREST_RATE * years);

            System.out.printf("Member %d final amount after %.2f years at 5%% = %.2f%n",
                    i, years, finalAmount);

            totalInvested += finalAmount;
            i++;
        }
        System.out.printf("Total (sum of final amounts for %d members): %.2f%n", n, totalInvested);
    }

    /**
     * Concave mirror focal length check using mirror formula:
     * 1/f = 1/v + 1/u  => f = 1 / ( (1/v) + (1/u) )
     *
     * Note: For concave mirrors in sign convention, u should be negative and v positive for real images.
     * We ensure u is negative (if user enters positive, we convert to negative and inform).
     *
     * The prompt had two different acceptable ranges (21.0-25.0 and 9.0-11.0). We compute f and check both,
     * reporting which ranges (if any) f falls into.
     */
    public static void concaveMirrorCheck(Scanner sc) {
        System.out.println("\n-- Concave mirror focal length check --");
        double u, v;
        try {
            System.out.print("Enter object distance u (cm) (for concave mirror, u should be negative): ");
            u = Double.parseDouble(sc.nextLine().trim());
            System.out.print("Enter image distance v (cm) (positive for real images): ");
            v = Double.parseDouble(sc.nextLine().trim());
        } catch (Exception e) {
            System.out.println("Invalid input. Returning to main menu.");
            return;
        }

        // enforce u negative for concave mirror (as prompt said u is always negative)
        if (u > 0) {
            System.out.printf("You entered u = %.3f (positive). For concave mirror convention, we'll use u = %.3f (negative of entered value).%n",
                    u, -Math.abs(u));
            u = -Math.abs(u);
        }

        // guard against division by zero
        if (v == 0 || u == 0) {
            System.out.println("u or v cannot be zero for the mirror formula. Aborting.");
            return;
        }

        double invF = (1.0 / v) + (1.0 / u);
        if (invF == 0) {
            System.out.println("Computed 1/f = 0 => focal length infinite (plane).");
            return;
        }
        double f = 1.0 / invF;

        System.out.printf("Computed focal length f = %.4f cm%n", f);

        // The prompt contained both ranges 21.0-25.0 and 9.0-11.0.
        boolean inRange21to25 = (f >= 21.0 && f <= 25.0);
        boolean inRange9to11 = (f >= 9.0 && f <= 11.0);

        if (inRange21to25) {
            System.out.println("Mirror ACCEPTABLE for the 21.0 cm - 25.0 cm criterion.");
        } else {
            System.out.println("Mirror NOT acceptable for the 21.0 cm - 25.0 cm criterion.");
        }

        if (inRange9to11) {
            System.out.println("Mirror ACCEPTABLE for the 9.0 cm - 11.0 cm criterion.");
        } else {
            System.out.println("Mirror NOT acceptable for the 9.0 cm - 11.0 cm criterion.");
        }

        // Friendly note to the student
        System.out.println("\nNote: Your exam prompt mentioned both ranges (21.0–25.0 and 9.0–11.0). " +
                "This program checks both and reports where f falls. Use the range your examiner specified.");
    }

    /**
     * Since the original "analyze the code below and state its output" code wasn't included in the user's message,
     * we provide a short example snippet and analyze its output for you (so that the "5 marks" portion is served).
     */
    public static void exampleCodeAnalysis() {
        System.out.println("\n-- Example code analysis (sample) --");
        System.out.println("Sample code:");
        System.out.println("int a = 5, b = 3;");
        System.out.println("int c = a++ + ++b; // evaluate and then explain");
        System.out.println("System.out.println(a + \" \" + b + \" \" + c);");
        System.out.println("\nAnalysis and output:");

        // Explanation:
        System.out.println("1) a is 5, b is 3 initially.");
        System.out.println("2) Expression 'a++ + ++b' :");
        System.out.println("   - a++ uses the current value of a (5) in the expression, then a becomes 6 afterwards.");
        System.out.println("   - ++b increments b first (b becomes 4) and then uses 4 in the expression.");
        System.out.println("   So c = 5 + 4 = 9.");
        System.out.println("3) After the expression, a is 6, b is 4, c is 9.");
        System.out.println("Therefore the printed line will be: 6 4 9");
    }
}
