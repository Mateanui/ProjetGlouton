package glouton.vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import glouton.controleur.InterfaceControleur;

public class VueGenerale implements Observer{
	private VueInformation vueInformation;
	private VueResultatGrille vueResultatGrille;
	private InterfaceControleur interfaceControleur;
	
	public VueGenerale(InterfaceControleur interfaceControleur) {
		this.interfaceControleur = interfaceControleur;
		this.interfaceControleur.getAlgorithmeGlouton().registerObserver(this);
		affichage(true);
	}

	/* **************** */
	/* *** Méthodes *** */
	/* **************** */
	
	/*********************************/
	/******* Interface Subject *******/
	/*********************************/
	
	@Override
	public void update() {
		vueResultatGrille.dispose();
		vueResultatGrille = new VueResultatGrille(interfaceControleur.getTailleTerrain().getLongueur(),interfaceControleur.getTailleTerrain().getLargeur(),interfaceControleur.getTerrain(),true);
	
		vueInformation.getjTextAreaInformations().setText(interfaceControleur.affichage());
	}
	
	/*************************/
	/******* Affichage *******/
	/*************************/
	
	public void affichage(boolean b) {
		vueInformation = new VueInformation(b);
		vueResultatGrille = new VueResultatGrille(interfaceControleur.getTailleTerrain().getLongueur(),interfaceControleur.getTailleTerrain().getLargeur(),interfaceControleur.getTerrain(),b);
		
		vueInformation.getjButtonFilename().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser choose = new JFileChooser();
				choose.setCurrentDirectory(new File("instances/"));
				int retour = choose.showOpenDialog(null);
				
				if(retour==JFileChooser.APPROVE_OPTION)
					interfaceControleur.setFilename(choose.getSelectedFile().getAbsolutePath());
			}
		});
		
		vueInformation.getjButtonLancerAlgo().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				interfaceControleur.setAlgorihtmeGloutonEffectueNbFois(false);
				interfaceControleur.lancerAlgo();
			}
		});
		
		vueInformation.getjButtonLancerAlgo1000().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				interfaceControleur.setAlgorihtmeGloutonEffectueNbFois(true);
				interfaceControleur.setNbFoisAlgorithmeGlouton(Integer.parseInt(vueInformation.getjTextAreaNbFoisAlgorithmeGlouton().getText()));
				interfaceControleur.lancerAlgo1000();
			}
		});
		
		vueInformation.getjTextAreaInformations().setText(interfaceControleur.affichage());
	}

	/* **************************** */
	/* *** Getteurs et Setteurs *** */
	/* **************************** */
	
	public VueInformation getVueInformation() {
		return vueInformation;
	}

	public void setVueInformation(VueInformation vueInformation) {
		this.vueInformation = vueInformation;
	}

	public VueResultatGrille getVueResultatGrille() {
		return vueResultatGrille;
	}

	public void setVueResultatGrille(VueResultatGrille vueResultatGrille) {
		this.vueResultatGrille = vueResultatGrille;
	}
}
