package shape;
public class circle extends shape
{
	public circle()
	{
		super();
	}
	
	public double calcArea()
	{
		return super.getDim1() * super.getDim1() * 3.14;
	}
}