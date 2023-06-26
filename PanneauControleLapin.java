package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.Batimentmodele;
import modele.Cartemodele;
import modele.TypeBatiment;
import modele.Unitemodele;

public class PanneauControleLapin extends JPanel {

 	// Attributes //

 	private Cartemodele c;
 	protected static final String PATHIMG="img/";
 	protected BufferedImage img ;
	private Batimentmodele batiment;

 	
 	/**
 	 * @param c
 	 */
 	public PanneauControleLapin(Cartemodele c,Unitemodele unit) {
 		this.c=c;
 		this.setPreferredSize(new Dimension(200,200));

         try {
             img = ImageIO.read(new File(Batimentmodele.PATHIMG + "lapin.png"));
         } catch (IOException e) {
             e.printStackTrace();
         }

         JPanel imagePanel = new JPanel(new BorderLayout());
         JLabel imageLabel = new JLabel(new ImageIcon(img));
         imagePanel.add(imageLabel, BorderLayout.CENTER);

         JPanel textPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
         JLabel argent = new JLabel("L'argent est : " + c.getjardinier().getargent());
         JLabel nbrfleur = new JLabel("Nombre des fleurs est : " + c.getjardinier().getnbrfleurrecolt());
         JLabel nbrgraine = new JLabel("Nombre de graines est : " + c.getjardinier().getnbrgraine());
         JLabel nbrbouquet = new JLabel("Nombre des bouquets est : " + c.getjardinier().getnbrbouquet());
         textPanel.add(argent);      
         textPanel.add(nbrfleur);    
         textPanel.add(nbrgraine);
         textPanel.add(nbrbouquet);

         this.setLayout(new BorderLayout());
         this.add(imagePanel, BorderLayout.NORTH);
         this.add(textPanel, BorderLayout.CENTER);
 		}
 	}