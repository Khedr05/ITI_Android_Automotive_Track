import java.util.StringTokenizer;

class IpCutter  
{
    public static void main(String[] args) 
	{
        StringTokenizer tokenizer = new StringTokenizer(args[0], ".");

        while (tokenizer.hasMoreTokens()) 
		{
            System.out.println(tokenizer.nextToken());
        }
    }
}
