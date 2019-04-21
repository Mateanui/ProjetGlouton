package glouton.controleur;

import java.util.ArrayList;

import glouton.model.AlgorithmeGlouton;
import glouton.model.Dimension;

public class Controleur implements InterfaceControleur{
	private AlgorithmeGlouton algorithmeGlouton;
	
	public Controleur(AlgorithmeGlouton algorithmeGlouton) {
		this.algorithmeGlouton = algorithmeGlouton;
	}

	/* **************************************** */
	/* *************** Méthodes *************** */
	/* **************************************** */
	
	@Override
	public ArrayList<ArrayList<Integer>> getTerrain() {
		return algorithmeGlouton.getTerrain();
	}
	
	@Override
	public void setTerrain(ArrayList<ArrayList<Integer>> terrain) {
		algorithmeGlouton.setTerrain(terrain);
	}
	
	@Override
	public ArrayList<Dimension> getBatiments(){
		return algorithmeGlouton.getBatiments();
	}
	
	@Override
	public void setBatiments(ArrayList<Dimension> batiments) {
		algorithmeGlouton.setBatiments(batiments);
	}
	
	@Override
	public Dimension getTailleTerrain() {
		return algorithmeGlouton.getTailleTerrain();
	}
	
	@Override
	public void setTailleTerrain(Dimension tailleTerrain) {
		algorithmeGlouton.setTailleTerrain(tailleTerrain);
	}
	
	@Override
	public ArrayList<Dimension> getPositionsBatiments(){
		return algorithmeGlouton.getPositionsBatiments();
	}
	
	@Override
	public void setPositionsBatiments(ArrayList<Dimension> positionsBatiments) {
		algorithmeGlouton.setPositionsBatiments(positionsBatiments);
	}
	
	@Override
	public AlgorithmeGlouton getAlgorithmeGlouton() {
		return algorithmeGlouton;
	}
	
	@Override
	public void setAlgorithmeGlouton(AlgorithmeGlouton algorithmeGlouton) {
		this.algorithmeGlouton = algorithmeGlouton;
	}
	
	@Override
	public String getFilename() {
		return algorithmeGlouton.getFilename();
	}
	
	@Override
	public void setFilename(String filename) {
		algorithmeGlouton.setFilename(filename);
	}
	
	@Override
	public void lancerAlgo() {
		algorithmeGlouton.algorithmeGlouton();
	}
	
	@Override
	public void lancerAlgo1000() {
		algorithmeGlouton.algorithmeGlouton1000OrdreAleatoire();
	}
	
	@Override
	public int getNbFoisAlgorithmeGlouton() {
		return algorithmeGlouton.getNbFoisAlgorithmeGlouton();
	}
	
	@Override
	public void setNbFoisAlgorithmeGlouton(int nbFoisAlgorithmeGlouton) {
		algorithmeGlouton.setNbFoisAlgorithmeGlouton(nbFoisAlgorithmeGlouton);
	}
	
	@Override
	public String affichage() {
		return algorithmeGlouton.affichageGenerale();
	}
	
	@Override
	public boolean getAlgorihtmeGloutonEffectueNbFois() {
		return algorithmeGlouton.isAlgorihtmeGloutonEffectueNbFois();
	}
	
	@Override
	public void setAlgorihtmeGloutonEffectueNbFois(boolean algorihtmeGloutonEffectueNbFois) {
		algorithmeGlouton.setAlgorihtmeGloutonEffectueNbFois(algorihtmeGloutonEffectueNbFois);
	}
}
