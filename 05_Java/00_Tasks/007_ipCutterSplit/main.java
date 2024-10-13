
class IpCutter 
{
    public static void main(String[] args) 
	{
        String[] ips = args[0].split("\\.");
        
        for (int i = 0; i < ips.length; i++) 
		{
            System.out.println(ips[i]);
        }
    }
}
