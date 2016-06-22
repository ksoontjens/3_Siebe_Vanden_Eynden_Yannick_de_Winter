public class StudentWerknemer extends PartTimeWerknemer
{
	public StudentWerknemer(String voornaam, String achternaam, int wNummer, float salaris, int urenGw)
	{
		super(voornaam, achternaam, wNummer, salaris, urenGw);
		setRSZ(5.0f);
	}
}