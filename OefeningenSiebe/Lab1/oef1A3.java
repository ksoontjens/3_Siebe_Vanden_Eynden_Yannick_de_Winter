public class oef1A3
{
	public static void main (String arg[])
	{
		geef_mij_pi();
	}
	
	public static void geef_mij_pi()
	{
		double pi = 0;
		int counter;
		int y = 1;
		float som = 0;
		for(counter=0; counter<10000; counter++)
		{
			if(counter%2 == 0)
			{
				som += (1.0f/y);
			}
			else if(counter%2 != 0)
			{
				som -= (1.0f/y);
			}
			y += 2;
		}
		pi = 4*(som);
		System.out.println(pi);
	}
}