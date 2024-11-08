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
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class represents GFA test cases for a Plot object.
 * 
 * @author Farnaz Eivazi
 * @version 7/11/2022
 * 
 */
public class PlotTestGFA {
	private Plot plot1, plot5;

	@Before
	public void setUp() throws Exception {
		plot1 = new Plot(2, 2, 6, 6);
		plot5 = new Plot(3, 4, 4, 3);
	}

	@After
	public void tearDown() throws Exception {
		plot1 = plot5 = null;
	}

	@Test
	public void testOverlaps() {
		assertTrue(plot1.overlaps(plot5)); // plot5 is entirely inside plot1
	}
	
	@Test
	public void testToString() {
		assertEquals("3,4,4,3",plot5.toString());	
	}

}