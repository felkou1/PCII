package modele;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.swing.JPanel;

import view.PanneauControle;



public class Cartemodele extends JPanel {

	//Attributes //
	  private Jardiniermodele jr ;
	  private List<Lapinmodele> lapins=new ArrayList<Lapinmodele>();
	  private List<Fleurmodele> fleurs = new ArrayList<Fleurmodele>();
	  private Unitemodele[][] cases;
	  private Unitemodele[][] unites ;
	  private List<Batimentmodele> batiments=new ArrayList<Batimentmodele>();
	  private final static int NBRLIGNE = 500 ;
	  private final static int NBRCOLONNE = 500;
	  public final static int LENGTH = 500;
	  public final static int WIDTH = 500;
	  public final static int TAILLEUNITE = 30;
	  private List<Integer> xs;
	  
    //Constructor//
    /**
     * 
     */
    public Cartemodele(){
    	this.cases = new Unitemodele[NBRLIGNE][NBRCOLONNE];
    	this.unites = new Unitemodele[NBRLIGNE][NBRCOLONNE];
    	this.xs = new ArrayList<Integer>();
        for(int i=0;i<NBRLIGNE;i+=TAILLEUNITE){
        	xs.add(i);
            for(int j=0;j<NBRCOLONNE;j+=TAILLEUNITE){
            	if(i==TAILLEUNITE && j==TAILLEUNITE) {
            		batiments.add(new Batimentmodele(i,j,TypeBatiment.PRINCIPALE));
            		this.cases[i][j] = new Unitemodele(i,j,new Batimentmodele(i,j,TypeBatiment.PRINCIPALE));
            	}	
            	else {
            		if(i==90 && j ==0 ) {
                		this.fleurs.add(new Fleurmodele(i,j));
                		this.cases[i][j] = new Unitemodele(i,j,new Fleurmodele(i,j));
            		}else {
            			if(i==150 && j == 90) {
                    		jr = new Jardiniermodele(i,j);
                    		this.cases[i][j] = new Unitemodele(i,j,jr);
            			}else {
            				if(i==270 && j == 360) {
            					batiments.add(new Batimentmodele(i,j,TypeBatiment.DEFENSE));
                        		this.cases[i][j] = new Unitemodele(i,j,new Batimentmodele(i,j,TypeBatiment.DEFENSE));
            				}else {
            					if(i==210 && j == 30) {
            						batiments.add(new Batimentmodele(i,j,TypeBatiment.PRODUCTION));
            	            		this.cases[i][j] = new Unitemodele(i,j,new Batimentmodele(i,j,TypeBatiment.PRODUCTION));
            					}else {
            						this.cases[i][j] = new Unitemodele(i,j);
            					}
            				}
                    		
            			}
            		}
            	}
            }    
           
        }    
       setPreferredSize(new Dimension(LENGTH, WIDTH));
       this.unites=this.cases;
    }

	
    /**
	 * @return ArrayList<Unitemodele>
	 */
    public Unitemodele[][] getunites(){
    	return cases;
    }
    

    /**
     * @param i
     * @param j
     * @return
     */
    public Unitemodele getunite(int i,int j){
    	return this.cases[i][j];
    }
    /**
	 * @param i
	 * @param Unitemodele
	 */
    public void setunit(int i,int j,Unitemodele un) {
    	cases[i][j] = un;
    }

    /**
     * @return
     */
    public Jardiniermodele getjardinier() {
    	return jr;
    }
    
    /**
     * @param i
     * @param j
     * @return
     */
    public Fleurmodele getfleur(int i,int j) {
    	for(int k =0;k<fleurs.size();k++) {
    		if(fleurs.get(k).x == i && fleurs.get(k).y == j ) {
    			return fleurs.get(k);
    		}
    	}
    	return null;
    }
    
    /**
     * @return
     */
    public int nbrligne() {
    	return NBRLIGNE;
    }
    
    /**
     * @return
     */
    public int nbrcolonne() {
    	return NBRCOLONNE;
    }


