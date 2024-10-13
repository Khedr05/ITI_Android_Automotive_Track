package classes;
class Main
{
	public static void main(String[] args)
	{
		child c = new child();
		
		c.setNo1(3);
		c.setNo2(5);
		c.setNo3(2);
		
		int sum = c.sum();
		System.out.println("sum = "+sum);
	}
}
