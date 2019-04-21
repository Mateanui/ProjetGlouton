package glouton.model;

public class Dimension {
	private int longueur, largeur;
	
	public Dimension(int longueur, int largeur) {
		this.longueur = longueur;
		this.largeur = largeur;
	}
	
	/* **************************** */
	/* *** Getteurs et Setteurs *** */
	/* **************************** */

	public int getLongueur() {
		return longueur;
	}

	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}

	public int getLargeur() {
		return largeur;
	}

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}
}