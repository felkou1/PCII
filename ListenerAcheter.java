/**
 * This class implements the MouseListener interface and provides functionality
 * for buying seeds when the mouse is clicked. It checks if the user has enough
 * money to buy the seed and displays a message accordingly.
 *
 * @author IKHELEF Mounia, TADJIN Amina, El Kouch Fadwa
 */
package control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modele.Cartemodele;
import view.Carte;

public class ListenerAcheter implements MouseListener {

    // Attributes
    private Cartemodele c;

    /**
     * Constructs a new instance of the ListenerAcheter class with the provided
     * Cartemodele object.
     *
     * @param c The Cartemodele object used to buy seeds.
     */
    public ListenerAcheter(Cartemodele c) {
        this.c = c;
    }

    /**
     * Handles mouse click events. Buys seeds if the user has enough money, and
     * displays a message accordingly.
     *
     * @param e The MouseEvent object representing the mouse click event.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (c.Acheter()) {
            JOptionPane.showMessageDialog(null, "Graine achet�e");
            System.out.printf("Achet�");
        } else {
            JOptionPane.showMessageDialog(null, "Vous n'avez pas assez d'argent");
            System.out.printf("Pas achet�");
        }
    }

    // Unused methods
    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
