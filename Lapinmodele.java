/**
 * représente un lapin dans le jeu. 
 * @author IKHELEF Mounia
 *         TADJIN Amina
 *         El Kouch Fadwa
 */
package modele;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Lapinmodele extends Unitemodele {



	/**
	 * Constructeur de la classe Lapinmodele.
	 * @param x La position en abscisse du lapin.
	 * @param y La position en ordonnée du lapin.
	 */
	public Lapinmodele(int x, int y) {
	    super(x, y);
	    try {
	        img = ImageIO.read(new File(Lapinmodele.PATHIMG + "lapin.png"));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	/**
	 * Setter pour changer l'image du lapin.
	 * @param image La nouvelle image du lapin.
	 */
	public void setImage(BufferedImage image) {
	    img = image;
	}

	/**
	 * Getter pour obtenir l'image du lapin.
	 * @return L'image actuelle du lapin.
	 */
	public BufferedImage getImage() {
	    return img;
	}

	/**
	 * Getter pour obtenir la position en abscisse du lapin.
	 * @return La position en abscisse du lapin.
	 */
	public int getX() {
	    return x;
	}

	/**
	 * Getter pour obtenir la position en ordonnée du lapin.
	 * @return La position en ordonnée du lapin.
	 */
	public int getY() {
	    return y;
	}

}

