public class oef1A5
{
	public static void main (String arg[])
	{
		priemen(100);
	}
	
	public static void priemen(int max_getal)
	{
		boolean isPriem = true;
		int getal;
		for(getal=3; getal < max_getal; getal++)
		{
			isPriem = true;
			float deler;
			for(deler=1.0f; deler<getal; deler++)
			{
				if(getal%deler == 0)
				{
					if(deler != 1 && deler != getal) {
						isPriem = false;
					}
				}
			}
			if(isPriem)
			{
				System.out.println(getal);
			}

		}
	}
}