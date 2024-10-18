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

public class CryptoManager {

    private static final char LOWER_RANGE = ' ';
    private static final char UPPER_RANGE = '_';
    private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

    public static boolean isStringInBounds(String plainText) {
        for (int i = 0; i < plainText.length(); i++) {
            char ch = plainText.charAt(i);
            if (ch < LOWER_RANGE || ch > UPPER_RANGE) {
                return false;
            }
        }
        return true;
    }

    public static String caesarEncryption(String plainText, int key) {
        if (!isStringInBounds(plainText)) {
            return "The selected string is not in bounds, Try again.";
        }

        StringBuilder encryptedText = new StringBuilder();

        // Normalize the key to avoid large shifts
        int normalizedKey = key % RANGE;

        for (int i = 0; i < plainText.length(); i++) {
            char ch = plainText.charAt(i);
            if (ch >= LOWER_RANGE && ch <= UPPER_RANGE) {
                int offset = ch + normalizedKey;
                offset = adjustWithinRange(offset);

                encryptedText.append((char) offset);
            } else {
                encryptedText.append(ch);
            }
        }
        return encryptedText.toString();
    }

    public static String caesarDecryption(String encryptedText, int key) {
        if (!isStringInBounds(encryptedText)) {
            return "The selected string is not in bounds, Try again.";
        }

        StringBuilder decryptedText = new StringBuilder();

        // Normalize the key to avoid large shifts
        int normalizedKey = key % RANGE;

        for (int i = 0; i < encryptedText.length(); i++) {
            char ch = encryptedText.charAt(i);
            if (ch >= LOWER_RANGE && ch <= UPPER_RANGE) {
                int offset = ch - normalizedKey;
                offset = adjustWithinRange(offset);

                decryptedText.append((char) offset);
            } else {
                decryptedText.append(ch);
            }
        }
        return decryptedText.toString();
    }

    public static String bellasoEncryption(String plainText, String bellasoStr) {
        StringBuilder encryptedText = new StringBuilder();
        StringBuilder extendedKey = new StringBuilder();
        extendKey(plainText, bellasoStr, extendedKey);

        for (int i = 0; i < plainText.length(); i++) {
            char plainChar = plainText.charAt(i);
            char keyChar = extendedKey.charAt(i);
            int offset = (plainChar + keyChar - LOWER_RANGE) % RANGE;

            if (offset < 0) {
                offset += RANGE;
            }
            encryptedText.append((char) (LOWER_RANGE + offset));
        }

        return encryptedText.toString();
    }

    public static String bellasoDecryption(String encryptedText, String bellasoStr) {
        StringBuilder decryptedText = new StringBuilder();
        StringBuilder extendedKey = new StringBuilder();
        extendKey(encryptedText, bellasoStr, extendedKey);

        for (int i = 0; i < encryptedText.length(); i++) {
            char encryptedChar = encryptedText.charAt(i);
            char keyChar = extendedKey.charAt(i);
            int offset = (encryptedChar - keyChar - LOWER_RANGE) % RANGE;

            if (offset < 0) {
                offset += RANGE;
            }
            decryptedText.append((char) (LOWER_RANGE + offset));
        }

        return decryptedText.toString();
    }

    // Helper function to adjust offset within bounds
    private static int adjustWithinRange(int offset) {
        if (offset > UPPER_RANGE) {
            return LOWER_RANGE + ((offset - LOWER_RANGE) % RANGE);
        } else if (offset < LOWER_RANGE) {
            return UPPER_RANGE - ((LOWER_RANGE - offset) % RANGE);
        } else {
            return offset;
        }
    }

    // Helper function to extend the key
    private static void extendKey(String text, String key, StringBuilder extendedKey) {
        for (int i = 0; i < text.length(); i++) {
            extendedKey.append(key.charAt(i % key.length()));
        }
    }
}
