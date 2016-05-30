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

  * @param arg[] Dit zijn parameters die met de commandline meekomen

  */

  public static void main (String arg [])

  {

    drukaf(100);

  }



  /**

  * Deze methode drukt getallen af tot m

  * @param m Deze parameter geeft aan tot welke waarde je gaat afdrukken

  */

  public static void drukaf(int m) 

  {
    int a;
    for(a=0; a<m; a++)
    {

      System.out.println(a);

    }


    System.out.println(~10);

  }


}