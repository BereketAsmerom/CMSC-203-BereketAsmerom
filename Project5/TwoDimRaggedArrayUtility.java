/*
 * Class: CMSC203 
 * Instructor:Prof Tarek
 * Description: holiday bonus program
 * Due: 11/25/24
 * Platform/compiler:
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Bereket Asmerom
*/

package project55;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {

    // Get the total of all elements in the array
    public static double getTotal(double[][] array) {
        double total = 0;
        for (double[] row : array) {
            for (double val : row) {
                total += val;
            }
        }
        return total;
    }

    // Get the total of a specific row
    public static double getRowTotal(double[][] array, int rowIndex) {
        if (array == null || rowIndex < 0 || rowIndex >= array.length) {
            return 0; // Return 0 for invalid indices
        }
        double total = 0;
        for (double val : array[rowIndex]) {
            total += val;
        }
        return total;
    }

    // Get the total of a specific column
    public static double getColumnTotal(double[][] array, int columnIndex) {
        double total = 0;
        if (array == null) {
            return 0; // Return 0 for null arrays
        }
        for (double[] row : array) {
            if (columnIndex < row.length) {
                total += row[columnIndex];
            }
        }
        return total;
    }

    // Get the highest value in a specific column
    public static double getHighestInColumn(double[][] array, int columnIndex) {
        double highest = Double.NEGATIVE_INFINITY;
        boolean found = false;

        for (double[] row : array) {
            if (columnIndex < row.length) {
                highest = Math.max(highest, row[columnIndex]);
                found = true;
            }
        }

        return found ? highest : 0; // Return 0 if no valid value was found
    }

    // Get the lowest value in a specific column
    public static double getLowestInColumn(double[][] array, int columnIndex) {
        double lowest = Double.POSITIVE_INFINITY;
        boolean found = false;

        for (double[] row : array) {
            if (columnIndex < row.length) {
                lowest = Math.min(lowest, row[columnIndex]);
                found = true;
            }
        }

        return found ? lowest : 0; // Return 0 if no valid value was found
    }

    // Get the lowest value in the entire array
    public static double getLowestInArray(double[][] array) {
        double lowest = Double.POSITIVE_INFINITY;
        if (array == null) {
            return 0; // Return 0 for null arrays
        }
        for (double[] row : array) {
            for (double val : row) {
                lowest = Math.min(lowest, val);
            }
        }
        return lowest;
    }

    // Read a ragged 2D array from a file
    public static double[][] readFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        StringBuilder content = new StringBuilder();

        while (scanner.hasNextLine()) {
            content.append(scanner.nextLine()).append("\n");
        }

        scanner.close();
        String[] lines = content.toString().split("\n");
        double[][] data = new double[lines.length][];

        for (int i = 0; i < lines.length; i++) {
            String[] values = lines[i].trim().split("\\s+");
            data[i] = new double[values.length];
            for (int j = 0; j < values.length; j++) {
                try {
                    data[i][j] = Double.parseDouble(values[j]);
                } catch (NumberFormatException e) {
                    data[i][j] = 0; // Handle non-numeric input gracefully
                }
            }
        }

        return data;
    }

    // Write a ragged 2D array to a file
    public static void writeToFile(double[][] data, File file) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(file);

        for (double[] row : data) {
            for (double val : row) {
                writer.print(val + " ");
            }
            writer.println();
        }

        writer.close();
    }
}
