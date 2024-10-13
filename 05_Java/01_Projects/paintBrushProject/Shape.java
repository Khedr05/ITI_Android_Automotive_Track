import java.awt.*;

// Abstract class Shape that serves as a base class for different shapes
abstract public class Shape {
    
    // Constants for color types
    public static final int GREEN_COLOR = 0; // Constant representing green color
    public static final int BLUE_COLOR = 1;  // Constant representing blue color
    public static final int RED_COLOR = 2;   // Constant representing red color	
    public static final int WHITE_COLOR = 3; // Default color for clearing the canvas

    // Variables to store the parameters of the shape (e.g., coordinates)
    private int param1;
    private int param2;
    private int param3;
    private int param4;
    
    // Variable to store the color of the shape
    private int color;
    
    // Default constructor
    public Shape() {
        // Default constructor, does nothing
    }
    
    // Parameterized constructor to initialize the shape's position and color
    public Shape(int p1, int p2, int p3, int p4, int c) {
        param1 = p1; // Set the first parameter (e.g., start X coordinate)
        param2 = p2; // Set the second parameter (e.g., start Y coordinate)
        param3 = p3; // Set the third parameter (e.g., end X coordinate)
        param4 = p4; // Set the fourth parameter (e.g., end Y coordinate)
        color = c;   // Set the color of the shape
    }
    
    // Abstract method to be implemented by subclasses for drawing the shape
    abstract public void drawShape(Graphics g);
    
    // Setter methods for the shape parameters
    void setParam1(int p) {
        param1 = p; // Set the first parameter
    }
    
    void setParam2(int p) {
        param2 = p; // Set the second parameter
    }
    
    void setParam3(int p) {
        param3 = p; // Set the third parameter
    }

    void setParam4(int p) {
        param4 = p; // Set the fourth parameter
    }
    
    // Setter method for the color
    void setColor(int colorArg) {
        color = colorArg; // Set the color
    }

    // Getter methods to retrieve the shape parameters
    int getParam1() {
        return param1; // Get the first parameter
    }
    
    int getParam2() {
        return param2; // Get the second parameter
    }

    int getParam3() {
        return param3; // Get the third parameter
    }

    int getParam4() {
        return param4; // Get the fourth parameter
    }
    
    // Getter method to retrieve the color
    int getColor() {
        return color; // Get the color
    }
}
