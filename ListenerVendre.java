/**
 * 
 * Listener for selling bouquets in the game
 * @author IKHELEF Mounia, TADJIN Amina, El Kouch Fadwa
 */
package control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import modele.Cartemodele;
import view.Carte;

public class ListenerVendre implements MouseListener {
	
	// Attributes //

	private Cartemodele c;

	/**
	 * Constructor for ListenerVendre
	 * 
	 * @param c the Cartemodele object representing the game map
	 */
	public ListenerVendre(Cartemodele c)
	{
		this.c = c;
	}

	/**
	 * Handle the mouse click event for selling bouquets
	 * 
	 * This method checks if the player has enough bouquets to sell and sells them if possible.
	 * It also displays a message dialog to inform the player about the result of the operation.
	 * 
	 * @param e the MouseEvent object representing the mouse click event
	 */
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		if(c.Vendre()) {
			 JOptionPane.showMessageDialog(null,"Bouquet Vendu");
			System.out.printf("vendu");
		 }else {
			 JOptionPane.showMessageDialog(null,"Vous avez pas assez de bouquets � vendre");
				System.out.printf("pas vendu");
		 }
	}

	/**
	 * Handle the mouse pressed event
	 * 
	 * This method does nothing for the current implementation.
	 * 
	 * @param e the MouseEvent object representing the mouse pressed event
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Handle the mouse released event
	 * 
	 * This method does nothing for the current implementation.
	 * 
	 * @param e the MouseEvent object representing the mouse released event
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Handle the mouse entered event
	 * 
	 * This method does nothing for the current implementation.
	 * 
	 * @param e the MouseEvent object representing the mouse entered event
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Handle the mouse exited event
	 * 
	 * This method does nothing for the current implementation.
	 * 
	 * @param e the MouseEvent object representing the mouse exited event
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
