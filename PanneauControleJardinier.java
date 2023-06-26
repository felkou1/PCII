package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.ListenerRecolter;
import modele.Batimentmodele;
import modele.Cartemodele;
import modele.Unitemodele;

public class PanneauControleJardinier extends JPanel {

    private Cartemodele c;
    private Unitemodele unit;
 	protected BufferedImage img ;


    public PanneauControleJardinier(Cartemodele c, Unitemodele unit) {
        this.unit = unit;
        this.setPreferredSize(new Dimension(200, 200));
        this.c = c;

        this.setPreferredSize(new Dimension(200,200));

         try {
             img = ImageIO.read(new File(Batimentmodele.PATHIMG + "jardinier.png"));
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
	     this.add(textPanel, BorderLayout.NORTH);
        this.add(imagePanel, BorderLayout.CENTER);

    }
}
