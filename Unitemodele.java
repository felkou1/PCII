/**
 * The Unitemodele class represents an item on the game board, which can be either empty, contain a rabbit, a gardener, a flower or a building.
 * * @author IKHELEF Mounia
 *         TADJIN Amina
 *         El Kouch Fadwa
 */
package modele;
import control.controlable;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public  class Unitemodele  {

	//Attributes//
	 protected int x;
	 protected int y;
	 private String type;
	 protected BufferedImage img ;
	 public static final String PATHIMG="img/";
   	 private Lapinmodele lapin;
 	 private Batimentmodele batiment;
   	private Jardiniermodele jardinier;
   	private Fleurmodele fleur;
 	private boolean avecjardinier;
 	private boolean avecfleur;
 	private boolean avecBatiment;
 	private boolean aveclapin;
 	private boolean vide;
	 
 	
 	//Constructor//
 	/**
 	 * Constructs an empty item with the specified coordinates.
 	 * 
 	 * @param x the x-coordinate of the item.
 	 * @param y the y-coordinate of the item.
 	 */
 	public Unitemodele(int x,int y)
	    {
	        this.x=x;
	        this.y = y;
	        try {
				img = ImageIO.read(new File(PATHIMG+"unit.jpeg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
	        this.vide=true;
	    }
	  		
 	/**
 	 * Constructs an item with the specified coordinates and a rabbit.
 	 * 
 	 * @param x the x-coordinate of the item.
 	 * @param y the y-coordinate of the item.
 	 * @param lp the rabbit contained in the item.
 	 */
	    	public Unitemodele(int x,int y,Lapinmodele lp){
	    		this.x=x;
	    		this.y=y;
	    		this.lapin=lp;
	    		this.aveclapin=true;
	    		this.vide=false;
	    	}
	    	/**
	    	 * Constructs an item with the specified coordinates and a gardener.
	    	 * 
	    	 * @param x the x-coordinate of the item.
	    	 * @param y the y-coordinate of the item.
	    	 * @param jr the gardener contained in the item.
	    	 */
	    	public Unitemodele(int x,int y,Jardiniermodele jr){
	    		this.x=x;
	    		this.y=y;
	    		this.jardinier=jr;
	    		this.avecjardinier=true;
	    		this.vide=false;
	    	}
	    	/**
	    	 * Constructs an item with the specified coordinates and a flower.
	    	 * 
	    	 * @param x the x-coordinate of the item.
	    	 * @param y the y-coordinate of the item.
	    	 * @param fl the flower contained in the item.
	    	 */
	    	public Unitemodele(int x,int y,Fleurmodele fl){
	    		this.x=x;
	    		this.y=y;
	    		this.fleur=fl;
	    		this.avecfleur=true;
	    		this.vide=false;
	    	}
	    	/**
	    	 * Constructs an item with the specified coordinates and a building.
	    	 * 
	    	 * @param x the x-coordinate of the item.
	    	 * @param y the y-coordinate of the item.
	    	 * @param bat the building contained in the item.
	    	 */
	    	public Unitemodele(int x,int y,Batimentmodele bat){
	    		this.x=x;
	    		this.y=y;
	    		this.batiment=bat;
	    		this.avecBatiment=true;
	    		this.vide=false;
	    	}
	    	


	    	/**
	    	 * @return
	    	 */
	    	public BufferedImage Afficheimg(){
	    		if(aveclapin()){
	    			return this.lapin.getImage();
	    		}
	    		if(avecjardinier()){
	    			return this.jardinier.getImage();
	    		}
	    		if(avecfleur()){
	    			return this.fleur.getImage();
	    		}
	    		if(avecBatiment()){
	    			return this.batiment.getImage();
	    		}
	    		
	    		return img;
	    	}

	    	

	    	/**
	    	 * @return
	    	 */
	    	public boolean avecBatiment() {
				return avecBatiment;
			}

	    	/**
	    	 * @return
	    	 */
	    	public boolean avecfleur() {
				return avecfleur;
			}

			/**
			 * @return
			 */
			public boolean avecjardinier() {
				return avecjardinier;
			}

			/**
			 * @return
			 */
			public boolean aveclapin() {
				return aveclapin;
			}
			
			/**
			 * @return
			 */
			public boolean isVide() {
				return vide;
			}

			/**
			 * @param image
			 */
			public void setimage(BufferedImage image) {
	    		if(avecfleur()){
	    			this.fleur.setImage(image);
	    		}else {
		    		if(avecjardinier()){
		    			this.jardinier.setImage(image);
		    		}else {
			    		if(avecBatiment()){
			    			this.batiment.setImage(image);
			    		}else {
				    		if(aveclapin()){
				    			this.lapin.setImage(image);
				    		}else {
				    			img = image;
				    		}
			    		}	
		    		}	
		    	}
	    	}
			
			
			/**
			 * @return
			 */
			public int getX() {
				return x;
			}

			/**
			 * @return
			 */
			public int getY() {
				return y;
			}
			
			/**
			 * @return
			 */
			public Fleurmodele getfleur() {
				return this.fleur;
			}

			public TypeBatiment getypebat() {
				return this.batiment.getypebat();
			}

			public Batimentmodele getbat() {
				return this.batiment;
			}

	
}
