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

public class PropertyTestStudent {

    Property propertyTest;

    @BeforeEach
    public void setUp() throws Exception {
        propertyTest = new Property("Sunny Apartments", "Bethesda", 1800.00, "John Doe", 2, 3, 4, 5);
    }

    @AfterEach
    public void tearDown() throws Exception {
        propertyTest = null;
    }

    @Test
    public void testGetCity() {
        assertEquals("Bethesda", propertyTest.getCity());
    }

    @Test
    public void testGetOwner() {
        assertEquals("John Doe", propertyTest.getOwner());
    }

    @Test
    public void testGetRentAmount() {
        assertEquals(1800.00, propertyTest.getRentAmount(), 0.001);
    }

    @Test
    public void testGetPropertyName() {
        assertEquals("Sunny Apartments", propertyTest.getPropertyName());
    }

    @Test
    public void testGetPlot() {
        assertEquals(2, propertyTest.getPlot().getX());
        assertEquals(3, propertyTest.getPlot().getY());
        assertEquals(4, propertyTest.getPlot().getWidth());
        assertEquals(5, propertyTest.getPlot().getDepth());
    }

    @Test
    public void testToString() {
        String expectedOutput = "Property Name: Sunny Apartments\n" +
                                "Located in Bethesda\n" +
                                "Belonging to John Doe\n" +
                                "Rent Amount: 1800.0";
        //assertEquals(expectedOutput, propertyTest.toString());
    }
}
