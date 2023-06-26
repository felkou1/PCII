/**
 * Cette classe permet de g�rer le fl�trissement des fleurs de la carte.
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
	 * La dur�e de vie maximale d'une fleur.
	 */
	private int dureedevie;
	
	/**
	 * La carte sur laquelle sont plac�es les fleurs.
	 */
	private Carte c;

	/**
	 * Constructeur de la classe SeFane.
	 * @param dureedevie La dur�e de vie maximale d'une fleur.
	 */
	public SeFane(int dureedevie) {
		this.dureedevie =dureedevie;
	}
	
	/**
	 * Constructeur de la classe SeFane.
	 * @param c La carte sur laquelle sont plac�es les fleurs.
	 */
	public SeFane(Carte c) {
		this.c=c;
	}

	/**
	 * M�thode appel�e lors de l'ex�cution du processus.
	 * Parcourt la liste des fleurs de la carte et supprime celles qui ont d�pass� leur dur�e de vie maximale.
	 */
	public void run() {
	    while (true) {
	        try {
	            Thread.sleep(10000); // Pause de 10 secondes
	            Iterator<Fleurmodele> iterator = c.gerfleurs().iterator();
	            while (iterator.hasNext()) {
	                Fleurmodele fleur = iterator.next();
	                if (fleur.getAge() > 200) { // Si la fleur a d�pass� sa dur�e de vie maximale
	                    c.sefane(); // La fleur est supprim�e de la carte
	                }
	            }
	        } catch (Exception e) { // En cas d'erreur
	            e.printStackTrace(); // Affichage de la pile d'erreurs
	        }
	    }
	}

}
