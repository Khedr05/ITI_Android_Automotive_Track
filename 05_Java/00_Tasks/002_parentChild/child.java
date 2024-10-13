package classes;
public class child extends parent
{
	private int no3;
	
	public void setNo3(int no)
	{
		no3 = no;
	}
		
	public int getNo3()
	{
		return no3;
	}
	
	public int sum()
	{
		return super.sum()+no3;
	}
	
	public child()
	{
		super();
		System.out.println("default child");
	}
	
}