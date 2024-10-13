import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

// Main class extending Applet to create a paintbrush application
public class PaintBrush extends Applet {
	
	
    // Constants for different colors and shapes
    public static final int GREEN_COLOR = 0;
    public static final int BLUE_COLOR = 1;
    public static final int RED_COLOR = 2;

    public static final int LINE_SHAPE = 0;
    public static final int OVAL_SHAPE = 1;
    public static final int RECTANGLE_SHAPE = 2;
    public static final int PENSILE_SHAPE = 3;
    public static final int ERASER_SHAPE = 4;
    public static final int CLEARALL_SHAPE = 5;

    // Constants for different draw modes (normal, solid, dotted)
    public static final int NORMAL_DRAW_MODE = 0;
    public static final int SOLID_DRAW_MODE = 1;
    public static final int DOTTED_DRAW_MODE = 2;

    int eraserSize = 20; // Default size for the eraser

    // Variables to track the current color, shape, and draw mode
    int currentColor = GREEN_COLOR;
    int currentShape = LINE_SHAPE;
    int currentDrawMode = NORMAL_DRAW_MODE;

    // Variable to track the current shape being drawn (-1 means no shape)
    int currentShapeIndex = -1;

    // Vector to store all drawn shapes
    Vector<Shape> shapesVector = new Vector<>();

    // UI components: buttons for colors, shapes, undo, and clear all actions
    Button greenColorButton;
    Button blueColorButton;
    Button redColorButton;
    Button lineShapeButton;
    Button ovalShapeButton;
    Button rectShapeButton;
    Button pensileShapeButton;
    Button eraserShapeButton;
    Button clearAllShapeButton;
    Button undoButton;

    // Checkboxes for toggling solid and dotted draw modes
    Checkbox solidCheckbox;
    Checkbox dottedCheckbox;

