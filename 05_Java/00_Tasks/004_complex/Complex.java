package complex;

public class Complex
{
	private int real;
	private int imaginary;
	
	public void setReal(int r)
	{
		real = r;
	}
	
	public void setImaginary(int i)
	{
		imaginary = i;
	}
	
	public int getReal()
	{
		return real;
	}
	
	public int getImaginary()
	{
		return imaginary;
	}
	
	public void printComplex()
    {
		if(imaginary > 0)	
			System.out.println(real + "+i" + imaginary);
		else if(imaginary < 0)
			System.out.println(real +""+ imaginary + "i");
		else if(imaginary == 0)
			System.out.println(real);
		
    }
	
	public Complex sum(Complex c1 , Complex c2)
	{
		Complex sum = new Complex();
		sum.real = c1.real + c2.real;
		sum.imaginary = c1.imaginary + c2.imaginary;
		return sum;
	}
	
	public Complex subtract(Complex c1 , Complex c2)
	{
		Complex subtract = new Complex();
		subtract.real = c1.real - c2.real;
		subtract.imaginary = c1.imaginary - c2.imaginary;
		return subtract;
	}
	
	public Complex()
	{
		
	}
	
	public Complex(int r, int i)
    {
        real = r;
        imaginary = i;
    }
}