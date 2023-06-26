/**
 * Enumération des types de bâtiments disponibles dans le jeu. 
 * @author IKHELEF Mounia
 *         TADJIN Amina
 *         El Kouch Fadwa
 */
package modele;

public enum TypeBatiment {  
  
	//Attributes//

	/**
	 * Le type de bâtiment correspondant au bâtiment principal.
	 */
	PRINCIPALE("principale"),

	/**
	 * Le type de bâtiment correspondant aux bâtiments de production de ressources.
	 */
	PRODUCTION("production"), 

	/**
	 * Le type de bâtiment correspondant aux bâtiments de défense.
	 */
	DEFENSE("defense") ;  
	  
	//Constructor //

	/**
	 * Constructeur privé de l'enumération TypeBatiment.
	 * 
	 * @param tb la chaîne de caractères correspondant au type de bâtiment
	 */
	private TypeBatiment(String tb) {  
	    this.typebat = tb ;  
	}  
	  
	//Methods //

	/**
	 * Retourne la chaîne de caractères correspondant au type de bâtiment.
	 * 
	 * @return la chaîne de caractères correspondant au type de bâtiment
	 */
	public String gettypabatiment() {  
	    return  this.typebat ;  
	}

	//Attributes//

	/**
	 * La chaîne de caractères correspondant au type de bâtiment.
	 */
	private String typebat ;  

}

