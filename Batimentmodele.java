/**
 * Cette classe définit le modèle des bâtiments. 
 * @author IKHELEF Mounia
 *         TADJIN Amina
 *         El Kouch Fadwa
 */
package modele;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Batimentmodele extends Unitemodele {

	// Attributs //
	private TypeBatiment tb;


	// Constructeurs //
	/**
	 * Initialise un bâtiment en spécifiant sa position.
	 * Charge l'image par défaut des bâtiments.
	 *
	 * @param x la position horizontale du bâtiment sur la carte
	 * @param y la position verticale du bâtiment sur la carte
	 */
	public Batimentmodele(int x, int y) {
		super(x, y);
		try {
			img = ImageIO.read(new File(Batimentmodele.PATHIMG + "batiment.jpeg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialise un bâtiment en spécifiant sa position et son type.
	 * Charge l'image correspondante au type de bâtiment.
	 *
	 * @param x la position horizontale du bâtiment sur la carte
	 * @param y la position verticale du bâtiment sur la carte
	 * @param tb le type de bâtiment
	 */
	public Batimentmodele(int x, int y, TypeBatiment tb) {
		super(x, y);
		this.tb = tb;
		if (tb == TypeBatiment.PRINCIPALE)
			try {
				img = ImageIO.read(new File(Batimentmodele.PATHIMG + "batiment.jpeg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		else {
			if (tb == TypeBatiment.DEFENSE)
				try {
					img = ImageIO.read(new File(Batimentmodele.PATHIMG + "Defense.jpeg"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			else {
				try {
					img = ImageIO.read(new File(Batimentmodele.PATHIMG + "Production.jpeg"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// Méthodes //

	/**
	 * Modifie l'image du bâtiment.
	 *
	 * @param image la nouvelle image du bâtiment
	 */
	public void setImage(BufferedImage image) {
		img = image;
	}

	/**
	 * Récupère l'image du bâtiment.
	 *
	 * @return l'image du bâtiment
	 */
	public BufferedImage getImage() {
		return img;
	}

	/**
	 * Récupère la position horizontale du bâtiment.
	 *
	 * @return la position horizontale du bâtiment
	 */
	public int getX() {
		return x;
	}

	/**
	 * Récupère la position verticale du bâtiment.
	 *
	 * @return la position verticale du bâtiment
	 */
	public int getY() {
		return y;
	}

	/**
	 * Récupère le type de bâtiment.
	 *
	 * @return le type de bâtiment
	  */
	public TypeBatiment typebat() {
		return tb;
	}
}