	/**
	 * @param di
	 * @return
	 */
	public boolean possible(String di){
		if(di.equals("Haut") && valide(this.jr.getX(),this.jr.getY()-TAILLEUNITE) )return true;
		if(di.equals("Gauche") &&valide(this.jr.getX()-TAILLEUNITE,this.jr.getY()) )return true;
		if(di.equals("Droit")&&valide(this.jr.getX()+TAILLEUNITE,this.jr.getY()) )return true;
		if(di.equals("Bas") && valide(this.jr.getX(),this.jr.getY()+TAILLEUNITE) )return true;
		return false;
	}

	/**
	 * @param i
	 * @param j
	 * @return
	 */
	private boolean isVide(int i, int j) {
		 return cases[i][j].isVide();
	}


	/**
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean valide(int x,int y){
		return x>=0 && x<LENGTH+TAILLEUNITE && y>=0 && y<WIDTH+TAILLEUNITE;
	}

	/**
	 * @param di
	 */
	public void deplace(String di){
		remplircasepasse();
		augmenterlagedesfleurs();
		if(di.equals("Haut")){
			if(!this.cases[this.jr.getX()][this.jr.getY()-TAILLEUNITE].avecfleur() && !this.cases[this.jr.getX()][this.jr.getY()-TAILLEUNITE].avecBatiment()){
				if(this.cases[this.jr.getX()][this.jr.getY()-TAILLEUNITE].aveclapin()){
					if(jr.surlapin()){
								Effrayerlapin(jr.x,jr.y);
								this.cases[this.jr.getX()][this.jr.getY()]= new Unitemodele(this.jr.getX(),this.jr.getY());
								this.cases[this.jr.getX()][this.jr.getY()-TAILLEUNITE]=new Jardiniermodele(this.jr.getX(),this.jr.getY()-TAILLEUNITE);
								this.jr.setx(this.jr.getX());
								this.jr.sety(this.jr.getY()-TAILLEUNITE);
							}else {
								this.cases[this.jr.getX()][this.jr.getY()]= new Unitemodele(this.jr.getX(),this.jr.getY());
								this.cases[this.jr.getX()][this.jr.getY()-TAILLEUNITE]=new Jardiniermodele(this.jr.getX(),this.jr.getY()-TAILLEUNITE);
								this.jr.setx(this.jr.getX());
								this.jr.sety(this.jr.getY()-TAILLEUNITE);
						}
					}else{	
						if(jr.surlapin()){
							Effrayerlapin(jr.x,jr.y);
							this.cases[this.jr.getX()][this.jr.getY()]= new Unitemodele(this.jr.getX(),this.jr.getY());
							this.cases[this.jr.getX()][this.jr.getY()-TAILLEUNITE]=new Jardiniermodele(this.jr.getX(),this.jr.getY()-TAILLEUNITE);
							this.jr.setx(this.jr.getX());
							this.jr.sety(this.jr.getY()-TAILLEUNITE);
						}else {
							this.cases[this.jr.getX()][this.jr.getY()]= new Unitemodele(this.jr.getX(),this.jr.getY());
							this.cases[this.jr.getX()][this.jr.getY()-TAILLEUNITE]=new Jardiniermodele(this.jr.getX(),this.jr.getY()-TAILLEUNITE);
							this.jr.setx(this.jr.getX());
							this.jr.sety(this.jr.getY()-TAILLEUNITE);
							}
					}
			}
		}
		if(di.equals("Bas")){
			if(!this.cases[this.jr.getX()][this.jr.getY()+TAILLEUNITE].avecfleur() && !this.cases[this.jr.getX()][this.jr.getY()+TAILLEUNITE].avecBatiment()){
				if(this.cases[this.jr.getX()][this.jr.getY()+TAILLEUNITE].aveclapin()){
					if(jr.surlapin()){
								Effrayerlapin(jr.x,jr.y);
								this.cases[this.jr.getX()][this.jr.getY()]= new Unitemodele(this.jr.getX(),this.jr.getY());
								this.cases[this.jr.getX()][this.jr.getY()+TAILLEUNITE]=new Jardiniermodele(this.jr.getX(),this.jr.getY()+TAILLEUNITE);
								this.jr.setx(this.jr.getX());
								this.jr.sety(this.jr.getY()+TAILLEUNITE);
							}else {
								this.cases[this.jr.getX()][this.jr.getY()]= new Unitemodele(this.jr.getX(),this.jr.getY());
								this.cases[this.jr.getX()][this.jr.getY()+TAILLEUNITE]=new Jardiniermodele(this.jr.getX(),this.jr.getY()+TAILLEUNITE);
								this.jr.setx(this.jr.getX());
								this.jr.sety(this.jr.getY()+TAILLEUNITE);
						}
					}else{	
						if(jr.surlapin()){
							Effrayerlapin(jr.x,jr.y);
							this.cases[this.jr.getX()][this.jr.getY()]= new Unitemodele(this.jr.getX(),this.jr.getY());
							this.cases[this.jr.getX()][this.jr.getY()+TAILLEUNITE]=new Jardiniermodele(this.jr.getX(),this.jr.getY()+TAILLEUNITE);
							this.jr.setx(this.jr.getX());
							this.jr.sety(this.jr.getY()+TAILLEUNITE);
						}else {
							this.cases[this.jr.getX()][this.jr.getY()]= new Unitemodele(this.jr.getX(),this.jr.getY());
							this.cases[this.jr.getX()][this.jr.getY()+TAILLEUNITE]=new Jardiniermodele(this.jr.getX(),this.jr.getY()+TAILLEUNITE);
							this.jr.setx(this.jr.getX());
							this.jr.sety(this.jr.getY()+TAILLEUNITE);
							}
					}
			}
		}
		if(di.equals("Gauche")){
			if(!this.cases[this.jr.getX()-TAILLEUNITE][this.jr.getY()].avecfleur() && !this.cases[this.jr.getX()-TAILLEUNITE][this.jr.getY()].avecBatiment()){
				if(this.cases[this.jr.getX()-TAILLEUNITE][this.jr.getY()].aveclapin()){
					if(jr.surlapin()){
								Effrayerlapin(jr.x,jr.y);
								this.cases[this.jr.getX()][this.jr.getY()]= new Unitemodele(this.jr.getX(),this.jr.getY());
								this.cases[this.jr.getX()-TAILLEUNITE][this.jr.getY()]=new Jardiniermodele(this.jr.getX()-TAILLEUNITE,this.jr.getY());
								this.jr.setx(this.jr.getX()-TAILLEUNITE);
								this.jr.sety(this.jr.getY());
							}else {
								this.cases[this.jr.getX()][this.jr.getY()]= new Unitemodele(this.jr.getX(),this.jr.getY());
								this.cases[this.jr.getX()-TAILLEUNITE][this.jr.getY()]=new Jardiniermodele(this.jr.getX()-TAILLEUNITE,this.jr.getY());
								this.jr.setx(this.jr.getX()-TAILLEUNITE);
								this.jr.sety(this.jr.getY());
						}
					}else{	
						if(jr.surlapin()){
							Effrayerlapin(jr.x,jr.y);
							this.cases[this.jr.getX()][this.jr.getY()]= new Unitemodele(this.jr.getX(),this.jr.getY());
							this.cases[this.jr.getX()-TAILLEUNITE][this.jr.getY()]=new Jardiniermodele(this.jr.getX()-TAILLEUNITE,this.jr.getY());
							this.jr.setx(this.jr.getX()-TAILLEUNITE);
							this.jr.sety(this.jr.getY());
						}else {
							this.cases[this.jr.getX()][this.jr.getY()]= new Unitemodele(this.jr.getX(),this.jr.getY());
							this.cases[this.jr.getX()-TAILLEUNITE][this.jr.getY()]=new Jardiniermodele(this.jr.getX()-TAILLEUNITE,this.jr.getY());
							this.jr.setx(this.jr.getX()-TAILLEUNITE);
							this.jr.sety(this.jr.getY());
							}
					}
			}
		}
		if(di.equals("Droit")){
			
			if(!this.cases[this.jr.getX()+TAILLEUNITE][this.jr.getY()].avecfleur() && !this.cases[this.jr.getX()+TAILLEUNITE][this.jr.getY()].avecBatiment()){
				if(this.cases[this.jr.getX()+TAILLEUNITE][this.jr.getY()].aveclapin()){
					if(jr.surlapin()){
								Effrayerlapin(jr.x,jr.y);
								this.cases[this.jr.getX()][this.jr.getY()]= new Unitemodele(this.jr.getX(),this.jr.getY());
								this.cases[this.jr.getX()+TAILLEUNITE][this.jr.getY()]=new Jardiniermodele(this.jr.getX()+TAILLEUNITE,this.jr.getY());
								this.jr.setx(this.jr.getX()+TAILLEUNITE);
								this.jr.sety(this.jr.getY());
							}else {
								this.cases[this.jr.getX()][this.jr.getY()]= new Unitemodele(this.jr.getX(),this.jr.getY());
								this.cases[this.jr.getX()+TAILLEUNITE][this.jr.getY()]=new Jardiniermodele(this.jr.getX()+TAILLEUNITE,this.jr.getY());
								this.jr.setx(this.jr.getX()+TAILLEUNITE);
								this.jr.sety(this.jr.getY());
						}
					}else{	
						if(jr.surlapin()){
							Effrayerlapin(jr.x,jr.y);
							this.cases[this.jr.getX()][this.jr.getY()]= new Unitemodele(this.jr.getX(),this.jr.getY());
							this.cases[this.jr.getX()+TAILLEUNITE][this.jr.getY()]=new Jardiniermodele(this.jr.getX()+TAILLEUNITE,this.jr.getY());
							this.jr.setx(this.jr.getX()+TAILLEUNITE);
							this.jr.sety(this.jr.getY());
						}else {
							this.cases[this.jr.getX()][this.jr.getY()]= new Unitemodele(this.jr.getX(),this.jr.getY());
							this.cases[this.jr.getX()+TAILLEUNITE][this.jr.getY()]=new Jardiniermodele(this.jr.getX()+TAILLEUNITE,this.jr.getY());
							this.jr.setx(this.jr.getX()+TAILLEUNITE);
							this.jr.sety(this.jr.getY());
							}
					}
			}
		}
	}
	
	
		public void augmenterlagedesfleurs() {
			for(Fleurmodele f : fleurs) {
				f.setAge(10);
			}
		
		}


