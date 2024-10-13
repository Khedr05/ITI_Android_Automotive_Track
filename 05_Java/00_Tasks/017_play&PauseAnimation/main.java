import java.applet.Applet;
import java.awt.Graphics;
import java.awt.*;
import java.awt.event.*;

public class main extends Applet implements Runnable
{
	int x = 0;
	int y = 0;
	boolean xFlag = false;
	boolean yFlag = false;
	boolean firstStartFlag = false;
	
	Thread th;
	public void init(){
	th = new Thread(this);
		
	Button startBtn;	
	Button pauseBtn;
	
	startBtn = new Button("Start");
	startBtn.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ev)
		{
			if(firstStartFlag == false)
			{
				th.start();
				firstStartFlag = true;
			}
			else if(firstStartFlag == true)
			{
				th.resume();
			}
		}
	});
	add(startBtn);
	
	pauseBtn = new Button("Pause");
	pauseBtn.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent ev)
		{
			th.suspend();
		}
	});
	add(pauseBtn);
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