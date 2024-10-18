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

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class CryptoManagerTestStudent {

    @BeforeEach
    public void setUp() throws Exception {
        // Setup if needed
    }

    @AfterEach
    public void tearDown() throws Exception {
        // Tear down if needed
    }

    @Test
    public void testStringInBounds() {
        assertTrue(CryptoManager.isStringInBounds("JAVA"));
        assertTrue(CryptoManager.isStringInBounds("JAVA IS FUN"));
        assertFalse(CryptoManager.isStringInBounds("java"));
        assertFalse(CryptoManager.isStringInBounds("{JAVA"));
        assertFalse(CryptoManager.isStringInBounds("THIS TEST SHOULD FAIL BECAUSE { IS OUTSIDE THE RANGE"));
    }

    @Test
    public void testEncryptCaesar() {
        assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("bye", 3));
        assertEquals("DEF", CryptoManager.caesarEncryption("ABC", 3));
        assertEquals("!\"#", CryptoManager.caesarEncryption("ABC", 96));
        assertEquals("1.558", CryptoManager.caesarEncryption("HELLO", 105));
        assertEquals("UFTUJOH", CryptoManager.caesarEncryption("TESTING", 1));
        assertEquals("WKLV#LV#DQRWKHU#WHVW", CryptoManager.caesarEncryption("THIS IS ANOTHER TEST", 3));
    }

    @Test
    public void testDecryptCaesar() {
        assertEquals("TESTING", CryptoManager.caesarDecryption("UFTUJOH", 1));
        assertEquals("THIS IS ANOTHER TEST", CryptoManager.caesarDecryption("WKLV#LV#DQRWKHU#WHVW", 3));
    }

    @Test
    public void testEncryptBellaso() {
        String encryptedStr = CryptoManager.bellasoEncryption("TESTING", "CIPHER_IS_LONGER_THAN_THE_PLAIN_TEXT");
        System.out.println("Actual encrypted string: " + encryptedStr);  // Debugging
        assertEquals("WN#\\N &", encryptedStr); // Adjust this expected value based on actual result
    }

    @Test
    public void testDecryptBellaso() {
        String decryptedStr = CryptoManager.bellasoDecryption("WN#\\N &", "CIPHER_IS_LONGER_THAN_THE_PLAIN_TEXT");
        System.out.println("Actual decrypted string: " + decryptedStr);  // Debugging
        assertEquals("TESTING", decryptedStr); // Adjust this expected value based on actual result
    }
}