		/**
		 * 
		 */
		private void remplircasepasse() {
			this.unites=  new Unitemodele[NBRLIGNE][NBRCOLONNE];
			for(int i=0;i<NBRLIGNE;i+=TAILLEUNITE){
				for(int j=0;j<NBRCOLONNE;j+=TAILLEUNITE){
					this.unites[i][j]=this.cases[i][j];
				}
			}		
	}


		/**
		 * @param i
		 * @param j
		 * @return
		 */
		private boolean checktypebatiment(int i, int j) {
			for(int k = 0;k<batiments.size();k++) {
				if(batiments.get(k).x == i && batiments.get(k).y == j )
					return TypeBatiment.PRINCIPALE == batiments.get(k).typebat();
			}
		return false;
	}


		/**
		 * @param i
		 * @param j
		 * @return
		 */
		public boolean Planter(int i,int j) {
			if(jr.getX() != i || jr.getY() != j) {
				if(!cases[i][j].aveclapin()) {
					if(jr.getnbrgraine()>0  ) {
						cases[i][j] = new Unitemodele(i,j,new Fleurmodele(i,j));
						jr.setnbrfleur(1);
						jr.setnbrgraine(-1);
						this.fleurs.add(new Fleurmodele(i,j));
						return true;
					}
				}
			}
			return false;
		}
		
