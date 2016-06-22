/**
*
* Dit is een programma
*
* @author Siebe Vanden Eynden
*
*/


public class EersteProg
{
  /**
  * Dit is de main methode
  *
  * @param arg[] Parameters van commandline
  */

  public static void main (String arg [])
  {
    afdrukken(100);
  }

  /**
  * Getal afdrukken, zeker dat!
  *
  * @param m Af te drukken waarde
  */
  public static void afdrukken(int m) 
  {
    int a;
    for(a=0; a<m; a++)
    {
      System.out.println(a);
    }

    System.out.println(~10);
  }
}