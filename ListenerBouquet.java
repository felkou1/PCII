/**
 * 
 * This class represents a listener for the Bouquet creation button.
 * @author IKHELEF Mounia, TADJIN Amina, El Kouch Fadwa
 */
package control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import modele.Cartemodele;
import view.Carte;

public class ListenerBouquet implements MouseListener {

	// Attributes //

	private Cartemodele C;

	/**
	 * Constructor for the ListenerBouquet class.
	 * 
	 * @param c the CarteModele object to use
	 */
	public ListenerBouquet(Cartemodele c) {
		this.C = c;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		 if(C.creerbouquet()) {
			 	JOptionPane.showMessageDialog(null,"Bouquet Construit");
				System.out.printf("construit");
		 } else {
			JOptionPane.showMessageDialog(null,"Vous avez pas assez des fleurs");
			System.out.printf("pas construit");
		 }
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}


}
