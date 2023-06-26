/**
 * Enum�ration des types de b�timents disponibles dans le jeu. 
 * @author IKHELEF Mounia
 *         TADJIN Amina
 *         El Kouch Fadwa
 */
package modele;

public enum TypeBatiment {  
  
	//Attributes//

	/**
	 * Le type de b�timent correspondant au b�timent principal.
	 */
	PRINCIPALE("principale"),

	/**
	 * Le type de b�timent correspondant aux b�timents de production de ressources.
	 */
	PRODUCTION("production"), 

	/**
	 * Le type de b�timent correspondant aux b�timents de d�fense.
	 */
	DEFENSE("defense") ;  
	  
	//Constructor //

	/**
	 * Constructeur priv� de l'enum�ration TypeBatiment.
	 * 
	 * @param tb la cha�ne de caract�res correspondant au type de b�timent
	 */
	private TypeBatiment(String tb) {  
	    this.typebat = tb ;  
	}  
	  
	//Methods //

	/**
	 * Retourne la cha�ne de caract�res correspondant au type de b�timent.
	 * 
	 * @return la cha�ne de caract�res correspondant au type de b�timent
	 */
	public String gettypabatiment() {  
	    return  this.typebat ;  
	}

	//Attributes//

	/**
	 * La cha�ne de caract�res correspondant au type de b�timent.
	 */
	private String typebat ;  

}

