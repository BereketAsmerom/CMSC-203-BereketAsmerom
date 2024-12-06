/*
 * Class: CMSC203 
 * Instructor: Prof Tarek
 * Description: Holiday Bonus Program
 * Due: 11/25/24
 * Platform/compiler:
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
 * Print your Name here: Bereket Asmerom
 */

package project55;

public class HolidayBonus {

    // Constants for bonus amounts
    private static final double HIGH_BONUS = 5000.0;
    private static final double LOW_BONUS = 1000.0;
    private static final double MID_BONUS = 2000.0;

    /**
     * Calculates the holiday bonus for each store based on the sales data.
     *
     * @param salesData 2D array of sales data
     * @return Array of bonuses for each store
     */
    public static double[] calculateHolidayBonus(double[][] salesData) {
        int numStores = salesData.length;
        double[] bonuses = new double[numStores];

        // Determine the maximum number of columns in the data set
        int maxColumns = getMaxColumns(salesData);

        // Iterate through each column
        for (int col = 0; col < maxColumns; col++) {
            double highValue = Double.NEGATIVE_INFINITY; 
            double lowValue = Double.POSITIVE_INFINITY;
            boolean hasPositiveValues = false; // Track if the column has any positive values

            // Identify the highest and lowest positive values in the column
            for (int row = 0; row < numStores; row++) {
                if (col < salesData[row].length && salesData[row][col] > 0) { // Exclude negative or zero values
                    double value = salesData[row][col];
                    if (value > highValue) {
                        highValue = value;
                    }
                    if (value < lowValue) {
                        lowValue = value;
                    }
                    hasPositiveValues = true; // At least one positive value found
                }
            }

            // Skip the column if no positive values are found
            if (!hasPositiveValues) {
                continue;
            }

            // Assign bonuses for the current column
            for (int row = 0; row < numStores; row++) {
                if (col < salesData[row].length && salesData[row][col] > 0) { // Exclude negative or zero values
                    double value = salesData[row][col];
                    if (value == highValue) {
                        bonuses[row] += HIGH_BONUS;
                    } else if (value == lowValue) {
                        bonuses[row] += LOW_BONUS;
                    } else {
                        bonuses[row] += MID_BONUS;
                    }
                }
            }
        }
        return bonuses;
    }

    /**
     * Calculates the total holiday bonus across all stores.
     *
     * @param salesData 2D array of sales data
     * @return Total holiday bonus
     */
    public static double calculateTotalHolidayBonus(double[][] salesData) {
        double totalBonus = 0.0;

        // Calculate bonuses for each store
        double[] bonuses = calculateHolidayBonus(salesData);

        // Sum up all bonuses
        for (double bonus : bonuses) {
            totalBonus += bonus;
        }

        return totalBonus;
    }

    /**
     * Finds the maximum number of columns across all rows in the dataset.
     *
     * @param salesData 2D array of sales data
     * @return Maximum number of columns
     */
    private static int getMaxColumns(double[][] salesData) {
        int maxColumns = 0;

        // Find the maximum number of columns across all rows
        for (double[] row : salesData) {
            if (row.length > maxColumns) {
                maxColumns = row.length;
            }
        }

        return maxColumns;
    }
}
