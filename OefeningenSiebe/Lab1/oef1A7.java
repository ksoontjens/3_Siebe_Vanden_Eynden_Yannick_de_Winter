public class oef1A7 {

	public static void main (String arg[])
	{
		int getallen[] = {12,34,56,78,123,234,99,88};
		
		int gesorteerd[] = descending(getallen);

		int i = 0;
		for(i=0; i<gesorteerd.length; i++) {
			System.out.println(gesorteerd[i]);
		}
	}
	
	public static int[] maxGet(int[] getallen)
	{
		int grootste = 0;
		int plaats = 0;
		int i = 0;		

		for(i = 0; i<getallen.length; i++)
		{
			if(getallen[i] > grootste)
			{
				grootste = getallen[i];
				plaats = i;
			}
		}

		int[] resultaat;
		resultaat = new int[2];
		resultaat[0] = plaats;
		resultaat[1] = grootste;
		
		return resultaat;
	}

	public static int[] descending (int[] getallen)
	{
		int[] gesorteerd;
		gesorteerd= new int[8];
		int i = 0;
		
		for(i = 0; i < getallen.length; i++)
		{
			int resultaten[] = grootsteItem(getallen);
			gesorteerd[i] = resultaten[1];
			getallen[resultaten[0]] = 0;
		}

		return gesorteerd;
	}


}