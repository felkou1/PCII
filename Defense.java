/**

* Cette classe permet de creer un thread qui lance la methode "defense" de la classe "Carte" en boucle infinie pour que les d�fenses soient r�guli�rement mises � jour.
* @author IKHELEF Mounia, TADJIN Amina, El Kouch Fadwa
*/
package control;

import view.Carte;

public class Defense extends Thread{
	
	public Carte c;
	
	/**
	 * Constructeur de la classe Defense prenant en param�tre une instance de la classe "Carte".
	 * @param c Instance de la classe "Carte".
	 */
	public Defense(Carte c) {
		this.c = c;
	}
	/**
	 * M�thode permettant de lancer la m�thode "defense" de la classe "Carte" en boucle infinie pour que les d�fenses soient r�guli�rement mises � jour.
	 */
	public void run() {
		while(true ){
	           try {Thread.sleep(10000); 
	            	this.c.defense();
	        }catch (Exception e) { e.printStackTrace(); }
		}
	}
}