    // Initialization method where UI components are created and added
    public void init() {
				
		// Create a panel to hold all components in a horizontal layout (top bar)
		Panel topBarPanel = new Panel(new FlowLayout(FlowLayout.LEFT));

		// Label for color selection
		Label colorLabel = new Label("Colors:");
		topBarPanel.add(colorLabel);

		// Color buttons with colors applied
		greenColorButton = new Button("Green");
		greenColorButton.setBackground(Color.GREEN);
		greenColorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				currentColor = GREEN_COLOR; 
			}
		});
		topBarPanel.add(greenColorButton);

		blueColorButton = new Button("Blue");
		blueColorButton.setBackground(Color.BLUE);
		blueColorButton.setForeground(Color.WHITE);
		blueColorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				currentColor = BLUE_COLOR; 
			}
		});
		topBarPanel.add(blueColorButton);

		redColorButton = new Button("Red");
		redColorButton.setBackground(Color.RED);
		redColorButton.setForeground(Color.WHITE);
		redColorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				currentColor = RED_COLOR; 
			}
		});
		topBarPanel.add(redColorButton);

		// Label for shape selection
		Label shapeLabel = new Label("Shapes:");
		topBarPanel.add(shapeLabel);

		// Shape buttons
		pensileShapeButton = new Button("Pencil");
		pensileShapeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				currentShape = PENSILE_SHAPE; 
			}
		});
		topBarPanel.add(pensileShapeButton);

		lineShapeButton = new Button("Line");
		lineShapeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				currentShape = LINE_SHAPE; 
			}
		});
		topBarPanel.add(lineShapeButton);

		ovalShapeButton = new Button("Oval");
		ovalShapeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				currentShape = OVAL_SHAPE; 
			}
		});
		topBarPanel.add(ovalShapeButton);

		rectShapeButton = new Button("Rectangle");
		rectShapeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				currentShape = RECTANGLE_SHAPE; 
			}
		});
		topBarPanel.add(rectShapeButton);

		eraserShapeButton = new Button("Eraser");
		eraserShapeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				currentShape = ERASER_SHAPE; 
			}
		});
		topBarPanel.add(eraserShapeButton);

		undoButton = new Button("Undo");
		undoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				if (!shapesVector.isEmpty()) {
					shapesVector.removeElementAt(shapesVector.size() - 1);
					repaint();
				}
			}
		});
		topBarPanel.add(undoButton);

		clearAllShapeButton = new Button("Clear All");
		clearAllShapeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				ClearAll newClear = new ClearAll();
				shapesVector.add(newClear);
				newClear.setAppletWidth(getWidth());
				newClear.setAppletHeight(getHeight());
				Graphics g = getGraphics(); 
				newClear.drawShape(g); 
				shapesVector.clear();
			}
		});
		topBarPanel.add(clearAllShapeButton);

		// Label for mode selection
		Label modeLabel = new Label("Modes:");
		topBarPanel.add(modeLabel);

		// Mode checkboxes
		solidCheckbox = new Checkbox("Solid Mode");
		solidCheckbox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ev) {
				if (solidCheckbox.getState()) {
					currentDrawMode = SOLID_DRAW_MODE; 
				} else {
					currentDrawMode = NORMAL_DRAW_MODE; 
				}
			}
		});
		topBarPanel.add(solidCheckbox);

		dottedCheckbox = new Checkbox("Dotted Mode");
		dottedCheckbox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ev) {
				if (dottedCheckbox.getState()) {
					currentDrawMode = DOTTED_DRAW_MODE; 
				} else {
					currentDrawMode = NORMAL_DRAW_MODE; 
				}
			}
		});
		topBarPanel.add(dottedCheckbox);

		// Add the top bar panel to the applet
		setLayout(new BorderLayout());
		add(topBarPanel, BorderLayout.NORTH);


        // Add mouse listener for handling mouse events
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent ev) {
                // Handle mouse press events for different shapes
                if (currentShape == LINE_SHAPE) {
                    Line newLine = new Line();
                    newLine.setColor(currentColor); // Set line color
                    newLine.setDotted(currentDrawMode == DOTTED_DRAW_MODE); // Set dotted mode
                    newLine.setParam1(ev.getX()); // Set start point X
                    newLine.setParam2(ev.getY()); // Set start point Y
                    shapesVector.add(newLine); // Add line to vector
                    currentShapeIndex = shapesVector.size() - 1; // Update current shape index
                } else if (currentShape == OVAL_SHAPE) {
                    Oval newOval = new Oval();
                    newOval.setColor(currentColor); // Set oval color
                    newOval.setSolid(currentDrawMode == SOLID_DRAW_MODE); // Set solid mode
					newOval.setDotted(currentDrawMode == DOTTED_DRAW_MODE); // Set dotted mode						
                    newOval.setParam1(ev.getX()); // Set start point X
                    newOval.setParam2(ev.getY()); // Set start point Y
                    shapesVector.add(newOval); // Add oval to vector
                    currentShapeIndex = shapesVector.size() - 1; // Update current shape index
                } else if (currentShape == RECTANGLE_SHAPE) {
                    Rectangle newRectangle = new Rectangle();
                    newRectangle.setColor(currentColor); // Set rectangle color
                    newRectangle.setSolid(currentDrawMode == SOLID_DRAW_MODE); // Set solid mode
					newRectangle.setDotted(currentDrawMode == DOTTED_DRAW_MODE); // Set dotted mode					
                    newRectangle.setParam1(ev.getX()); // Set start point X
                    newRectangle.setParam2(ev.getY()); // Set start point Y
                    shapesVector.add(newRectangle); // Add rectangle to vector
                    currentShapeIndex = shapesVector.size() - 1; // Update current shape index
                } else if (currentShape == PENSILE_SHAPE) {
                    Pensile newPensile = new Pensile();
                    newPensile.setColor(currentColor); // Set pensile color
                    newPensile.addPoint(ev.getX(), ev.getY()); // Add point to pensile
					newPensile.setDotted(currentDrawMode == DOTTED_DRAW_MODE); // Set dotted mode						
                    shapesVector.add(newPensile); // Add pensile to vector
                    currentShapeIndex = shapesVector.size() - 1; // Update current shape index
                } else if (currentShape == ERASER_SHAPE) {
                    Eraser newEraser = new Eraser(eraserSize);
                    newEraser.setParam1(ev.getX()); // Set eraser position X
                    newEraser.setParam2(ev.getY()); // Set eraser position Y
                    shapesVector.add(newEraser); // Add eraser to vector
                    repaint(); // Repaint the applet
                }
            }

            // Handle mouse release events to finalize shapes
            public void mouseReleased(MouseEvent ev) {
                if (currentShape == LINE_SHAPE) {
                    Shape currentLine = shapesVector.get(currentShapeIndex);
                    currentLine.setParam3(ev.getX()); // Set end point X
                    currentLine.setParam4(ev.getY()); // Set end point Y
                    repaint(); // Repaint the applet
                } else if (currentShape == OVAL_SHAPE) {
                    Shape currentOval = shapesVector.get(currentShapeIndex);
                    currentOval.setParam3(ev.getX()); // Set end point X
                    currentOval.setParam4(ev.getY()); // Set end point Y
                    repaint(); // Repaint the applet
                } else if (currentShape == RECTANGLE_SHAPE) {
                    Shape currentRectangle = shapesVector.get(currentShapeIndex);
                    currentRectangle.setParam3(ev.getX()); // Set end point X
                    currentRectangle.setParam4(ev.getY()); // Set end point Y
                    repaint(); // Repaint the applet
                }
            }
        });

        // Add mouse motion listener for handling drag events
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent ev) {
                // Handle mouse drag events for different shapes
                if (currentShape == LINE_SHAPE) {
                    Shape currentLine = shapesVector.get(currentShapeIndex);
                    currentLine.setParam3(ev.getX()); // Update end point X
                    currentLine.setParam4(ev.getY()); // Update end point Y
                    repaint(); // Repaint the applet
                } else if (currentShape == OVAL_SHAPE) {
                    Shape currentOval = shapesVector.get(currentShapeIndex);
                    currentOval.setParam3(ev.getX()); // Update end point X
                    currentOval.setParam4(ev.getY()); // Update end point Y
                    repaint(); // Repaint the applet
                } else if (currentShape == RECTANGLE_SHAPE) {
                    Shape currentRectangle = shapesVector.get(currentShapeIndex);
                    currentRectangle.setParam3(ev.getX()); // Update end point X
                    currentRectangle.setParam4(ev.getY()); // Update end point Y
                    repaint(); // Repaint the applet
                } else if (currentShape == PENSILE_SHAPE) {
                    Pensile currentPensile = (Pensile) shapesVector.get(currentShapeIndex);
                    currentPensile.addPoint(ev.getX(), ev.getY()); // Add point to pensile
                    currentPensile.drawShape(getGraphics()); // Draw pensile
                } else if (currentShape == ERASER_SHAPE) {
                    Eraser currentEraser = new Eraser(eraserSize);
                    currentEraser.setParam1(ev.getX()); // Update eraser position X
                    currentEraser.setParam2(ev.getY()); // Update eraser position Y
                    shapesVector.add(currentEraser); // Add eraser to vector
                    currentEraser.drawShape(getGraphics()); // Draw eraser
                }
            }
        });  
    }



    // Paint method to draw all shapes on the applet
    public void paint(Graphics g) {
        for (Shape shapeToDraw : shapesVector) {
            shapeToDraw.drawShape(g); // Draw each shape in the vector
        }
    }
}
