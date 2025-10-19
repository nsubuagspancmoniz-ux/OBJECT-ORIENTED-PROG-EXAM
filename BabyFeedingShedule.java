import java.util.*;

public class BabyFeedingSchedule {
    public static void main(String[] args) {
        double porridge = 2.0; // liters
        double milk = 2.0; // liters
        double cup = 0.5; // liters per feeding

        int porridgeFeeds = (int)(porridge / cup);
        int milkFeeds = (int)(milk / cup);

        int porridgeTime = porridgeFeeds * 45; // 45 minutes per half cup
        int milkTime = milkFeeds * 30; // 30 minutes per half cup

        int totalTime = porridgeTime + milkTime;

        System.out.println("Total time for baby to finish all meals: " + totalTime + " minutes");
        System.out.println("Which is approximately " + (totalTime / 60) + " hours and " + (totalTime % 60) + " minutes.");
    }
}
