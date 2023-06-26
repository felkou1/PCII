/**
 * représente le modèle d'une fleur dans le jeu.  
 * @author IKHELEF Mounia
 *         TADJIN Amina
 *         El Kouch Fadwa
 */
package modele;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import control.SeFane;


public class Fleurmodele extends Unitemodele {
	
	// Attributes //

	private int vitesse;
	private String typefleur;
	private int tempsmaturite;
	private int dureedevie;
	private int age;
	
    // Constructor //
    /**
     * @param x
     * @param y
     */
    public Fleurmodele(int x,int y){
        super(x, y);
        try{
            img = ImageIO.read(new File(Fleurmodele.PATHIMG+"fleur.jpeg"));
        } 
        catch (IOException e) {
        	e.printStackTrace();
        }
        this.dureedevie=20;
        this.vitesse = 50;
        this.typefleur ="ROSE";  
        this.tempsmaturite =5;
        this.age=0;
    }

   

	
	
	/**
	 * @return
	 */
	public int getvitesse() {
		return vitesse;
	}
	
	/**
	 * @return
	 */
	public String gettypefleur() {
		return typefleur;
	}

	/**
	 * @return
	 */
	public int gettempsmaturite() {
		return tempsmaturite;
	}

	/**
	 * @param tempsmaturitÃ©
	 */
	public void settempsmaturite(int tempsmaturite) {
		this.tempsmaturite = tempsmaturite;
	}

	/**
	 * @return
	 */
	public int getdureedevie() {
		return dureedevie;
	}

	/**
	 * @param durÃ©edevie
	 */
	public void setdureedevie(int dureedevie) {
		this.dureedevie = dureedevie;
	}

	

	/**
	 * @return
	 */
	public BufferedImage getImage() {
		return img;
	}




	/**
	 * @param image
	 */
	public void setImage(BufferedImage image) {
		img = image;
	}


	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}





	/**
	 * @return
	 */
	public int getAge() {
		return age;
	}





	/**
	 * @param age
	 */
	public void setAge(int age) {
		this.age += age;
	}

	
}

