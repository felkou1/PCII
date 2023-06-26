/**
 * Menu class represents the menu bar displayed at the top of the game screen.
 * @author IKHELEF Mounia
 *         TADJIN Amina
 *         El Kouch Fadwa
 */ 
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu extends JMenuBar{

	// Attributes //

	private Carte c; // Reference to the game board
    private int count; // Countdown timer
    private Timer timer; // Swing timer object
    private boolean perdu = false; // Flag indicating if the game is lost

    
	/**
	 * Constructor of the Menu class
	 * 
	 * @param plateau the reference to the game board object
	 */
	public Menu(Carte plateau) {
		this.c=plateau;	
		JMenuBar mb=new JMenuBar(); 
		JMenu partie = new JMenu("Partie");
		JMenu options = new JMenu("Options de jeu");
		
		// MenuItem for restarting the game
		JMenuItem recommencer = new JMenuItem("Recommencer la partie");
		recommencer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				plateau.rejouer();
				plateau.repaint();
			}
		});
		options.add(recommencer);
		
		// MenuItem for undoing the last move
		JMenuItem Annuler = new JMenuItem("Annuler le dernier pas");
		Annuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				plateau.annulerdernierpas();

			}});
		options.add(Annuler);
		partie.add(options);
		
		// MenuItem for quitting the game
		JMenuItem quit = new JMenuItem("Quitter");
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		partie.add(quit);
		mb.add(partie);
		
		// Menu for help and information
		JMenu aide = new JMenu("Aide");
		JMenuItem help = new JMenuItem("Aide");
		help.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Le joueur contrôle des jardiniers qui plantent et récoltent des fleurs de différent type pour composer des bouquets.\nLes bouquets rapportent de l’argent qui permettent d’embaucher plus de jardiniers ou d’acheter de nouvelles graines pour faire plus de bouquets.\nMalheureusement, une famille de lapins a élu domicile �  proximité de la jardinerie et les lapins raffolent des fleurs fraîches.\nLe but de notre jeu sera de produire une certaine quantité de bouquets ou de collecter une certaine somme d’argent dans un temps imparti.");
			}
		});
		        JMenuItem fonc = new JMenuItem("Comment jouer?");
				fonc.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null, "Le jeu consiste à gérer un jardin et à le faire prospérer en récoltant des fleurs, en cultivant des graines et en vendant des bouquets.\n Pour déplacer le jardinier utiliser les flèches de votre clavier, vous pouvez cliquez sur une case pour y planter une graine, au début vous en avez 5.\n Pour récolter une fleur, vous devez cliquer sur la fleur et utiliser le bouton de récolte.Une fois que vous avez récolté suffisamment de fleurs, \n vous pouvez créer un bouquet de 5 fleurs et le vendre, pour ce faire vous pouvez cliquer sur le bâtiment principal. \n Une fois que vous êtes à l'intérieur, vous pouvez sélectionner de construire des bouquets, de les vendre ou d'acheter des graines en utilisant l'argent que vous gagnez en vendant les bouquets.\n En cliquant sur \"Partie\" en haut a gauche, vous avez la possibilité d'annuler votre dernier pas ou de recommencer la partie.\n N'oubliez pas que vous avez un temps impartie de 15 minutes pour gagner 100€.\n Avec suffisamment de soins et de persévérance, vous pouvez faire prospérer votre jardin et devenir un jardinier expert !");
					}
				});
				aide.add(fonc);
				aide.add(help);
				mb.add(aide);
				JMenu timerItem = new JMenu();

				count = 900;
				timer = new Timer(1000, new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                count--;
		                int minutes = count / 60;
		                int seconds = count % 60;
		                String time = String.format("%02d:%02d", minutes, seconds);
		                timerItem.setText("Time left: " + time );    
		                if (count == 0){
		                	 timer.stop();
		                     perdu=true;
		                     
		                }
		            }
		        });
			
			
			   //timer.start();
				mb.add(timerItem);				
				add(mb);
	}
	
	public Timer timer() {
		return timer;
	}
	public boolean partieperdu()
	{
		return perdu;
	}
	public void redrawMenu() {
		this.removeAll();
		this.validate();
		 JMenuBar mb=new JMenuBar(); 
			JMenu partie = new JMenu("Partie");
			JMenu options = new JMenu("Options de jeu");
			JMenuItem recommencer = new JMenuItem("Recommencer la partie");
			recommencer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					c.rejouer();
					c.repaint();
				}
			});
			options.add(recommencer);
			
	        JMenuItem Annuler = new JMenuItem("Annuler le dernier pas");
			Annuler.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					c.annulerdernierpas();

							}});
			options.add(Annuler);
			partie.add(options);
			
			JMenuItem quit = new JMenuItem("Quitter");
			quit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			partie.add(quit);
			mb.add(partie);
			JMenu aide = new JMenu("Aide");
	        JMenuItem help = new JMenuItem("Aide");
			help.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "Le joueur contrôle des jardiniers qui plantent et récoltent des fleurs de différent type pour composer des bouquets.\nLes bouquets rapportent de l’argent qui permettent d’embaucher plus de jardiniers ou d’acheter de nouvelles graines pour faire plus de bouquets.\nMalheureusement, une famille de lapins a élu domicile à proximité de la jardinerie et les lapins raffolent des fleurs fraîches.\nLe but de notre jeu sera de produire une certaine quantité de bouquets ou de collecter une certaine somme d’argent dans un temps imparti.");
				}
			});
	        JMenuItem fonc = new JMenuItem("Comment jouer?");
			fonc.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "Le jeu consiste à gérer un jardin et à le faire prospérer en récoltant des fleurs, en cultivant des graines et en vendant des bouquets.\n Pour déplacer le jardinier utiliser les flèches de votre clavier, vous pouvez cliquez sur une case pour y planter une graine, au début vous en avez 5.\n Pour récolter une fleur, vous devez cliquer sur la fleur et utiliser le bouton de récolte.Une fois que vous avez récolté suffisamment de fleurs, \n vous pouvez créer un bouquet de 5 fleurs et le vendre, pour ce faire vous pouvez cliquer sur le bâtiment principal. \n Une fois que vous êtes à l'intérieur, vous pouvez sélectionner de construire des bouquets, de les vendre ou d'acheter des graines en utilisant l'argent que vous gagnez en vendant les bouquets.\n En cliquant sur \"Partie\" en haut a gauche, vous avez la possibilité d'annuler votre dernier pas ou de recommencer la partie.\n N'oubliez pas que vous avez un temps impartie de 15 minutes pour gagner 100€.\n Avec suffisamment de soins et de persévérance, vous pouvez faire prospérer votre jardin et devenir un jardinier expert !");
				}
			});
			aide.add(fonc);
			aide.add(help);
			mb.add(aide);
			JMenu timerItem = new JMenu();

			count = 900;
			timer = new Timer(1000, new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                count--;
	                int minutes = count / 60;
	                int seconds = count % 60;
	                String time = String.format("%02d:%02d", minutes, seconds);
	                timerItem.setText("Time left: " + time );    
	                if (count == 0){
	                	 timer.stop();
	                     perdu=true;
	                     
	                }
	            }
	        });
		
		
		   //timer.start();
			mb.add(timerItem);				
			add(mb);
		this.revalidate();
		this.repaint();
	}

	
}
