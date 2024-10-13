package complex;
class Main
{
	public static void main(String[] args)
	{
		Complex c1 = new Complex(5,2);
		Complex c2 = new Complex(2,6);
		Complex c3 = new Complex();
		
		c3 = c3.sum(c1,c2);
		c3.printComplex();
		c3 = c3.subtract(c1,c2);
		c3.printComplex();		
		
	}
}