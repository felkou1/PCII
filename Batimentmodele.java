/**
 * Cette classe d�finit le mod�le des b�timents. 
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
	 * Initialise un b�timent en sp�cifiant sa position.
	 * Charge l'image par d�faut des b�timents.
	 *
	 * @param x la position horizontale du b�timent sur la carte
	 * @param y la position verticale du b�timent sur la carte
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
	 * Initialise un b�timent en sp�cifiant sa position et son type.
	 * Charge l'image correspondante au type de b�timent.
	 *
	 * @param x la position horizontale du b�timent sur la carte
	 * @param y la position verticale du b�timent sur la carte
	 * @param tb le type de b�timent
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

	// M�thodes //

	/**
	 * Modifie l'image du b�timent.
	 *
	 * @param image la nouvelle image du b�timent
	 */
	public void setImage(BufferedImage image) {
		img = image;
	}

	/**
	 * R�cup�re l'image du b�timent.
	 *
	 * @return l'image du b�timent
	 */
	public BufferedImage getImage() {
		return img;
	}

	/**
	 * R�cup�re la position horizontale du b�timent.
	 *
	 * @return la position horizontale du b�timent
	 */
	public int getX() {
		return x;
	}

	/**
	 * R�cup�re la position verticale du b�timent.
	 *
	 * @return la position verticale du b�timent
	 */
	public int getY() {
		return y;
	}

	/**
	 * R�cup�re le type de b�timent.
	 *
	 * @return le type de b�timent
	  */
	public TypeBatiment typebat() {
		return tb;
	}
}

