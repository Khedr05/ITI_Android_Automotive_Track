package shape;
abstract public class shape
{
	private double dim1;
	
	public void setDim1(double dim)
	{
		dim1 = dim;
	}
	
	public double getDim1()
	{
		return dim1;
	}
	
	abstract public double calcArea();
	
	public shape()
	{
		System.out.println("shape constractor");
	}
}
