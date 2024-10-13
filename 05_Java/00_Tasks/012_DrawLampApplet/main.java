import java.awt.*;
import java.applet.*;

public class main extends Applet {
    public void paint(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillOval(100, 50, 200, 50);

        g.setColor(Color.BLACK);
        g.drawOval(100, 50, 200, 50);

        g.drawLine(100, 75, 75, 200);
        g.drawLine(300, 75, 325, 200);
        g.drawArc(75, 190, 250, 20, 0, -180);

        g.setColor(Color.YELLOW);
        g.fillOval(170, 110, 50, 90);
        g.fillOval(110, 110, 40, 80);
        g.fillOval(250, 110, 40, 80);

        g.setColor(Color.BLACK);
        g.drawOval(170, 110, 50, 90);
        g.drawOval(110, 110, 40, 80);
        g.drawOval(250, 110, 40, 80);

        g.drawLine(190, 210, 170, 300);
        g.drawLine(210, 210, 230, 300);

        g.drawRect(100, 300, 200, 20);
    }
}