		/**
		 * @param i
		 * @param j
		 * @return
		 */
		public boolean Recolte(int i,int j) {
			for (Fleurmodele f : fleurs) {
				if(f.x == i && f.y == j ) {
					if(f.getAge()>30) {
						cases[i][j] = new Unitemodele(i,j);
						jr.setnbrfleur(-1);
						jr.ajouterfleurrecolte(1);
						fleurs.remove(f);
						return true;
					}
				}
			}
			return false;
		}
		
		/**
		 * @param i
		 * @param j
		 */
		public void Construire(int i,int j) {
			cases[i][j] = new Unitemodele(i,j,new Batimentmodele(i,j));
			jr.setnbrfleur(1);
		}
			
		/**
		 * @return
		 */
		public boolean Vendre () {
			return jr.vendrebouquet(20, 1);
		}
		
		/**
		 * @return
		 */
		public boolean creerbouquet() {
			
			return jr.creerbouquet();
		}
		
		/**
		 * @return
		 */
		public boolean Acheter() {
			return jr.achetergraine(10, 5, "Rose");
		}
		



	/**
	 * @param i
	 * @param j
	 */
	private void Effrayerlapin(int i,int j) {
		
		for(int k = 0;k<lapins.size();k++) {
			if(lapins.get(k).x == i && lapins.get(k).y == j ) {
				lapins.remove(k);
				cases[i][j] = new Unitemodele(i,j);
			}
		}
		
		
	}


