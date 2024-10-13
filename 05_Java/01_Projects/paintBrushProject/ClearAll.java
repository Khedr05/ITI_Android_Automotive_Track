import java.awt.*;

public class ClearAll extends Shape {

    private int appletWidth;  // Width of the applet (canvas)
    private int appletHeight; // Height of the applet (canvas)

    // Default constructor
    public ClearAll() {
        super();             // Calls the default constructor of the Shape class
        setColor(WHITE_COLOR); // Sets the color to white for clearing the canvas
    }
    
    // Method to set the width of the applet
    public void setAppletWidth(int w) {
        appletWidth = w;
    }
    
    // Method to set the height of the applet
    public void setAppletHeight(int h) {
        appletHeight = h;
    }    

    // Method to get the width of the applet
    int getAppletWidth() {
        return appletWidth;
    }
    
    // Method to get the height of the applet
    int getAppletHeight() {
        return appletHeight;
    }    
    
    // Method to draw the clear shape on the canvas
    public void drawShape(Graphics g) {
        g.setColor(Color.WHITE); // Sets the color to white for clearing
        // Draws a filled rectangle that covers the entire applet area
        g.fillRect(0, 0, getAppletWidth(), getAppletHeight());
    }
}
