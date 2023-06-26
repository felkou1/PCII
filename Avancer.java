/**

* This class represents a thread for moving the character on the game map
* @author IKHELEF Mounia, TADJIN Amina, El Kouch Fadwa
*/
package control;

import java.awt.event.KeyEvent;

import view.Carte;
import view.PanneauControle;

public class Avancer extends Thread {

	// Attributes //

	private Carte c;
	private int vk;

	/**
	 * Constructs an object of the class Avancer
	 * 
	 * @param c the game map object
	 * @param vk the key code for the movement direction
	 */
	public Avancer(Carte c,int vk) {
		this.c =c;
		this.vk = vk;
		Avance();
	}

	/**
	 * Moves the character on the game map in the specified direction
	 */
	private void Avance() {
		if(vk == KeyEvent.VK_UP) {
			c.deplacerhaut();
		
		}
		if(vk == KeyEvent.VK_DOWN) {
			c.deplacerbas();
		
		}
		if(vk == KeyEvent.VK_LEFT) {
			c.deplacergauche();

		}
		if(vk == KeyEvent.VK_RIGHT) {
			c.deplacerdroit();
			
		}
		
	}

}
