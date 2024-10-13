import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class main extends Applet{
    int x1 = 0;
    int y1 = 0;
    int x2 = 0;
    int y2 = 0;

    public void init(){
        addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent ev){
                x1 = ev.getX();
                y1 = ev.getY();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseDragged(MouseEvent ev){
                x2 = ev.getX();
                y2 = ev.getY();
                repaint();
            }
        });
    }

    public void paint(Graphics g){
        g.setColor(Color.GREEN);
        g.drawLine(x1, y1, x2, y2);
    }
}
