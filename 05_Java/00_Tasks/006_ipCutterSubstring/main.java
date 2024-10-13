class IpCutter
{
    public static void main(String[] args) 
	{
        int index = 0;
        int prvindex = 0;
        
        while (index != -1) 
		{
            index = args[0].indexOf('.', index);
            if (index != -1) 
			{
                System.out.println(args[0].substring(prvindex, index));
                prvindex = index + 1;
                index++;
            }
			if(index == -1)
				System.out.println(args[0].substring(prvindex));
        }
    }
}
