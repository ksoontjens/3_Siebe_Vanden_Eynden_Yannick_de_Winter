public class PartTimeWerknemer extends Werknemer
{
	int urenGewerkt;
	public PartTimeWerknemer(String voornaam, String achternaam, int wNummer, float salaris, int urenGw)
	{
		super(voornaam, achternaam, wNummer, salaris);
		urenGewerkt = urenGw;
	}
	
	public void salarisVerhogen(int percentage)
	{
		if(percentage > 5)
		{
			System.err.println("Max 5 %");
		}
		else
		{
			super.salarisVerhogen(percentage);
		}
	}
}