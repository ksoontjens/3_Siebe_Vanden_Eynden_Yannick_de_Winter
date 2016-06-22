public class oef1A1
{
	public static void main (String arg[])
	{
		tafel();
	}
	public static void tafel()
	{
		int x;
		int y;
		for(x=1; x<10; x++)
		{
			for(y=1; y<10; y++)
			{
				System.out.println(x + " x " + y + " = " + (x*y));
			}
		}
	}
}