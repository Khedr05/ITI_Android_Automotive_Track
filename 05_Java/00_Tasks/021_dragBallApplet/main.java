import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class main extends Applet{
    int x1 = 210;
    int y1 = 130;
    int xOffset = 50; 
    int yOffset = 50; 
    int startX, startY;

    public void init(){
        addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent ev){
                startX = ev.getX() - x1;
                startY = ev.getY() - y1;
            }
        });

        addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseDragged(MouseEvent ev){
                x1 = ev.getX() - startX;
                y1 = ev.getY() - startY;
                repaint();
            }
        });
    }

    public void paint(Graphics g){
        g.setColor(Color.GREEN);
        g.fillOval(x1, y1, xOffset, yOffset);
    }
}
