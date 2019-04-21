package glouton.model;

import java.util.ArrayList;
import java.util.Collections;

import glouton.vue.Observer;

public class AlgorithmeGlouton implements Subject {
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	private String filename;
	//Parseur des fichiers instances
	private Parseur parseur;
	//Le terrain à remplir de bâtiments
	private ArrayList<ArrayList<Integer>> terrain;
	//Tous les bâtiments de l'instance (fichiers)
	private ArrayList<Dimension> batiments;
	private Dimension tailleTerrain;
	//Toutes les positions des bâtiments placés sur le terrain
	private ArrayList<Dimension> positionsBatiments;
	//permet de faire nombre de fois l'algorithme glouton
	private int nbFoisAlgorithmeGlouton;
	//Savoir si l'algorithme glouton à été effectue avec un nombre de fois
	private boolean algorihtmeGloutonEffectueNbFois;
	
	public AlgorithmeGlouton(String filename) {
		this.filename = filename;
		parseur = new Parseur(filename);
		parseur.lecture(); //Lecture du fichier
		terrain = new ArrayList<ArrayList<Integer>>();
		batiments = new ArrayList<Dimension>();
		tailleTerrain = new Dimension(-1,-1);
		positionsBatiments = new ArrayList<Dimension>();
		nbFoisAlgorithmeGlouton = 10; //initialse à 10
		algorihtmeGloutonEffectueNbFois = false;
	}
	
	/* **************************************** */
	/* *************** Méthodes *************** */
	/* **************************************** */
	
