package glouton.controleur;

import java.util.ArrayList;

import glouton.model.AlgorithmeGlouton;
import glouton.model.Dimension;

public interface InterfaceControleur {
	public ArrayList<ArrayList<Integer>> getTerrain();	
	public void setTerrain(ArrayList<ArrayList<Integer>> terrain);	
	public ArrayList<Dimension> getBatiments();	
	public void setBatiments(ArrayList<Dimension> batiments);
	public Dimension getTailleTerrain();	
	public void setTailleTerrain(Dimension tailleTerrain);	
	public ArrayList<Dimension> getPositionsBatiments();	
	public void setPositionsBatiments(ArrayList<Dimension> positionsBatiments);
	public AlgorithmeGlouton getAlgorithmeGlouton();
	public void setAlgorithmeGlouton(AlgorithmeGlouton algorithmeGlouton);
	public String getFilename();
	public void setFilename(String filename);
	public void lancerAlgo();
	public void lancerAlgo1000();
	public int getNbFoisAlgorithmeGlouton();
	public void setNbFoisAlgorithmeGlouton(int nbFoisAlgorithmeGlouton);
	public String affichage();
	public boolean getAlgorihtmeGloutonEffectueNbFois();
	public void setAlgorihtmeGloutonEffectueNbFois(boolean algorihtmeGloutonEffectueNbFois);
}
