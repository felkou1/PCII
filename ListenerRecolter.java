/**
 * 
 * classe qui implemente l'interface MouseListener. Cette classe permet d'effectuer des actions lorsque
 * l'utilisateur clique sur une fleur afin de la recolter.
 * @author IKHELEF Mounia, TADJIN Amina, El Kouch Fadwa
 */
package control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import modele.Cartemodele;
import modele.Unitemodele;
import view.Carte;

public class ListenerRecolter implements MouseListener {

	// Attributes //

	private Cartemodele c;
	private Unitemodele unit;

	/**
	 * Constructeur de la classe ListenerRecolter.
	 * 
	 * @param c le mod�le de la carte
	 * @param unit le mod�le de la fleur � recolter
	 */
	public ListenerRecolter(Cartemodele c,Unitemodele unit) {
		this.c=c;
		this.unit = unit;
	}

	/**
	 * M�thode qui est appel�e lorsque l'utilisateur clique sur une fleur.
	 * Si la fleur peut �tre r�colt�e, elle est r�colt�e et la carte est redessin�e.
	 * Sinon, un message est affich� pour informer l'utilisateur qu'il ne peut pas encore r�colter cette fleur.
	 * 
	 * @param e l'�v�nement de la souris
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		 if(c.Recolte(unit.getX(),unit.getY())) {
			 c.repaint();
			 JOptionPane.showMessageDialog(null,"Fleur recolt�e");
				System.out.printf("Recolte");
		 }else {
			JOptionPane.showMessageDialog(null,"Vous ne pouvez pas encore recolter la fleur");
			System.out.printf("Recolte");
		}
	}

	/**
	 * M�thode qui est appel�e lorsque la souris est press�e.
	 * 
	 * @param e l'�v�nement de la souris
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * M�thode qui est appel�e lorsque la souris est rel�ch�e.
	 * 
	 * @param e l'�v�nement de la souris
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * M�thode qui est appel�e lorsque la souris entre dans la zone de la fleur.
	 * 
	 * @param e l'�v�nement de la souris
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * M�thode qui est appel�e lorsque la souris sort de la zone de la fleur.
	 * 
	 * @param e l'�v�nement de la souris
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}


}
