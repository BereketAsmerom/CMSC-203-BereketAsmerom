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

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ManagementCompanyTestStudent {
    private ManagementCompany managementCo;
    private Property property1, property2, property3;

    @Before
    public void setUp() throws Exception {
        // Create a management company instance
        managementCo = new ManagementCompany("Realty Corp", "123456789", 5); // Adjusted to 5 properties for limit test
        
        // Add three properties with different plots to the management company
        property1 = new Property("Property One", "City A", 1500, "Owner A", 1, 1, 2, 2);
        property2 = new Property("Property Two", "City B", 2000, "Owner B", 3, 1, 2, 2);
        property3 = new Property("Property Three", "City C", 2500, "Owner C", 5, 1, 2, 2);

        managementCo.addProperty(property1);
        managementCo.addProperty(property2);
        managementCo.addProperty(property3);
    }

    @After
    public void tearDown() {
        managementCo = null;
    }

    @Test
    public void testAddPropertyDefaultPlot() {
        // Add a property with 4 arguments (default plot)
        Property property4 = new Property("Property Four", "City D", 3000, "Owner D");
        int index4 = managementCo.addProperty(property4);
        assertEquals("Property should be added at index 3", 3, index4);

        // Add a property with specific plot dimensions
        Property property5 = new Property("Property Five", "City E", 3500, "Owner E", 7, 1, 2, 2);
        int index5 = managementCo.addProperty(property5);
        assertEquals("Property should be added at index 4", 4, index5);

        // Attempt to add a property that exceeds the array size limit
        Property property6 = new Property("Property Six", "City F", 4000, "Owner F", 9, 1, 2, 2);
        int index6 = managementCo.addProperty(property6);
    }

    @Test
    public void testMaxPropertyRent() {
        // Check if getHighestRentProperty returns the property with the highest rent
        Property highestRentProperty = managementCo.getHighestRentProperty();
        assertNotNull("Highest rent property should not be null", highestRentProperty);
        assertEquals("Property Three", highestRentProperty.getPropertyName());
        assertEquals(2500, highestRentProperty.getRentAmount(), 0.001);
    }

    @Test
    public void testTotalRent() {
        // Check if getTotalRent calculates the sum of rents correctly
        double totalRent = property1.getRentAmount() + property2.getRentAmount() + property3.getRentAmount();
        assertEquals("Total rent should match sum of individual rents", totalRent, managementCo.getTotalRent(), 0.001);
    }
}
