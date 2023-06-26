/**

* Cette classe AjouterLapin permet d'ajouter r�guli�rement un lapin � la carte en lan�ant un thread.
* @author IKHELEF Mounia, TADJIN Amina, El Kouch Fadwa
*/
package control;

import view.Carte;

public class AjouterLapin extends Thread{

	// Attributes //

	private Carte c;
	
	/**
	 * Constructeur de la classe AjouterLapin qui prend en param�tre un objet de type Carte.
	 * @param c Objet de type Carte qui repr�sente la carte du jeu.
	 */
	public AjouterLapin(Carte c) {
		this.c = c;
	}
	
    @Override
	public void run() {
    	// Ajouter un lapin toute les secondes
        while(true ){
	            try {Thread.sleep(10000); 
	            		this.c.creerlapin();
	            }catch (Exception e) { e.printStackTrace(); } 
        }

    }
}