	/**
	 * 
	 */
	public void creelapin() {
		 Random rand = new Random();
		 int randx= xs.get(rand.nextInt(xs.size()));
	     int randy = xs.get(rand.nextInt(xs.size()));
	     if(!this.cases[randx][randy].avecBatiment() && !this.cases[randx][randy].avecjardinier() && !this.cases[randx][randy].aveclapin()) {
		     cases[randx][randy] = new Unitemodele(randx,randy,new Lapinmodele(randx,randy));
		     lapins.add(new Lapinmodele(randx,randy));
		     mangerfleur(randx,randy);
	     }else {
	    	 creelapin();
	     }
	}
	
	
	/**
	 * 
	 */
	public void deplacementlapin() {
		Random rand = new Random();
		if(!lapins.isEmpty()) {
			Lapinmodele randl = lapins.get(rand.nextInt(lapins.size()));
			int randx = xs.get(rand.nextInt(xs.size()));
			int randy = xs.get(rand.nextInt(xs.size()));
			if(!this.cases[randx][randy].avecBatiment() && !this.cases[randx][randy].avecjardinier() && !this.cases[randx][randy].aveclapin()) {
				lapins.remove(randl);
				this.cases[randl.getX()][randl.getY()] = new Unitemodele(randl.getX(),randl.getY());
				lapins.add(new Lapinmodele(randx,randy));
				this.cases[randx][randy] = new Unitemodele(randx,randy,new Lapinmodele(randx,randy));
				mangerfleur(randx,randy);
			}else {
				deplacementlapin();
			}
		}else {
			creelapin();
		}
	}


	/**
	 * 
	 */
	public void sefane() {
		for(int j= 0;j<fleurs.size();j++) {
			if(fleurs.get(j).getdureedevie()>0) {
				fleurs.get(j).setdureedevie(-1);
			}else {
				jr.setnbrfleur(-1);
				this.cases[fleurs.get(j).x][fleurs.get(j).y] = new Unitemodele(fleurs.get(j).x,fleurs.get(j).y);
				fleurs.remove(j);
			}
		}
	}
	
	
		
	/**
	 * @param i
	 * @param k
	 */
	public void mangerfleur(int i,int k) {
		 for(int j= 0;j<fleurs.size();j++) {
				if(fleurs.get(j).x == i && fleurs.get(j).y == k )
					fleurs.remove(j);
					jr.setnbrfleur(-1);
			}
	}
	
	/**
	 * 
	 */
	public void batDefense () {
	
		Random rand = new Random();
		
		if(!lapins.isEmpty()) {

			Lapinmodele randf = lapins.get(rand.nextInt(lapins.size()));
	
			int randx = randf.getX();
	
			int randy = randf.getY();
			
			Effrayerlapin(randx,randy);

		}
		
	}




		/**
		 * 
		 */
	public void batProduction() {
	    Random rand = new Random();
	    if (fleurs.size() != 0) {
	        Fleurmodele randf = fleurs.get(rand.nextInt(fleurs.size()));
	        int randx = randf.getX();
	        int randy = randf.getY();
	        Map<Integer, Integer> position = new HashMap<Integer, Integer>();
	        if (valide(randx+TAILLEUNITE, randy)) {
	            position.put(randx+TAILLEUNITE, randy);
	        }
	        if (valide(randx, randy+TAILLEUNITE)) {
	            position.put(randx, randy+TAILLEUNITE);
	        }
	        if (valide(randx-TAILLEUNITE, randy)) {
	            position.put(randx-TAILLEUNITE, randy);
	        }
	        if (valide(randx, randy-TAILLEUNITE)) {
	            position.put(randx, randy-TAILLEUNITE);
	        }
	        if (valide(randx+TAILLEUNITE, randy-TAILLEUNITE)) {
	            position.put(randx+TAILLEUNITE, randy-TAILLEUNITE);
	        }
	        if (valide(randx+TAILLEUNITE, randy+TAILLEUNITE)) {
	            position.put(randx+TAILLEUNITE, randy+TAILLEUNITE);
	        }
	        if (valide(randx-TAILLEUNITE, randy+TAILLEUNITE)) {
	            position.put(randx-TAILLEUNITE, randy+TAILLEUNITE);
	        }
	        if (position.size() != 0) {
	            int randX = (int) position.keySet().toArray()[rand.nextInt(position.size())];
	            int randY = position.get(randX);
	            if (!this.cases[randX][randY].avecBatiment() && !this.cases[randX][randY].avecjardinier() && !this.cases[randX][randY].aveclapin() && !this.cases[randX][randY].avecfleur()) {
	                this.cases[randX][randY] = new Unitemodele(randX, randY, new Fleurmodele(randX, randY));
	                jr.setnbrfleur(1);
	                fleurs.add(new Fleurmodele(randX, randY));
	            }
	        }
	    }
	}


