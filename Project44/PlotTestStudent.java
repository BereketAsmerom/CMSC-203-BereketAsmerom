/*
 * Class: CMSC203 CRN 20932
 * Instructor: Prof. Tarek 
 * Description: Management Company Program
 * Due: 11/2/2024
 * Platform/compiler:
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Bereket Asmerom
*/
package project44;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlotTestStudent {

    private Plot plot1;
    private Plot plot2;

    @BeforeEach
    public void setUp() throws Exception {
        plot1 = new Plot(2, 3, 4, 5);  // Creating a Plot with x=2, y=3, width=4, depth=5
        plot2 = new Plot(3, 4, 2, 2);  // Adjusted Plot 2 to start within Plot 1's bounds for overlap
    }

    @AfterEach
    public void tearDown() throws Exception {
        plot1 = null;
        plot2 = null;
    }

    @Test
    public void testGetX() {
        assertEquals(2, plot1.getX());
    }

    @Test
    public void testGetY() {
        assertEquals(3, plot1.getY());
    }

    @Test
    public void testGetWidth() {
        assertEquals(4, plot1.getWidth());
    }

    @Test
    public void testGetDepth() {
        assertEquals(5, plot1.getDepth());
    }

    @Test
    public void testToString() {
        String expectedOutput = "Upper left: (2,3); Width: 4 Depth:5";
    }

    @Test
    public void testOverlaps() {
        assertTrue(plot1.overlaps(plot2));  // Expecting overlap based on adjusted coordinates
    }

    @Test
    public void testEncompasses() {
        Plot smallerPlot = new Plot(3, 4, 1, 1);
        assertTrue(plot1.encompasses(smallerPlot)); // plot1 should encompass smallerPlot
        assertFalse(smallerPlot.encompasses(plot1)); // smallerPlot should not encompass plot1
    }
}
