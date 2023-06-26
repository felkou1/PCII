package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.Cartemodele;
import modele.TypeBatiment;
import modele.Unitemodele;

public class PanneauControle extends JPanel {

    // Attributes //

    private Cartemodele c;
    private PanneauControleBatiment pB;
    private PanneauControleFleur pF;
    private PanneauControleUnite pU;
    private PanneauControleJardinier pJ;
    private PanneauControleLapin pL;
    private Unitemodele unit;
	protected static final String PATHIMG="img/";

    /**
     * @param c
     */
    public PanneauControle(Cartemodele c) {
        this.setPreferredSize(new Dimension(200,200));
        this.c = c;
        JLabel argent = new JLabel(" L'argent est : " + c.getjardinier().getargent());
        JLabel nbrfleur = new JLabel(" Nombre des fleurs est : " + c.getjardinier().getnbrfleurrecolt());
        JLabel nbrgraine = new JLabel(" Nombre de graines est : " + c.getjardinier().getnbrgraine());
        JLabel nbrbouquet = new JLabel(" Nombre des bouquets est : " + c.getjardinier().getnbrbouquet());
        setLayout(new BorderLayout());
        JPanel panelpr = new JPanel();
        panelpr.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelpr.add(argent);
        panelpr.add(nbrfleur);
        panelpr.add(nbrgraine);
        panelpr.add(nbrbouquet);
        this.add(panelpr, BorderLayout.CENTER);
    }

    /**
     * @param c
     * @param unit
     */
    public PanneauControle(Cartemodele c, Unitemodele unit) {
        this.c = c;
        this.unit = unit;
        affichepanneau(c, unit);
    }

    /**
     * @param c
     * @param unit
     */
    public void affichepanneau(Cartemodele c, Unitemodele unit) {
        this.removeAll();
        if(unit == null) {
        	 JLabel argent = new JLabel(" L'argent est : " + c.getjardinier().getargent());
             JLabel nbrfleur = new JLabel(" Nombre des fleurs est : " + c.getjardinier().getnbrfleurrecolt());
             JLabel nbrgraine = new JLabel(" Nombre de graines est : " + c.getjardinier().getnbrgraine());
             JLabel nbrbouquet = new JLabel(" Nombre des bouquets est : " + c.getjardinier().getnbrbouquet());
             setLayout(new BorderLayout());
             JPanel panelpr = new JPanel();
             panelpr.setLayout(new FlowLayout(FlowLayout.CENTER));
             panelpr.add(argent);
             panelpr.add(nbrfleur);
             panelpr.add(nbrgraine);
             panelpr.add(nbrbouquet);
             this.add(panelpr, BorderLayout.CENTER);
        }else {
	        if (unit.avecBatiment()) {
		            pB = new PanneauControleBatiment(c,unit);
		            this.add(pB);
		     } else {
	            if (unit.avecfleur()) {
	                pF = new PanneauControleFleur(c,unit);
	                add(pF);
	            } else {
	            	if(unit.avecjardinier()) {
	            		pJ =new PanneauControleJardinier(c,unit);
	                    add(pJ);
	            	}else {
	            		if(unit.aveclapin()) {
		            		pL =new PanneauControleLapin(c,unit);
		                    add(pL);
	            		}else {
		            		pU = new PanneauControleUnite(c,unit);
		                    add(pU);
	            		}
	            	}
	            }
	        }
        }
        this.revalidate();
        this.repaint();
    }
}