		/**
		 * @return
		 */
		public int argent() {
			return this.jr.getargent();
		}


		/**
		 * @return
		 */
		public boolean finDePartie() {
			
			return jr.getargent() >=100;
		}


		/**
		 * 
		 */
		public void annulerdernierpas() {
			this.cases=  new Unitemodele[NBRLIGNE][NBRCOLONNE];
			for(int i=0;i<NBRLIGNE;i+=TAILLEUNITE){
				for(int j=0;j<NBRCOLONNE;j+=TAILLEUNITE){
					this.cases[i][j]=this.unites[i][j];
				}
			}
			
		}


		/**
		 * 
		 */
		public void rejouer() {
			lapins=new ArrayList<Lapinmodele>();
			fleurs = new ArrayList<Fleurmodele>();
			batiments= new ArrayList<Batimentmodele>();
			this.cases = new Unitemodele[NBRLIGNE][NBRCOLONNE];
	    	this.unites = new Unitemodele[NBRLIGNE][NBRCOLONNE];
	    	this.xs = new ArrayList<Integer>();
	        for(int i=0;i<NBRLIGNE;i+=TAILLEUNITE){
	        	xs.add(i);
	            for(int j=0;j<NBRCOLONNE;j+=TAILLEUNITE){
	            	if(i==TAILLEUNITE && j==TAILLEUNITE) {
	            		batiments.add(new Batimentmodele(i,j,TypeBatiment.PRINCIPALE));
	            		this.cases[i][j] = new Unitemodele(i,j,new Batimentmodele(i,j,TypeBatiment.PRINCIPALE));
	            	}	
	            	else {
	            		if(i==90 && j ==0 ) {
	                		fleurs.add(new Fleurmodele(i,j));
	                		this.cases[i][j] = new Unitemodele(i,j,new Fleurmodele(i,j));
	            		}else {
	            			if(i==150 && j == 90) {
	                    		jr = new Jardiniermodele(i,j);
	                    		this.cases[i][j] = new Unitemodele(i,j,jr);
	            			}else {
	            				if(i==270 && j == 360) {
	            					batiments.add(new Batimentmodele(i,j,TypeBatiment.DEFENSE));
	                        		this.cases[i][j] = new Unitemodele(i,j,new Batimentmodele(i,j,TypeBatiment.DEFENSE));
	            				}else {
	            					if(i==210 && j == 30) {
	            						batiments.add(new Batimentmodele(i,j,TypeBatiment.PRODUCTION));
	            	            		this.cases[i][j] = new Unitemodele(i,j,new Batimentmodele(i,j,TypeBatiment.PRODUCTION));
	            					}else {
	            						this.cases[i][j] = new Unitemodele(i,j);
	            					}
	            				}
	                    		
	            			}
	            		}
	            	}
	            }    
	           
	        }    
	       setPreferredSize(new Dimension(LENGTH, WIDTH));
		}


		public Batimentmodele getbatiment(int x, int y) {
			for(int i =0;i<batiments.size();i++) {
				if(batiments.get(i).x == x && batiments.get(i).y == y) {
					return batiments.get(i);
				}
			}
			return null;
		}


		public List<Fleurmodele> getfleurs() {
			return fleurs;
		}


	
}

