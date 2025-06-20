// File: FinancialForecast.java

public class FinancialForecast {

    /**
     * Recursively predicts the future value based on current value, growth rate, and years.
     *
     * @param currentValue the current financial amount
     * @param growthRate   the annual growth rate (e.g., 0.05 for 5%)
     * @param years        the number of years into the future
     * @return the predicted future value
     */
    public double predictFutureValue(double currentValue, double growthRate, int years) {
        // Base Case: If no years left, return the current value
        if (years == 0) {
            return currentValue;
        }

        // Recursive Case: Apply growth rate and move to next year
        double updatedValue = currentValue * (1 + growthRate);
        return predictFutureValue(updatedValue, growthRate, years - 1);
    }

    public static void main(String[] args) {
        // Sample Inputs
        double initialValue = 1000.0;
        double growthRate = 0.05; // 5%
        int years = 3;

        FinancialForecast forecastTool = new FinancialForecast();
        double predictedValue = forecastTool.predictFutureValue(initialValue, growthRate, years);

        // Display Output
        System.out.println("Initial Value: $" + initialValue);
        System.out.println("Growth Rate: " + (growthRate * 100) + "%");
        System.out.println("Years: " + years);
        System.out.printf("Predicted Future Value: $%.3f%n", predictedValue);
    }
}
