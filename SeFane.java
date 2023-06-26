/**
 * Cette classe permet de gérer le flétrissement des fleurs de la carte.
 * @author IKHELEF Mounia
 * @author TADJIN Amina
 * @author El Kouch Fadwa
 */
package control;

import java.util.Iterator;

import modele.Fleurmodele;
import view.Carte;

public class SeFane extends Thread{

	// Attributes //

	/**
	 * La durée de vie maximale d'une fleur.
	 */
	private int dureedevie;
	
	/**
	 * La carte sur laquelle sont placées les fleurs.
	 */
	private Carte c;

	/**
	 * Constructeur de la classe SeFane.
	 * @param dureedevie La durée de vie maximale d'une fleur.
	 */
	public SeFane(int dureedevie) {
		this.dureedevie =dureedevie;
	}
	
	/**
	 * Constructeur de la classe SeFane.
	 * @param c La carte sur laquelle sont placées les fleurs.
	 */
	public SeFane(Carte c) {
		this.c=c;
	}

	/**
	 * Méthode appelée lors de l'exécution du processus.
	 * Parcourt la liste des fleurs de la carte et supprime celles qui ont dépassé leur durée de vie maximale.
	 */
	public void run() {
	    while (true) {
	        try {
	            Thread.sleep(10000); // Pause de 10 secondes
	            Iterator<Fleurmodele> iterator = c.gerfleurs().iterator();
	            while (iterator.hasNext()) {
	                Fleurmodele fleur = iterator.next();
	                if (fleur.getAge() > 200) { // Si la fleur a dépassé sa durée de vie maximale
	                    c.sefane(); // La fleur est supprimée de la carte
	                }
	            }
	        } catch (Exception e) { // En cas d'erreur
	            e.printStackTrace(); // Affichage de la pile d'erreurs
	        }
	    }
	}

}
