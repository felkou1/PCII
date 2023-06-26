/**

* This class represents a thread that moves rabbits on the map periodically.
* @author IKHELEF Mounia, TADJIN Amina, El Kouch Fadwa
*/
package control;

import view.Carte;

public class DeplacerLapin extends Thread{

	
	// Attributes //

	private Carte c;

	// constructors //
	/**
	 * Constructs a new DeplacerLapin object with the given Carte object.
	 * 
	 * @param c the Carte object to be used for moving rabbits
	 */
	public DeplacerLapin(Carte c) {
		this.c = c;
	}

	@Override
	/**
	 * Runs the thread by repeatedly sleeping for a certain amount of time and then moving the rabbits.
	 */
	public void run() {
	    while(true ){
	    	try {Thread.sleep(10000); 
	    		this.c.deplacerlapin();
	    	}catch (Exception e) { e.printStackTrace(); }
	    }
	}
}
