/**
 * cette classe repr�sente l'affichage graphique de l'application
 * @author IKHELEF Mounia
 *         TADJIN Amina
 *         El Kouch Fadwa
 */
package view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;

import control.AjouterLapin;
import control.Defense;
import control.DeplacerLapin;
import control.Production;
import control.SeFane;
import control.controlable;

public class Affichage extends JFrame {
	/**
	 * Construit un nouvel objet Affichage avec le titre sp�cifi�, cr�e les �l�ments graphiques et les 
	 * objets de contr�le n�cessaires et lance les threads correspondants.
	 * 
	 * @param s le titre de la fen�tre principale.
	 */
	public Affichage(String s) {
	    Carte plateau = new Carte();
	    controlable control = new controlable(plateau);
	    SeFane sefane = new SeFane(plateau);
	    DeplacerLapin deplacelapin = new DeplacerLapin(plateau);
	    AjouterLapin ajouterlapin=new AjouterLapin(plateau);
	    Production p = new Production(plateau);
	    Defense d = new Defense(plateau);
	    ajouterlapin.start();
	    deplacelapin.start();
	    sefane.start();
	    p.start();
	    d.start();
	    
	    //Cr�ation de la fen�tre
	    GridLayout experimentLayout = new GridLayout(0,2);
	    setLayout(experimentLayout);
		setTitle(s);
	    setPreferredSize(new Dimension(1500,600));
	    addKeyListener(control);
	    this.setJMenuBar(plateau.getMn());
	    add(plateau,BorderLayout.WEST);
	    add(plateau.pC,BorderLayout.EAST);
	    pack();
	    setVisible(true);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
