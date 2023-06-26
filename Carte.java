/**
 * La classe Carte représente la vue principale de notre application
 * @author IKHELEF Mounia
 *         TADJIN Amina
 *         El Kouch Fadwa
 */
package view;

import java.awt.*;
import javax.swing.*;

import control.ListenerVendre;
import modele.Batimentmodele;
import modele.Cartemodele;
import modele.Fleurmodele;
import modele.Unitemodele;

import java.awt.event.*;
import java.util.List;


public class Carte extends JPanel implements MouseListener
{
	//Attributes //
    private Cartemodele cm ;
    private Menu mn;
    PanneauControle pC;
  //Constructor //
    /**
     * Constructeur qui permet de créer une nouvelle instance de la carte
     * 
     */
    public Carte(){
        cm = new Cartemodele();
        this.setPreferredSize(new Dimension(Cartemodele.WIDTH,Cartemodele.HEIGHT));
        pC = new PanneauControle(cm);
        setMn(new Menu(this));
        this.addMouseListener(this);
        mn.timer().start();
    }
    
    //Methods //
    
    //methode qui dessine l'interface //
    /**
	 * @param Graphics
	 */
    public void paintComponent(Graphics g) {
    	int i;
    	int j = 0;
        super.paintComponent(g);
        for(i=0;i<cm.nbrligne();i+=Cartemodele.TAILLEUNITE){
            for(j=0;j<cm.nbrcolonne();j+=Cartemodele.TAILLEUNITE){
            	g.drawImage(cm.getunite(i,j).Afficheimg(),this.cm.getunite(i,j).getX(),this.cm.getunite(i,j).getY(),Cartemodele.TAILLEUNITE-1,Cartemodele.TAILLEUNITE-1, null);
        }
        }
      
    }


	public void deplacerhaut() {
		partiefinie();
		partieperdu();
		if(this.cm.possible("Haut")){
            this.cm.deplace("Haut");  
            this.removeAll();
            this.invalidate();
            this.validate();
            this.repaint();
           
        }
	}
		public void deplacerbas() {
			partiefinie();
			partieperdu();
			if(this.cm.possible("Bas")){
                this.cm.deplace("Bas");  
                this.removeAll();
                this.invalidate();
                this.validate();
                this.repaint();
            }
		}
		
		public void deplacergauche() {
			partiefinie();
			partieperdu();
			if(this.cm.possible("Gauche")){
                this.cm.deplace("Gauche");  
                this.removeAll();
                this.invalidate();
                this.validate();
                this.repaint();
            }
		}
		
		public void deplacerdroit() {
			partiefinie();
			partieperdu();
			if(this.cm.possible("Droit")){
                this.cm.deplace("Droit");  
                this.removeAll();
                this.invalidate();
                this.validate();
                this.repaint();
            }
		}

		public void creerlapin() {
			this.cm.creelapin();
		}
		public Carte getcartes()
	    {
	    	return this;
	    }

		public void deplacerlapin() {
			cm.deplacementlapin();
		}

		public void sefane() {
			cm.sefane();
		}

		public Cartemodele getcarte() {
			return cm;
		}

		public void partiefinie() {
		    if (this.cm.finDePartie()) {
		        mn.timer().stop();
		        int argent = this.cm.argent();
		        int choice = JOptionPane.showOptionDialog(null, "YOUPII VOUS AVEZ GANGNEE\n" + "Argent: " + argent + "\nVoulez-vous rejouer ?", "Partie terminÃ©e", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Oui", "Non" }, "Oui");
		        if (choice == JOptionPane.YES_OPTION) {
		            rejouer();
		        } else {
		            System.exit(0);
		        }
		    }
		}
		
		public void partieperdu() {
			if(mn.partieperdu()) {
				 int choice = JOptionPane.showOptionDialog(null, "VOUS AVEZ PERDU\n" + "\nVoulez-vous rejouer ?", "Partie terminÃ©e", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Oui", "Non" }, "Oui");
			        if (choice == JOptionPane.YES_OPTION) {
			            rejouer();
			        } else {
			            System.exit(0);
			        }
			}
		}

		public void rejouer() {
			    this.cm.rejouer();
			    this.removeAll();
			    this.invalidate();
			    pC.affichepanneau(cm, null);
			    mn.timer().stop();
			    mn.redrawMenu();
			    mn.timer().start();;
			    this.addMouseListener(this);
			    validate();
			    repaint();

		}
		    public void annulerdernierpas(){
		        this.cm.annulerdernierpas();
		        this.removeAll();
		        this.invalidate();
		        this.validate();
		        this.repaint();
		    }
		    
		    public PanneauControle getpanneau() {
		    	return  pC;
		    }
		    
		    public void mouseClicked(MouseEvent e) {
		        int mouseX = e.getX();
		        int mouseY = e.getY();
		        System.out.print(mouseX+"\n");
		        int row = mouseY / Cartemodele.TAILLEUNITE;
		        int col = mouseX / Cartemodele.TAILLEUNITE;
		        Unitemodele unit = cm.getunite(col * Cartemodele.TAILLEUNITE, row * Cartemodele.TAILLEUNITE);
		        pC.affichepanneau(cm, unit);
		        this.removeAll();
		        this.invalidate();
		        this.validate();
		        this.repaint();
		        partiefinie();
				partieperdu();
				cm.augmenterlagedesfleurs();
		        
		    }

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void production() {
				this.cm.batProduction();
				 this.removeAll();
			     this.invalidate();
			     this.validate();
			     this.repaint();
			}

			public void defense() {
				this.cm.batDefense();
				this.removeAll();
			    this.invalidate();
			    this.validate();
			    this.repaint();
				
			}

			public Menu getMn() {
				return mn;
			}

			public void setMn(Menu mn) {
				this.mn = mn;
			}

			public List<Fleurmodele> gerfleurs() {
				return cm.getfleurs();
			}
	}

