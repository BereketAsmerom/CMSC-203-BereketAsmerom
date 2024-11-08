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

public class Plot {
    private int x;
    private int y;
    private int width;
    private int depth;

    // Default constructor
    public Plot() {
        this.x = 0;
        this.y = 0;
        this.width = 1;
        this.depth = 1;
    }

    // Copy constructor
    public Plot(Plot p) {
        this.x = p.x;
        this.y = p.y;
        this.width = p.width;
        this.depth = p.depth;
    }

    // Parameterized constructor
    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    // Method to check if this plot overlaps with another plot
    public boolean overlaps(Plot p) {
        if (this.x + this.width <= p.x || p.x + p.width <= this.x) {
            return false;
        }
        if (this.y + this.depth <= p.y || p.y + p.depth <= this.y) {
            return false;
        }
        return true;
    }

    // Method to check if this plot encompasses another plot
    public boolean encompasses(Plot p) {
        return p.x >= this.x && p.y >= this.y &&
               (p.x + p.width) <= (this.x + this.width) &&
               (p.y + p.depth) <= (this.y + this.depth);
    }

    // Getters and setters
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    // Updated toString method to match expected output in test
    @Override
    public String toString() {
        return x + "," + y + "," + width + "," + depth;
    }
}
