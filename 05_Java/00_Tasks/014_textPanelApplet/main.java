import java.applet.Applet;
import java.awt.Graphics;

public class main extends Applet implements Runnable
{
	int x = -60;
	Thread th;
	public void init(){
	th = new Thread(this);
	th.start();
}

public void paint(Graphics g)
{
	g.drawString("Java World",x,getHeight()/2);
	x++;
	if(x >= getWidth())
		x = -60;
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