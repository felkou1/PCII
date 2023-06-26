package view;

	 import java.awt.BorderLayout;
	 import java.awt.Dimension;
	 import java.awt.FlowLayout;
	 import java.awt.image.BufferedImage;
	 import java.io.File;
	 import java.io.IOException;

	 import javax.imageio.ImageIO;
	 import javax.swing.ImageIcon;
	 import javax.swing.JButton;
	 import javax.swing.JLabel;
	 import javax.swing.JPanel;

	 import control.ListenerAcheter;
	 import control.ListenerBouquet;
	 import control.ListenerVendre;
	 import modele.Batimentmodele;
	 import modele.Cartemodele;
import modele.TypeBatiment;
import modele.Unitemodele;

public class PanneauControleBatiment extends JPanel {

	 	// Attributes //

	 	private Cartemodele c;
	 	protected static final String PATHIMG="img/";
	 	protected BufferedImage img ;
		private Batimentmodele batiment;

	 	
	 	/**
	 	 * @param c
	 	 */
	 	public PanneauControleBatiment(Cartemodele c,Unitemodele unit) {
	 		this.c=c;
	 		this.batiment = c.getbatiment(unit.getX(),unit.getY());
	 		if(batiment.typebat() == TypeBatiment.PRINCIPALE) {
	 		this.setPreferredSize(new Dimension(200,200));

	         try {
	             img = ImageIO.read(new File(Batimentmodele.PATHIMG + "batiment.png"));
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

	         JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	         JButton construireButton = new JButton("Construire un bouquet");
	         construireButton.addMouseListener(new ListenerBouquet(c));
	         JButton vendreButton = new JButton("Vendre bouquet");       
	         vendreButton.addMouseListener(new ListenerVendre(c));
	         JButton achetergraine = new JButton("Acheter graine");
	         achetergraine.addMouseListener(new ListenerAcheter(c));
	         buttonsPanel.add(construireButton);
	         buttonsPanel.add(vendreButton);
	         buttonsPanel.add(achetergraine);

	         this.setLayout(new BorderLayout());
	         this.add(imagePanel, BorderLayout.NORTH);
	         this.add(textPanel, BorderLayout.CENTER);
	         this.add(buttonsPanel, BorderLayout.SOUTH);
	 		}
	 	else {
	 			if(batiment.typebat() == TypeBatiment.DEFENSE) {
	 		 		this.setPreferredSize(new Dimension(200,200));

	 		         try {
	 		             img = ImageIO.read(new File(Batimentmodele.PATHIMG + "batimentD.png"));
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

				 	}else {
				 		this.setPreferredSize(new Dimension(200,200));

		 		         try {
		 		             img = ImageIO.read(new File(Batimentmodele.PATHIMG + "batimentP.png"));
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
	 	}
	 }

	
