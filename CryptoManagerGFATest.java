/*
 * Class: CMSC203 
 * Instructor: Prof. Tarek 
 * Description: CryptoManager Encryption
 * Due: 10/16/24
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Bereket Asmerom
*/

package project33;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * This class represents GFA test cases for a CryptoManager object.
 * 
 * @author Farnaz Eivazi
 * @version 7/12/2022
 * 
 */
public class CryptoManagerGFATest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("THIS TEST SHOULD SUCCEED"));
	}

	@Test
	public void testEncryptCaesar() {
		assertEquals("IFMMP!XPSME", CryptoManager.caesarEncryption("HELLO WORLD", 1));
	}

	@Test
	public void testDecryptCaesar() {
		assertEquals("HELLO WORLD", CryptoManager.caesarDecryption("IFMMP!XPSME", 1));
	}
}

	

