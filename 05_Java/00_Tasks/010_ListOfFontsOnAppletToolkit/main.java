import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Font;

public class main extends Applet {

    private String[] allFonts; 

    public void init() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        allFonts = toolkit.getFontList();
    }

    public void paint(Graphics g) {
        int y = 20;

        for (String fontName : allFonts) {
            Font font = new Font(fontName, Font.PLAIN, 12);
            g.setFont(font);
            g.drawString(fontName, 50, y);
            y += 15;
        }
    }
}
