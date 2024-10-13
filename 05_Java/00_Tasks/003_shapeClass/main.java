package shape;
class Main
{
	public static double sumArea(shape s1,shape s2,shape s3)
	{
		return s1.calcArea() + s2.calcArea() + s3.calcArea();
	}
	
	public static void main(String[] args)
	{
		shape c = new circle();
		triangle t = new triangle();
		retangle r = new retangle();
			
		c.setDim1(5);
		t.setDim1(5);
		t.setDim2(10);	
		r.setDim1(5);
		r.setDim2(10);	
		
		System.out.println("area of circle = "+c.calcArea());
		System.out.println("area of triangle = "+t.calcArea());
		System.out.println("area of retangle = "+r.calcArea());
		
		System.out.println("Sum of area = "+sumArea(c,t,r));
	}	
}
