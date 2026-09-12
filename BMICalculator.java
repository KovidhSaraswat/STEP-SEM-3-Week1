import java.util.Random;

public class BMICalculator {

    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            return "Normal";
        } else if (bmi >= 25.0 && bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("=========================================================================");
        System.out.printf("%-10s | %-12s | %-12s | %-10s | %-12s\n", "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("-------------------------------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);
            System.out.printf("Person %-3d | %-12.2f | %-12.2f | %-10.2f | %-12s\n", 
                              (i + 1), heights[i], weights[i], bmi, status);
        }
        System.out.println("=========================================================================");
    }

    public static void main(String[] args) {
        int teamSize = 10;
        double[] heights = new double[teamSize];
        double[] weights = new double[teamSize];

        // Seeded values to ensure demonstration contains predictable output ranges
        double[] sampleHeights = {1.75, 1.60, 1.80, 1.55, 1.70, 1.65, 1.85, 1.50, 1.78, 1.62};
        double[] sampleWeights = {70.0, 90.0, 50.0, 65.0, 72.0, 85.0, 95.0, 42.0, 80.0, 58.0};

        System.arraycopy(sampleHeights, 0, heights, 0, teamSize);
        System.arraycopy(sampleWeights, 0, weights, 0, teamSize);

        printWellnessReport(heights, weights);
    }
}