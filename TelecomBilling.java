public class TelecomBilling {
    public static void main(String[] args) {
        double load = 10000; // UGX loaded
        double taxRate = 0.10; // 10%
        double callRate = 200; // UGX per second
        int callDuration = 5 * 60; // 5 minutes = 300 seconds

        // Step 1: Deduct tax
        double afterTax = load - (load * taxRate);

        // Step 2: Deduct call cost
        double callCost = callRate * callDuration;

        double balance = afterTax - callCost;

        System.out.println("Initial Load: UGX " + load);
        System.out.println("After 10% tax: UGX " + afterTax);
        System.out.println("Cost of 5-minute call: UGX " + callCost);
        System.out.println("Remaining Balance: UGX " + balance);
    }
}
