package glouton.vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VueResultatGrille extends JFrame{
	private static final long serialVersionUID = 1L;

	public VueResultatGrille(int longueur, int largeur,ArrayList<ArrayList<Integer>> terrain,boolean b) {
		affichage(longueur, largeur, terrain, b);
	}
	
	/* **************** */
	/* *** Méthodes *** */
	/* **************** */
	
	public void affichage(int longueur, int largeur,ArrayList<ArrayList<Integer>> terrain,boolean b) {
		JPanel conteneur = new JPanel();
		this.setTitle("Résultat glouton");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400,520);
		this.setLocation(660,100);
		
		conteneur.setLayout(new GridLayout(longueur,largeur));
		
		for(int i = 0; i < longueur; i++) {
			for(int j = 0; j < largeur; j++) {
				if(terrain.get(i).get(j)!=-1) {
					JButton button = new JButton();
					
					switch(terrain.get(i).get(j).intValue()) {
						case 0:
							button.setBackground(Color.DARK_GRAY);
							break;
							
						case 1:
							button.setBackground(Color.YELLOW);
							break;
							
						case 2:
							button.setBackground(Color.RED);
							break;
							
						case 3:
							button.setBackground(Color.PINK);
							break;
							
						case 4:
							button.setBackground(Color.ORANGE);
							break;
							
						case 5:
							button.setBackground(Color.MAGENTA);
							break;
							
						case 6:
							button.setBackground(Color.GREEN);
							break;
							
						case 7:
							button.setBackground(Color.GRAY);
							break;
							
						case 8:
							button.setBackground(Color.CYAN);
							break;
							
						case 9:
							button.setBackground(Color.BLUE);
							break;

						default:
							button.setBackground(Color.BLACK);
							break;
					}
					
					conteneur.add(button);
				}
				else
					conteneur.add(new JButton());
			}
		}
		
		this.setContentPane(conteneur);
		this.setVisible(b);
	}
}
