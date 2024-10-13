import java.applet.Applet;
import java.awt.Graphics;
import java.awt.*;
import java.awt.event.*;

public class main extends Applet
{
    int x;
    Button incBtn;
    Button decBtn;

    public void init()
    {
        incBtn = new Button("Increment");
        incBtn.addActionListener(ev -> {
            x++;
            repaint();
        });
        add(incBtn);

        decBtn = new Button("Decrement");
        decBtn.addActionListener(ev -> {
            if (x != 0) x--;
            repaint();
        });
        add(decBtn);
    }

    public void paint(Graphics g)
    {
        g.drawString("Click Count is: " + x, 200, 150);
    }
}
