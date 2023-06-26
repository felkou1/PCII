package view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.ListenerRecolter;
import modele.Batimentmodele;
import modele.Cartemodele;
import modele.Unitemodele;

public class PanneauControleFleur extends JPanel {

    private Cartemodele c;
    private Unitemodele unit;

    public PanneauControleFleur(Cartemodele c, Unitemodele unit) {
        this.unit = unit;
        this.setPreferredSize(new Dimension(200, 200));
        this.c = c;

        JLabel argent = new JLabel("L'argent est : " + c.getjardinier().getargent());
        JLabel nbrfleur = new JLabel("Nombre des fleurs est : " + c.getjardinier().getnbrfleurrecolt());
        JLabel nbrgraine = new JLabel("Nombre de graines est : " + c.getjardinier().getnbrgraine());
        JLabel nbrbouquet = new JLabel("Nombre des bouquets est : " + c.getjardinier().getnbrbouquet());

        JLabel nomfleur = new JLabel("\n Fleur type est :" + unit.getfleur().gettypefleur());
        JLabel Dureedevie = new JLabel(" La Duree de vie est : " + unit.getfleur().getdureedevie());

        // Create image panel with a vertical BoxLayout
        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new BoxLayout(imagePanel, BoxLayout.Y_AXIS));
        JLabel imageLabel = new JLabel(new ImageIcon(Batimentmodele.PATHIMG + "fleur.png"));
        imagePanel.add(imageLabel);
        imagePanel.add(nomfleur);
        imagePanel.add(Dureedevie);

        JPanel textPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        textPanel.add(argent);
        textPanel.add(nbrfleur);
        textPanel.add(nbrgraine);
        textPanel.add(nbrbouquet);

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton recolterButton = new JButton("Récolter la fleur");
        recolterButton.addMouseListener(new ListenerRecolter(c, unit));
        buttonsPanel.add(recolterButton);

        setLayout(new BorderLayout());
        add(textPanel, BorderLayout.NORTH);
        add(imagePanel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);
    }
}
