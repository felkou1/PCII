package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.ListenerPlanter;
import control.ListenerVendre;
import modele.Cartemodele;
import modele.Unitemodele;


public class PanneauControleUnite extends JPanel 
{

		// Attributes //

	private Cartemodele c;
	private Unitemodele unit;
	/**
	 * @param c
	 * @param unit
	 */
	public PanneauControleUnite(Cartemodele c,Unitemodele unit)
	{
		this.setPreferredSize(new Dimension(200,200));
		this.c=c;
		this.unit=unit;
		JLabel argent = new JLabel(" L'argent est : " + c.getjardinier().getargent());
    	JLabel nbrfleur = new JLabel(" Nombre des fleurs est : " +c.getjardinier().getnbrfleurrecolt());
        JLabel nbrgraine = new JLabel(" Nombre de graines est : " + c.getjardinier().getnbrgraine());
    	JLabel nbrbouquet = new JLabel(" Nombre des bouquets est : " + c.getjardinier().getnbrbouquet());

    	
	    	setLayout(new BorderLayout());  
	    	JPanel Panelpr = new JPanel();
		    Panelpr.setLayout(new FlowLayout(FlowLayout.CENTER));
		    Panelpr.add(argent);		
		    Panelpr.add(nbrfleur);	
		    Panelpr.add(nbrgraine);
		    Panelpr.add(nbrbouquet);	
		    this.add(Panelpr, BorderLayout.NORTH);
		    JButton btn3 = new JButton("Planter"); 
	     	btn3.setFocusable(false);
	    	btn3.addMouseListener(new ListenerPlanter(c,unit));
	     	JPanel buttonsPanel2 = new JPanel();
			buttonsPanel2.setLayout(new FlowLayout(FlowLayout.CENTER));
			buttonsPanel2.add(btn3);
			this.add(buttonsPanel2, BorderLayout.SOUTH);
			
	}

	
	
}
		
