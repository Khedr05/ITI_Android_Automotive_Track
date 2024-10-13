class calc
{
	public static void main(String args[])
	{
		if(args.length == 3)
		{
			
			float op1 = Float.parseFloat(args[0]);
			float op2 = Float.parseFloat(args[2]);
			switch(args[1])
			{
				case "+":
				{
					System.out.println(op1 + " " + args[1] + " " + op2 + " = " + (op1+op2));
					break;
				}
				case "-":
				{
					System.out.println(op1 + " " + args[1] + " " + op2 + " = " + (op1-op2));
					break;
				}
				case "x":
				{
					System.out.println(op1 + " " + args[1] + " " + op2 + " = " + (op1*op2));
					break;
				}
				case "/":
				{
					if(op2 == 0)
					System.out.println("Operand Number Two Is Equal Zero Cant Divide It");
					else
					System.out.println(op1 + " " + args[1] + " " + op2 + " = " + (op1/op2));
					break;
				}
				default :
				{
					System.out.println("Invalid Operator Enter One Of This (+,-,/,x)");
				}
			}
		}
		else
		{
			System.out.println("Invalid Number Of Args You Must Enter Equation Like This operand operator operand ex:10 + 20");
		}
	}
}