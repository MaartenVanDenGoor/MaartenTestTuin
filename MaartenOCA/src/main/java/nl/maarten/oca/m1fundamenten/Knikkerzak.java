package nl.maarten.oca.m1fundamenten;


/**
 * De klasse Knikkerzak is een voorbeeldklasse.
 * Met de methoden setVerloren en setGewonnen kan het aantal knikkers worden gewijzigd.
 * Met de methode getAantalKnikkers kan het aantal knikkers worden opgehaald.
 *
 * @author Marko Draisma
 * @version 1.0 05/09/2002
 */

  public class Knikkerzak{

/**
 *  Het attribuut aantalKnikkers verschijnt niet in de Java Documentatie.
 *  Alleen public attributen en methoden worden gedocumenteerd.
 */

  private int aantalKnikkers;


/**
 *  Een standaard knikkerzak met 50 knikkers.
 */

  public Knikkerzak()
  {
    aantalKnikkers = 50;
  }
  
/**
 *  Een knikkerzak met een op te geven aantal knikkers.
 *
 *  @param  aantal      Het aantal knikkers in deze knikkerzak.
 */

  public Knikkerzak(int aantal)
  {
    aantalKnikkers=aantal;
  }
  

/**
 *  Vermeerdert het aantal knikkers in de knikkerzak na een gewonnen partij.
 *
 *  @param  gewonnen    Het aantal knikkers dat in dit potje is gewonnen.
 *
 *  @see    #getAantalKnikkers()
 *  @see    #setVerloren(int)
 */

  public void setGewonnen(int gewonnen)
  {
    aantalKnikkers = aantalKnikkers + gewonnen;
  }
  

/**
 *  Vermindert het aantal knikkers in de knikkerzak na een verloren partij.
 *
 *  @param  verloren    Het aantal knikkers dat in dit potje is verloren.
 *  @see    #getAantalKnikkers()
 *  @see    #setGewonnen(int)
 */

  public void setVerloren(int verloren)
  {
    aantalKnikkers = aantalKnikkers - verloren;
  }

/**
 *  Toont het huidige aantal knikkers in de knikkerzak.
 *
 *  @return Het huidige aantal knikkers in de knikkerzak.
 *  @see    #setGewonnen(int)
 *  @see    #setVerloren(int)
 */

  public int getAantalKnikkers()
  {
    return aantalKnikkers;
  }
  
}