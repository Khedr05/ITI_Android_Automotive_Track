import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class main extends Applet{
 
	int lineCounter=0;
	Line[] lineArr = new Line[3];	
    
	public void init() {
		    
		for (int i = 0; i < lineArr.length; i++){
			lineArr[i] = new Line();
		}
		
        addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent ev){
				if(lineCounter < 3){
					lineArr[lineCounter].setX1(ev.getX());
					lineArr[lineCounter].setY1(ev.getY());
					repaint();
				}else{/*Do Nothing */}
            }
        });

        addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseDragged(MouseEvent ev){
				if((lineCounter < 3) && (lineArr[lineCounter] != null)){
                    lineArr[lineCounter].setX2(ev.getX());
                    lineArr[lineCounter].setY2(ev.getY());
                    repaint();
				}else{/*Do Nothing */}
            }
        });
		
        addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent ev){
				if (lineCounter < 3) {
					lineArr[lineCounter].setX2(ev.getX());
					lineArr[lineCounter].setY2(ev.getY());
					lineCounter++; 
					repaint();
				}
			}	
        });		
    }

    public void paint(Graphics g){
        g.setColor(Color.GREEN);
		for(int i=0;((i <= lineCounter) && (i < 3));i++){
			g.drawLine(lineArr[i].getX1(),lineArr[i].getY1(),lineArr[i].getX2(),lineArr[i].getY2());
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


