package classes;
public class parent
{
	private int no1;
	private int no2;
	
	public void setNo1(int no)
	{
		no1 = no;
	}
	
	public void setNo2(int no)
	{
		no2 = no;
	}
	
	public int getNo1()
	{
		return no1;
	}
	
	public int getNo2()
	{
		return no2;
	}
	
	public int sum()
	{
		return no1+no2;
	}
	
	public parent()
	{
		System.out.println("default parent");
	}
	
}