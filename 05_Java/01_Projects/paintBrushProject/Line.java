import java.awt.*;

// Line class extending Shape, represents a drawable line
public class Line extends Shape {

    // Boolean to track whether the line is dotted (dashed) or not	
    private boolean dottedState;

    // Default constructor
    public Line() {
        super(); // Call the superclass (Shape) constructor
    }

    // Parameterized constructor to initialize the line's position and color
    public Line(int p1, int p2, int p3, int p4, int c) {
        super(p1, p2, p3, p4, c); // Call the superclass constructor with parameters
    }

    // Method to set the dotted state of the line
    void setDotted(boolean state) {
        dottedState = state; 
    }

    // Method to get the current dotted state of the line
    boolean getDotted() {
        return dottedState; 
    }

    // Method to draw the line on the screen
    public void drawShape(Graphics g) {    
        // Set the color based on the current color value
        if (super.getColor() == GREEN_COLOR) {
            g.setColor(Color.GREEN);
        } else if (super.getColor() == BLUE_COLOR) {
            g.setColor(Color.BLUE);
        } else if (super.getColor() == RED_COLOR) {
            g.setColor(Color.RED);
        } else {
            // If no matching color, do nothing (default color)
        }
		
		int x1 = super.getParam1();
		int y1 = super.getParam2();
		int x2 = super.getParam3();
		int y2 = super.getParam4();	
	
	
		if(dottedState) {
			
			drawDashedLine(g,x1,y1,x2,y2);
		}
		else {
			// Draw the line from the starting point (param1, param2) to the ending point (param3, param4)
			g.drawLine(x1,y1,x2,y2);  
		}
    }
	
	public void drawDashedLine(Graphics g, int x1, int y1, int x2, int y2) {
		// Create a Graphics2D object from Graphics
		Graphics2D g2d = (Graphics2D) g;
		
		// Save the current state of the Graphics2D object
		Object oldStroke = g2d.getStroke();

		// Set the dash pattern: 5-pixel dash followed by 5-pixel gap
		float[] dashPattern = {10,10};

		// Set the stroke with the dash pattern
		g2d.setStroke(new BasicStroke(
			2, // Line thickness (adjust as needed)
			BasicStroke.CAP_BUTT, // Flat end caps for dashes
			BasicStroke.JOIN_BEVEL, // Beveled joins between line segments
			0, // Miter limit (not used with beveled joins)
			dashPattern, // Dash pattern: 5px dash, 5px gap
			0 // Dash phase (starts at the beginning of the pattern)
		));

		// Draw the dashed line between the two points
		g2d.drawLine(x1, y1, x2, y2);
		
		// Restore the original stroke
		g2d.setStroke((Stroke) oldStroke);
	}

}
