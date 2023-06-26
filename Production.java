/**

* Cette classe gère la production de fleurs dans la carte.
* @author IKHELEF Mounia, TADJIN Amina, El Kouch Fadwa
*/
package control;

import view.Carte;

public class Production extends Thread{
	
	  private Carte c;

	  /**
	   * Constructeur de la classe Production.
	   * 
	   * @param c une instance de la classe Carte
	   */
	  public Production(Carte c) {
		  this.c = c;
		  
		}
	  
	  /**
	   * Cette méthode lance la production de fleurs en appelant la méthode production de la classe Carte toutes les 30 secondes.
	   */
	  public void run() {
		    while (true) {
		        try {
		            Thread.sleep(30000); // sleep for 30 seconds
		            this.c.production();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
		}


}
