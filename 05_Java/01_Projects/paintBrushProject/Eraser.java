import java.awt.*;

public class Eraser extends Shape {

    private int size; // Size of the eraser

    // Default constructor
    public Eraser() {
        super();             // Calls the default constructor of the Shape class
        this.size = 20;      // Sets the default size of the eraser
        setColor(WHITE_COLOR); // Sets the color of the eraser to white
    }

    // Parameterized constructor to initialize the eraser's size
    public Eraser(int size) {
        super();             // Calls the default constructor of the Shape class
        this.size = size;    // Sets the size of the eraser
        setColor(WHITE_COLOR); // Sets the color of the eraser to white
    }

    // Method to set the size of the eraser
    public void setSize(int size) {
        this.size = size;
    }

    // Method to get the current size of the eraser
    public int getSize() {
        return size;
    }

    // Method to draw the eraser on the canvas
    public void drawShape(Graphics g) {
        g.setColor(Color.WHITE); // Sets the color to white for erasing
        // Draw a filled rectangle to represent the eraser
        g.fillRect(getParam1() - size / 2, getParam2() - size / 2, size, size);
    }
}
