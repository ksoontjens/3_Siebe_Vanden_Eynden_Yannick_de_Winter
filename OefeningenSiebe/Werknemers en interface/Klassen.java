public class Klassen
{
	public static void main (String args[])
	{
		Werknemer jan;
		jan = new Werknemer("Jan", "Janssens", 1, 20.0f);

		Werknemer tom = new Werknemer("Tom", "Tommens", 3, 2000.0f);
		Werknemer rudy = new Werknemer("Rudy", "Verboce", 4, 1850.0f);
		Werknemer herman = new Werknemer("Herman", "Hermans", 2, 30.0f);
		PartTimeWerknemer pol = new PartTimeWerknemer("Pol", "Pollens", 5, 1500.0f, 22);
		PartTimeWerknemer kak = new PartTimeWerknemer("Kak", "kak", 6, 1200.0f, 16);
		
		jan.salarisVerhogen(10);
		herman.salarisVerhogen(10);

		pol.salarisVerhogen(2);

		System.out.println(jan.voornaam + " verdient " + jan.getSalaris());
		System.out.println(herman.voornaam + " verdient " + herman.getSalaris());
		System.out.println(tom.voornaam + " verdient " + tom.getSalaris());
		System.out.println(rudy.voornaam + " verdient " + rudy.getSalaris());

		System.out.println(pol.voornaam + " verdient " + pol.getSalaris() + " en heeft " + pol.urenGewerkt + " uren gewerkt.");
		System.out.println(kak.voornaam + " verdient " + kak.getSalaris() + " en heeft " + kak.urenGewerkt + " uren gewerkt.");

		System.out.println("Het RSZ-percentage van Jan is " + jan.getRSZ());
		System.out.println("Het RSZ-percentage van Pol is " + pol.getRSZ());
		System.out.println("Het RSZ-percentage van kak is " + kak.getRSZ());

		kak.setRSZ(15);

		System.out.println("Het RSZ-percentage van kak is " + kak.getRSZ());

		StudentWerknemer yannick = new StudentWerknemer("Yannick", "DW", 7, 2000.0f, 24);
		System.out.println(yannick.voornaam + " verdient " + yannick.getSalaris() + ", heeft " + yannick.urenGewerkt + " uren gewerkt. En betaalt een RSZ van " + yannick.getRSZ() + "%.");

		Factuur factuur1 = new Factuur(1, 100.0f);

		Betaalbaar[] BetDingen = new Betaalbaar[2];
		BetDingen[0] = jan;
		BetDingen[1] = factuur1;

		for(int i = 0; i<2; i++)
		{
			BetDingen[i].betaal();
		}
		System.out.println("aantal werknemers = " + Werknemer.aantalWerknemers);
	}
}