import java.awt.*;
import java.util.Vector;

public class Pensile extends Shape {

    // Vector to store the points of the pencil drawing
    private Vector<Point> points;

    // Boolean to track whether the rectangle is dotted (dashed) or not	
	private boolean dottedState;

    // Default constructor
    public Pensile() {
        super();           // Calls the default constructor of the Shape class
        points = new Vector<>(); // Initializes the Vector to store points
    }

    // Parameterized constructor to initialize the pencil's position and color
    public Pensile(int p1, int p2, int p3, int p4, int c) {
        super(p1, p2, p3, p4, c); // Calls the parameterized constructor of the Shape class
        points = new Vector<>();  // Initializes the Vector to store points
    }

    // Method to add a point to the Vector
    public void addPoint(int x, int y) {
        points.add(new Point(x, y)); // Adds a new Point with coordinates (x, y)
    }

    // Method to set the dotted state of the line
    void setDotted(boolean state) {
        dottedState = state; 
    }

    // Method to get the current dotted state of the line
    boolean getDotted() {
        return dottedState; 
    }

    // Method to draw the pencil strokes on the screen
    public void drawShape(Graphics g) {

        // Set the color based on the current color state
        if (super.getColor() == GREEN_COLOR) {
            g.setColor(Color.GREEN);
        } else if (super.getColor() == BLUE_COLOR) {
            g.setColor(Color.BLUE);
        } else if (super.getColor() == RED_COLOR) {
            g.setColor(Color.RED);
        } else {
            // Do nothing if color is not set to a known value
        }
		
		if(dottedState) {
            drawDottedLines(g);			
		}
		else {
			// Draw lines connecting each pair of consecutive points
			for (int i = 0; i < points.size() - 1; i++) {
				Point p1 = points.get(i);       // Get the first point of the pair
				Point p2 = points.get(i + 1);   // Get the second point of the pair
				g.drawLine(p1.x, p1.y, p2.x, p2.y); // Draw a line between the two points
			}
		}
    }
	
   // Method to draw dotted lines between points
    private void drawDottedLines(Graphics g) {
		
		// Cast the Graphics object to Graphics2D
		Graphics2D g2d = (Graphics2D) g;

		// Define the dash pattern (dashLength, gapLength)
		float[] dashPattern = {10, 10}; // Dash of 10 pixels and gap of 10 pixels

		// Create a BasicStroke with the dash pattern
		g2d.setStroke(new BasicStroke(
			2, // Line thickness (you can adjust this value)
			BasicStroke.CAP_BUTT, // End-cap style
			BasicStroke.JOIN_BEVEL, // Line join style
			0, // Miter limit (used for JOIN_MITER style)
			dashPattern, // The dash pattern
			0 // Dash phase (shift dash pattern start)
		));

		// Draw the dotted line segments
		for (int i = 0; i < points.size() - 1; i++) {
			Point p1 = points.get(i);
			Point p2 = points.get(i + 1);
			g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
		}
    }	
}
