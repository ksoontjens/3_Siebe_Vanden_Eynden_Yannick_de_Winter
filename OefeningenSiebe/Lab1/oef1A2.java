public class oef1A2
{
	public static void main (String arg[])
	{
		weekdagen();
	}
	public static void weekdagen()
	{
		int weekdag = 0;
		int x;
		for(x=0; x<=28; x++)
		{
			if(weekdag==0)
			{
				System.out.print("zon");
			}
			if(weekdag==1)
			{
				System.out.print("maan");
			}
			if(weekdag==2)
			{
				System.out.print("dins");
			}
			if(weekdag==3)
			{
				System.out.print("woens");
			}
			if(weekdag==4)
			{
				System.out.print("donder");
			}
			if(weekdag==5)
			{
				System.out.print("vrij");
			}
			if(weekdag==6)
			{
				System.out.print("zater");
			}
	
			weekdag++;
			if(weekdag>6) weekdag = 0;
			
			System.out.println("dag " + x + " februari 2009");
		}
	}
}