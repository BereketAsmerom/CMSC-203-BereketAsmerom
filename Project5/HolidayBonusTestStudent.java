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

import static org.junit.Assert.*;
import org.junit.Test;

public class HolidayBonusTestStudent {

    @Test
    public void testCalculateHolidayBonus() {
        double[][] salesData = {
            {1000, 1500, 2000}, // Store 0
            {1200, 1300, 1400}, // Store 1
            {800, 900, 1000}    // Store 2
        };

        // Recalculate expected bonuses based on the provided logic in HolidayBonus
        // Highest in each column gets HIGH_BONUS = 5000.0
        // Lowest in each column gets LOW_BONUS = 1000.0
        // Everything else gets MID_BONUS = 2000.0

        // Column 0: Store 1 = HIGH (5000), Store 2 = LOW (1000), Store 0 = MID (2000)
        // Column 1: Store 0 = HIGH (5000), Store 2 = LOW (1000), Store 1 = MID (2000)
        // Column 2: Store 0 = HIGH (5000), Store 2 = LOW (1000), Store 1 = MID (2000)
        // Total bonuses for each store:
        // Store 0: 2000 + 5000 + 5000 = 12000
        // Store 1: 5000 + 2000 + 2000 = 9000
        // Store 2: 1000 + 1000 + 1000 = 3000

        double[] expected = {12000.0, 9000.0, 3000.0};
        double[] result = HolidayBonus.calculateHolidayBonus(salesData);

        for (int i = 0; i < result.length; i++) {
            System.out.printf("Store %d: Expected %.2f, Actual %.2f%n", i, expected[i], result[i]);
        }

        assertArrayEquals("Bonuses do not match expected values", expected, result, 0.0001);
    }

    @Test
    public void testCalculateTotalHolidayBonus() {
        double[][] salesData = {
            {1000, 1500, 2000}, // Store 0
            {1200, 1300, 1400}, // Store 1
            {800, 900, 1000}    // Store 2
        };

        // Total holiday bonus:
        double expectedTotal = 12000.0 + 9000.0 + 3000.0; // = 24000.0
        double actualTotal = HolidayBonus.calculateTotalHolidayBonus(salesData);

        System.out.printf("Expected Total: %.2f, Actual Total: %.2f%n", expectedTotal, actualTotal);

        assertEquals("Total bonus does not match expected value", expectedTotal, actualTotal, 0.0001);
    }
}
