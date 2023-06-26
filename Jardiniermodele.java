/**
 * représente un jardinier dans le jeu. 
 * @author IKHELEF Mounia
 *         TADJIN Amina
 *         El Kouch Fadwa
 */
package modele;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.imageio.ImageIO;



public class Jardiniermodele extends Unitemodele {

	// Attributes //
	private int argent= 0;
	private int nbrbouquet = 0;
	private int nbrfleur = 0;
	private int nbrfleurrecolt = 0;
	private SortedMap<String, Integer> graine = new TreeMap<>();
	private boolean estsurlapin;
	private boolean estsurbat;
	private boolean estsurfleur;
	private int nbrgraine = 5;
	
	
    //Constructor //
    /**
     * @param x
     * @param y
     */
    public Jardiniermodele(int x,int y){
        super(x, y);
        try{
            img = ImageIO.read(new File(Jardiniermodele.PATHIMG+"jardinier.png"));
        } 
        catch (IOException e) {
        	e.printStackTrace();
        }

    }



   	/**
   	 * @param n
   	 */
   	public void ajouterunefleur(int n) {
   		setnbrfleur(getnbrfleur() + n);
   	}
   	
   	/**
   	 * @param prix
   	 * @param nbr
   	 * @param type
   	 * @return
   	 */
   	public boolean achetergraine(int prix,int nbr,String type) {
   		if(argent>=prix) {
   		graine.put(type, nbr);
   		argent -= prix;;
   		setnbrgraine(nbr);
   		return true;
   		}
   		return false;
   	}
   	
   	/**
   	 * @return
   	 */
   	public boolean creerbouquet() {
   		
   		if(nbrfleurrecolt >= 5) {
   			nbrbouquet += 1;
   			nbrfleurrecolt  -=5;
   			return true;
   		}
   		return false;
   	}
   	
   	/**
   	 * @param prix
   	 * @param nbrbouquetav
   	 * @return
   	 */
   	public boolean vendrebouquet(int prix,int nbrbouquetav) {
   		if(nbrbouquetav<=nbrbouquet) {
   			argent += prix;
   	   		nbrbouquet-= nbrbouquetav;
   	   		return true;
   		}
   		return false;
   	}
   	
   	/**
   	 * @param n
   	 */
   	public void ajouterfleurrecolte(int n) {
   		nbrfleurrecolt += n;
   		setnbrfleur(getnbrfleur() - n);
   	}

   	public void setnbrfleurrecolt(int n) {
   		nbrfleurrecolt = n;
   	}
   	
   	public int getnbrfleurrecolt() {
   		return nbrfleurrecolt;
   	}
	/**
	 * @return
	 */
	public int getnbrfleur() {
		return nbrfleur;
	}


	/**
	 * @param nbrfleu
	 */
	public void setnbrfleur(int nbrfleu) {
		this.nbrfleur += nbrfleu;
	}

	

	/**
	 * @return
	 */
	public int getargent() {
		return argent;
	}


	public void setargent(int argent) {
	}


	/**
	 * @return
	 */
	public int getnbrbouquet() {
		return nbrbouquet;
	}
	
	/**
	 * @return
	 */
	public int getnbrgraine() {
		return nbrgraine;
	}
	
	/**
	 * @param nbr
	 */
	public void setnbrgraine(int nbr) {
		nbrgraine += nbr;
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
	 * 
	 */
	public void setjarsurfleur(){
		this.estsurfleur=true;
	}
	/**
	 * 
	 */
	public void setjarnofleur(){
		this.estsurfleur=false;
	}

	/**
	 * @return
	 */
	public boolean surfleur(){
		return this.estsurfleur;
	}

	/**
	 * 
	 */
	public void setjarsurbat(){
		this.estsurbat=true;
	}
	/**
	 * 
	 */
	public void setjarnobat(){
		this.estsurbat=false;
	}

	/**
	 * @return
	 */
	public boolean surbat(){
		return this.estsurbat;
	}

	/**
	 * 
	 */
	public void setjarsurlapin(){
		this.estsurlapin=true;
	}
	/**
	 * 
	 */
	public void setjarnolapin(){
		this.estsurlapin=false;
	}

	/**
	 * @return
	 */
	public boolean surlapin(){
		return this.estsurlapin;
	}



	/**
	 * @param x
	 */
	public void setx(int x) {

		this.x=x;
	}



	/**
	 * @param i
	 */
	public void sety(int i) {
		this.y=i;
	}

   	}
   


