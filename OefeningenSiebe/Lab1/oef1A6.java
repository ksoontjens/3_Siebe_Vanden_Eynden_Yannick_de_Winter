public class oef1A6
{
	public static void main (String arg[])
	{
		int getallen[] = {12,34,56,78,123,234,99,88};
		maxGet(getallen);
	}

	public static void maxGet(int[] getallen)
	{
		int grootste = 0;
		int i = 0;		

		for(i = 0; i < getallen.length; i++)
		{
			if(getallen[i] > grootste)
			{
				grootste = getallen[i];
			}
		}
		System.out.println("Grootste getal van de reeks is " + grootste);
	}
}