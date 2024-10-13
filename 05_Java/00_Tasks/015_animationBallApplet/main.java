import java.applet.Applet;
import java.awt.Graphics;
import java.awt.*;

public class main extends Applet implements Runnable
{
	int x = 0;
	int y = 0;
	boolean xFlag = false;
	boolean yFlag = false;
	
	Thread th;
	public void init(){
	th = new Thread(this);
	th.start();
}

public void paint(Graphics g)
{
	g.setColor(Color.GREEN);
	g.fillOval(x,y,50,50);
	
	if(xFlag == false)
	{
		x++;
		if(x >= getWidth()-50)
		xFlag = true;
	}
	else if(xFlag == true)
	{
		x--;
		if(x <= 0)
		xFlag = false;		
	}
	else
	{
		/* Do Nothing */
	}
	
	if(yFlag == false)
	{
		y++;
		if(y >= getHeight()-50)
		yFlag = true;
	}
	else if(yFlag == true)
	{
		y--;
		if(y <= 0)
		yFlag = false;		
	}
	else
	{
		/* Do Nothing */
	}
}

public void run()
{
	while(true)
	{
		try
		{
			repaint();
			Thread.sleep(10); 
		}
		catch(InterruptedException ie){ie.printStackTrace();}
		}
	}
}