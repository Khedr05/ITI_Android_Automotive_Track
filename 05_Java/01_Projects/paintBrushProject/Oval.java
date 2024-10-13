import java.awt.*;

public class Oval extends Shape {

    // Constants for draw modes
    public static final int UNSOLID_DRAW_MODE = 0; // Non-solid (outline) draw mode
    public static final int SOLID_DRAW_MODE = 1;   // Solid (filled) draw mode

    // Boolean to track whether the oval is solid (filled) or not
    private boolean solidState;
    // Boolean to track whether the oval is dotted (dashed) or not	
    private boolean dottedState;	

    // Default constructor
    public Oval() {
        super(); // Calls the default constructor of the Shape class
    }

    // Parameterized constructor to initialize the oval's position, color, and solid state
    public Oval(int p1, int p2, int p3, int p4, int c, boolean solid) {
        super(p1, p2, p3, p4, c); // Calls the parameterized constructor of the Shape class
        solidState = solid;       // Set the solid state (true for solid, false for outline)
    }

    // Setter method to update the solid state of the oval
    void setSolid(boolean state) {
        solidState = state;
    }

    // Getter method to retrieve the solid state of the oval
    boolean getSolid() {
        return solidState;
    }

    // Method to set the dotted state of the line
    void setDotted(boolean state) {
        dottedState = state; 
    }

    // Method to get the current dotted state of the line
    boolean getDotted() {
        return dottedState; 
    }

    // Method to draw the oval shape on the screen
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

        // Calculate the width and height based on the coordinates
        int x = Math.min(super.getParam1(), super.getParam3());
        int y = Math.min(super.getParam2(), super.getParam4());
        int width = Math.abs(super.getParam3() - super.getParam1());
        int height = Math.abs(super.getParam4() - super.getParam2());

        // Draw the oval based on the solid state
        if (solidState) {
            g.fillOval(x, y, width, height); // Draw a filled oval	
        }
		else if(dottedState) {
            drawDottedOval(g, x, y, width, height);		
		}			
		else {
            g.drawOval(x, y, width, height); // Draw an outlined oval
        }
    }
	
	// Method to draw a dotted oval
	private void drawDottedOval(Graphics g, int x, int y, int width, int height) {
		// Convert Graphics to Graphics2D
		Graphics2D g2d = (Graphics2D) g;
		
		// Save the current state of the Graphics2D object
		Object oldStroke = g2d.getStroke();

		// Set the dash pattern: 10-pixel dash followed by 10-pixel gap
		float[] dashPattern = {10.0f, 10.0f};

		// Set the stroke with the dash pattern
		g2d.setStroke(new BasicStroke(
			2, // Line thickness (adjust as needed)
			BasicStroke.CAP_BUTT, // Flat end caps for dashes
			BasicStroke.JOIN_BEVEL, // Beveled joins between segments
			0, // Miter limit (not used with beveled joins)
			dashPattern, // Dash pattern: 10px dash, 10px gap
			0 // Dash phase (starts at the beginning of the pattern)
		));

		// Draw the oval with the dashed stroke
		g2d.drawOval(x, y, width, height);
		
		// Restore the original stroke
		g2d.setStroke((Stroke) oldStroke);
	}

}
