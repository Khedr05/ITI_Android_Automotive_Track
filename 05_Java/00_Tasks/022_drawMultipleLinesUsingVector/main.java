import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class main extends Applet{
 
    int lineCounter = 0;
    Vector<Line> linesVector = new Vector<>();

    public void init(){
		    		
        addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent ev){
                Line newLine = new Line();
                newLine.setX1(ev.getX());
                newLine.setY1(ev.getY());
                linesVector.add(newLine);
               // repaint();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseDragged(MouseEvent ev){
                Line currentLine = linesVector.get(lineCounter);
                if (currentLine != null){
                    currentLine.setX2(ev.getX());
                    currentLine.setY2(ev.getY());
                    repaint();
                }
            }
        });
		
        addMouseListener(new MouseAdapter(){
            public void mouseReleased(MouseEvent ev){
                Line currentLine = linesVector.get(lineCounter);
                currentLine.setX2(ev.getX());
                currentLine.setY2(ev.getY());
                lineCounter++;
                repaint();
            }
        });		
    }

    public void paint(Graphics g){
        g.setColor(Color.GREEN);
        for (int i = 0; i < linesVector.size(); i++){
            Line line = linesVector.get(i);
            g.drawLine(line.getX1(), line.getY1(), line.getX2(), line.getY2());
        }
    }
	
    class Line{
        private int x1 = 0;
        private int y1 = 0;
        private int x2 = 0;
        private int y2 = 0;
		
        public void setX1(int x){
            x1 = x;
        }
        public void setX2(int x){
            x2 = x;
        }		
        public void setY1(int y){
            y1 = y;
        }	
        public void setY2(int y){
            y2 = y;
        }
		
        public int getX1(){
            return x1;
        }
        public int getX2(){
            return x2;
        }
        public int getY1(){
            return y1;
        }
        public int getY2(){
            return y2;
        }
    }
}
