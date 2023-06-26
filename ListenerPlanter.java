/**
 * This class implements the mouse listener interface and is used to handle events related to planting flowers in the garden.
 * 
 * The class is associated with a Cartemodele object and a Unitemodele object that represent the garden and the flower to be planted, respectively.
 * 
 * @version 1.0
 * @author IKHELEF Mounia
 * @author TADJIN Amina
 * @author El Kouch Fadwa
 */
package control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import modele.Cartemodele;
import modele.Unitemodele;
import view.Carte;

public class ListenerPlanter implements MouseListener {
	
	// Attributes //

	private Cartemodele c;
	private Unitemodele unit;
	
	/**
	 * Constructor that initializes the listener with the garden and the flower to be planted.
	 * 
	 * @param c the Cartemodele object representing the garden
	 * @param unit the Unitemodele object representing the flower to be planted
	 */
	public ListenerPlanter(Cartemodele c, Unitemodele unit) {
		this.c = c;
		this.unit = unit;
	}

    /**
     * Handles the mouse click event and plants the flower in the garden.
     * 
     * If there are enough seeds to plant the flower and the cell is available, the flower is planted and a message is displayed.
     * Otherwise, a message is displayed indicating that the flower cannot be planted.
     * 
     * @param e the MouseEvent object representing the mouse click event
     */
    @Override
	public void mouseClicked(MouseEvent e) {
		if(c.Planter(unit.getX(), unit.getY())) {
			JOptionPane.showMessageDialog(null,"Fleur plant�e");
			System.out.printf("plante");
		} else {
			JOptionPane.showMessageDialog(null,"Vous n'avez pas assez de graines ou vous ne pouvez pas planter dans cette case");
			System.out.printf("pas plante");
		}
	}

    /**
     * Handles the mouse press event (not used in this class).
     * 
     * @param e the MouseEvent object representing the mouse press event
     */
    @Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

    /**
     * Handles the mouse release event (not used in this class).
     * 
     * @param e the MouseEvent object representing the mouse release event
     */
    @Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

    /**
     * Handles the mouse enter event (not used in this class).
     * 
     * @param e the MouseEvent object representing the mouse enter event
     */
    @Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

    /**
     * Handles the mouse exit event (not used in this class).
     * 
     * @param e the MouseEvent object representing the mouse exit event
     */
    @Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