	/*********************************/
	/******* Interface Subject *******/
	/*********************************/
	
	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}
	
	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}
	
	@Override
	public void notifyObserver() {
		for(int i = 0; i < observers.size(); i++)
			observers.get(i).update();
	}
	
	/**************************************/
	/******* Phase d'initialisation *******/
	/**************************************/
	
	/*
	 * Initialise mon terrain à vide (-1)
	 */
	public void initTerrain() {
		terrain.clear();
		
		for(int i = 0; i < parseur.getDimensionTerrain().getLongueur(); i++) {
			terrain.add(new ArrayList<Integer>());
			
			for(int j = 0; j < parseur.getDimensionTerrain().getLargeur(); j++)
				terrain.get(i).add(-1);
		}
	}
	
	/*
	 * Initialise l'ensemble de bâtiments avec celui récupérer par le parseur
	 */
	public void initBatiments() {
		batiments = parseur.getBatiments();
	}
	
	/*
	 * Initialise la taille du terrain avec celui récupéré par le parseur
	 */
	
	public void initTailleTerrain() {
		tailleTerrain = parseur.getDimensionTerrain();
	}
	
	/*
	 * Initialise toutes les positions des terrains à (-1,-1)
	 * Il n'y a pas encore de bâtiments placés
	 */
	public void initPositionsBatiments() {
		positionsBatiments.clear();
		
		for(int i = 0; i < batiments.size(); i++) {
			Dimension dimensionTemp = new Dimension(-1,-1);
			positionsBatiments.add(i, dimensionTemp);
		}
	}
	
	/*
	 * Initialisation générale
	 */
	public void initGenerale() {
		initTerrain();
		initBatiments();
		initTailleTerrain();
		initPositionsBatiments();
		notifyObserver();
	}
	
	/**************************************/
	/********* Phase d'affichage **********/
	/**************************************/
	
	public String affichageTerrain() {
		String resultat = "";
		
		resultat += "  ---------------------------------\n";
		resultat += "  Terrain de bâtiments\n";
		resultat += "  ---------------------------------\n\n";

		for(int i = 0; i < parseur.getDimensionTerrain().getLongueur(); i++) {
			resultat += "  ";
			for(int j = 0; j < parseur.getDimensionTerrain().getLargeur(); j++) {
				if(terrain.get(i).get(j)==-1)
					resultat += "  X  ";
				else
					resultat += "  " + terrain.get(i).get(j) + "  ";
			}
			
			resultat += "\n";
		}
		
		resultat += "\n";
		
		return resultat;
				
	}
	
	public String affichageBatiments() {
		String resultat = "";
		
		resultat += "  --------------------------------\n";
		resultat += "  Taille des bâtiments\n";
		resultat += "  --------------------------------\n\n";
		
		int numeroBat = 1;
		for(int i = 0; i < batiments.size(); i++) {
			int longueur = batiments.get(i).getLongueur();
			int largeur = batiments.get(i).getLargeur();
					
			resultat += "    Bâtiment n°" + numeroBat + "\n";
			resultat += "    \tLongueur : " + longueur + "\n";
			resultat += "    \tLargeur : " + largeur + "\n";
			resultat += "\n";
			numeroBat++;
		}
		
		return resultat;
	}
	
	public String affichageTailleTerrain() {
		String resultat = "";
		
		resultat += "  -------------------------\n";
		resultat += "  Taille du terrain\n";
		resultat += "  -------------------------\n";
		
		resultat += "\tLongueur : " + tailleTerrain.getLongueur() + "\n";
		resultat += "\tLargeur : " + tailleTerrain.getLargeur() + "\n\n";
		
		return resultat;
	}
	
	public String affichagePositionsBatiments() {
		String resultat = "";
		
		resultat += "  ------------------------------------\n";
		resultat += "  Position des bâtiments\n";
		resultat += "  ------------------------------------\n\n";
		
		int numeroPos = 1;
		for(int i = 0; i < positionsBatiments.size(); i++) {
			resultat += "  " + numeroPos + " : ";
			resultat += " " + positionsBatiments.get(i).getLongueur() + "  " + positionsBatiments.get(i).getLargeur() + "\n";
			numeroPos++;
		}
		
		resultat += "\n";
		
		return resultat;
	}
	
	public String affichageAlgorithmeGloutonSimple() {
		String resultat = "";
		
		resultat += "=================================================\n";
		resultat += "  \tAlgorithme de Glouton simple\n";
		resultat += "=================================================\n\n";
		resultat += affichageTailleTerrain();
		resultat += affichageTerrain();
		resultat += affichageBatiments();
		resultat += affichagePositionsBatiments();
		
		return resultat;
	}
	
	public String affichageAlgorithme1000Glouton() {
		String resultat = "";
		
		resultat += "=================================================\n";
		resultat += "             Algorithme de Glouton effectué " + nbFoisAlgorithmeGlouton + " fois\n";
		resultat += "=================================================\n\n";
		resultat += affichageTailleTerrain();
		resultat += affichageTerrain();
		resultat += affichageBatiments();
		resultat += affichagePositionsBatiments();
		
		return resultat;
	}
	
	public String affichageGenerale() {
		String resultat = "";
		
		resultat += parseur.affichageFilename();
		
		if(!algorihtmeGloutonEffectueNbFois) {
			resultat += affichageAlgorithmeGloutonSimple();
		}
		else {
			resultat += affichageAlgorithme1000Glouton();
		}
		
		return resultat;
	}
	
	/****************************************************/
	/********* Phase de calcul de l'algorithme **********/
	/****************************************************/
	
	/*
	 * Applique l'algorithme de glouton
	 */
	public void algorithmeGlouton() {
		initGenerale();
		//Permet de trier aléatoirement les bâtiments : évite d'avoir toujours la même organisation sur le terrain
		Collections.shuffle(batiments);
		
		for(int i = 0; i < terrain.size(); i++) {
			for(int j = 0; j < terrain.get(i).size(); j++) {
				//Position superieure gauche
				Dimension positionSuperieureGauche = new Dimension(i, j);
				
				//Indice du bâtiment pouvant être placé
				int indiceBatiment = placementPossible(positionSuperieureGauche);
				
				//On construit le bâtiment s'il l'indice est différente de -1
				if(indiceBatiment!=-1)
					//Entre dans le tableau "positionsBatiments" la nouvelle position du bâtiment donné
					generePositionFinalBatiment(batiments.get(indiceBatiment), positionSuperieureGauche, indiceBatiment);
			}
		}
		
		notifyObserver();
	}
	
	/*
	 * Retourne l'indice du bâtiment pouvant être placé à la position donnée
	 */
	public int placementPossible(Dimension positionSuperieureGauche) {
		for(int i = 0; i < positionsBatiments.size(); i++)
			if(!estPlace(i) && peutEtrePlace(batiments.get(i),positionSuperieureGauche))
				return i;
		
		return -1;
	}
	
	/*
	 * Indique si le bâtiment dont l'indice est passé en paramètre est deja placé ou pas
	 */
	public boolean estPlace(int indiceBatiment) {
		return (positionsBatiments.get(indiceBatiment).getLongueur()!=-1 && positionsBatiments.get(indiceBatiment).getLargeur()!=-1);
	}
	
	/*
	 * Indique si le bâtiment passé en paramètre peut être placé
	 */
	public boolean peutEtrePlace(Dimension batimentAPlace,Dimension positionSuperieureGauche) {
		//Position inférieure droite
		Dimension positionInferieureDroite = new Dimension(positionSuperieureGauche.getLongueur()+(batimentAPlace.getLongueur()-1),positionSuperieureGauche.getLargeur()+(batimentAPlace.getLargeur()-1));
		
		return surfaceVide(positionSuperieureGauche, positionInferieureDroite);
	}
	
	/*
	 * Vérifie si la surface du bâtiment à placer est vide à l'aide des deux extrémités passées en paramètres
	 */
	public boolean surfaceVide(Dimension positionSuperieureGauche, Dimension positionInferieureDroite) {
		for(int i = positionSuperieureGauche.getLongueur(); i <= positionInferieureDroite.getLongueur(); i++)
			for(int j = positionSuperieureGauche.getLargeur(); j <= positionInferieureDroite.getLargeur(); j++)
				if(i<0 || j<0 || i>=terrain.size() || j>=terrain.get(i).size() || terrain.get(i).get(j)!=-1)
					return false;
		
		return true;
	}

	/*
	 * Si la construction est bien faite, on entre la position du bâtiment dans le tableau de "positionsBatiments"
	 */
	public void generePositionFinalBatiment(Dimension batimentAContruire, Dimension positionSuperieureGauche, int indiceBatiment) {
		//On revérifie s'il est plaçable
		if(peutEtrePlace(batimentAContruire, positionSuperieureGauche)) {
			//Position inférieure droite
			Dimension positionInferieureDroite = new Dimension(positionSuperieureGauche.getLongueur()+(batimentAContruire.getLongueur()-1),positionSuperieureGauche.getLargeur()+(batimentAContruire.getLargeur()-1)); 
			
			if(constructionBatiment(positionSuperieureGauche, positionInferieureDroite, indiceBatiment)) {
				//On ajoute sa position dans le tableau "positionsBatiments"
				Dimension position = new Dimension(positionSuperieureGauche.getLongueur(),positionSuperieureGauche.getLargeur());
				positionsBatiments.set(indiceBatiment, position);
			}
		}
	}
	
	/*
	 * Contruit le bâtiment sur le terrain.
	 * On modifiera les valeur -1 par l'indice du bâtiment lors de la construction sur le terrain
	 */
	public boolean constructionBatiment(Dimension positionSuperieureGauche, Dimension positionInferieureDroite, int indiceBatiment) {
		//On vérifie si le bâtiment ne dépasse pas le terrain
		boolean a = (positionSuperieureGauche.getLongueur()>=0);
		boolean b = (positionSuperieureGauche.getLargeur()>=0);
		boolean c = (positionInferieureDroite.getLongueur()>=0);
		boolean d = (positionInferieureDroite.getLargeur()>=0);
		boolean e = (positionSuperieureGauche.getLongueur()<tailleTerrain.getLongueur());
		boolean f = (positionSuperieureGauche.getLargeur()<tailleTerrain.getLargeur());
		boolean g = (positionInferieureDroite.getLongueur()<tailleTerrain.getLongueur());
		boolean h = (positionInferieureDroite.getLargeur()<tailleTerrain.getLargeur());
		
		if(a&&b&&c&&d&&e&&f&&g&&h) {
			for(int i = positionSuperieureGauche.getLongueur(); i <= positionInferieureDroite.getLongueur(); i++)
				for(int j = positionSuperieureGauche.getLargeur(); j <= positionInferieureDroite.getLargeur(); j++)
					terrain.get(i).set(j,indiceBatiment);
			
			return true;
		}
		else
			return false;
	}
	
	/************************************/
	/******* Phase d'amélioration *******/
	/************************************/
	
	/*
	 * Consiste à appliquer l'algorithme Glouton sur divers bâtiments générés aléatoirement
	 * et permet de trouver la meilleur solution.
	 * On appliquera 1000 fois l'algorithme et on mémorise le nombre d'espace occupée à chaque itération. 
	 */
	public void algorithmeGlouton1000OrdreAleatoire() {
		initPositionsBatiments();
		int occupe = 0;
		
		for(int i = 0; i < nbFoisAlgorithmeGlouton; i++) {			
			//On applique l'algorithme de glouton
			algorithmeGlouton();
			
			if(nbEspaceOccupe()>=occupe) {
				setPositionsBatiments(positionsBatiments);
				setBatiments(batiments);
				occupe = nbEspaceOccupe();
			}
		}
		
		//On reconstruit le terrain avec les positions des bâtiments finales
		for(int i = 0; i < positionsBatiments.size(); i++)
			generePositionFinalBatiment(batiments.get(i),positionsBatiments.get(i),i);
	}
	
	/*
	 * Renvoie le nombre d'espace occupé par les bâtiments sur un terrain
	 */
	public int nbEspaceOccupe() {
		int occupe = 0;
		
		for(int i = 0; i < terrain.size(); i++)
			for(int j = 0; j < terrain.get(i).size(); j++)
				if(terrain.get(i).get(j)!=-1)
					occupe++;
		
		return occupe;
	}
	
	/* **************************************** */
	/* ********* Getteurs et Setteurs ********* */
	/* **************************************** */
	
	public ArrayList<ArrayList<Integer>> getTerrain() {
		return terrain;
	}
	public void setTerrain(ArrayList<ArrayList<Integer>> terrain) {
		this.terrain = terrain;
	}
	public ArrayList<Dimension> getBatiments() {
		return batiments;
	}
	public void setBatiments(ArrayList<Dimension> batiments) {
		this.batiments = batiments;
	}
	public Dimension getTailleTerrain() {
		return tailleTerrain;
	}
	public void setTailleTerrain(Dimension tailleTerrain) {
		this.tailleTerrain = tailleTerrain;
	}
	public ArrayList<Dimension> getPositionsBatiments() {
		return positionsBatiments;
	}
	public void setPositionsBatiments(ArrayList<Dimension> positionsBatiments) {
		this.positionsBatiments = positionsBatiments;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
		parseur = new Parseur(filename);
		parseur.lecture(); //Lecture du fichier
	}
	public int getNbFoisAlgorithmeGlouton() {
		return nbFoisAlgorithmeGlouton;
	}
	public void setNbFoisAlgorithmeGlouton(int nbFoisAlgorithmeGlouton) {
		this.nbFoisAlgorithmeGlouton = nbFoisAlgorithmeGlouton;
	}
	public boolean isAlgorihtmeGloutonEffectueNbFois() {
		return algorihtmeGloutonEffectueNbFois;
	}
	public void setAlgorihtmeGloutonEffectueNbFois(boolean algorihtmeGloutonEffectueNbFois) {
		this.algorihtmeGloutonEffectueNbFois = algorihtmeGloutonEffectueNbFois;
	}
}