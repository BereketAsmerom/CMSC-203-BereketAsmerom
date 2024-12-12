package project66;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlcoholTestStudent {
		Alcohol test1 , test2 , test3;
	
	@BeforeEach
	void setUp() throws Exception {
		test1 = new Alcohol("Beer", SIZE.MEDIUM,true);
		test2 = new Alcohol("Wine", SIZE.MEDIUM,false);
		test3 = new Alcohol("Beer", SIZE.MEDIUM,true);
	}

	@AfterEach
	void tearDown() throws Exception {
		test1 = test2 = test3 = null;
	}

	@Test
	void testCalcPrice() {
		assertEquals(3.6,test1.calcPrice());
	}

	@Test
	void testEquals() {
		assertTrue(test1.equals(test3));
		assertFalse(test2.equals(test1));
		
	}

	@Test
	void testToString() {
		assertEquals("Beer, MEDIUM\n"
				+ " Drink is offered on weekends for 0.60$ extra\n"
				+ " Price: 3.6",test1.toString());
	}

	@Test
	void testIsWeekend() {
		assertTrue(test1.isWeekend());
		assertFalse(test2.isWeekend());
	}

}