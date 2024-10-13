import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class main extends Applet{
    
	Font font;

    int x = 180;
    int y = 160;
	
	final int FONT_SIZE = 50;
    final int STEP = 10;
    final int TEXT_WIDTH = 133;
    final int TEXT_HEIGHT = 33; 

    
    public void init(){
		font = new Font("Serif", Font.BOLD, FONT_SIZE); 
        
		addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent ev){
                switch (ev.getKeyCode()){
                    case KeyEvent.VK_UP:
                        if ((y - STEP - TEXT_HEIGHT) >= 0){
                            y -= STEP;  /* Move up */
                        }
                        break;
                    case KeyEvent.VK_DOWN:
                        if ((y + STEP) <= getHeight()){
                            y += STEP;  /* Move down */
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        if ((x + STEP + TEXT_WIDTH) <= getWidth()){
                            x += STEP;  /* Move right */
                        }
                        break;
                    case KeyEvent.VK_LEFT:
                        if ((x - STEP) >= 0){
                            x -= STEP;  /* Move left */
                        }
                        break;
                    default:
                        /* Do nothing */
                        break;
                }
                repaint();
            }
        });
    }

    public void paint(Graphics g){
		g.setFont(font);
        g.setColor(Color.GREEN);
		
		if (x + TEXT_WIDTH > getWidth()){
            x = getWidth() - TEXT_WIDTH;
        }
        if (y > getHeight()){
            y = getHeight();
        }
        g.drawString("JAVA",x,y);
    }
}
