package projet_glouton;

public class Terrain {
	private int longueur;
	private int largeur;
	
	public Terrain(int longueur, int largeur) {
		this.longueur = longueur;
		this.largeur = largeur;
	}
	
	/* *** Méthodes *** */
	
	public String toString() {
		String taille;
		
		taille = "Taille du terrain :\n";
		taille += "\tLongueur : " + this.longueur + "\n";
		taille += "\tLargeur : " + this.largeur + "\n";
		
		return taille;
	}
		
	/* *** Getteurs et Setteurs *** */

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
