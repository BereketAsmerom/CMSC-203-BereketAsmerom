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
import java.io.File;

public class TwoDimRaggedArrayUtilityTestStudent {

    @Test
    public void testGetTotal() {
        double[][] array = {
            {1.5, 2.0},
            {3.0},
            {4.5, 5.5, 6.0}
        };
        assertEquals(22.5, TwoDimRaggedArrayUtility.getTotal(array), 0.0001);
    }

    @Test
    public void testGetRowTotal() {
        double[][] array = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0}
        };
        assertEquals(6.0, TwoDimRaggedArrayUtility.getRowTotal(array, 0), 0.0001);
        assertEquals(9.0, TwoDimRaggedArrayUtility.getRowTotal(array, 1), 0.0001);
        assertEquals(6.0, TwoDimRaggedArrayUtility.getRowTotal(array, 2), 0.0001);
    }

    @Test
    public void testGetColumnTotal() {
        double[][] array = {
            {1.0, 2.0},
            {3.0},
            {4.0, 5.0}
        };
        assertEquals(8.0, TwoDimRaggedArrayUtility.getColumnTotal(array, 0), 0.0001);
        assertEquals(7.0, TwoDimRaggedArrayUtility.getColumnTotal(array, 1), 0.0001);
    }

    @Test
    public void testGetHighestInColumn() {
        double[][] array = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0, 7.0, 8.0}
        };
        assertEquals(6.0, TwoDimRaggedArrayUtility.getHighestInColumn(array, 0), 0.0001);
        assertEquals(7.0, TwoDimRaggedArrayUtility.getHighestInColumn(array, 1), 0.0001);
        assertEquals(8.0, TwoDimRaggedArrayUtility.getHighestInColumn(array, 2), 0.0001);
    }

    @Test
    public void testGetLowestInColumn() {
        double[][] array = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0, 7.0, 8.0}
        };
        assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInColumn(array, 0), 0.0001);
        assertEquals(2.0, TwoDimRaggedArrayUtility.getLowestInColumn(array, 1), 0.0001);
        assertEquals(3.0, TwoDimRaggedArrayUtility.getLowestInColumn(array, 2), 0.0001);
    }

    @Test
    public void testGetLowestInArray() {
        double[][] array = {
            {1.5, 2.0},
            {3.0},
            {0.5, 4.0, 5.0}
        };
        assertEquals(0.5, TwoDimRaggedArrayUtility.getLowestInArray(array), 0.0001);
    }

    @Test
    public void testReadAndWriteFile() throws Exception {
        double[][] array = {
            {1.0, 2.0},
            {3.0, 4.0},
            {5.0}
        };
        File file = new File("test.txt");

        TwoDimRaggedArrayUtility.writeToFile(array, file);
        double[][] readArray = TwoDimRaggedArrayUtility.readFile(file);

        for (int i = 0; i < array.length; i++) {
            assertArrayEquals(array[i], readArray[i], 0.0001);
        }

        file.delete();
    }
}
