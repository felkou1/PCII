/**

* Cette classe est utilis�e pour g�rer le contr�le des mouvements du personnage dans le jeu.
* @author IKHELEF Mounia, TADJIN Amina, El Kouch Fadwa
*/
package control;


import view.Carte;
import view.PanneauControle;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class controlable implements KeyListener
{
	// Attributes//
	private Carte c;
	private Avancer j;
	private PanneauControle pn;
	// constructors //
	/**
	 * Constructeur de la classe controlable
	 * @param c l'instance de la classe Carte
	 */
	public controlable(Carte c) {
		this.c = c;
		//this.pn = pn;
	}

	/**
	 * M�thode appel�e lorsqu'une touche du clavier est press�e. Elle cr�e une instance de la classe Avancer avec le code de la touche press�e en param�tre et la d�marre.
	 * @param e l'�v�nement de la touche press�e
	 */
	@Override
	public void keyPressed(KeyEvent e) {
	      j = new Avancer(c,e.getKeyCode());
	      j.start();
	}

	/**
	 * M�thode appel�e lorsqu'une touche du clavier est rel�ch�e.
	 * @param e l'�v�nement de la touche rel�ch�e
	 */
	@Override
	public void keyReleased(KeyEvent e) {
	    // TODO Auto-generated method stub
	    
	}

	/**
	 * M�thode appel�e lorsqu'une touche du clavier est tap�e.
	 * @param e l'�v�nement de la touche tap�e
	 */
	@Override
	public void keyTyped(KeyEvent e) {
	    // TODO Auto-generated method stub
	    
	}

}
