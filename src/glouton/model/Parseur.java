package glouton.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Parseur {
	private String filename;
	private Dimension dimensionTerrain;
	private int nbBatiment;
	private ArrayList<Dimension> batiments;
	
	public Parseur(String filename) {
		this.filename = filename;
		this.dimensionTerrain = new Dimension(0,0);
		this.nbBatiment = 0;
		this.batiments = new ArrayList<Dimension>();
	}
	
	/* **************** */
	/* *** Méthodes *** */
	/* **************** */
	
	public void lecture() {
		String ligne = "";
		
		try {
			FileReader fileReader = new FileReader(filename);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			int curseur = 0;
			
			while((ligne = bufferedReader.readLine()) != null) {
				String[] tab = ligne.split(" ");
				
				if(curseur==0) {
					dimensionTerrain.setLongueur(Integer.parseInt(tab[0]));
					dimensionTerrain.setLargeur(Integer.parseInt(tab[1]));
				} else if(curseur==1) {
					nbBatiment = Integer.parseInt(ligne);
				} else {
					Dimension batiment = new Dimension(Integer.parseInt(tab[0]),Integer.parseInt(tab[1]));
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
		
		//Permet de trier aléatoirement les bâtiments : évite d'avoir toujours la même organisation sur le terrain
		Collections.shuffle(batiments);
	}
	
	public String affichageFilename() {
		String resultat = "";
		
		//Récupère juste le nom du fichier, pas le chemin
		String[] fichier = filename.split("/");
		String nomDuFichier = fichier[fichier.length-1];
		
		resultat += "\t********************************\n\n";
		resultat += "\t Nom du fichier : " + nomDuFichier + "\n\n";
		resultat += "\t********************************\n\n";
		
		return resultat;
	}
	
	public void affichage() {
		String resultat = "";
		
		//Affichage du fichier : filename
		resultat += affichageFilename();

		resultat += "Taille du terrain :\n";
		resultat += "\tLongueur : " + dimensionTerrain.getLongueur() + "\n";
		resultat += "\tLargeur : " + dimensionTerrain.getLargeur() + "\n\n";
		
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
	
	/* **************************** */
	/* *** Getteurs et Setteurs *** */
	/* **************************** */
	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Dimension getDimensionTerrain() {
		return dimensionTerrain;
	}

	public void setDimensionTerrain(Dimension tailleTerrain) {
		this.dimensionTerrain = tailleTerrain;
	}

	public int getNbBatiment() {
		return nbBatiment;
	}

	public void setNbBatiment(int nbBatiment) {
		this.nbBatiment = nbBatiment;
	}

	public ArrayList<Dimension> getBatiments() {
		return batiments;
	}

	public void setBatiments(ArrayList<Dimension> batiments) {
		this.batiments = batiments;
	}
}