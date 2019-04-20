package projet_glouton;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Parseur {
	private String filename;
	private Terrain tailleTerrain;
	private int nbBatiment;
	private ArrayList<Terrain> batiments;
	
	public Parseur(String filename) {
		this.filename = filename;
		this.tailleTerrain = new Terrain(0, 0);
		this.nbBatiment = 0;
		this.batiments = new ArrayList<Terrain>();
	}
	
	/* *** Méthodes *** */
	
	public void lecture() {
		String ligne = "";
		
		try {
			FileReader fileReader = new FileReader(filename);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			int curseur = 0;
			
			while((ligne = bufferedReader.readLine()) != null) {
				String[] tab = ligne.split(" ");
				
				if(curseur==0) {
					tailleTerrain.setLongueur(Integer.parseInt(tab[0]));
					tailleTerrain.setLargeur(Integer.parseInt(tab[1]));
				} else if(curseur==1) {
					nbBatiment = Integer.parseInt(ligne);
				} else {
					Terrain batiment = new Terrain(Integer.parseInt(tab[0]),Integer.parseInt(tab[1]));
					batiments.add(batiment);
				}
				
				curseur++;
			}
			
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Le fichier " + filename + " n'existe pas");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Problème au niveau du BufferedReader");
		}
	}
	
	public void affichage() {
		String resultat = "";
		
		//Récupère juste le nom du fichier, pas le chemin
		String[] fichier = filename.split("/");
		String nomDuFichier = fichier[fichier.length-1];
		
		resultat += "----------------------------------\n";
		resultat += "Nom du fichier : " + nomDuFichier + "\n";
		resultat += "----------------------------------\n\n";

		resultat += tailleTerrain.toString() + "\n";
		
		if(nbBatiment==batiments.size())
			resultat += "Nombre de bâtiments : " + nbBatiment + "\n\n";
		else
			resultat += "Nombre de bâtiments : -1\n\n";
		
		int numeroBat = 1;
		for(int i = 0; i < batiments.size(); i++) {
			int longueur = batiments.get(i).getLongueur();
			int largeur = batiments.get(i).getLargeur();
			
			resultat += "Taille du bâtiment n°" + numeroBat + "\n";
			resultat += "\tLongueur : " + longueur + "\n";
			resultat += "\tLargeur : " + largeur + "\n";
			resultat += "\n";
			numeroBat++;
		}
		
		resultat += "\n";
		System.out.println(resultat);
	}
	
	/* *** Getteurs et Setteurs *** */
	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Terrain getTailleTerrain() {
		return tailleTerrain;
	}

	public void setTailleTerrain(Terrain tailleTerrain) {
		this.tailleTerrain = tailleTerrain;
	}

	public int getNbBatiment() {
		return nbBatiment;
	}

	public void setNbBatiment(int nbBatiment) {
		this.nbBatiment = nbBatiment;
	}

	public ArrayList<Terrain> getBatiments() {
		return batiments;
	}

	public void setBatiments(ArrayList<Terrain> batiments) {
		this.batiments = batiments;
	}
}
