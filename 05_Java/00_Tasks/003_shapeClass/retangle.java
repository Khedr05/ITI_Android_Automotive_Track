package shape;
public class retangle extends shape
{
	private double dim2;
	
	public void setDim2(double dim)
	{
		dim2 = dim;
	}
	
	public double getDim2()
	{
		return dim2;
	}
	
	public retangle()
	{
		super();
	}
	
	public double calcArea()
	{
		return super.getDim1() * getDim2();
	}
}