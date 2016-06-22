public class oef1A4
{
	public static void main (String arg[])
	{
		neg(4302);
	}

	public static void neg(int getal)
	{
		getal = ~getal;
		getal += 1;

		System.out.println(getal);
	}
}